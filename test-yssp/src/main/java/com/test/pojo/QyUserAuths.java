package com.test.pojo;

public class QyUserAuths {
    /**
     * 用户可登陆权限表主键id
     */
    private Integer qyUserAuthsId;

    /**
     * 用户主键id
     */
    private Long primarykeyid;

    /**
     * 登陆权限类型
     */
    private String identityType;

    /**
     * 权限登陆账号
     */
    private String identifier;

    /**
     * 权限密码
     */
    private String credential;

    /**
     * 是否授权该种方式登录登录
     */
    private Byte verified;

    /**
     * 备注信息，保留扩展字段
     */
    private String authsRemark;

    /**
     * 用户可登陆权限表主键id
     * @return qy_user_auths_id 用户可登陆权限表主键id
     */
    public Integer getQyUserAuthsId() {
        return qyUserAuthsId;
    }

    /**
     * 用户可登陆权限表主键id
     * @param qyUserAuthsId 用户可登陆权限表主键id
     */
    public void setQyUserAuthsId(Integer qyUserAuthsId) {
        this.qyUserAuthsId = qyUserAuthsId;
    }

    /**
     * 用户主键id
     * @return primaryKeyId 用户主键id
     */
    public Long getPrimarykeyid() {
        return primarykeyid;
    }

    /**
     * 用户主键id
     * @param primarykeyid 用户主键id
     */
    public void setPrimarykeyid(Long primarykeyid) {
        this.primarykeyid = primarykeyid;
    }

    /**
     * 登陆权限类型
     * @return identity_type 登陆权限类型
     */
    public String getIdentityType() {
        return identityType;
    }

    /**
     * 登陆权限类型
     * @param identityType 登陆权限类型
     */
    public void setIdentityType(String identityType) {
        this.identityType = identityType == null ? null : identityType.trim();
    }

    /**
     * 权限登陆账号
     * @return identifier 权限登陆账号
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * 权限登陆账号
     * @param identifier 权限登陆账号
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    /**
     * 权限密码
     * @return credential 权限密码
     */
    public String getCredential() {
        return credential;
    }

    /**
     * 权限密码
     * @param credential 权限密码
     */
    public void setCredential(String credential) {
        this.credential = credential == null ? null : credential.trim();
    }

    /**
     * 是否授权该种方式登录登录
     * @return verified 是否授权该种方式登录登录
     */
    public Byte getVerified() {
        return verified;
    }

    /**
     * 是否授权该种方式登录登录
     * @param verified 是否授权该种方式登录登录
     */
    public void setVerified(Byte verified) {
        this.verified = verified;
    }

    /**
     * 备注信息，保留扩展字段
     * @return auths_remark 备注信息，保留扩展字段
     */
    public String getAuthsRemark() {
        return authsRemark;
    }

    /**
     * 备注信息，保留扩展字段
     * @param authsRemark 备注信息，保留扩展字段
     */
    public void setAuthsRemark(String authsRemark) {
        this.authsRemark = authsRemark == null ? null : authsRemark.trim();
    }
}