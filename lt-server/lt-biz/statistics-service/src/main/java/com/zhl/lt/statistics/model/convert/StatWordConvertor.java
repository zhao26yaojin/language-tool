package com.zhl.lt.statistics.model.convert;

import com.zhl.lt.statistics.model.entity.StatWord;
import com.zhl.lt.statistics.model.vo.StatWordVO;
import org.springframework.beans.BeanUtils;

public class StatWordConvertor {

	public static StatWordVO entityToVO(StatWord entity) {
		if (entity == null) {
			return null;
		}

		StatWordVO vo = new StatWordVO();
		BeanUtils.copyProperties(entity, vo);

		return vo;
	}

	public static StatWord voToEntity(StatWordVO vo) {
		if (vo == null) {
			return null;
		}

		StatWord entity = new StatWord();
		BeanUtils.copyProperties(vo, entity);

		return entity;
	}

}
