package com.zhl.lt.lexical.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhl.lt.lexical.model.entity.TbSentence;
import com.zhl.lt.lexical.model.qo.SentenceQO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SentenceMapper extends BaseMapper<TbSentence> {

	default LambdaQueryWrapper getQueryWrapper(SentenceQO qo) {
		LambdaQueryWrapper<TbSentence> wrapper = Wrappers.lambdaQuery(TbSentence.class);

		wrapper.eq(qo.getWordId() != null, TbSentence::getWordId, qo.getWordId());

		return wrapper;
	}

}
