//package com.fastcampus.ch4.dao;
//
//import com.fastcampus.ch4.domain.BoardDto;
//import com.fastcampus.ch4.domain.SearchCondition;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//public class BoardDaoImplTest {
//    @Autowired
//    BoardDao boardDao;
//
//    @Test
//    public void searchSelectPage() throws Exception {
//        boardDao.deleteAll();
//        for (int i = 1; i <= 20; i++) {
//            BoardDto boardDto = new BoardDto("title"+i, "asdfaskldnln", "asdf+i");
//            boardDao.insert(boardDto);
//        }
//
//        SearchCondition sc = new SearchCondition(1, 10, "title2", "T"); // title2%
//        List<BoardDto> list = boardDao.searchSelectPage(sc);
//        assertTrue(list.size()==2); // 1~20, title2, title20
//
//        sc = new SearchCondition(1, 10, "title2", "W"); // title2%
//        list = boardDao.searchSelectPage(sc);
//        System.out.println("list = " + list);
//        assertTrue(list.size()==2); // 1~20, asdf2, asdf20
//
//    @Test
//    public void searchResultCntTest() throws Exception {
//        boardDao.deleteAll();
//        for (int i = 1; i <= 20; i++) {
//            BoardDto boardDto = new BoardDto("title"+i, "asdfaskldnln", "asdf");
//            boardDao.insert(boardDto);
//        }
//
//        SearchCondition sc = new SearchCondition(1, 10, "title2", "T"); // title2%
//        int cnt = boardDao.searchResultCnt(sc);
//        System.out.println("cnt = " + cnt);
//        assertTrue(cnt==2); // 1~20, title2, title20
//    }
//
//    @Test
//    public void insertTestData() throws Exception{
//        boardDao.deleteAll();
//        for(int i=1; i<=220; i++) {
//            BoardDto boardDto = new BoardDto("title"+i, "no content", "asdf");
//            try {
//                boardDao.insert(boardDto);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test
//    public void selectTest() {
//        assertTrue(boardDao != null);
//        System.out.println("boardDao="+boardDao);;
//    }
//
//    @Test
//    public void insertTest() throws Exception {
//        boardDao.deleteAll();
//        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//        assertTrue(boardDao.count()==1);
//    }
//
//    @Test
//    public void updateTest() throws Exception {
//        boardDao.deleteAll();
//        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
//
////        밑에 코드 잘 모르겠다.
//        Integer bno = boardDao.selectAll().get(0).getBno();
//        System.out.println("bno="+bno);
//        boardDto.setBno(bno);
//        boardDto.setTitle("yse title");
//        assertTrue(boardDao.update(boardDto)==1);
////      밑에 코드 잘 모르겠다.
//        BoardDto boardDto2 = boardDao.select(bno);
//        assertTrue(boardDto.equals(boardDto2));
//    }
//
//    @Test
//    public void deleteTest() throws Exception {
//        boardDao.deleteAll();
//        assertTrue(boardDao.count()==0);
//
//        BoardDto boardDto = new BoardDto("no title", "no content", "asdf");
//        assertTrue(boardDao.insert(boardDto)==1);
////        코드해석 .get(0)의 의미가 무엇인가?
//        Integer bno = boardDao.selectAll().get(0).getBno();
//        assertTrue(boardDao.delete(bno, boardDto.getWriter())==1);
//        assertTrue(boardDao.count()==0);
//
//        assertTrue(boardDao.insert(boardDto)==1);
//        bno = boardDao.selectAll().get(0).getBno();
//        assertTrue(boardDao.delete(bno, boardDto.getWriter()+"222")==0);
//        assertTrue(boardDao.count()==1);
//
//        assertTrue(boardDao.delete(bno, boardDto.getWriter())==1);
//        assertTrue(boardDao.count()==0);
//
//        assertTrue(boardDao.insert(boardDto)==1);
//        bno=boardDao.selectAll().get(0).getBno();
//        assertTrue(boardDao.delete(bno+1, boardDto.getWriter())==0);
//        assertTrue(boardDao.count()==1);
//    }
//}