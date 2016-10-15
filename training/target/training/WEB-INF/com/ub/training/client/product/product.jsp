<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<h1>Продукт</h1>
<div>Название: ${layoutView.productDoc.name}</div>
<div>ID продукта: ${layoutView.productDoc.id}</div>