//package cn.com.pro.control;
//
//
//import cn.com.pro.mapper.UserAdminMapper;
//import cn.com.pro.mapper.UserMapper;
//import cn.com.pro.vo.User;
//import cn.com.pro.vo.UserAdmin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//
///**
// * 基于springboot的webapi 接口
// * @author zhoubin
// *
// */
//
//@Controller
//public class TestControl {
//
//	@Autowired
//	UserMapper userMapper;
//
//	@Autowired
//	UserAdminMapper userAdminMapper;
//
//
//	@RequestMapping("/test1")
//	@ResponseBody
//	public String test() {
//		/*加入逻辑*/
//		return "hello world";
//	}
//
//	@RequestMapping("/user")
//	@ResponseBody
//	public List<User> getUser(){
//		return userMapper.selectAll();
//	}
//
//	@RequestMapping("/test")
//	public String testPage() {
//		//System.out.println(user.selectAll());
//		return "login";
//	}
//
//	@RequestMapping("/batch")
//	@ResponseBody
//	public String batchInsert(){
//		for (int i = 0; i < 100000; i++){
//			UserAdmin userAdmin = new UserAdmin();
//			userAdmin.setAddr("beijing" + i);
//			userAdmin.setEmail("hello@126.ocom");
//			userAdmin.setPhone("15321111111" + i);
//			userAdmin.setUsername(String.valueOf(i));
//			userAdminMapper.insert(userAdmin);
//		}
//		return "OK";
//	}
//
//	@RequestMapping("/index")
//	public String toIndex(@RequestParam("page") String page){
//		if("1".equals(page)) {
//			return "index";
//		}
//		return "redirect";
//	}
//}
