package com.zhl.lt.lexical.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "词汇详情信息")
public class WordInfoVO {

	private WordVO word;

	private List<SentenceVO> sentenceList;

	private List<PhraseVO> phraseList;

}
