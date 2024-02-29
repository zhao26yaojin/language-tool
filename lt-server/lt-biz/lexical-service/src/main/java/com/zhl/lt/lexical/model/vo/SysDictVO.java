package com.zhl.lt.lexical.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysDictVO implements Serializable {

	@Schema(description = "名字")
	private String name;

	@Schema(description = "标签")
	private String label;

}
