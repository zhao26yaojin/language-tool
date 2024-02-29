package com.zhl.lt.lexical.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "翻译例句表")
public class TbSentence {

	@Schema(description = "id")
	private Long id;

	@Schema(description = "word id")
	private Long wordId;

	@Schema(description = "目标语言")
	private String tgtLang;

	@Schema(description = "词性")
	private String partOfSpeech;

	@Schema(description = "原文词意")
	private String srcMeaning;

	@Schema(description = "译文词意")
	private String tgtMeaning;

	@Schema(description = "原文例句")
	private String srcSentence;

	@Schema(description = "译文例句")
	private String tgtSentence;

}
