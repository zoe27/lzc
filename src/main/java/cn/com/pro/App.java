package cn.com.pro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class, args);
    }
}
