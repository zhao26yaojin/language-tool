package com.zhl.lt.lexical.service;

import com.zhl.lt.lexical.model.entity.SysDict;
import com.zhl.lt.lexical.model.qo.SysDictQO;
import com.zhl.lt.lexical.model.vo.SysDictVO;

import java.util.List;

public interface SysDictService {

	List<SysDict> selectList(SysDictQO qo);

	List<SysDictVO> selectVOList(SysDictQO qo);

	void clearDictCache(SysDictQO qo);

}
