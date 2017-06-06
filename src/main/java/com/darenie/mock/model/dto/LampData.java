package com.darenie.mock.model.dto;

import java.util.concurrent.ConcurrentHashMap;

public class LampData {


    private Integer lampId;
    private String status;

    public LampData(Integer lampId, String status) {
        this.lampId = lampId;
        this.status = status;
    }

    public interface Status {
        String WORKING ="W";
        String NOT_WORKING ="N";
        String BROKEN ="B";
    }

    public Integer getLampId() {
        return lampId;
    }

    public void setLampId(Integer lampId) {
        this.lampId = lampId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
