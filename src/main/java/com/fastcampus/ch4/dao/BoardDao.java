package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;

import java.util.List;

public interface BoardDao {
//   select에 해당하는 dao값을 만든다.
    BoardDto select(Integer bno) throws Exception;
    int insert(BoardDto boardDto) throws Exception;
    int deleteAll() throws Exception;
    int count() throws Exception;
    int update(BoardDto boardDto) throws Exception;
    int delete(Integer bno, String writer) throws Exception;
    List<BoardDto> selectAll() throws Exception;
}
