package com.xiyifen.miaosha.service;

import com.xiyifen.miaosha.dao.UserDao;
import com.xiyifen.miaosha.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: fs.z
 * @Date: 2018/12/22 10:59
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public User getById(int id) {
        return userDao.getById(id);
    }

    @Transactional
    public boolean tx(){
        User u1=new User();
        u1.setId(2);
        u1.setName("xiaoming");
        userDao.insert(u1);

        User user=new User();
        user.setId(1);
        user.setName("jfkdfjdk");
        userDao.insert(user);

        return true;
    }
}
