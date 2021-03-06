package com.tan.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 24429 on 2017/3/18.
 * by 谭钧豪
 */

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date createtime;

    @Id
    private String username;
    @Column(nullable = false)
    private String password;
    private String avatarurl;

    private String nickname;
    private String signature;
    private Date birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean checkUserNameOrPasswordIsEmpty(){
        return !(getUsername() != null && getPassword() != null && !getUsername().isEmpty() && !getPassword().isEmpty());
    }
}
