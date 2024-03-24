package com.test.test.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private Map<String, String> data;
    private String response = "ok";
    private Integer request;
}
