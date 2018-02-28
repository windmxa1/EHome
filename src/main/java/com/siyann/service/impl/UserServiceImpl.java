package com.siyann.service.impl;

import com.siyann.dao.AppVersionDao;
import com.siyann.dao.UserAddressDao;
import com.siyann.dao.UserDao;
import com.siyann.dao.UserFeedbackDao;
import com.siyann.entity.AppVersion;
import com.siyann.entity.User;
import com.siyann.entity.UserAddress;
import com.siyann.entity.UserFeedback;
import com.siyann.service.UserService;
import com.siyann.util.TokenUtils;
import com.siyann.util.Utils;
import com.siyann.view.VUser;
import com.siyann.view.VUserFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    Map<String, Object> data;
    @Autowired
    UserAddressDao uAddressDao;
    @Autowired
    AppVersionDao versionDao;
    @Autowired
    UserFeedbackDao userFeedbackDao;

    @Override
    public Object login(String phone, String password) throws Exception {
        User u = userDao.findFirstByPhoneAndPassword(phone, password);
        if (u != null) {
            data = new HashMap<String, Object>();
            // 验证通过并生成token,c为过期时间，暂时用不到
            Calendar c = Calendar.getInstance();
            c.add(c.DATE, 14);
            String token = TokenUtils.buildJwt1(TokenUtils.getKey(0),
                    c.getTime(), u.getId());
            // ObjectMapper mapper = new ObjectMapper();
            data.put("token", token);
            return Utils.toJson(100, "登录成功", data);
        } else {
            return Utils.toJson(101, "登录失败", "");
        }
    }

    @Override
    public Object getUserInfo(Long userid) throws Exception {
        VUser u = userDao.getFirstById(userid);
        if (u == null) {
            return Utils.toJson(101, "系统错误，请重试", data);
        }
        u.setPassword("");
        data.put("user", u);
        return Utils.toJson(100, "", data);
    }

    @Override
    public Object phoneVerify(String phone) throws Exception {
        User u = userDao.findFirstByPhone(phone);
        if (u != null) {
            data = new HashMap<String, Object>();
            // 验证通过并生成token,c为过期时间，暂时用不到
            Calendar c = Calendar.getInstance();
            c.add(c.DATE, 14);
            String token = TokenUtils.buildJwt1(TokenUtils.getKey(0),
                    c.getTime(), u.getId());
            data.put("token", token);
            return Utils.toJson(101, "该手机号已注册", data);
        } else {
            return Utils.toJson(100, "该手机号还未注册", "");
        }
    }

    @Override
    public Object updatePassword(Long userid, String passowrd)
            throws Exception {
        if (userDao.updateByIdAndPassowrd(userid, passowrd) > 0) {
            return Utils.toJson(100, "修改成功", "");
        } else {
            return Utils.toJson(101, "修改失败", "");
        }
    }

    @Override
    public Object register(String phone, String password) throws Exception {
        User u = userDao.findFirstByPhone(phone);
        if (u != null) {
            return Utils.toJson(101, "注册失败，该账号已被注册", "");
        }
        User user = new User(phone, password, System.currentTimeMillis() / 1000);
        userDao.saveAndFlush(user);
        return Utils.toJson(100, "注册成功", "");
    }

    @Override
    public Object updateUserInfo(Long userid, String password,
                                 String newPwd, String nickname) throws Exception {
        if (password != null) {
            if (userDao.findFirstByIdAndPassword(userid, password) == null) {
                return Utils.toJson(101, "修改失败,旧密码不正确", "");
            }
            if (userDao.updateByIdAndPassowrd(userid, newPwd) > 0) {
                return Utils.toJson(100, "修改成功", "");
            }
        }
        if (nickname != null) {
            if (userDao.updateByIdAndNickname(userid, nickname) > 0) {
                return Utils.toJson(100, "修改成功", "");
            }
        }
        return Utils.toJson(101, "修改失败", "");
    }

    @Override
    public Object updateHead(CommonsMultipartFile file,
                             String path, Long userid) throws Exception {
//        String path = request.getSession().getServletContext()
//                .getRealPath("/upload/headimg/");
        String filename = (System.currentTimeMillis() / 1000) + "_"
                + file.getOriginalFilename();
        String filePath = path + File.separator + filename;
        File newFile = new File(filePath);

        if (!newFile.getParentFile().exists()) {
            System.out.println("目标文件的目录不存在，准备创建目录...");
            if (!newFile.getParentFile().mkdirs()) {
                System.out.println("创建目录失败");
                return Utils.toJson(101, "服务器繁忙请重试", "");
            }
        }
        // 通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);

        String url = "upload/headimg/" + filename;

        // 删除之前的头像
        String usedHead = userDao.getOne(userid).getHeadUrl();
        if (usedHead != null) {
            File f = new File(TokenUtils.rootPath
                    + usedHead);
            if (f.exists()) {
                f.delete();
            }
        }
        // 更新头像
        userDao.updateByHeadUrl(url, userid);
        return Utils.toJson(100, "修改成功", "");
    }

    @Override
    public Object getAddresses(Long userid) throws Exception {
        List<UserAddress> list = uAddressDao.findByUserid(userid);
        data = new HashMap<>();
        data.put("list", list);
        return Utils.toJson(100, "", data);
    }

    @Override
    public Object insertAddress(Long userid, String address,
                                String receiver, String tel, String sex) throws Exception {
        UserAddress userAddress = new UserAddress(userid, address, receiver,
                tel, sex);
        uAddressDao.saveAndFlush(userAddress);
        return Utils.toJson(100, "添加成功", "");
//        return Utils.toJson(101, "添加失败", "");
    }

    @Override
    public Object deleteAddress(Long userid, Long id)
            throws Exception {
        if (uAddressDao.deleteByIdAndUserid(id, userid) > 0) {
            return Utils.toJson(100, "删除成功", "");
        }
        return Utils.toJson(101, "删除失败", "");
    }

    @Override
    public Object updateAddress(Long userid, Long id,
                                String address, String receiver, String tel, String sex,
                                Integer default_) throws Exception {
        // System.out.println(default_);
        uAddressDao.update(userid, address, receiver,
                default_, tel, sex, id);
        return Utils.toJson(100, "修改成功", "");
        //return Utils.toJson(101, "修改失败", "");
    }

    /**
     * 修改默认地址(无法取消默认)，与原接口不同
     */
    @Override
    public Object updateDefaultAddress(Long id, Long userid) throws Exception {
        uAddressDao.update(id, userid);
        return Utils.toJson(100, "修改成功", "");
//            return Utils.toJson(101, "修改失败", "");
    }

    /**
     * 检测版本是否为最新版
     */
    @Override
    public Object checkVersion(String version)
            throws Exception {
//        VersionDao vDao = new VersionDaoImp();
        AppVersion v = versionDao.findFirstByOrderByIdDesc();
        if (v == null || v.getVersion().equals(version)) {
            return Utils.toJson(100, "", "");
        }
        data = new HashMap<>();
        data.put("version", v);
        return Utils.toJson(101, "生态宜家的最新版本" + v.getVersion()
                + "已发布,当前版本为" + version, data);
    }

    /**
     * 获取默认地址
     */
    @Override
    public Object getDefaultAddress(Long userid)
            throws Exception {
        UserAddress userAddress = uAddressDao.findFirstByUseridAndDefault_(userid, 1);
        if (userAddress == null) {
            return Utils.toJson(101, "您没有设置默认地址", "");
        }
        data = new HashMap<>();
        data.put("address", userAddress);
        return Utils.toJson(100, "", data);
    }

    /**
     * 用户反馈
     */
    @Override
    public Object addFeedback(Long userid, String message)
            throws Exception {
        Long time = System.currentTimeMillis() / 1000;
        UserFeedback userFeedback = new UserFeedback(message, userid, time);
        userFeedbackDao.save(userFeedback);
        return Utils.toJson(100, "反馈成功，我们会尽快处理", "");
//        return Utils.toJson(101, "反馈失败，服务器繁忙，请重试", "");
    }

    /**
     * 获取用户列表
     */
    @Override
    public Object getUserList(Integer start,
                              Integer limit) throws Exception {
        Pageable pageable = new PageRequest(start, limit);
        Page<VUser> list = userDao.getAll(pageable);
        data = new HashMap<String, Object>();
        data.put("list", list);
        data.put("total", userDao.count());
        return Utils.toJson(100, "", data);
    }

    /**
     * 获取用户反馈列表
     */
    @Override
    public Object getFeedbackList(Integer start,
                                  Integer limit, Integer read) throws Exception {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, limit, sort);
        Page<VUserFeedback> page = userFeedbackDao.getAllByRead(read, pageable);
        List<VUserFeedback> list = page.getContent();
        data = new HashMap<String, Object>();
        data.put("list", list);
        data.put("total", userFeedbackDao.countByRead(read));
        return Utils.toJson(100, "", data);
    }

    /**
     * 删除用户反馈记录
     */
    @Override
    public Object deleteFeedback(Integer id)
            throws Exception {
        userFeedbackDao.deleteById(id);
        return Utils.toJson(100, "删除成功", "");
    }

    /**
     * 更新用户反馈进度
     */
    @Override
    public Object updateFeedbackState(Integer id)
            throws Exception {
        if (userFeedbackDao.updateById(id) > 0) {
            return Utils.toJson(100, "修改成功", "");
        }
        return Utils.toJson(101, "修改失败", "");
    }

    /**
     * 获取免单用户列表
     */
    @Override
    public Object getFreeList(Integer start,
                              Integer limit) throws Exception {
        Pageable pageable = new PageRequest(start, limit);
        Page<VUser> page = userDao.getAllByIsFree(1, pageable);
        List<VUser> list = page.getContent();
        data = new HashMap<String, Object>();
        data.put("list", list);
        data.put("total", userDao.countByIsFree(1));
        return Utils.toJson(100, "", data);
    }

    /**
     * 搜索用户
     */
    @Override
    public Object getUserByPhone(String phone,
                                 Integer start, Integer limit) throws Exception {
        Pageable pageable = new PageRequest(start, limit);
        Page<VUser> page = userDao.getAllByPhone(phone, pageable);
        List<VUser> list = page.getContent();
        data = new HashMap<String, Object>();
        data.put("list", list);
        data.put("total", userDao.countByPhone(phone));
        return Utils.toJson(100, "", data);
    }

    /**
     * 设置免单授权
     */
    @Override
    public Object setFree(Integer isFree,
                          Long userid) throws Exception {
        if (userDao.updateByIdAnd(isFree, userid) > 0) {
            return Utils.toJson(100, "修改成功", "");
        }
        return Utils.toJson(101, "修改失败", "");
    }

}
