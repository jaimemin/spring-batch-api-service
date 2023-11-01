package com.tistory.jaimemin.springbatchapiservice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponseVO {

    private int status;

    private String message;

}
