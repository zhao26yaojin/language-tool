package com.zhl.lt.lexical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.lt.lexical.mapper.SentenceMapper;
import com.zhl.lt.lexical.model.convert.SentenceConvertor;
import com.zhl.lt.lexical.model.entity.TbSentence;
import com.zhl.lt.lexical.model.qo.SentenceQO;
import com.zhl.lt.lexical.model.vo.SentenceVO;
import com.zhl.lt.lexical.service.SentenceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SentenceServiceImpl extends ServiceImpl<SentenceMapper, TbSentence> implements SentenceService {

	@Override
	public List<TbSentence> selectList(SentenceQO qo) {
		LambdaQueryWrapper<TbSentence> wrapper = baseMapper.getQueryWrapper(qo);

		List<TbSentence> entityList = this.list(wrapper);

		return entityList;
	}

	@Override
	public List<SentenceVO> selectVOList(SentenceQO qo) {
		List<TbSentence> entityList = selectList(qo);

		List<SentenceVO> voList = SentenceConvertor.entityListToVOList(entityList);

		return voList;
	}

	@Override
	public boolean saveVOList(List<SentenceVO> voList) {
		if (CollectionUtils.isEmpty(voList)) {
			return false;
		}

		List<TbSentence> entityList = SentenceConvertor.voListToEntityList(voList);

		return this.saveOrUpdateBatch(entityList);
	}

	@Override
	public boolean delete(SentenceQO qo) {
		LambdaQueryWrapper<TbSentence> wrapper = baseMapper.getQueryWrapper(qo);

		int result = baseMapper.delete(wrapper);

		return result > 0;
	}

}
