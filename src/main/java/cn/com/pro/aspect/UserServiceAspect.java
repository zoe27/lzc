package cn.com.pro.aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserServiceAspect {

    @Pointcut("execution(public * cn.com.pro.service.UserService.checkLogin(..))")
    public void checklogin(){
        System.out.println("aspect");
    }

    @Before("checklogin()")
    public void doBefore(){
        System.out.println("before");
    }

    @After("checklogin()")
    public void doAfter(){
        System.out.println("after");
    }

    @AfterThrowing("checklogin()")
    public void rollback(){

    }


}
