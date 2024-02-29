package com.zhl.lt.lexical.service;

import com.zhl.lt.lexical.model.qo.WordQO;
import com.zhl.lt.lexical.model.vo.WordInfoVO;

import java.util.List;

public interface WordInfoService {

	WordInfoVO getWordInfo(WordQO wordQO);

	String saveWordInfo(WordInfoVO wordInfoVO);

	String deleteByIds(List<Long> idList);

}
