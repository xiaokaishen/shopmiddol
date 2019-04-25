package com.test.pojo;

public class ShopCmsUser {
    /**
     * 后台用户唯一自增主键
     */
    private Long cmsUserId;

    /**
     * 后台用户唯一用户名
     */
    private String cmsUserName;

    /**
     * 后台用户登录密码
     */
    private String cmsUserPass;

    /**
     * 后台管理系统用户头像
     */
    private String cmsUserImg;

    /**
     * 后台管理系统用户电话
     */
    private String cmsUserTel;

    /**
     * 后台用户状态:1正常状态  -1：已删除状态
     */
    private Byte cmsUserStatus;

    /**
     * 后台用户权限 未定
     */
    private Byte cmsUserAuth;

    /**
     * 后台用户唯一自增主键
     * @return cms_user_id 后台用户唯一自增主键
     */
    public Long getCmsUserId() {
        return cmsUserId;
    }

    /**
     * 后台用户唯一自增主键
     * @param cmsUserId 后台用户唯一自增主键
     */
    public void setCmsUserId(Long cmsUserId) {
        this.cmsUserId = cmsUserId;
    }

    /**
     * 后台用户唯一用户名
     * @return cms_user_name 后台用户唯一用户名
     */
    public String getCmsUserName() {
        return cmsUserName;
    }

    /**
     * 后台用户唯一用户名
     * @param cmsUserName 后台用户唯一用户名
     */
    public void setCmsUserName(String cmsUserName) {
        this.cmsUserName = cmsUserName == null ? null : cmsUserName.trim();
    }

    /**
     * 后台用户登录密码
     * @return cms_user_pass 后台用户登录密码
     */
    public String getCmsUserPass() {
        return cmsUserPass;
    }

    /**
     * 后台用户登录密码
     * @param cmsUserPass 后台用户登录密码
     */
    public void setCmsUserPass(String cmsUserPass) {
        this.cmsUserPass = cmsUserPass == null ? null : cmsUserPass.trim();
    }

    /**
     * 后台管理系统用户头像
     * @return cms_user_img 后台管理系统用户头像
     */
    public String getCmsUserImg() {
        return cmsUserImg;
    }

    /**
     * 后台管理系统用户头像
     * @param cmsUserImg 后台管理系统用户头像
     */
    public void setCmsUserImg(String cmsUserImg) {
        this.cmsUserImg = cmsUserImg == null ? null : cmsUserImg.trim();
    }

    /**
     * 后台管理系统用户电话
     * @return cms_user_tel 后台管理系统用户电话
     */
    public String getCmsUserTel() {
        return cmsUserTel;
    }

    /**
     * 后台管理系统用户电话
     * @param cmsUserTel 后台管理系统用户电话
     */
    public void setCmsUserTel(String cmsUserTel) {
        this.cmsUserTel = cmsUserTel == null ? null : cmsUserTel.trim();
    }

    /**
     * 后台用户状态:1正常状态  -1：已删除状态
     * @return cms_user_status 后台用户状态:1正常状态  -1：已删除状态
     */
    public Byte getCmsUserStatus() {
        return cmsUserStatus;
    }

    /**
     * 后台用户状态:1正常状态  -1：已删除状态
     * @param cmsUserStatus 后台用户状态:1正常状态  -1：已删除状态
     */
    public void setCmsUserStatus(Byte cmsUserStatus) {
        this.cmsUserStatus = cmsUserStatus;
    }

    /**
     * 后台用户权限 未定
     * @return cms_user_auth 后台用户权限 未定
     */
    public Byte getCmsUserAuth() {
        return cmsUserAuth;
    }

    /**
     * 后台用户权限 未定
     * @param cmsUserAuth 后台用户权限 未定
     */
    public void setCmsUserAuth(Byte cmsUserAuth) {
        this.cmsUserAuth = cmsUserAuth;
    }
}