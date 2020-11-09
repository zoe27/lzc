package cn.com.pro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created with IntelliJ IDEA.
 *
 * @title: App
 * @projectName pro
 * @description: TODO
 * @User: zhoubin
 * @Date: 2020-10-18 10:39
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.com.pro.mapper")
@ServletComponentScan
public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
