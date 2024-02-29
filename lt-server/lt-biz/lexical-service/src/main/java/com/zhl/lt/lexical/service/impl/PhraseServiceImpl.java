package com.zhl.lt.lexical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.lt.lexical.mapper.PhraseMapper;
import com.zhl.lt.lexical.model.convert.PhraseConvertor;
import com.zhl.lt.lexical.model.entity.TbPhrase;
import com.zhl.lt.lexical.model.qo.PhraseQO;
import com.zhl.lt.lexical.model.vo.PhraseVO;
import com.zhl.lt.lexical.service.PhraseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PhraseServiceImpl extends ServiceImpl<PhraseMapper, TbPhrase> implements PhraseService {

	@Override
	public List<TbPhrase> selectList(PhraseQO qo) {
		LambdaQueryWrapper<TbPhrase> wrapper = baseMapper.getQueryWrapper(qo);

		List<TbPhrase> entityList = this.list(wrapper);

		return entityList;
	}

	@Override
	public List<PhraseVO> selectVOList(PhraseQO qo) {
		List<TbPhrase> entityList = selectList(qo);

		List<PhraseVO> voList = PhraseConvertor.entityListToVOList(entityList);

		return voList;
	}

	@Override
	public boolean saveVOList(List<PhraseVO> voList) {
		if (CollectionUtils.isEmpty(voList)) {
			return false;
		}

		List<TbPhrase> entityList = PhraseConvertor.voListToEntityList(voList);

		return this.saveOrUpdateBatch(entityList);
	}

	@Override
	public boolean delete(PhraseQO qo) {
		LambdaQueryWrapper<TbPhrase> wrapper = baseMapper.getQueryWrapper(qo);

		int result = baseMapper.delete(wrapper);

		return result > 0;
	}

}
