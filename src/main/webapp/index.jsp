<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">
<c:set var="title" value="Gradle Demo Home Page" scope="request" />
<c:import url="imports/head.jsp"></c:import>

<body class="bg-white">
<div class="container-fluid p-3">
    <c:import url="imports/header.jsp"></c:import>

    <main>
        <p>Go to <a href="demo">demo page</a>.</p>
    </main>

    <c:import url="imports/scripts.jsp"></c:import>
</div>
</body>
</html>