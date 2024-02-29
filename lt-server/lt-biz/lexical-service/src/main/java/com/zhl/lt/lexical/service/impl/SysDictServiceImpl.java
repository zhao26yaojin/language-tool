package com.zhl.lt.lexical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.lt.lexical.mapper.SysDictMapper;
import com.zhl.lt.lexical.model.entity.SysDict;
import com.zhl.lt.lexical.model.qo.SysDictQO;
import com.zhl.lt.lexical.model.vo.SysDictVO;
import com.zhl.lt.lexical.service.SysDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.zhl.lt.lexical.model.convert.SysDictConvertor;

import java.util.List;

@Service
@Slf4j
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {

	@Override
	public List<SysDict> selectList(SysDictQO qo) {
		LambdaQueryWrapper<SysDict> wrapper = baseMapper.getQueryWrapper(qo);

		List<SysDict> entityList = this.list(wrapper);

		return entityList;
	}

	@Override
	@Cacheable(value = "dict", key = "#qo.type")
	public List<SysDictVO> selectVOList(SysDictQO qo) {
		List<SysDict> entityList = selectList(qo);

		List<SysDictVO> voList = SysDictConvertor.entityListToVOList(entityList);

		return voList;
	}

	@Override
	@CacheEvict(value = "dict", key = "#qo.type")
	public void clearDictCache(SysDictQO qo) {

	}

}
