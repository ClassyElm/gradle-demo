<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">
<c:set var="title" value="Gradle Demo Query Page" scope="request" />
<c:import url="imports/head.jsp"></c:import>

<body class="bg-white">
<div class="container-fluid p-3">
    <c:import url="imports/header.jsp"></c:import>

    <main>
        <p>Go back to <a href="./">landing page</a>.</p>

        <c:choose>
            <c:when test="${users != null}">
                <c:choose>
                    <c:when test="${users.size() > 0}">
                        <h2>Found ${users.size()} Users:</h2>
                        <table id="userResults">
                            <thead>
                                <tr>
                                    <th>User ID</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Age</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.age}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:when>
                    <c:otherwise>
                        <h2>No Results Found from Search Query</h2>
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise>
                <h2>Failed to load list of users!</h2>
            </c:otherwise>
        </c:choose>
    </main>
</div>
</body>

<c:import url="imports/scripts.jsp"></c:import>

</html>