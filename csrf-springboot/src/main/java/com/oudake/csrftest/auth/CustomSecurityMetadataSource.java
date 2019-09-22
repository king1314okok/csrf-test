package com.oudake.csrftest.auth;

import com.oudake.csrftest.model.Permission;
import com.oudake.csrftest.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangyi
 */
@Configuration
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    @Autowired
    private IPermissionService permissionService;

    /**
     * 获取全部url非空的权限
     */
    public void loadPermissions() {
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute configAttribute;
        List<Permission> permissions = permissionService.findAllPermissions();
        for (Permission permission : permissions) {
            if (permission.getUrl() != null && !"".equals(permission.getUrl())) {
                array = new ArrayList<>();
                configAttribute = new SecurityConfig(permission.getName());
                // 此处只添加了用户的名字，其实还可以添加更多权限的信息，例如请求方法到ConfigAttribute的集合中去。此处添加的信息将会作为MyAccessDecisionManager类的decide的第三个参数。
                array.add(configAttribute);
                // 用权限的getUrl()作为map的key，用ConfigAttribute的集合作为 value，
                map.put(permission.getUrl(), array);
            }
        }

    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) {
            loadPermissions();
        }
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        // 如果当前请求url在权限集合里,则需要验证该用户是否有该权限
        for (String url : map.keySet()) {
            resUrl = url;
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
