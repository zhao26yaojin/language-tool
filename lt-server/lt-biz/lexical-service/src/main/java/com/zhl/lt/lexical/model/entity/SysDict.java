package com.zhl.lt.lexical.model.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "字典表")
public class SysDict {

	@Schema(description = "id")
	private Long id;

	@Schema(description = "类型")
	private String type;

	@Schema(description = "名字")
	private String name;

	@Schema(description = "标签")
	private String label;

	@Schema(description = "是否删除")
	@TableLogic
	private Integer hasDel;

}
