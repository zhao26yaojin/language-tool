package com.zhl.lt.lexical.model.convert;

import com.zhl.lt.lexical.model.entity.SysDict;
import com.zhl.lt.lexical.model.vo.SysDictVO;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class SysDictConvertor {

	public static SysDictVO entityToVO(SysDict entity) {
		if (entity == null) {
			return null;
		}

		SysDictVO vo = new SysDictVO();
		BeanUtils.copyProperties(entity, vo);

		return vo;
	}

	public static List<SysDictVO> entityListToVOList(List<SysDict> entityList) {
		if (entityList == null) {
			return null;
		}

		List<SysDictVO> voList = Lists.newArrayList();

		for (SysDict entity : entityList) {
			SysDictVO vo = entityToVO(entity);

			voList.add(vo);
		}

		return voList;
	}

}
