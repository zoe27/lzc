package cn.com.pro.control;


import cn.com.pro.mapper.UserMapper;
import cn.com.pro.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 基于springboot的webapi 接口
 * @author zhoubin
 *
 */

@Controller
public class TestControl {

	@Autowired
	UserMapper userMapper;
	

	@RequestMapping("/test1")
	@ResponseBody
	public String test() {
		/*加入逻辑*/
		return "hello world";
	}

	@RequestMapping("/user")
	@ResponseBody
	public List<User> getUser(){
		return userMapper.selectAll();
	}

	@RequestMapping("/test")
	public String testPage() {
		//System.out.println(user.selectAll());
		return "login";
	}
}
