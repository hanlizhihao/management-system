package com.changjiang.controller;

import com.changjiang.entity.Users;
import com.changjiang.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes("user")
public class UsersController {

    @Autowired
    private UsersService service;
    //要求在session中可以找到user，才可以登录到index首页

    @RequestMapping(value = "/indexManage", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
        if (request.getSession().getAttribute("user") == null) {
            return "redirect:/login";
        }
        return "index_manage";
    }

    @RequestMapping(value = "/addUsers", method = RequestMethod.POST,
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String addUsers(Users user) {

        return "success";
    }
    //根据userId获取店的所有用户

    @RequestMapping(value = "/allUsers", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Users> getAllUsersByUserId(@RequestParam("user_id") Integer userId) {
        List<Users> users = service.selectAllUsersByUserId(userId);
        return users;
    }
    //根据userId获取店启用用户
    @RequestMapping(value = "/enabledUsers", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Users> getEnabledUsersByUserId(@RequestParam("user_id") Integer userId) {
        List<Users> users = service.selectEnabledUsersByUserId(userId);
        return users;
    }

    @RequestMapping(value = "/disabledUsers", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Users> getDisabledUsersByUserId(@RequestParam("user_id") Integer userId) {
        List<Users> users = service.selectDisabledUsersByUserId(userId);
        return users;
    }
    //根据用户id

    @RequestMapping(value = "/storeNumber", method = RequestMethod.POST,
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getStoreNmberByUserId(@RequestParam("user_id") Integer id) {
        return service.selectUsersById(id).getStore();
    }

    @RequestMapping(value = "deleteSingleUser", method = RequestMethod.POST,
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteSingleUser(@RequestParam("user_id") Integer id) {
        int result = service.deleteUsersById(id);
        if (result == 1) {
            return "success";
        } else {
            return "false";
        }
    }

    @RequestMapping(value = "deleteManyUser", method = RequestMethod.POST,
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String deleteManyUser(@RequestParam("deleteUsers") Integer[] users) {
        boolean sign = service.deleteManyUser(users);
        if (sign) {
            return "success";
        } else {
            return "defeat";
        }
    }
    //添加用户

    @RequestMapping(value = "addUser", method = RequestMethod.POST,
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String addUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") Integer role, @RequestParam("store") String store,
            @RequestParam("userInformation") Integer userInformation) {
        Users user = new Users();
        user.setPassword(password);
        user.setRoleId(role);
        user.setStore(store);//店编号
        user.setUserInformation(userInformation);//userInformationID
        user.setUsername(username);
        try {
            service.insertNonEmptyUsers(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "defeat";
        }
        return "success";
    }
    //更改User

    @RequestMapping(value = "changeUser", method = RequestMethod.POST,
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String changeUserById(Users user) {
        int result = service.updateNonEmptyUsersById(user);
        if (result == 1) {
            return "success";
        } else {
            return "defeat";
        }
    }
}
