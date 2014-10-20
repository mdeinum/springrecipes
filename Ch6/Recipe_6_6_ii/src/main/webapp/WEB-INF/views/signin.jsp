<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <c:url var="formLogin" value="/j_spring_security_check" />
    <form method="post" action="${formLogin}">
        <table>
            <tr><td><label for="j_username">Username</label></td><td><input type="text" name="j_username"/></td></tr>
            <tr><td><label for="j_password">Username</label></td><td><input type="password" name="j_password"/></td></tr>
        </table>
    </form>
    <!-- TWITTER SIGNIN -->
    <c:url var="twitterSigin" value="/auth/twitter"/>
    <p><a href="${twitterSigin}">Sign in with Twitter</a></p>

    <!-- FACEBOOK SIGNIN -->
    <c:url var="twitterSigin" value="/auth/facebook"/>
    <p><a href="${twitterSigin}">Sign in with Facebook</a></p>
</head>
</html>