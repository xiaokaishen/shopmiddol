package com.test.pojo;

import java.util.Date;

public class ShopUser {
    /**
     * 会员号
     */
    private Long id;

    /**
     * 用户名
     */
    private String userid;

    /**
     * 姓名
     */
    private String username;

    /**
     * 微信唯一ID
     */
    private String openid;

    /**
     * 微信昵称
     */
    private String wxname;

    /**
     * 头像URL
     */
    private String headPortraitUrl;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别：0，男；1：女
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 身份证号码
     */
    private String idcard;

    /**
     * 注册时间
     */
    private Date createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 个人简介
     */
    private String userRemark;

    /**
     * 
     */
    private String userCity;

    /**
     * 会员号
     * @return ID 会员号
     */
    public Long getId() {
        return id;
    }

    /**
     * 会员号
     * @param id 会员号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 用户名
     * @return userID 用户名
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 用户名
     * @param userid 用户名
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * 姓名
     * @return username 姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 姓名
     * @param username 姓名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 微信唯一ID
     * @return openID 微信唯一ID
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 微信唯一ID
     * @param openid 微信唯一ID
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 微信昵称
     * @return wxName 微信昵称
     */
    public String getWxname() {
        return wxname;
    }

    /**
     * 微信昵称
     * @param wxname 微信昵称
     */
    public void setWxname(String wxname) {
        this.wxname = wxname == null ? null : wxname.trim();
    }

    /**
     * 头像URL
     * @return Head_portrait_url 头像URL
     */
    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    /**
     * 头像URL
     * @param headPortraitUrl 头像URL
     */
    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl == null ? null : headPortraitUrl.trim();
    }

    /**
     * 电话
     * @return telephone 电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 电话
     * @param telephone 电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 性别：0，男；1：女
     * @return sex 性别：0，男；1：女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别：0，男；1：女
     * @param sex 性别：0，男；1：女
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 生日
     * @return birthday 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 身份证号码
     * @return IDCard 身份证号码
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 身份证号码
     * @param idcard 身份证号码
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * 注册时间
     * @return CreateTime 注册时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 注册时间
     * @param createtime 注册时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 更新时间
     * @return UpdateTime 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 更新时间
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 个人简介
     * @return user_remark 个人简介
     */
    public String getUserRemark() {
        return userRemark;
    }

    /**
     * 个人简介
     * @param userRemark 个人简介
     */
    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark == null ? null : userRemark.trim();
    }

    /**
     * 
     * @return user_city 
     */
    public String getUserCity() {
        return userCity;
    }

    /**
     * 
     * @param userCity 
     */
    public void setUserCity(String userCity) {
        this.userCity = userCity == null ? null : userCity.trim();
    }
}