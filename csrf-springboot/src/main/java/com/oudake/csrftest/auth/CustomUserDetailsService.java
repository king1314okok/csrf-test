package com.oudake.csrftest.auth;

import com.oudake.csrftest.model.Role;
import com.oudake.csrftest.service.IRoleService;
import com.oudake.csrftest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyi
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.oudake.csrftest.model.User user = userService.findUserByUsername(username);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if (user == null) {
            throw new UsernameNotFoundException("用户:" + username + "不存在");
        } else {
            List<Role> roleList = roleService.findRolesByUserId(user.getId());
            for (Role role : roleList) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
                // 此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority对象。
                grantedAuthorityList.add(grantedAuthority);
            }
        }
        return new User(username, passwordEncoder.encode(user.getPassword()),
                true, true, true, true, grantedAuthorityList);
    }
}
