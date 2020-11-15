package cn.com.pro.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {
    @RequestMapping("/search.html")
    public String toSearchPage() {
        return "mall/search_result";
    }
}
