package com.codingrecipe.board.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardFileDTO {
    private Long id;
    private Long boardId;

    // 사용자가 입력한 파일 이름
    private String originFileName;

    // 저장을 위한 파일 이름
    private String storedFileName;

}
