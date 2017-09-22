package com.pandatv.event;

/**
 * Created by Windows on 2017/9/22.
 */

public class EventBusBean {
    private String id;

    public EventBusBean(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
