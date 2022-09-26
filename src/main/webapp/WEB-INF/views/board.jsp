<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div id="menu">
    <ul>
        <li id="logo">fastcampus</li>
        <li><a href="<c:url value='/'/>">Home</a></li>
        <li><a href="<c:url value='/board/list'/>">Board</a></li>
        <li><a href="<c:url value='/login/login'/>">login</a></li>
        <li><a href="<c:url value='/register/add'/>">Sign in</a></li>
        <li><a href=""><i class="fas fa-search small"></i></a></li>
    </ul>
</div>
<script>
    let msg = "${msg}";
    if(msg=="WRT_ERR") alert("게시물 등록에 실패했습니다. 다시 시도해 주세요.");
</script>
<div style="text-align:center">
    <h2>게시물 ${mode=="new" ? "글쓰기" : "읽기"}</h2>
    <form action="" id="form">
<%--        mode의 값에 따라 값을 다르게 지정하는 방식 주목--%>
<%--        input의 type을 작업할 떄는 보이게 'text'로 설정한 다음 작업이 끝난 후에는 'hidden'으로 바꾼다.--%>
        <input type="hidden" name="bno" value="${boardDto.bno}">
        <input type="text" name="title" value="${boardDto.title}" ${mode=="new" ? '' : 'readonly="readonly"'}>
        <textarea name="content" id="" cols="30" rows="10" ${mode=="new" ? '' : 'readonly="readonly"'}>${boardDto.content}</textarea>
        <button type="button" id="writeBtn" class="btn">글쓰기</button>
        <button type="button" id="modifyBtn" class="btn">수정</button>
        <button type="button" id="removeBtn" class="btn">삭제</button>
        <button type="button" id="listBtn" class="btn">목록</button>
    </form>
</div>
<script>

<%--    get 요청--%>
    $(document).ready(function() {
        $('#listBtn').on("click",function(){
        //    location은 브라우저 창에 url주소를 치는 영역을 의미한다.
            location.href= "<c:url value='/board/list'/>?page=${page}&pageSize=${pageSize}";
        });


    //post 요청

        $('#removeBtn').on("click",function(){
            //삭제하기 전에 한번 물어본다.
            if(!confirm("정말로 삭제하시겠습니까?")) return;
            let form = $('#form');
            form.attr("action", "<c:url value='/board/remove'/>?page=${page}&pageSize=${pageSize}");
            form.attr("method", "post");
            form.submit();
        });

        $('#writeBtn').on("click", function(){
           let form = $('#form');
           form.attr("action", "<c:url value='/board/write'/>");
           form.attr("method", "post");
           form.submit();
        });

        $('#modifyBtn').on("click", function(){
            // 1.읽기 상태이면 수정상태로 변경.
            let form = $('#form');
            let isReadOnly = $("input[name=title]").attr('readonly');

            if(isReadOnly=='readonly') {
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("등록");
                $("h2").html("게시물 수정");
                return;
            }

            // 2.수정 상태이면, 수정된 내용을 서버로 전송


            form.attr("action", "<c:url value='/board/modify'/>");
            form.attr("method", "post");
            form.submit();
        });
    });
</script>
</body>
</html>