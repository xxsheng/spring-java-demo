package com.springboot.demo.api.exception;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class ApplicationException extends RuntimeException {

    static Gson gson = new Gson();
    
    public String getCode() {
        return super.getMessage();
    }

    @Getter
    private String param;

    public ApplicationException(String code, String param) {
        super(code);
        this.param = param;
    }

    public ApplicationException(Enum code, Object param) {
        this(code.name(), gson.toJson(param));
    }

    public ApplicationException(String code) {
        super(code);
    }

    public ApplicationException(Enum code) {
        super(code.name());
    }


}
