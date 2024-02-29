package com.zhl.lt.lexical.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhl.lt.lexical.model.entity.TbPhrase;
import com.zhl.lt.lexical.model.qo.PhraseQO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhraseMapper extends BaseMapper<TbPhrase> {

	default LambdaQueryWrapper getQueryWrapper(PhraseQO qo) {
		LambdaQueryWrapper<TbPhrase> wrapper = Wrappers.lambdaQuery(TbPhrase.class);

		wrapper.eq(qo.getWordId() != null, TbPhrase::getWordId, qo.getWordId());

		return wrapper;
	}

}
