package com.zhl.lt.lexical.service;

import com.zhl.lt.common.rest.PageBean;
import com.zhl.lt.common.rest.PageParam;
import com.zhl.lt.lexical.model.entity.TbWord;
import com.zhl.lt.lexical.model.qo.WordQO;
import com.zhl.lt.lexical.model.vo.WordVO;

import java.util.List;

public interface WordService {

	List<TbWord> selectList(WordQO qo);

	List<WordVO> selectVOList(WordQO qo);

	PageBean<WordVO> selectVOPage(WordQO qo, PageParam pageParam);

	TbWord selectEntity(WordQO qo);

	WordVO selectVO(WordQO qo);

	boolean saveVO(WordVO vo);

	boolean exists(WordQO qo);

	boolean deleteByIds(List<Long> idList);

}
