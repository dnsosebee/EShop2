<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- FOOTER -->
	<footer id="footer" class="section section-grey">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<!-- footer widget -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="footer">
						<!-- footer logo -->
						<div class="footer-logo">
							<a class="logo" href="index.html">
		            <img src="./img/logo.png" alt="">
		          </a>
						</div>
						<!-- /footer logo -->

					</div>
				</div>
				<!-- /footer widget -->

				<!-- footer widget -->
				<div class="col-md-3 col-sm-6 col-xs-6">
					<div class="footer">
					<% if (session.getAttribute("user") == null) { %>
						<h3 class="footer-header">Account</h3>
						<ul class="list-links">
								<li><a href="login.html"> Login</a></li>
								<li><a href="signUp.html"> Create An Account</a></li>
						</ul>
					<% } else { %>
						<h3 class="footer-header">My Account</h3>
						<ul class="list-links">
								<li><a href="userProfile.html"> Dashboard</a></li>
								<%
									if (((Applicationuser.uc3m.ctw.model.ApplicationUser.uc3m.eshop.model.ApplicationUser)session.getAttribute("user")).getRole() == 0) {
								%>
									<li><a href="wishlist.html"> Wishlist</a></li>
									<li><a href="orders.html"> Orders</a></li>
								<% } %>
								<li><a href="inbox.html"> Inbox</a></li>
								<li><a href="login.html"> Login As Other User</a></li>
								<li><a href="signUp.html"> Create An Account</a></li>
								<li><a href="logout.html"> Logout</a></li>
						</ul>
					<% } %>
					</div>
				</div>
				<!-- /footer widget -->

				<div class="clearfix visible-sm visible-xs"></div>
			</div>
			<!-- /row -->
			<hr>
			<!-- row -->
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<!-- footer copyright -->
					<div class="footer-copyright">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</div>
					<!-- /footer copyright -->
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</footer>
	<!-- /FOOTER -->

	<!-- jQuery Plugins -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/slick.min.js"></script>
	<script src="js/nouislider.min.js"></script>
	<script src="js/jquery.zoom.min.js"></script>
	<script src="js/main.js"></script>

</body>

</html>