<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Spring Recipes Social - Profile Page</title>
</head>
<body>
<h3>Twitter Profile</h3>

<p>
    <table>
        <tr><td>Name:</td><td>${twitterProfile.screenName}</td></tr>
        <tr><td>Location:</td><td>${twitterProfile.location}</td></tr>
        <tr><td>Friends:</td><td>${twitterProfile.friendsCount}</td></tr>
    </table>
    <h3>Tweets</h3>
    <table>
        <c:forEach items="${tweets}" var="tweet">
            <tr><td>${tweet.createdAt}</td><td>${tweet.text}</td></tr>
        </c:forEach>
    </table>
</p>
</body>
</html>