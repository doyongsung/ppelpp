<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.80.0">
<title>Offcanvas template · Bootstrap v4.6</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>

<style>
	.bg_ornage{
		background-color: orange;
	}
	
	.bg_red{
		background-color: red;
	}
	
	.nav-link{
		color: white!important;
	}
</style>

</head>
<body class="bg-light">

	<%@ include file="/WEB-INF/views/frame/bootstrap_header.jsp"%>

	<main role="main" class="container">
		<div
			class="d-flex align-items-center p-3 my-3 text-white-50 bg_red rounded shadow-sm">
			<img class="mr-3" src="../assets/brand/bootstrap-outline.svg" alt=""
				width="48" height="48">
			<div class="lh-100">
				<h6 class="mb-0 text-white lh-100">Bootstrap</h6>
				<small>Since 2011</small>
			</div>
		</div>

		<div class="my-3 p-3 bg-white rounded shadow-sm">
			<h6 class="border-bottom border-gray pb-2 mb-0">Recent updates</h6>
			<div class="media text-muted pt-3">
				<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
					xmlns="http://www.w3.org/2000/svg" role="img"
					aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#007bff" />
					<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

				<p
					class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
					<strong class="d-block text-gray-dark">@username</strong> Playing
					ping pong all night long, everything's all neon and hazy. Yeah,
					she's so in demand. She's sweet as pie but if you break her heart.
					But down to earth. It's time to face the music I'm no longer your
					muse. I guess that I forgot I had a choice.
				</p>
			</div>
			<div class="media text-muted pt-3">
				<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
					xmlns="http://www.w3.org/2000/svg" role="img"
					aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#e83e8c" />
					<text x="50%" y="50%" fill="#e83e8c" dy=".3em">32x32</text></svg>

				<p
					class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
					<strong class="d-block text-gray-dark">@username</strong> Standing
					on the frontline when the bombs start to fall. Heaven is jealous of
					our love, angels are crying from up above. Can't replace you with a
					million rings. Boy, when you're with me I'll give you a taste.
					There’s no going back. Before you met me I was alright but things
					were kinda heavy. Heavy is the head that wears the crown.
				</p>
			</div>
			<div class="media text-muted pt-3">
				<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
					xmlns="http://www.w3.org/2000/svg" role="img"
					aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#6f42c1" />
					<text x="50%" y="50%" fill="#6f42c1" dy=".3em">32x32</text></svg>

				<p
					class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
					<strong class="d-block text-gray-dark">@username</strong> Will you
					do the same for me? It's time to face the music I'm no longer your
					muse. Heard it's beautiful, be the judge and my girls gonna take a
					vote. I can feel a phoenix inside of me. Heaven is jealous of our
					love, angels are crying from up above. Yeah, you take me to utopia.
				</p>
			</div>
			<small class="d-block text-right mt-3"> <a href="#">All
					updates</a>
			</small>
		</div>

		<div class="my-3 p-3 bg-white rounded shadow-sm">
			<h6 class="border-bottom border-gray pb-2 mb-0">Suggestions</h6>
			<div class="media text-muted pt-3">
				<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
					xmlns="http://www.w3.org/2000/svg" role="img"
					aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#007bff" />
					<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

				<div
					class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
					<div
						class="d-flex justify-content-between align-items-center w-100">
						<strong class="text-gray-dark">Full Name</strong> <a href="#">Follow</a>
					</div>
					<span class="d-block">@username</span>
				</div>
			</div>
			<div class="media text-muted pt-3">
				<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
					xmlns="http://www.w3.org/2000/svg" role="img"
					aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#007bff" />
					<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

				<div
					class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
					<div
						class="d-flex justify-content-between align-items-center w-100">
						<strong class="text-gray-dark">Full Name</strong> <a href="#">Follow</a>
					</div>
					<span class="d-block">@username</span>
				</div>
			</div>
			<div class="media text-muted pt-3">
				<svg class="bd-placeholder-img mr-2 rounded" width="32" height="32"
					xmlns="http://www.w3.org/2000/svg" role="img"
					aria-label="Placeholder: 32x32"
					preserveAspectRatio="xMidYMid slice" focusable="false">
					<title>Placeholder</title><rect width="100%" height="100%"
						fill="#007bff" />
					<text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>

				<div
					class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
					<div
						class="d-flex justify-content-between align-items-center w-100">
						<strong class="text-gray-dark">Full Name</strong> <a href="#">Follow</a>
					</div>
					<span class="d-block">@username</span>
				</div>
			</div>
			<small class="d-block text-right mt-3"> <a href="#">All
					suggestions</a>
			</small>
		</div>
	</main>

	<%@ include file="/WEB-INF/views/frame/footer.jsp" %> 

	</body>
</html>
