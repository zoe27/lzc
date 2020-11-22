package cn.com.pro.control;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 基于springboot的webapi 接口
 *
 * @author zhoubin
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
        return "login";
    }

    @RequestMapping("/batch")
    @ResponseBody
    public String batchInsert() {

        return "OK";
    }

    @RequestMapping("/index")
    public String toIndex(@RequestParam("page") String page) {
        if ("1".equals(page)) {
            return "index";
        }
        return "redirect";
    }
}
