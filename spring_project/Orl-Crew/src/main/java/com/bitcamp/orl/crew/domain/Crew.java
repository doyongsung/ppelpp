package com.bitcamp.orl.crew.domain;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
// 한꺼번에 설정해줌
                        // 필요한 생성자 생성 
// @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 
@Data
// 자동생성자
@AllArgsConstructor
@NoArgsConstructor
// 빌드 자동 생성
@Builder
public class Crew {
	private int crewIdx;
	private String crewName;
	private String crewPhoto;
	private String crewDiscription;
	@JsonFormat(pattern = "yyyy.MM.dd. HH:mm")
	private Timestamp crewCreatedate;
	private String crewTag;
	private int memberIdx;
	private String memberNickName;
	
}
