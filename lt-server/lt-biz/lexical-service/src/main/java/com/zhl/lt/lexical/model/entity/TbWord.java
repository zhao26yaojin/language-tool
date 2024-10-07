package com.zhl.lt.lexical.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "词汇表")
public class TbWord {

	@Schema(description = "id")
	private Long id;

	@Schema(description = "词语")
	private String name;

	@Schema(description = "源语言")
	private String srcLang;

	@Schema(description = "词性")
	private String partOfSpeech;

	@Schema(description = "音标")
	private String phoneticSymbol;

	@Schema(description = "中文语义")
	private String zhMeaning;

	@Schema(description = "英语语义")
	private String enMeaning;

	@Schema(description = "日语语义")
	private String jpMeaning;

	@Schema(description = "法语语义")
	private String frMeaning;

	@Schema(description = "德语语义")
	private String deMeaning;

	@Schema(description = "西班牙语语义")
	private String esMeaning;

	@Schema(description = "韩语语义")
	private String krMeaning;

	@Schema(description = "意大利语语义")
	private String itMeaning;

	@Schema(description = "等级")
	private Integer level;

}
