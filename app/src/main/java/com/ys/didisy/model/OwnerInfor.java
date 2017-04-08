package com.ys.didisy.model;

import com.baidu.mapapi.model.LatLng;

/**
 * Created by Administrator on 2017/4/8 0008.
 */
public class OwnerInfor {
   private  LatLng point;
    private Integer image;
    private String name;

    public OwnerInfor(LatLng point,Integer image,String name){
          this.point =point;
          this.image =image;
        this.name =name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public LatLng getPoint() {
        return point;
    }

    public void setPoint(LatLng point) {
        this.point = point;
    }
}
