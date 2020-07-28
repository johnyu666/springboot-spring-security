package cn.johnyu.springbootspringsecurity.domain;

import org.hibernate.engine.internal.Cascade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class SysUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    //此处不能使用默认的懒加载
    @ManyToMany(fetch=FetchType.EAGER)
    private List<SysRole> roles;
    @Override
    public String getUsername() {
        return username;
    }
    @Override
    public String getPassword() {
        return password;
    }
    //给用户赋予角色的逻辑
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths=new ArrayList<>();
        List<SysRole> roles=this.roles;
        for (SysRole role:roles){
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    /**
     * 以下的方法可以动态的让一个用户"失效"
     * @return
     */

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
