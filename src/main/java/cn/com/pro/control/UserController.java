package cn.com.pro.control;


import cn.com.pro.service.UserService;
import cn.com.pro.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
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
            request.getSession().setAttribute("user", user);
			//response.sendRedirect("/index");
            Cookie loginCookie = new Cookie("token", user.getUsername());
            loginCookie.setDomain("127.0.0.1");
            loginCookie.setPath("/");
            response.addCookie(loginCookie);
            //response.sendRedirect("/index");
			return "/mall/index";
		} else {
            return "/mall/user/register";

		}

	}

}