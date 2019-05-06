package com.test.pojo;

public class ShopStore {
    /**
     * 门店id
     */
    private Integer storeId;

    /**
     * 门店所在省份
     */
    private String storeProvince;

    /**
     * 门店所在城市
     */
    private String storeCity;

    /**
     * 门店所在区域
     */
    private String storeRegion;

    /**
     * 经销商简称
     */
    private String storeDistributorJc;

    /**
     * 经销商全称
     */
    private String storeDistributorQc;

    /**
     * 电话
     */
    private String storePhone;

    /**
     * 地址
     */
    private String storeAddress;

    /**
     * 门店id
     * @return store_id 门店id
     */
    public Integer getStoreId() {
        return storeId;
    }

    /**
     * 门店id
     * @param storeId 门店id
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    /**
     * 门店所在省份
     * @return store_province 门店所在省份
     */
    public String getStoreProvince() {
        return storeProvince;
    }

    /**
     * 门店所在省份
     * @param storeProvince 门店所在省份
     */
    public void setStoreProvince(String storeProvince) {
        this.storeProvince = storeProvince == null ? null : storeProvince.trim();
    }

    /**
     * 门店所在城市
     * @return store_city 门店所在城市
     */
    public String getStoreCity() {
        return storeCity;
    }

    /**
     * 门店所在城市
     * @param storeCity 门店所在城市
     */
    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity == null ? null : storeCity.trim();
    }

    /**
     * 门店所在区域
     * @return store_region 门店所在区域
     */
    public String getStoreRegion() {
        return storeRegion;
    }

    /**
     * 门店所在区域
     * @param storeRegion 门店所在区域
     */
    public void setStoreRegion(String storeRegion) {
        this.storeRegion = storeRegion == null ? null : storeRegion.trim();
    }

    /**
     * 经销商简称
     * @return store_distributor_jc 经销商简称
     */
    public String getStoreDistributorJc() {
        return storeDistributorJc;
    }

    /**
     * 经销商简称
     * @param storeDistributorJc 经销商简称
     */
    public void setStoreDistributorJc(String storeDistributorJc) {
        this.storeDistributorJc = storeDistributorJc == null ? null : storeDistributorJc.trim();
    }

    /**
     * 经销商全称
     * @return store_distributor_qc 经销商全称
     */
    public String getStoreDistributorQc() {
        return storeDistributorQc;
    }

    /**
     * 经销商全称
     * @param storeDistributorQc 经销商全称
     */
    public void setStoreDistributorQc(String storeDistributorQc) {
        this.storeDistributorQc = storeDistributorQc == null ? null : storeDistributorQc.trim();
    }

    /**
     * 电话
     * @return store_phone 电话
     */
    public String getStorePhone() {
        return storePhone;
    }

    /**
     * 电话
     * @param storePhone 电话
     */
    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone == null ? null : storePhone.trim();
    }

    /**
     * 地址
     * @return store_address 地址
     */
    public String getStoreAddress() {
        return storeAddress;
    }

    /**
     * 地址
     * @param storeAddress 地址
     */
    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }
}