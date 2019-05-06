package com.test.pojo;

public class ShopReport {
    /**
     * id
     */
    private Integer reportId;

    /**
     * 姓名
     */
    private String reportName;

    /**
     * 手机
     */
    private String reportPhone;

    /**
     * 邮箱
     */
    private String reportMailbox;

    /**
     * 支付宝账号
     */
    private String reportAlipay;

    /**
     * 试驾意向
     */
    private Byte reportTestDrive;

    /**
     * 更新时间
     */
    private String reportUpdateTime;

    /**
     * 创建时间
     */
    private String reportCreateTime;

    /**
     * 状态
     */
    private Byte reportStatus;



    /**
     * 
     * @return report_id 
     */
    public Integer getReportId() {
        return reportId;
    }

    /**
     * 
     * @param reportId 
     */
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    /**
     * 
     * @return report_name 
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * 
     * @param reportName 
     */
    public void setReportName(String reportName) {
        this.reportName = reportName == null ? null : reportName.trim();
    }

    /**
     * 
     * @return report_phone 
     */
    public String getReportPhone() {
        return reportPhone;
    }

    /**
     * 
     * @param reportPhone 
     */
    public void setReportPhone(String reportPhone) {
        this.reportPhone = reportPhone == null ? null : reportPhone.trim();
    }

    /**
     * 
     * @return report_mailbox 
     */
    public String getReportMailbox() {
        return reportMailbox;
    }

    /**
     * 
     * @param reportMailbox 
     */
    public void setReportMailbox(String reportMailbox) {
        this.reportMailbox = reportMailbox == null ? null : reportMailbox.trim();
    }

    /**
     * 
     * @return report_alipay 
     */
    public String getReportAlipay() {
        return reportAlipay;
    }

    /**
     * 
     * @param reportAlipay 
     */
    public void setReportAlipay(String reportAlipay) {
        this.reportAlipay = reportAlipay == null ? null : reportAlipay.trim();
    }

    /**
     * 
     * @return report_test_drive 
     */
    public Byte getReportTestDrive() {
        return reportTestDrive;
    }

    /**
     * 
     * @param reportTestDrive 
     */
    public void setReportTestDrive(Byte reportTestDrive) {
        this.reportTestDrive = reportTestDrive;
    }

    /**
     * 更新时间
     * @return report_update_time 更新时间
     */
    public String getReportUpdateTime() {
        return reportUpdateTime;
    }

    /**
     * 更新时间
     * @param reportUpdateTime 更新时间
     */
    public void setReportUpdateTime(String reportUpdateTime) {
        this.reportUpdateTime = reportUpdateTime == null ? null : reportUpdateTime.trim();
    }

    /**
     * 创建时间
     * @return report_create_time 创建时间
     */
    public String getReportCreateTime() {
        return reportCreateTime;
    }

    /**
     * 创建时间
     * @param reportCreateTime 创建时间
     */
    public void setReportCreateTime(String reportCreateTime) {
        this.reportCreateTime = reportCreateTime == null ? null : reportCreateTime.trim();
    }

    /**
     * 状态
     * @return report_status 状态
     */
    public Byte getReportStatus() {
        return reportStatus;
    }

    /**
     * 状态
     * @param reportStatus 状态
     */
    public void setReportStatus(Byte reportStatus) {
        this.reportStatus = reportStatus;
    }

    @Override
    public String toString() {
        return "ShopReport{" +
                "reportId=" + reportId +
                ", reportName='" + reportName + '\'' +
                ", reportPhone='" + reportPhone + '\'' +
                ", reportMailbox='" + reportMailbox + '\'' +
                ", reportAlipay='" + reportAlipay + '\'' +
                ", reportTestDrive='" + reportTestDrive + '\'' +
                ", reportUpdateTime='" + reportUpdateTime + '\'' +
                ", reportCreateTime='" + reportCreateTime + '\'' +
                ", reportStatus=" + reportStatus +
                '}';
    }
}