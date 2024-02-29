package com.zhl.lt.lexical.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhl.lt.lexical.model.entity.SysDict;
import com.zhl.lt.lexical.model.qo.SysDictQO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {

	default LambdaQueryWrapper getQueryWrapper(SysDictQO qo) {
		LambdaQueryWrapper<SysDict> wrapper = Wrappers.lambdaQuery(SysDict.class);

		wrapper.eq(qo.getType() != null, SysDict::getType, qo.getType());

		return wrapper;
	}

}
