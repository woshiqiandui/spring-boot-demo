package com.example.demo.beans;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collection;


@Entity
// 表名 写 READER 或者 reader 都是一样的 参考ImprovedNamingStrategy
// hibernate 默认表名和类名完全映射，如果是 ReaderHistory => reader_history (默认转换为下划线+名称) 或者你配置 @Table(name="readerHistory")  也会转换为 reader_history
@Table(name="reader")
public class Reader implements UserDetails {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="ID",columnDefinition = "int(11)")
    private String id;

    @Column(name="USER_NAME",columnDefinition = "char(255)")
    private String username;

    @Column(name="FULL_NAME",columnDefinition = "char(255)")
    private String fullname;

    @Column(name="PASS_WORD",columnDefinition = "char(255)")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
     *  授权 reader的权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }


    /**
     *  不过期，不加锁，不禁用
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
