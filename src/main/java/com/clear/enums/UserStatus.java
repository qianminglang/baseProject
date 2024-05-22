package com.clear.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * ClassName UserStatus
 *
 * @author qml
 * Date 2024-5-22 15:27
 * Version 1.0
 **/

@Getter
public enum UserStatus {
    FROZEN(0, "禁止使用"),
    NORMAL(1, "已激活"),
    ;

    @EnumValue
    private Integer value;
    @JsonValue
    private String desc;

    UserStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static UserStatus of(Integer value) {
        for (UserStatus status : UserStatus.values()) {
            if (status.getValue().equals(value)) {
                return status;
            }
        }
        return null;
    }
}