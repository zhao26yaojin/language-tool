package com.zhl.lt.common.enums;

import lombok.Getter;

public enum LevelEnum {

    SKILLED("skilled", "熟练"),

    FAMILLIAR("familliar", "熟悉"),

    COMMON("common", "一般");

    @Getter
    private String code;

    @Getter
    private String desc;

    LevelEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }
}
