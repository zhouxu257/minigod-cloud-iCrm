package com.sunline.modules.account.online.protocol;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author LiYangFeng
 * @createDate 2017/2/22
 * @description
 * @email justbelyf@gmail.com
 */

public class OpenAccountImageInfo {

    @JSONField(name = "imageLocation")
    private Integer imageLocation;

    @JSONField(name = "imageLocationType")
    private Integer imageLocationType;

    @JSONField(name = "imageUrl")
    private String imageUrl;

    public Integer getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(Integer imageLocation) {
        this.imageLocation = imageLocation;
    }

    public Integer getImageLocationType() {
        return imageLocationType;
    }

    public void setImageLocationType(Integer imageLocationType) {
        this.imageLocationType = imageLocationType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
