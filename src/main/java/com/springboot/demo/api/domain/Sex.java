package com.springboot.demo.api.domain;

//import com.xxq.sdk.processor.annotation.JpaConverter;
import lombok.Getter;

//@JpaConverter
public enum Sex {
    MAN((int)0),
    FEMAL((int)1);

    @Getter
    private int n;

    Sex(int n){
        this.n = n;
    }
}
