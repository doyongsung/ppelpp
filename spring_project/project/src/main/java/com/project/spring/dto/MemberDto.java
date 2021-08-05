package com.project.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {
	private String member_name;
	private String member_email;
	private String member_pw;
	private String member_join;
	private String member_login;

}