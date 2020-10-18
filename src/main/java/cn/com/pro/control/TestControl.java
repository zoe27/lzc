package cn.com.pro.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 基于springboot的webapi 接口
 * @author zhoubin
 *
 */

@Controller
public class TestControl {
	

	@RequestMapping("/test1")
	@ResponseBody
	public String test() {
		/*加入逻辑*/
		return "hello world";
	}

	@RequestMapping("/test")
	public String testPage() {
		//System.out.println(user.selectAll());
		return "login";
	}
}
