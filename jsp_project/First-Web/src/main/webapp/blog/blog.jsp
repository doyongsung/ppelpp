<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Blog</title>
    
<!--     http://localhost:8080/First-Web/blog/css/blog.css -->
    
    <link rel="stylesheet" href="/First-Web/blog/blog.css">
</head>
<body>
    
    <div id="main_wrap">
        <!-- header 시작-->
       <%@ include file="../include2/header.jsp" %>
        <!-- header 끝-->
        
        <!-- navigation 시작 --> 
       <%@ include file="../include2/nav.jsp" %>
        <!-- navigation 끝 -->

        <!-- content 영역 시작 -->
        <div id="content_wrap">
            <section>
                <article class="border_bottom_a margin_bottom_20">
                    <h1 class="title">킹크랩</h1>
                    <p class="date">2021.07.02</p>
                    <img class="post_img" src="../images/king.jpg">
                    <p class="postcontent">오늘 여자친구와 데이트 하기 위해서 맛집 찾아서 경기도에서 서울로 왔어요. 사장님께서 메뉴하나하나 친절하게 설명을 해주셨고, 인원에 알맞게 얼만큼의 양을 주문해야 하는 지 세세하게 알려주셨던 점이 너무 좋았어요. 그리고 다른 가게와 다르게 맛집인 만큼 테이블 회전 수가 엄청 빨라서 게가 엄청 싱싱하더라고요. 추가로 궁금해서 여쭤보았는데, 하루의 정해진 판매량에 맞추어서 게를 들여오기 때문에 맛이 없을 수가 없겠더라고요. 정말 너무 만족스러웠어요.
                        전 확실히 가까운 거리는 아니지만, 여자친구랑 재방문 할 의향 100% 있습니다.</p>
                </article>
                <article>
                    <h1 class="title">킹크랩</h1>
                    <p class="date">2021.07.02</p>
                    <img class="post_img" src="../images/king.jpg">
                    <p class="postcontent">오늘 여자친구와 데이트 하기 위해서 맛집 찾아서 경기도에서 서울로 왔어요. 사장님께서 메뉴하나하나 친절하게 설명을 해주셨고, 인원에 알맞게 얼만큼의 양을 주문해야 하는 지 세세하게 알려주셨던 점이 너무 좋았어요. 그리고 다른 가게와 다르게 맛집인 만큼 테이블 회전 수가 엄청 빨라서 게가 엄청 싱싱하더라고요. 추가로 궁금해서 여쭤보았는데, 하루의 정해진 판매량에 맞추어서 게를 들여오기 때문에 맛이 없을 수가 없겠더라고요. 정말 너무 만족스러웠어요.
                        전 확실히 가까운 거리는 아니지만, 여자친구랑 재방문 할 의향 100% 있습니다.</p>
                </article>
            </section>
            
        <!-- aside 영역 시작 -->
        <%@ include file="../include2/aside.jsp" %>
        <!-- aside 영역 끝 -->

        </div>
        <!-- content 영역 끝 -->
        <!-- footer 시작 -->
  <%@ include file="../include2/footer.jsp" %>
        <!-- footer 끝 -->

    </div>
</body>
</html>