
package com.example.news_api_create.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WpAttachment {

    @SerializedName("href")
    @Expose
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
