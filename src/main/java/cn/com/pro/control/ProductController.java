package cn.com.pro.control;

import cn.com.pro.service.ProductService;
import cn.com.pro.vo.Product;
import cn.com.pro.vo.pojo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
class ProductController {
    @Autowired
     private ProductService productService;

    /**
     * 查找最新商品
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("/new.do")
    public ResultBean<List<Product>> getNewProduct(@RequestParam(value="pageNo", defaultValue = "0", required=false) Integer pageNo, @RequestParam(value="pageSize", defaultValue = "12", required=false) Integer pageSize) {
        // 1、 需要做一些参数校验
        // 2、 可以返回一些错误code， mesg
        // 3、 数据OK， 可以返回code， Data
        Pageable pageable = new PageRequest(pageNo, pageSize);
        List<Product> products = productService.findNewProduct(pageable);
        ResultBean bean = new ResultBean(products);
        bean.setState(0);
        return bean;
    }
}