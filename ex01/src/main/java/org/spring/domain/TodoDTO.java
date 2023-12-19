package org.spring.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String doIt; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
}
