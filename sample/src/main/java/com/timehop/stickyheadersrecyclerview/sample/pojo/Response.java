
package com.timehop.stickyheadersrecyclerview.sample.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Response {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("thumbnail_path")
    @Expose
    private String thumbnailPath;
    @SerializedName("image_width")
    @Expose
    private String imageWidth;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    @SerializedName("vendor_thumbnail_path")
    @Expose
    private String vendorThumbnailPath;
    @SerializedName("total_pages")
    @Expose
    private int totalPages;
    @SerializedName("vendor_image_path")
    @Expose
    private String vendorImagePath;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();
    @SerializedName("image_height")
    @Expose
    private String imageHeight;
    @SerializedName("user_image_path")
    @Expose
    private String userImagePath;
    @SerializedName("image_path")
    @Expose
    private String imagePath;
    @SerializedName("code")
    @Expose
    private String code;

    /**
     * 
     * @return
     *     The message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 
     * @return
     *     The thumbnailPath
     */
    public String getThumbnailPath() {
        return thumbnailPath;
    }

    /**
     * 
     * @param thumbnailPath
     *     The thumbnail_path
     */
    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    /**
     * 
     * @return
     *     The imageWidth
     */
    public String getImageWidth() {
        return imageWidth;
    }

    /**
     * 
     * @param imageWidth
     *     The image_width
     */
    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    /**
     * 
     * @return
     *     The userThumbnailPath
     */
    public String getUserThumbnailPath() {
        return userThumbnailPath;
    }

    /**
     * 
     * @param userThumbnailPath
     *     The user_thumbnail_path
     */
    public void setUserThumbnailPath(String userThumbnailPath) {
        this.userThumbnailPath = userThumbnailPath;
    }

    /**
     * 
     * @return
     *     The vendorThumbnailPath
     */
    public String getVendorThumbnailPath() {
        return vendorThumbnailPath;
    }

    /**
     * 
     * @param vendorThumbnailPath
     *     The vendor_thumbnail_path
     */
    public void setVendorThumbnailPath(String vendorThumbnailPath) {
        this.vendorThumbnailPath = vendorThumbnailPath;
    }

    /**
     * 
     * @return
     *     The totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * 
     * @param totalPages
     *     The total_pages
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 
     * @return
     *     The vendorImagePath
     */
    public String getVendorImagePath() {
        return vendorImagePath;
    }

    /**
     * 
     * @param vendorImagePath
     *     The vendor_image_path
     */
    public void setVendorImagePath(String vendorImagePath) {
        this.vendorImagePath = vendorImagePath;
    }

    /**
     * 
     * @return
     *     The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    /**
     * 
     * @return
     *     The imageHeight
     */
    public String getImageHeight() {
        return imageHeight;
    }

    /**
     * 
     * @param imageHeight
     *     The image_height
     */
    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    /**
     * 
     * @return
     *     The userImagePath
     */
    public String getUserImagePath() {
        return userImagePath;
    }

    /**
     * 
     * @param userImagePath
     *     The user_image_path
     */
    public void setUserImagePath(String userImagePath) {
        this.userImagePath = userImagePath;
    }

    /**
     * 
     * @return
     *     The imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 
     * @param imagePath
     *     The image_path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

}
