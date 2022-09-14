package com.fastcampus.ch4.domain;

public class PageHandler {
    private int totalCnt; // 총 게시물 갯수
    private int pageSize; // 한 페이지의 크기
    private int naviSize = 10; // 페이지 내비게이션의 크기
    private int totalPage; // 전체 페이지의 갯수
    private int page; // 현재 페이지
    private int beginPage; // 내비게이션의 첫번째 페이지
    private int endPage; // 내비게이션으 마지막 페이지
    private boolean showPrev; // 이전 페이지로 이동하는 링크를 보여줄 것인지의 여부
    private boolean showNext; // 다음 페이지로 이동하는 링크를 보여줄 것인지의 여부

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public PageHandler(int totalCnt, int page) {
//        아래 PageHandler 생성자를 가져옴
        this(totalCnt, page, 10);
    }

// 페이징을 하기 위해선 totalCnt, page, pageSize가 필요하다.
    public PageHandler(int totalCnt, int page, int pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

//    전체 페이지의 갯수는 총 게시물 갯수를 한 페이지의 크기로 나눈 값으로 구한다. 그런데 소숫점이 나올 경우 페이지 추가가 안되기(25.6의 값이 나오면 26페이지가 나와야하는데
//    정수의 값으로 구하면 버림을 해서 26페이지를 못 구한다.)때문에 반올림 한다. 여기에 더해 pageSize앞에 'double'로 형변환해줘 반올림을 가능하게 한다.
        totalPage = (int)Math.ceil(totalCnt / (double)pageSize);

//    시작페이지는 '일의 자리를 버리고 1을 더한다'는 아이디어로 값을 구한다. 일의 자리를 버리는 건 공식처럼 되어있다
        beginPage = (page-1) / naviSize * naviSize +1;

//    beginPage에 1을 navisize에 10을 대입하면 이해가 쉽다. 그런데 endPage보다 totalPage가 작은 경우가 있다 그렇게 되면 total페이지가 endPage가 된다.
//        그래서 totalPage와 endPage중 더 작은 값을 endPage로 한다.
        endPage = Math.min((beginPage + naviSize)-1, totalPage);

//    1과 totalpage는 페이징의 처음과 끝이다 처음과 끝이 아니라면 prev와 Next는 존재한다.
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

//    페이징 확인을 위한 프린트 메서드
    void print() {
        System.out.println("page = " + page);
        System.out.printf(showPrev ? "[PREV] " : "");
        for (int i = beginPage; i <= endPage; i++) {
            System.out.printf(i+" ");
        }
        System.out.println(showNext ? " [NEXT]" : "");
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", pageSize=" + pageSize +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
