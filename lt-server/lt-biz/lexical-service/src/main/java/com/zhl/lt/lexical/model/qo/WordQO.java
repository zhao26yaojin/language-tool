package com.zhl.lt.lexical.model.qo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class WordQO {

	@Schema(description = "id")
	private Long id;

	@Schema(description = "id")
	private List<Long> idList;

	@Schema(description = "词语")
	private String name;

	@Schema(description = "源语言")
	private String srcLang;

	@Schema(description = "词性")
	private String partOfSpeech;

}
