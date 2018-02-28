package com.siyann.app.controller;

import com.siyann.entity.User;
import com.siyann.service.UserService;
import com.siyann.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController("/app/UserController")
@RequestMapping("/app/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("login")
    public Object login(User user) throws Exception {
        return userService.login(user.getPhone(), user.getPassword());
    }

    @RequestMapping("/getUserInfo")
    public Object getUserInfo(HttpServletRequest request) throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.getUserInfo(userid);
    }

    @RequestMapping("/phoneVerify")
    public Object phoneVerify(HttpServletRequest request, User user)
            throws Exception {
        return userService.phoneVerify(user.getPhone());
    }

    @RequestMapping("updatePassword")
    public Object updatePassword(HttpServletRequest request, String newPwd)
            throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.updatePassword(userid, newPwd);
    }

    @RequestMapping("/register")
    public Object register(User user) throws Exception {
        return userService.register(user.getPhone(), user.getPassword());
    }

    @RequestMapping("/updateUserInfo")
    public Object updateUserInfo(HttpServletRequest request, String password,
                                 String newPwd, String nickname) throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.updateUserInfo(userid, password, newPwd, nickname);
    }

    @RequestMapping("updateHead")
    public Object updateHead(HttpServletRequest request, CommonsMultipartFile file) throws Exception {
        Long userid = TokenUtils.getUserId(request);
        String path = request.getSession().getServletContext()
                .getRealPath("/upload/headimg/");
        return userService.updateHead(file, path, userid);
    }

    @RequestMapping("getAddress")
    public Object getAddresses(HttpServletRequest request) throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.getAddresses(userid
        );
    }

    @RequestMapping("insertAddress")
    public Object insertAddress(HttpServletRequest request, String address,
                                String receiver, String tel, String sex) throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.insertAddress(userid, address, receiver, tel, sex);
    }

    @RequestMapping("deleteAddress")
    public Object deleteAddress(HttpServletRequest request, Long id)
            throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.deleteAddress(userid, id);
    }

    @RequestMapping("updateAddress")
    public Object updateAddress(HttpServletRequest request, Long id,
                                String address, String receiver, String tel, String sex,
                                Integer default_) throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.updateAddress(userid, id, address, receiver, tel, sex, default_);
    }

    @RequestMapping("updateDefaultAddress")
    public Object updateDefaultAddress(HttpServletRequest request, Long id
    ) throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.updateDefaultAddress(id, userid);
    }

    @RequestMapping("checkVersion")
    public Object checkVersion(HttpServletRequest request, String version)
            throws Exception {
        return userService.checkVersion(version);
    }

    @RequestMapping("getDefaultAddress")
    public Object getDefaultAddress(HttpServletRequest request)
            throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.getDefaultAddress(userid);
    }

    @RequestMapping("addFeedback")
    public Object addFeedback(HttpServletRequest request, String message)
            throws Exception {
        Long userid = TokenUtils.getUserId(request);
        return userService.addFeedback(userid, message);
    }


}
