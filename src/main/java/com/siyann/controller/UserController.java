package com.siyann.controller;

import com.siyann.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/back/UserController")
@RequestMapping("/back/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("getUserList")
    public Object getUserList(Integer start,
                              Integer limit) throws Exception {
        return userService.getUserList(start, limit);
    }

    @RequestMapping("getFeedbackList")
    public Object getFeedbackList(Integer start,
                                  Integer limit, Integer read) throws Exception {
        return userService.getFeedbackList(start, limit, read);
    }

    @RequestMapping("deleteFeedback")
    public Object deleteFeedback(Integer id)
            throws Exception {
        return userService.deleteFeedback(id);
    }

    @RequestMapping("updateFeedbackState")
    public Object updateFeedbackState(Integer id)
            throws Exception {
        return userService.updateFeedbackState(id);
    }

    @RequestMapping("getFreeList")
    public Object getFreeList(Integer start,
                              Integer limit) throws Exception {
        return userService.getFreeList(start, limit);
    }

    @RequestMapping("getUserByPhone")
    public Object getUserByPhone(String phone,
                                 Integer start, Integer limit) throws Exception {
        return userService.getUserByPhone(phone, start, limit);
    }

    @RequestMapping("setFree")
    public Object setFree(Integer isFree,
                          Long userid) throws Exception {
        return userService.setFree(isFree, userid);
    }

}
