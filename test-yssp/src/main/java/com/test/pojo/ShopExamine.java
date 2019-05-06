package com.test.pojo;

public class ShopExamine {
    /**
     * 审核id
     */
    private Integer examineId;

    /**
     * 审核门店id
     */
    private Integer examineStoreId;

    /**
     * 审核门店名称
     */
    private String examineStoreName;

    /**
     * 审核用户id
     */
    private Integer examineUserId;

    /**
     * 审核用户名称
     */
    private String examineUserName;

    /**
     * 用户手机号码
     */
    private String examineUserPhone;

    /**
     * 用户支付宝账号
     */
    private String examineUserAlipay;

    /**
     * 审核状态
     */
    private Byte examineState;

    /**
     * 支付情况
     */
    private Byte paymentState;

    /**
     * 创建时间
     */
    private String examineEstablishTime;

    /**
     * 修改时间
     */
    private String examineModifyTime;

    /**
     * 审核id
     * @return examine_id 审核id
     */
    public Integer getExamineId() {
        return examineId;
    }

    /**
     * 审核id
     * @param examineId 审核id
     */
    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    /**
     * 审核门店id
     * @return examine_store_id 审核门店id
     */
    public Integer getExamineStoreId() {
        return examineStoreId;
    }

    /**
     * 审核门店id
     * @param examineStoreId 审核门店id
     */
    public void setExamineStoreId(Integer examineStoreId) {
        this.examineStoreId = examineStoreId;
    }

    /**
     * 审核门店名称
     * @return examine_store_name 审核门店名称
     */
    public String getExamineStoreName() {
        return examineStoreName;
    }

    /**
     * 审核门店名称
     * @param examineStoreName 审核门店名称
     */
    public void setExamineStoreName(String examineStoreName) {
        this.examineStoreName = examineStoreName == null ? null : examineStoreName.trim();
    }

    /**
     * 审核用户id
     * @return examine_user_id 审核用户id
     */
    public Integer getExamineUserId() {
        return examineUserId;
    }

    /**
     * 审核用户id
     * @param examineUserId 审核用户id
     */
    public void setExamineUserId(Integer examineUserId) {
        this.examineUserId = examineUserId;
    }

    /**
     * 审核用户名称
     * @return examine_user_name 审核用户名称
     */
    public String getExamineUserName() {
        return examineUserName;
    }

    /**
     * 审核用户名称
     * @param examineUserName 审核用户名称
     */
    public void setExamineUserName(String examineUserName) {
        this.examineUserName = examineUserName == null ? null : examineUserName.trim();
    }

    /**
     * 用户手机号码
     * @return examine_user_phone 用户手机号码
     */
    public String getExamineUserPhone() {
        return examineUserPhone;
    }

    /**
     * 用户手机号码
     * @param examineUserPhone 用户手机号码
     */
    public void setExamineUserPhone(String examineUserPhone) {
        this.examineUserPhone = examineUserPhone == null ? null : examineUserPhone.trim();
    }

    /**
     * 用户支付宝账号
     * @return examine_user_alipay 用户支付宝账号
     */
    public String getExamineUserAlipay() {
        return examineUserAlipay;
    }

    /**
     * 用户支付宝账号
     * @param examineUserAlipay 用户支付宝账号
     */
    public void setExamineUserAlipay(String examineUserAlipay) {
        this.examineUserAlipay = examineUserAlipay == null ? null : examineUserAlipay.trim();
    }

    /**
     * 修改状态
     * @return examine_state 修改状态
     */
    public Byte getExamineState() {
        return examineState;
    }

    /**
     * 修改状态
     * @param examineState 修改状态
     */
    public void setExamineState(Byte examineState) {
        this.examineState = examineState;
    }

    /**
     * 支付情况
     * @return payment_state 支付情况
     */
    public Byte getPaymentState() {
        return paymentState;
    }

    /**
     * 支付情况
     * @param paymentState 支付情况
     */
    public void setPaymentState(Byte paymentState) {
        this.paymentState = paymentState;
    }

    /**
     * 创建时间
     * @return examine_establish_time 创建时间
     */
    public String getExamineEstablishTime() {
        return examineEstablishTime;
    }

    /**
     * 创建时间
     * @param examineEstablishTime 创建时间
     */
    public void setExamineEstablishTime(String examineEstablishTime) {
        this.examineEstablishTime = examineEstablishTime == null ? null : examineEstablishTime.trim();
    }

    /**
     * 修改时间
     * @return examine_modify_time 修改时间
     */
    public String getExamineModifyTime() {
        return examineModifyTime;
    }

    /**
     * 修改时间
     * @param examineModifyTime 修改时间
     */
    public void setExamineModifyTime(String examineModifyTime) {
        this.examineModifyTime = examineModifyTime == null ? null : examineModifyTime.trim();
    }
}