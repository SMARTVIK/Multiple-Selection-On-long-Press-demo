
package com.timehop.stickyheadersrecyclerview.sample.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TagsName {

    @SerializedName("category_name")
    @Expose
    private String categoryName;

    /**
     * 
     * @return
     *     The categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 
     * @param categoryName
     *     The category_name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
