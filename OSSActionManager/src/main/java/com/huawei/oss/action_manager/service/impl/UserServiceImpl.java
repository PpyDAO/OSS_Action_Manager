package com.huawei.oss.action_manager.service.impl;

import com.huawei.oss.action_manager.dao.IUserDao;
import com.huawei.oss.action_manager.pojo.User;
import com.huawei.oss.action_manager.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class UserServiceImpl implements IUserService, UserDetailsService {
    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findByUsername(String username) {
        User user = new User();
        user.setUsername(username);

        return userDao.select(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //构建用户信息的逻辑(取数据库/LDAP等用户信息)

        User userInfo = new User();
        userInfo.setUsername(username);

        try {
            userInfo = userDao.selectOne(userInfo);
            userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));

            //Todo role future
            Set<GrantedAuthority> authoritiesSet = new HashSet<>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
            authoritiesSet.add(authority);
            userInfo.setAuthorities(authoritiesSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userInfo;
    }
}
