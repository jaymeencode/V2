package com.jaymin.TaskDemo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

public class Master{
    @JsonProperty("data")
    private List<DataClass> data;

    @JsonIgnore
    @JsonProperty("total")
    private int total;
    @JsonIgnore
    @JsonProperty("page")
    private int page;

    @JsonIgnore
    @JsonProperty("limit")
    private int limit;

    public List<DataClass> getData() {
        return data;
    }

    public int getTotal() {
        return total;
    }

    public int getPage() {
        return page;
    }

    public int getLimit() {
        return limit;
    }
}
