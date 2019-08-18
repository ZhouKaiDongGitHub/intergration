package cn.kzhou.swagger;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "订单实体")
public class OrderInfo {

    @ApiModelProperty(value = "订单号", example = "201701011234", notes = "订单的编号")
    private String orderNo;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("中介公司编码")
    private String agencyCode;

    @ApiModelProperty("中介公司名称")
    private String agencyName;

    @ApiModelProperty("门店ID")
    private String storeId;

    @ApiModelProperty("门店名称")
    private String storeName;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
