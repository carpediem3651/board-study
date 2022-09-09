package com.fastcampus.ch4.dao;

import com.fastcampus.ch4.domain.BoardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class boardDaoImplTest {
    @Autowired
    BoardDao boardDao;

    @Test
    public void selectTest() {
        assertTrue(boardDao != null);
        System.out.println("boardDao="+boardDao);;
    }

    @Test
    public void insertTest() throws Exception {
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);
    }

    @Test
    public void updateTest() throws Exception {
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
        assertTrue(boardDao.insert(boardDto)==1);

//        밑에 코드 잘 모르겠다.
        Integer bno = boardDao.selectAll().get(0).getBno();
        System.out.println("bno="+bno);
        boardDto.setBno(bno);
        boardDto.setTitle("yse title");
        assertTrue(boardDao.update(boardDto)==1);
//      밑에 코드 잘 모르겠다.
        BoardDto boardDto2 = boardDao.select(bno);
        assertTrue(boardDto.equals(boardDto2));
    }

    @Test
    public void deleteTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
        assertTrue(boardDao.insert(boardDto)==1);
//        코드해석 .get(0)의 의미가 무엇인가?
        Integer bno = boardDao.selectAll().get(0).getBno();
        assertTrue(boardDao.delete(bno, boardDto.getWriter())==1);
        assertTrue(boardDao.count()==0);

        assertTrue(boardDao.insert(boardDto)==1);
        bno = boardDao.selectAll().get(0).getBno();
        assertTrue(boardDao.delete(bno, boardDto.getWriter()+"222")==0);
        assertTrue(boardDao.count()==1);

        assertTrue(boardDao.delete(bno, boardDto.getWriter())==1);
        assertTrue(boardDao.count()==0);

        assertTrue(boardDao.insert(boardDto)==1);
        bno=boardDao.selectAll().get(0).getBno();
        assertTrue(boardDao.delete(bno+1, boardDto.getWriter())==0);
        assertTrue(boardDao.count()==1);
    }
}