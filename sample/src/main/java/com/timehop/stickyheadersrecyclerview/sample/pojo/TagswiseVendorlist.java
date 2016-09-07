
package com.timehop.stickyheadersrecyclerview.sample.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TagswiseVendorlist {

    @SerializedName("vendor_name")
    @Expose
    private String vendorName;
    @SerializedName("vendor_type")
    @Expose
    private String vendorType;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;  //shop id is same as vendor id
    @SerializedName("operating_radius")
    @Expose
    private String operatingRadius;
    @SerializedName("vendor_address")
    @Expose
    private String vendorAddress;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("vendor_email")
    @Expose
    private String vendorEmail;
    @SerializedName("vendor_image")
    @Expose
    private String vendorImage;

    /**
     * 
     * @return
     *     The vendorName
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * 
     * @param vendorName
     *     The vendor_name
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    /**
     * 
     * @return
     *     The vendorType
     */
    public String getVendorType() {
        return vendorType;
    }

    /**
     * 
     * @param vendorType
     *     The vendor_type
     */
    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    /**
     * 
     * @return
     *     The vendorId
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * 
     * @param vendorId
     *     The vendor_id
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * 
     * @return
     *     The operatingRadius
     */
    public String getOperatingRadius() {
        return operatingRadius;
    }

    /**
     * 
     * @param operatingRadius
     *     The operating_radius
     */
    public void setOperatingRadius(String operatingRadius) {
        this.operatingRadius = operatingRadius;
    }

    /**
     * 
     * @return
     *     The vendorAddress
     */
    public String getVendorAddress() {
        return vendorAddress;
    }

    /**
     * 
     * @param vendorAddress
     *     The vendor_address
     */
    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * 
     * @return
     *     The vendorEmail
     */
    public String getVendorEmail() {
        return vendorEmail;
    }

    /**
     * 
     * @param vendorEmail
     *     The vendor_email
     */
    public void setVendorEmail(String vendorEmail) {
        this.vendorEmail = vendorEmail;
    }

    /**
     * 
     * @return
     *     The vendorImage
     */
    public String getVendorImage() {
        return vendorImage;
    }

    /**
     * 
     * @param vendorImage
     *     The vendor_image
     */
    public void setVendorImage(String vendorImage) {
        this.vendorImage = vendorImage;
    }

}
