package cn.com.pro.service;

import cn.com.pro.mapper.UserMapper;
import cn.com.pro.service.UserService;
import cn.com.pro.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(int id) {
        return null; //userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        // userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int create(User user) {
        return userMapper.insert(user);
    }

    @Transactional
    @Override
    public void delById(int id) {
        /*userMapper.deleteByPrimaryKey(id);
        User user = new User();
        user.setId(2);*/
        //userMapper.insert(user);
    }

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    @Override
    public List<User> findByUsername(String username) {
        return null;
    }

    /**
     * 检查登录
     *
     * @param username 用户的用户名
     * @param password 用户的密码
     * @return
     */
    @Override
    public User checkLogin(String username, String password) {
        return userMapper.findByUsernameAndPassword(username, password);
    }
}