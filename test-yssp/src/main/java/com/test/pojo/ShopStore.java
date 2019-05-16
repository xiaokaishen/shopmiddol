package com.test.pojo;

import com.sun.javafx.beans.IDProperty;

import java.util.List;

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
     * 状态
     */
    private Byte storeState;
    /**
     * 展示图片路径
     */
    private String storeViewUrl;
    /**
     * 下载图片路径
     */
    private String storeDownloadUrl;


    @Override
    public String toString() {
        return "ShopStore{" +
                "storeId=" + storeId +
                ", storeProvince='" + storeProvince + '\'' +
                ", storeCity='" + storeCity + '\'' +
                ", storeRegion='" + storeRegion + '\'' +
                ", storeDistributorJc='" + storeDistributorJc + '\'' +
                ", storeDistributorQc='" + storeDistributorQc + '\'' +
                ", storePhone='" + storePhone + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeState=" + storeState +
                ", storeViewUrl='" + storeViewUrl + '\'' +
                ", storeDownloadUrl='" + storeDownloadUrl + '\'' +
                ", childList=" + childList +
                '}';
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreViewUrl() {
        return storeViewUrl;
    }

    public void setStoreViewUrl(String storeViewUrl) {
        this.storeViewUrl = storeViewUrl;
    }

    public String getStoreDownloadUrl() {
        return storeDownloadUrl;
    }

    public void setStoreDownloadUrl(String storeDownloadUrl) {
        this.storeDownloadUrl = storeDownloadUrl;
    }

    private List<ShopStore> childList;

    public List<ShopStore> getChildList() {
        return childList;
    }

    public void setChildList(List<ShopStore> childList) {
        this.childList = childList;
    }

    public Byte getStoreState() {
        return storeState;
    }

    public void setStoreState(Byte storeState) {
        this.storeState = storeState;
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