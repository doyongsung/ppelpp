<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<c:url value='/css/admin/admin.css'/>">

</head>
<body>
  <!--헤더시작 -->
 
   <nav class="navbar ">
       <div class="navbar__logo">
        <i class="fas fa-mountain"></i>
            <a href="<c:url value='/admin/member/'/>">오를래</a>
       </div>

       <ul class="navbar__menu">
            <li><a href="<c:url value='/admin/member/'/>">MEMBER</a></li>
            <li><a href="<c:url value='/admin/crew/'/>">CREW</a></li>
            <li><a href="<c:url value='/admin/feed/'/>">FEED</a></li>


       </ul>

       <ul class="navbar__icons">
           <li><a href="<c:url value='/admin/logout'/>">로그아웃</a></li>
       </ul>

       <a href="#" class="navbar__toogleBtn">
        <i class="fas fa-bars"></i>
       </a>

   </nav>
   
   
<!--헤더끝-->

<script>
        const toggleBtn = document.querySelector('.navbar__toogleBtn');
        const menu = document.querySelector('.navbar__menu');
        const icons = document.querySelector('.navbar__icons');
    
        toggleBtn.addEventListener('click', ()=>{
            menu.classList.toggle('active');
            icons.classList.toggle('active');
        });
</script>


</body>
</html>