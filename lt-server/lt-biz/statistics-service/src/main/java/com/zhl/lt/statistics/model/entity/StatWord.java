package com.zhl.lt.statistics.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "词汇统计表")
public class StatWord {

	@Schema(description = "id")
	private Long id;

	@Schema(description = "word id")
	private Long wordId;

	@Schema(description = "词语")
	private String name;

	@Schema(description = "源语言")
	private String srcLang;

	@Schema(description = "词性")
	private String partOfSpeech;

	@Schema(description = "查询记录信息")
	private String record;

	@Schema(description = "查询次数")
	private Integer count;

}
