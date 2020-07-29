package net.gdut.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import net.gdut.bean.TbUser;
import net.gdut.service.impl.TbUserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;


public class UserRealm extends AuthorizingRealm {
        @Autowired
        private TbUserServiceImpl userServiceImpl;

        //登录之后用于授权
        @Override
        protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
        {
            String username = (String) principals.getPrimaryPrincipal();
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            List<String> roles = userServiceImpl.getRole(username);
            for (String role : roles){
                System.out.println("权限为："+role);
            }
            authorizationInfo.setRoles(new HashSet<>(roles));
            return authorizationInfo;
        }

        //用于验证身份
        @Override
        protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
                throws AuthenticationException
        {
            String username = (String)authenticationToken.getPrincipal();
            TbUser user = userServiceImpl.getUser(username);
            System.out.println("验证用户："+user);
            if(user == null) {
                //找不到账号
                throw new UnknownAccountException();
            }
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    user.getUname(), //用户名
                    user.getPassword(),
                    getName()  //realm name
            );
            return authenticationInfo;
        }

}
