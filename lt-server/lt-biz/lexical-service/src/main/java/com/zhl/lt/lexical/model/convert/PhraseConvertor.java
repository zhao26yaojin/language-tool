package com.zhl.lt.lexical.model.convert;

import com.zhl.lt.lexical.model.entity.TbPhrase;
import com.zhl.lt.lexical.model.vo.PhraseVO;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class PhraseConvertor {

	public static PhraseVO entityToVO(TbPhrase entity) {
		if (entity == null) {
			return null;
		}

		PhraseVO vo = new PhraseVO();
		BeanUtils.copyProperties(entity, vo);

		return vo;
	}

	public static List<PhraseVO> entityListToVOList(List<TbPhrase> entityList) {
		if (entityList == null) {
			return null;
		}

		List<PhraseVO> voList = Lists.newArrayList();

		for (TbPhrase entity : entityList) {
			PhraseVO vo = entityToVO(entity);

			voList.add(vo);
		}

		return voList;
	}

	public static TbPhrase voToEntity(PhraseVO vo) {
		if (vo == null) {
			return null;
		}

		TbPhrase entity = new TbPhrase();
		BeanUtils.copyProperties(vo, entity);

		return entity;
	}

	public static List<TbPhrase> voListToEntityList(List<PhraseVO> voList) {
		if (voList == null) {
			return null;
		}

		List<TbPhrase> entityList = Lists.newArrayList();

		for (PhraseVO vo : voList) {
			TbPhrase entity = voToEntity(vo);

			entityList.add(entity);
		}

		return entityList;
	}

}
