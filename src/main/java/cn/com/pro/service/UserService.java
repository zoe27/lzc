package cn.com.pro.service;



import cn.com.pro.vo.User;

import java.util.List;

public interface UserService {

    User findById(int id);

    void update(User user);

    int create(User user);

    void delById(int id);

    List<User> findByUsername(String username);

    User checkLogin(String username, String password);

    void addOrder();


}
