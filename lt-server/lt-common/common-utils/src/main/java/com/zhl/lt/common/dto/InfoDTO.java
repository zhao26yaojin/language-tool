package com.zhl.lt.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfoDTO<T> {

	private T code;

	private String desc;

}
