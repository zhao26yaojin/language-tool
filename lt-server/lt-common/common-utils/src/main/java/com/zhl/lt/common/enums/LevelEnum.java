package com.zhl.lt.common.enums;

import lombok.Getter;

public enum LevelEnum {

	PROFICIENT(0, "精通"),

	SKILLED(1, "熟练"),

	FAMILLIAR(2, "熟悉");

	@Getter
	private Integer code;

	@Getter
	private String desc;

	LevelEnum(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return this.code;
	}

}
