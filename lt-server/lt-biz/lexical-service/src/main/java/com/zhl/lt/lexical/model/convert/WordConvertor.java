package com.zhl.lt.lexical.model.convert;

import com.zhl.lt.lexical.model.entity.TbWord;
import com.zhl.lt.lexical.model.vo.WordVO;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class WordConvertor {

	public static WordVO entityToVO(TbWord entity) {
		if (entity == null) {
			return null;
		}

		WordVO vo = new WordVO();
		BeanUtils.copyProperties(entity, vo);

		return vo;
	}

	public static List<WordVO> entityListToVOList(List<TbWord> entityList) {
		if (entityList == null) {
			return null;
		}

		List<WordVO> voList = Lists.newArrayList();

		for (TbWord entity : entityList) {
			WordVO vo = entityToVO(entity);

			voList.add(vo);
		}

		return voList;
	}

	public static TbWord voToEntity(WordVO vo) {
		if (vo == null) {
			return null;
		}

		TbWord entity = new TbWord();
		BeanUtils.copyProperties(vo, entity);

		return entity;
	}

}
