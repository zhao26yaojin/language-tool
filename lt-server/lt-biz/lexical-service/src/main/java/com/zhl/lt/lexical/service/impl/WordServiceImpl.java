package com.zhl.lt.lexical.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhl.lt.common.rest.PageBean;
import com.zhl.lt.common.rest.PageParam;
import com.zhl.lt.lexical.mapper.WordMapper;
import com.zhl.lt.lexical.model.convert.WordConvertor;
import com.zhl.lt.lexical.model.entity.TbWord;
import com.zhl.lt.lexical.model.qo.WordQO;
import com.zhl.lt.lexical.model.vo.WordVO;
import com.zhl.lt.lexical.service.WordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.zhl.lt.common.constant.DBConstant.LIMIT_ONE_SQL;

@Service
@Slf4j
public class WordServiceImpl extends ServiceImpl<WordMapper, TbWord> implements WordService {

	@Override
	public List<TbWord> selectList(WordQO qo) {
		LambdaQueryWrapper<TbWord> wrapper = baseMapper.getQueryWrapper(qo);

		List<TbWord> entityList = this.list(wrapper);

		return entityList;
	}

	@Override
	public List<WordVO> selectVOList(WordQO qo) {
		List<TbWord> entityList = selectList(qo);

		List<WordVO> voList = WordConvertor.entityListToVOList(entityList);

		return voList;
	}

	@Override
	public PageBean<WordVO> selectVOPage(WordQO qo, PageParam pageParam) {
		LambdaQueryWrapper<TbWord> wrapper = baseMapper.getQueryWrapper(qo);

		Page<TbWord> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());

		baseMapper.selectPage(page, wrapper);

		List<WordVO> wordVOList = WordConvertor.entityListToVOList(page.getRecords());

		return new PageBean<>(pageParam.getCurrent(), pageParam.getSize(), page.getTotal(), wordVOList);
	}

	@Override
	public TbWord selectEntity(WordQO qo) {
		LambdaQueryWrapper<TbWord> wrapper = baseMapper.getQueryWrapper(qo);
		wrapper.last(LIMIT_ONE_SQL);

		TbWord entity = this.getOne(wrapper);

		return entity;
	}

	@Override
	public WordVO selectVO(WordQO qo) {
		TbWord entity = selectEntity(qo);

		WordVO vo = WordConvertor.entityToVO(entity);

		return vo;
	}

	@Override
	public boolean saveVO(WordVO vo) {
		if (vo == null) {
			return false;
		}

		TbWord entity = WordConvertor.voToEntity(vo);

		boolean result = this.saveOrUpdate(entity);
		if (result) {
			vo.setId(entity.getId());
		}

		return result;
	}

	@Override
	public boolean exists(WordQO qo) {
		LambdaQueryWrapper<TbWord> wrapper = baseMapper.getQueryWrapper(qo);

		boolean result = this.exists(wrapper);

		return result;
	}

	@Override
	public boolean deleteByIds(List<Long> idList) {
		if (CollectionUtils.isEmpty(idList)) {
			return false;
		}

		int result = baseMapper.deleteBatchIds(idList);

		return result > 0;
	}

}
