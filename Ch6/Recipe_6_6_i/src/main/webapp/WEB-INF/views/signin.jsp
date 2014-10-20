<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <c:url var="formLogin" value="/signin/authenticate" />
    <form method="post" action="${formLogin}">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <table>
            <tr><td><label for="j_username">Username</label></td><td><input type="text" name="j_username"/></td></tr>
            <tr><td><label for="j_password">Username</label></td><td><input type="password" name="j_password"/></td></tr>
        </table>
    </form>
</head>
</html>