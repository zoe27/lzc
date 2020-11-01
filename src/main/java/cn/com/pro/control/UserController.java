package cn.com.pro.control;


import cn.com.pro.service.UserService;
import cn.com.pro.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/mall/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 打开注册页面
     *
     * @return
     */
    @RequestMapping("/toRegister.html")
    public String toRegister() {
        return "mall/user/register";
    }

    /**
     * 打开登录页面
     *
     * @return
     */
    @RequestMapping("/toLogin.html")
    public String toLogin() {
        return "mall/user/login";
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     */
	@RequestMapping("/login.do")
	public String login(String username, String password, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		User user = userService.checkLogin(username, password);
		if (user != null) {
			// 登录成功 重定向到首页
			/*request.getSession().setAttribute("user", user);
			response.setHeader("token", SecurityUtil.getToken(user));
			Cookie loginCookie = new Cookie("token", SecurityUtil.getToken(user));
			loginCookie.setDomain("127.0.0.1");  
            loginCookie.setPath("/"); 
			response.addCookie(loginCookie);*/
			response.sendRedirect("/index");
			return "/index";
		} else {
            return "/mall/user/register";

		}

	}

    /**
     * 注册
     */
//    @RequestMapping("/register.do")
//    public void register(String username,
//                         String password,
//                         String name,
//                         String phone,
//                         String email,
//                         String addr,
//                         HttpServletResponse response) throws IOException {
//        User user = new User();
//        user.setUsername(username);
//        user.setPhone(phone);
//        user.setPassword(password);
//        user.setName(name);
//        user.setEmail(email);
//        user.setAddr(addr);
//        userService.create(user);
//        // 注册完成后重定向到登录页面
//        response.sendRedirect("/mall/user/toLogin.html");
//    }

    /**
     * 登出
     */
//    @RequestMapping("/logout.do")
//    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.getSession().removeAttribute("user");
//        response.sendRedirect("/mall/index.html");
//    }

    /**
     * 验证用户名是否唯一
     * @param username
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/checkUsername.do")
//    public ResultBean<Boolean> checkUsername(String username){
//        List<User> users = userService.findByUsername(username);
//        if (users==null||users.isEmpty()){
//            return new ResultBean<>(true);
//        }
//        return new ResultBean<>(false);
//    }

 //   }
}