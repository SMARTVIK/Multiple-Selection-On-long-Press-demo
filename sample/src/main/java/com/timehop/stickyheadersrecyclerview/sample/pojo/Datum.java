
package com.timehop.stickyheadersrecyclerview.sample.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Datum {

    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("total_like_count")
    @Expose
    private String totalLikeCount;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("mark_favorite")
    @Expose
    private String markFavorite;
    @SerializedName("trending_sequence")
    @Expose
    private String trendingSequence;
    @SerializedName("vendor_image")
    @Expose
    private String vendorImage;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("vendor_id")
    @Expose
    private String vendorId;
    @SerializedName("is_favorite")
    @Expose
    private String isFavorite;
    @SerializedName("is_liked")
    @Expose
    private String isLiked;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("uuser_id")
    @Expose
    private String uuserId;
    @SerializedName("image_name")
    @Expose
    private String imageName;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("sub_category_id")
    @Expose
    private String subCategoryId;
    @SerializedName("tag_vendor_id")
    @Expose
    private String tagVendorId;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("tag_vendor_name")
    @Expose
    private String tagVendorName;
    @SerializedName("vendor_name")
    @Expose
    private String vendorName;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("tags_name")
    @Expose
    private List<TagsName> tagsName = new ArrayList<TagsName>();
    @SerializedName("tagswise_vendorlist")
    @Expose
    private List<TagswiseVendorlist> tagswiseVendorlist = new ArrayList<TagswiseVendorlist>();

    /**
     * 
     * @return
     *     The createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * 
     * @param createdDate
     *     The created_date
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 
     * @return
     *     The totalLikeCount
     */
    public String getTotalLikeCount() {
        return totalLikeCount;
    }

    /**
     * 
     * @param totalLikeCount
     *     The total_like_count
     */
    public void setTotalLikeCount(String totalLikeCount) {
        this.totalLikeCount = totalLikeCount;
    }

    /**
     * 
     * @return
     *     The productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     *     The product_id
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return
     *     The markFavorite
     */
    public String getMarkFavorite() {
        return markFavorite;
    }

    /**
     * 
     * @param markFavorite
     *     The mark_favorite
     */
    public void setMarkFavorite(String markFavorite) {
        this.markFavorite = markFavorite;
    }

    /**
     * 
     * @return
     *     The trendingSequence
     */
    public String getTrendingSequence() {
        return trendingSequence;
    }

    /**
     * 
     * @param trendingSequence
     *     The trending_sequence
     */
    public void setTrendingSequence(String trendingSequence) {
        this.trendingSequence = trendingSequence;
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

    /**
     * 
     * @return
     *     The categoryId
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 
     * @param categoryId
     *     The category_id
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
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
     *     The isFavorite
     */
    public String getIsFavorite() {
        return isFavorite;
    }

    /**
     * 
     * @param isFavorite
     *     The is_favorite
     */
    public void setIsFavorite(String isFavorite) {
        this.isFavorite = isFavorite;
    }

    /**
     * 
     * @return
     *     The isLiked
     */
    public String getIsLiked() {
        return isLiked;
    }

    /**
     * 
     * @param isLiked
     *     The is_liked
     */
    public void setIsLiked(String isLiked) {
        this.isLiked = isLiked;
    }

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The uuserId
     */
    public String getUuserId() {
        return uuserId;
    }

    /**
     * 
     * @param uuserId
     *     The uuser_id
     */
    public void setUuserId(String uuserId) {
        this.uuserId = uuserId;
    }

    /**
     * 
     * @return
     *     The imageName
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * 
     * @param imageName
     *     The image_name
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The subCategoryId
     */
    public String getSubCategoryId() {
        return subCategoryId;
    }

    /**
     * 
     * @param subCategoryId
     *     The sub_category_id
     */
    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    /**
     * 
     * @return
     *     The tagVendorId
     */
    public String getTagVendorId() {
        return tagVendorId;
    }

    /**
     * 
     * @param tagVendorId
     *     The tag_vendor_id
     */
    public void setTagVendorId(String tagVendorId) {
        this.tagVendorId = tagVendorId;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The tagVendorName
     */
    public String getTagVendorName() {
        return tagVendorName;
    }

    /**
     * 
     * @param tagVendorName
     *     The tag_vendor_name
     */
    public void setTagVendorName(String tagVendorName) {
        this.tagVendorName = tagVendorName;
    }

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
     *     The tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * 
     * @return
     *     The tagsName
     */
    public List<TagsName> getTagsName() {
        return tagsName;
    }

    /**
     * 
     * @param tagsName
     *     The tags_name
     */
    public void setTagsName(List<TagsName> tagsName) {
        this.tagsName = tagsName;
    }

    /**
     * 
     * @return
     *     The tagswiseVendorlist
     */
    public List<TagswiseVendorlist> getTagswiseVendorlist() {
        return tagswiseVendorlist;
    }

    /**
     * 
     * @param tagswiseVendorlist
     *     The tagswise_vendorlist
     */
    public void setTagswiseVendorlist(List<TagswiseVendorlist> tagswiseVendorlist) {
        this.tagswiseVendorlist = tagswiseVendorlist;
    }

}
