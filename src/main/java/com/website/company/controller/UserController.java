package com.website.company.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.website.company.controller.api.BaseController;
import com.website.company.entity.User;
import com.website.company.service.UserService;
import com.website.company.utils.MD5Utils;
import com.website.company.utils.ResponseBo;
import com.website.company.utils.ResponseList;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author peng yangyan
 * @since 2018-11-22
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    private static final String CODE_KEY = "_code";

    @Autowired
    UserService userService;

//    @GetMapping("/login")
//    public ResponseBo passLogin(){
//        Subject subject = getSubject();
//        if (subject != null){
//
//            User user = (User) subject.getPrincipal();
//            subject.getSession().setTimeout(86400000);
//            return ResponseBo.ok(user);
//        }else {
//            return ResponseBo.error("未登录！");
//        }
//    }

    @PostMapping("/login")
    public ResponseBo login(@RequestBody User user) {
        Session session = super.getSession();
        String sessionCode = (String) session.getAttribute(CODE_KEY);
        System.out.println(sessionCode);
        user.setLoginPassword(MD5Utils.encrypt(user.getLoginAccount().toLowerCase(), user.getLoginPassword()));
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginAccount(), user.getLoginPassword());
        try {
            Subject subject = getSubject();
            if (subject != null) {
                subject.logout();
            }
            super.login(token);
            Subject subject1 = getSubject();
            subject1.getSession().setTimeout(86400000);
            return ResponseBo.ok(this.userService.selectOne(new EntityWrapper<User>().eq("login_account",token.getUsername())));
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            return ResponseBo.error(e.getMessage());
        } catch (AuthenticationException e) {
            return ResponseBo.error("认证失败！");
        }
    }

    @GetMapping("/loginOut")
    public ResponseBo loginOut(){
        Subject subject = getSubject();
        if (subject!=null){
            subject.logout();
            return ResponseBo.ok("成功退出");
        }
        return ResponseBo.ok("尚未登录");
    }


    @GetMapping("/getUser")
    public ResponseBo getUser(@RequestParam("userId") Integer userId) {
        try {
            User user = this.userService.show(userId);
            return ResponseBo.ok(user);
        } catch (Exception e) {
            return ResponseBo.error("获取用户失败，请联系网站管理员！");
        }
    }

    @GetMapping("/getList")
    public ResponseList<User> getUserList(@RequestParam(value = "page",defaultValue = "1") Integer page,@RequestParam(value = "rows",defaultValue = "10")  Integer rows){
        return userService.list(page, rows);
    }

    @PostMapping("/deleteUser")
    public ResponseBo delete(@RequestBody Integer[] ids){
        try {
            userService.delete(ids);
            return ResponseBo.ok();
        }catch (Exception e){
            return ResponseBo.error("删除用户失败，请联系网站管理员！");
        }
    }

    @PostMapping("/saveUser")
    public ResponseBo saveUser(@RequestBody User user){
        if (StringUtils.isEmpty(user.getLoginAccount())){
            return ResponseBo.warn("请输入登录账号名！");
        }
        if (user.getId()==null){
            try{
                if (userService.findUserByAccount(user.getLoginAccount())!=null){
                    return ResponseBo.warn("该用户名已被使用！");
                }
                user.setLoginPassword(MD5Utils.encrypt(user.getLoginAccount(), user.getLoginPassword()));
                userService.add(user);
                return ResponseBo.ok();
            }catch (Exception e){
                return ResponseBo.error(e.getMessage());
            }
        }else {
            try{
                User u = userService.show(user.getId());
                if (u.getLoginPassword().equals(user.getLoginPassword()) && u.getLoginAccount().equals(user.getLoginAccount())){
                    userService.update(user);
                }else {
                    user.setLoginPassword(MD5Utils.encrypt(user.getLoginAccount(), user.getLoginPassword()));
                    userService.update(user);
                }
                return ResponseBo.ok();
            }catch (Exception e){
                return ResponseBo.error(e.getMessage());
            }
        }

    }
}
