package com.zhl.lt.lexical.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import static com.zhl.lt.common.constant.LanguageConstant.*;

@Data
@Schema(description = "词汇信息")
public class WordVO {

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
	@JsonProperty(ZH_CODE)
	private String zhMeaning;

	@Schema(description = "英语语义")
	@JsonProperty(EN_CODE)
	private String enMeaning;

	@Schema(description = "日语语义")
	@JsonProperty(JP_CODE)
	private String jpMeaning;

	@Schema(description = "法语语义")
	@JsonProperty(FR_CODE)
	private String frMeaning;

	@Schema(description = "德语语义")
	@JsonProperty(DE_CODE)
	private String deMeaning;

	@Schema(description = "西班牙语语义")
	@JsonProperty(ES_CODE)
	private String esMeaning;

	@Schema(description = "韩语语义")
	@JsonProperty(KR_CODE)
	private String krMeaning;

	@Schema(description = "意大利语语义")
	@JsonProperty(IT_CODE)
	private String itMeaning;

}
