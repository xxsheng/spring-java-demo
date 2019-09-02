package com.springboot.demo.api.exception;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionView {
    private String code;

    @JsonRawValue
    private String param;

    public ExceptionView(String code) {
        this.code = code;
    }
}
