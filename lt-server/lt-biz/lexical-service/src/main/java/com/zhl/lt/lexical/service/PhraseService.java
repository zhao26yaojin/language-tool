package com.zhl.lt.lexical.service;

import com.zhl.lt.lexical.model.entity.TbPhrase;
import com.zhl.lt.lexical.model.qo.PhraseQO;
import com.zhl.lt.lexical.model.vo.PhraseVO;

import java.util.List;

public interface PhraseService {

	List<TbPhrase> selectList(PhraseQO qo);

	List<PhraseVO> selectVOList(PhraseQO qo);

	boolean saveVOList(List<PhraseVO> voList);

	boolean delete(PhraseQO qo);

}
