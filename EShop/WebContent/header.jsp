<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

	<title>E-SHOP</title>

<style> 
	table { 
		border-collapse: collapse; 
	} 
	th { 
		background-color:green; 
		Color:white; 
	} 
	th, td { 
		width:150px; 
		text-align:center; 
		border:1px solid black; 
		padding:5px 
	} 
</style>

	<!-- Google font -->
	<link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />

	<!-- Slick -->
	<link type="text/css" rel="stylesheet" href="css/slick.css" />
	<link type="text/css" rel="stylesheet" href="css/slick-theme.css" />

	<!-- nouislider -->
	<link type="text/css" rel="stylesheet" href="css/nouislider.min.css" />

	<!-- Font Awesome Icon -->
	<link rel="stylesheet" href="css/font-awesome.min.css">

	<!-- Custom stlylesheet -->
	<link type="text/css" rel="stylesheet" href="css/style.css" />

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
	<!-- HEADER -->
	<header>
		<!-- top Header -->
		<div id="top-header">
			<div class="container">
				<div class="pull-left">
					<span>Welcome to E-shop!</span>
				</div>
				<div class="pull-right">
					<ul class="header-top-links">
						<li><a href="products.html">Products</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- /top Header -->

		<!-- header -->
		<div id="header">
			<div class="container">
				<div class="pull-left">
					<!-- Logo -->
					<div class="header-logo">
						<a class="logo" href="#">
							<img src="./img/logo.png" alt="">
						</a>
					</div>
					<!-- /Logo -->

					<!-- Search -->
					<div class="header-search">
						<form action="products.html" method="GET">
							<input class="input search-input" type="text" placeholder="Enter your keyword" name="term">
							<button class="search-btn"><i class="fa fa-search"></i></button>
						</form>
					</div>
					<!-- /Search -->
				</div>
				<div class="pull-right">
					<ul class="header-btns">
						<!-- Account -->
						<li class="header-account dropdown default-dropdown">
							<div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
								<div class="header-btns-icon">
									<i class="fa fa-user-o"></i>
								</div>
								<strong class="text-uppercase">My Account <i class="fa fa-caret-down"></i></strong>
							</div>
							<a href="login.html" class="text-uppercase">Login</a> / <a href="signup.html" class="text-uppercase">Join</a>
							<ul class="custom-menu">
								<li><a href="userProfile.html"><i class="fa fa-user-o"></i> My Dashboard</a></li>
								<li><a href="wishlist.html"><i class="fa fa-heart-o"></i> My Wishlist</a></li>
								<li><a href="inbox.html"><i class="fa fa-exchange"></i> Inbox</a></li>
								<li><a href="login.html"><i class="fa fa-unlock-alt"></i> Login</a></li>
								<li><a href="signUp.html"><i class="fa fa-user-plus"></i> Create An Account</a></li>
								<li><a href="logout.html"><i class="fa fa-check"></i> Logout</a></li>
							</ul>
						</li>
						<!-- /Account -->

						<!-- Cart -->
						<li class="header-cart dropdown default-dropdown">
							<div class="shopping-cart-btns">
								<button class="main-btn" onclick="window.location.href = 'showCart.html';">View Cart</button>
								<button class="primary-btn" onclick="window.location.href = 'checkout.html';">Checkout <i class="fa fa-arrow-circle-right"></i></button>
							</div>
						</li>
						<!-- /Cart -->
					</ul>
				</div>
			</div>
			<!-- header -->
		</div>
		<!-- container -->
	</header>
	<!-- /HEADER -->