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

//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import priv.jesse.mall.entity.*;
//import priv.jesse.mall.entity.pojo.ResultBean;
//import priv.jesse.mall.service.*;

@Controller
@RequestMapping("/product")
class ProductController {
    @Autowired
     private ProductService productService;
//     @Autowired
//     private ClassificationService classificationService;
//     @Autowired
//     private ShopCartService shopCartService;
//    @Autowired
//     private CommentService commentService;
//    @Autowired
//    private UserService userService;
//    @RequestMapping("/comment.do")
//    public void comment(
//                         int id,
//                         String name,
//                         String time,
//                         int likes,
//                         String content,
//                         String image,
//                         int commentnum,
//                         HttpServletResponse response) throws IOException {
////        SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
////        String datetime = tempDate.format(new Date());
//        int n=(int)(Math.random()*100)+1;
//        Integer A=Integer.valueOf(n);
//        Comment comment = new Comment();
//        comment.setId(id);
//        comment.setName("123");
//        comment.setTime("123");
//        comment.setLikes(likes);
//        comment.setContent(content);
//        comment.setImage("/mall/admin/product/img/10.jpg");
//       comment.setCommentnum(commentnum);
//        commentService.create(comment);
//        commentService.save(comment);
//        // 重定向刷新
//       response.sendRedirect("/mall/product/info.html");
//    }
     /**
     * 获取商品信息
     *
     * @param id
     * @return
     */
//    @RequestMapping("/get.do")
//    public ResultBean<Product> getProduct(int id) {
//        Product product = productService.findById(id);
//        return new ResultBean<>(product);
//    }
//    @RequestMapping("/getcomment.do")
//    public ResultBean<Comment> getComment(int id) {
//       Comment comments = commentService.findCommentById(id);
//     return new ResultBean<>(comments);
//   }
    /**
     * 打开商品详情页面
     *
     * @param id
     * @param map
     * @return
     */
//    @RequestMapping("/get.html")
//    public String toProductPage(int id, Map<String, Object> map) {
//        Product product = productService.findById(id);
//        User user =userService.findById(id);
//        List<Comment> comment = commentService.getCommentList();
//        map.put("product", product);
//        map.put("comment", comment);
//        map.put("user", user);
//        return "mall/product/info";
//    }
    /**
     * 查找热门商品
     *
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/hot.do")
//    public ResultBean<List<Product>> getHotProduct() {
//        List<Product> products = productService.findHotProduct();
//        return new ResultBean<>(products);
//    }

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

    /**
     * 打开分类查看商品页面
     *
     * @return
     */
//    @RequestMapping("/category.html")
//    public String toCatePage(int cid, Map<String, Object> map) {
//        Classification classification = classificationService.findById(cid);
//        map.put("category", classification);
//        return "mall/product/category";
//    }
//
//    @RequestMapping("/toCart.html")
//    public String toCart(){
//        return "mall/product/cart";
//    }

    /**
     * 按一级分类查找商品
     *
     * @param cid
     * @param pageNo
     * @param pageSize
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/category.do")
//    public ResultBean<List<Product>> getCategoryProduct(int cid, int pageNo, int pageSize) {
//        Pageable pageable = new PageRequest(pageNo, pageSize);
//        List<Product> products = productService.findByCid(cid, pageable);
//        return new ResultBean<>(products);
//    }

    /**
     * 按二级分类查找商品
     *
     * @param csId
     * @param pageNo
     * @param pageSize
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/categorySec.do")
//    public ResultBean<List<Product>> getCategorySecProduct(int csId, int pageNo, int pageSize) {
//        Pageable pageable = new PageRequest(pageNo, pageSize);
//        List<Product> products = productService.findByCsid(csId, pageable);
//        return new ResultBean<>(products);
//    }

    /**
     * 根据一级分类查询它所有的二级分类
     * @param cid
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/getCategorySec.do")
//    public ResultBean<List<Classification>> getCategorySec(int cid){
//        List<Classification> list = classificationService.findByParentId(cid);
//        return new ResultBean<>(list);
//    }

    /**
     * 添加进入购物车
     *
     * @param productId
     * @param request
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/addCart.do")
//    public ResultBean<Boolean> addToCart(int productId, HttpServletRequest request) throws Exception {
//        shopCartService.addCart(productId, request);
//        return new ResultBean<>(true);
//    }

    /**
     * 移除购物车
     *
     * @param productId
     * @param request
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/delCart.do")
//    public ResultBean<Boolean> delToCart(int productId, HttpServletRequest request) throws Exception {
//        shopCartService.remove(productId, request);
//        return new ResultBean<>(true);
//    }

    /**
     * 查看购物车商品
     * @param request
     * @return
     */
//    @ResponseBody
//    @RequestMapping("/listCart.do")
//    public ResultBean<List<OrderItem>> listCart(HttpServletRequest request) throws Exception {
//        List<OrderItem> orderItems = shopCartService.listCart(request);
//        return new ResultBean<>(orderItems);
//    }
}