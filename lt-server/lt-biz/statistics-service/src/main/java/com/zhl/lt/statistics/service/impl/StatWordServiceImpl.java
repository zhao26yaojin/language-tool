package com.zhl.lt.statistics.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.zhl.lt.common.util.JacksonUtil;
import com.zhl.lt.statistics.mapper.StatWordMapper;
import com.zhl.lt.statistics.model.convert.StatWordConvertor;
import com.zhl.lt.statistics.model.entity.StatWord;
import com.zhl.lt.statistics.model.vo.StatWordVO;
import com.zhl.lt.statistics.qo.StatWordQO;
import com.zhl.lt.statistics.service.StatWordService;
import com.zhl.lt.statistics.utils.StatWordUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.zhl.lt.common.constant.DBConstant.LIMIT_ONE_SQL;

@Service
@Slf4j
public class StatWordServiceImpl extends ServiceImpl<StatWordMapper, StatWord> implements StatWordService {

	@Override
	public Boolean recordWord(StatWordVO vo) {
		if (vo == null || vo.getWordId() == null || StringUtils.isEmpty(vo.getName())
				|| StringUtils.isEmpty(vo.getSrcLang())) {
			return false;
		}

		StatWord entity = StatWordConvertor.voToEntity(vo);

		StatWordQO qo = new StatWordQO();
		qo.setWordId(vo.getWordId());
		StatWord existStatWord = selectEntity(qo);

		StatWordUtil.mergeRecord(entity, existStatWord);

		boolean result = this.saveOrUpdate(entity);

		return result;
	}

	@Override
	public StatWord selectEntity(StatWordQO qo) {
		LambdaQueryWrapper<StatWord> wrapper = baseMapper.getQueryWrapper(qo);
		wrapper.last(LIMIT_ONE_SQL);

		StatWord entity = this.getOne(wrapper);

		return entity;
	}

}
