<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>${layoutView.seoTags.title}</title>

</head>
<body class="nav-on-header">

<jsp:include page="components/header.jsp"/>
<main>
    <tiles:insertAttribute name="content"/>
</main>
<jsp:include page="components/footer.jsp"/>



</body>
</html>