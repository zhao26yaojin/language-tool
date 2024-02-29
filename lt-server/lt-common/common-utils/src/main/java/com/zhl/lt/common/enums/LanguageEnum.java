package com.zhl.lt.common.enums;

import lombok.Getter;

import static com.zhl.lt.common.constant.LanguageConstant.*;

public enum LanguageEnum {

	CHINESE(ZH_CODE, "汉语"),

	ENGLISH(EN_CODE, "英语"),

	JAPANESE(JP_CODE, "日语"),

	FRENCH(FR_CODE, "法语"),

	SPAIN(ES_CODE, "西班牙语"),

	GERMANY(DE_CODE, "德语"),

	KOREAN(KR_CODE, "韩语"),

	ITALIAN(IT_CODE, "意大利语");

	@Getter
	private String code;

	@Getter
	private String desc;

	LanguageEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return this.code;
	}

}
