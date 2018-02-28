package com.siyann.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
@Transactional
public interface UserService {
    Object login(String phone, String password) throws Exception;

    Object getUserInfo(Long userid) throws Exception;

    Object phoneVerify(String phone) throws Exception;

    Object updatePassword(Long userid, String passowrd)
            throws Exception;

    Object register(String phone, String password) throws Exception;

    Object updateUserInfo(Long userid, String password,
                          String newPwd, String nickname) throws Exception;

    Object updateHead(CommonsMultipartFile file,
                      String path, Long userid) throws Exception;

    Object getAddresses(Long userid) throws Exception;

    Object insertAddress(Long userid, String address,
                         String receiver, String tel, String sex) throws Exception;

    Object deleteAddress(Long userid, Long id)
            throws Exception;

    Object updateAddress(Long userid, Long id,
                         String address, String receiver, String tel, String sex,
                         Integer default_) throws Exception;

    Object updateDefaultAddress(Long id,
                                Long userid) throws Exception;

    Object checkVersion(String version)
            throws Exception;

    Object getDefaultAddress(Long userid)
            throws Exception;

    Object addFeedback(Long userid, String message)
            throws Exception;

    Object getUserList(Integer start,
                       Integer limit) throws Exception;

    Object getFeedbackList(Integer start,
                           Integer limit, Integer read) throws Exception;

    Object deleteFeedback(Integer id)
            throws Exception;

    Object updateFeedbackState(Integer id)
            throws Exception;

    Object getFreeList(Integer start,
                       Integer limit) throws Exception;

    Object getUserByPhone(String phone,
                          Integer start, Integer limit) throws Exception;

    Object setFree(Integer isFree,
                   Long userid) throws Exception;
}
