package com.zhl.lt.statistics.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "词汇统计信息")
public class StatWordVO {

	@Schema(description = "word id")
	private Long wordId;

	@Schema(description = "词语")
	private String name;

	@Schema(description = "源语言")
	private String srcLang;

	@Schema(description = "词性")
	private String partOfSpeech;

}
