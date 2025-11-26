<%@page import="model.bean.Categories"%>
<%@page import="model.bean.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ví dụ Bootstrap</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
	integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
	crossorigin="anonymous"></script>
</head>
<body style="background-color:#f7f7f7;">
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg bg-white sticky-top shadow-sm">
			<div class="container-fluid">
				<span style="color: #9E896D;" class="navbar-brand">hieudaoshop.vn</span>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<div class="d-flex align-items-center ms-auto gap-2">

			        <!-- Search -->
			        <form class="d-flex" role="search" action="SearchServlet" method="get">
			          <input class="form-control me-2" type="search"
			                 placeholder="Tìm kiếm" aria-label="Search" name="nameProductSearch">
			          <button class="btn btn-outline-success" type="submit">Tìm</button>
			        </form>
			
			        <!-- Login -->
			        <a href="login.jsp"
			           class="btn btn-outline-secondary"
			           style="border-color:#9E896D; color:#9E896D;">
			          <img src="img/login/login.png" height="21px">
			        </a>
			      </div>
				</div>
			</div>
		</nav>
		
		
	<!-- End Navbar -->

	<!-- Page content -->
	<div class="container">
		<div class="row mt-4">
			<!-- Menu left -->
			<div class="col-lg-3 mt-4">
				<div class="list-group">
				<%
					List<Categories> categories = (List<Categories>)request.getAttribute("categories");
					for(Categories c : categories){
				%>
					<a href="CategoryServlet?id=<%=c.getId() %>" class="list-group-item list-group-item-action"> <%=c.getName() %> </a>
					<%}%>
				</div>
			</div>
			<!-- End Menu left -->
			
			<!-- Slider, Products -->
			<div class="col-lg-9">
				<!-- Silder -->
				<div id="carouselExampleCaptions" class="carousel slide">
				  <div class="carousel-indicators">
				    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
				    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
				    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
				  </div>
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img src="img/poster1.png" class="d-block w-100">
				      <div class="carousel-caption d-none d-md-block">
				        <h5 style="color: #9E896D;"><strong>HIEUDAOSHOP.VN</strong></h5>
				      </div>
				    </div>
				    <div class="carousel-item">
				      <img src="img/poster2.png" class="d-block w-100">
				      <div class="carousel-caption d-none d-md-block">
				        <h5 style="color: #9E896D;"><strong>HIEUDAOSHOP.VN</strong></h5>
				      </div>
				    </div>
				    <div class="carousel-item">
				      <img src="img/poster3.png" class="d-block w-100">
				      <div class="carousel-caption d-none d-md-block">
				        <h5 style="color: #9E896D;"><strong>HIEUDAOSHOP.VN</strong></h5>
				      </div>
				    </div>
				  </div>
				  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Previous</span>
				  </button>
				  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="visually-hidden">Next</span>
				  </button>
				</div>
				<br>
				<!-- End Slider -->
				<!-- Products -->
				<div class="row">
				<%
					List<Products> products = (List<Products>)request.getAttribute("products");
					for(Products p : products){
				%>
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<img class="card-img-top" src="<%=p.getThumbnail() %>" alt="">
							
							 <hr style="margin:0; border-top: 2px solid #BDBDBD;">
							
							<div class="card-body">
								<h4 class="card-title">
									<a href="OrderDetailsServlet?id=<%=p.getId() %>" style="color: #9E896D; text-decoration: none;"><%=p.getName() %></a>
								</h4>
								<h5><%=p.getPrice() %>>$</h5>
								<p class="card-text"><%=p.getDescription() %></p>
							</div>
						</div>
					</div>
					<%}%>
				</div>
				<!-- End Products -->
			</div>
		</div>
	</div>
	
	<!-- End Page content -->
	<!-- Footer -->
	<footer class="text-center text-lg-start mt-5" style="background-color: white;">
	  <div class="container pt-4">
	
	    <div class="row">
	
	      <div class="col-lg-4 col-md-6 mb-4">
	        <h5 style="color:#9E896D;">Liên hệ</h5>
	        <p>Email: daohuuhieu18112004@gmail.com</p>
	        <p>Phone: 0327419422</p>
	      </div>
	
	    </div>
	
	  </div>
	
	  <div class="text-center p-3" style="background-color: #9E896D; color: white;">
	    © 2025 hieudaoshop.vn - All Rights Reserved.
	  </div>
	</footer>
	
	<!-- End Footer -->
</body>
</html>