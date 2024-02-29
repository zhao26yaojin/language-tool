package com.zhl.lt.lexical.service;

import com.zhl.lt.lexical.model.entity.TbSentence;
import com.zhl.lt.lexical.model.qo.SentenceQO;
import com.zhl.lt.lexical.model.vo.SentenceVO;

import java.util.List;

public interface SentenceService {

	List<TbSentence> selectList(SentenceQO qo);

	List<SentenceVO> selectVOList(SentenceQO qo);

	boolean saveVOList(List<SentenceVO> voList);

	boolean delete(SentenceQO qo);

}
