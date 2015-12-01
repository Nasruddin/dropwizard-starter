package com.example.helloworld.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by nasir on 18/4/15.
 */
public class ResponsePro {

    private String name;

    private String nickName;

    public ResponsePro() {
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
