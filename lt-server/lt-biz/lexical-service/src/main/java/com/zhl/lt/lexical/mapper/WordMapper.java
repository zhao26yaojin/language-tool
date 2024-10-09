package com.zhl.lt.lexical.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.zhl.lt.lexical.model.entity.TbWord;
import com.zhl.lt.lexical.model.qo.WordQO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WordMapper extends BaseMapper<TbWord> {

	default LambdaQueryWrapper getQueryWrapper(WordQO qo) {
		LambdaQueryWrapper<TbWord> wrapper = Wrappers.lambdaQuery(TbWord.class);

		wrapper.eq(qo.getId() != null, TbWord::getId, qo.getId())
			.eq(StringUtils.isNotBlank(qo.getName()), TbWord::getName, qo.getName())
			.eq(StringUtils.isNotBlank(qo.getSrcLang()), TbWord::getSrcLang, qo.getSrcLang())
			.eq(StringUtils.isNotBlank(qo.getPartOfSpeech()), TbWord::getPartOfSpeech, qo.getPartOfSpeech())
			.eq(qo.getLevel() != null, TbWord::getLevel, qo.getLevel())
			.in(CollectionUtils.isNotEmpty(qo.getIdList()), TbWord::getId, qo.getIdList());

		return wrapper;
	}

}
