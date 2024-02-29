package com.zhl.lt.lexical.model.convert;

import com.zhl.lt.lexical.model.entity.TbSentence;
import com.zhl.lt.lexical.model.vo.SentenceVO;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class SentenceConvertor {

	public static SentenceVO entityToVO(TbSentence entity) {
		if (entity == null) {
			return null;
		}

		SentenceVO vo = new SentenceVO();
		BeanUtils.copyProperties(entity, vo);

		return vo;
	}

	public static List<SentenceVO> entityListToVOList(List<TbSentence> entityList) {
		if (entityList == null) {
			return null;
		}

		List<SentenceVO> voList = Lists.newArrayList();

		for (TbSentence entity : entityList) {
			SentenceVO vo = entityToVO(entity);

			voList.add(vo);
		}

		return voList;
	}

	public static TbSentence voToEntity(SentenceVO vo) {
		if (vo == null) {
			return null;
		}

		TbSentence entity = new TbSentence();
		BeanUtils.copyProperties(vo, entity);

		return entity;
	}

	public static List<TbSentence> voListToEntityList(List<SentenceVO> voList) {
		if (voList == null) {
			return null;
		}

		List<TbSentence> entityList = Lists.newArrayList();

		for (SentenceVO vo : voList) {
			TbSentence entity = voToEntity(vo);

			entityList.add(entity);
		}

		return entityList;
	}

}
