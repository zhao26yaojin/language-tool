package com.zhl.lt.statistics.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhl.lt.statistics.model.entity.StatWord;
import com.zhl.lt.statistics.qo.StatWordQO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatWordMapper extends BaseMapper<StatWord> {

	default LambdaQueryWrapper getQueryWrapper(StatWordQO qo) {
		LambdaQueryWrapper<StatWord> wrapper = Wrappers.lambdaQuery(StatWord.class);

		wrapper.eq(qo.getWordId() != null, StatWord::getWordId, qo.getWordId());

		return wrapper;
	}

}
