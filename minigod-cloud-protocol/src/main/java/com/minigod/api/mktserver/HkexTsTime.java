package com.minigod.api.mktserver;

import java.io.Serializable;

public class HkexTsTime implements Serializable {
    private static final long serialVersionUID = -1551958913919371631L;
    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

}
