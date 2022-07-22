<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Adlister Home</a>
            <ul class="nav navbar-nav navbar-left">
                <li><a href="/ads">Ads</a> </li>
            </ul>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li class="login"><a href="/login">Login</a></li>
            <li class="login"><a href="/register">Register</a></li>
            <li class="logout" style=display:none><a href="/profile">Profile</a></li>
            <li class="logout" style=display:none><a href="/logout">Logout</a> </li>
        </ul>
        <c:if test="${userCk != null && userCk != ' there'}">
            <script>
				const elem = document.getElementsByClassName("logout");
				for (let i = 0; i < elem.length; i++) {
					elem[i].style.display = "block";
				}
				const elem2 = document.getElementsByClassName("login");
				for (let i = 0; i < elem2.length; i++) {
					elem2[i].style.display = "none";
				}
            </script>
        </c:if>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
