package com.zhl.lt.lexical.model.qo;

import lombok.Data;

import java.util.List;

@Data
public class PhraseQO {

	private Long wordId;

	private List<Long> wordIdList;

}
