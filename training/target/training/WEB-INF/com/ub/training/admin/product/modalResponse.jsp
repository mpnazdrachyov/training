<%@ page import="com.ub.training.product.routes.ProductAdminRoutes" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>

<style>
    .curcor-pointer:hover {
        cursor: pointer;
        background-color: whitesmoke;
    }
</style>
<div class="row" style="margin-top: 10px">
    <div class="col-lg-12">
        <table class="table table-bordered" id="table-1">
            <thead>
            <tr>
                
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${searchProductAdminResponse.result}" var="doc">

                <tr class="curcor-pointer modal-product-line" data-id="${doc.id}" data-title="${doc.title}">
                    
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <div class="col-lg-12 text-center">
        <ul class="pagination pagination-sm">

            <li>
                <a href="#" class="modal-product-goto" data-query="${searchProductAdminResponse.query}"
                   data-number="${searchProductAdminResponse.prevNum()}">
                    <i class="entypo-left-open-mini"></i></a>
            </li>
            <c:forEach items="${searchProductAdminResponse.paginator()}" var="page">
                <li class="<c:if test="${searchProductAdminResponse.currentPage eq page}">active</c:if>">
                    <a href="#" class="modal-product-goto" data-query="${searchProductAdminResponse.query}"
                       data-number="${page}">${page + 1}</a>
                </li>
            </c:forEach>
            <li>
                <a href="#" class="modal-product-goto" data-query="${searchProductAdminResponse.query}"
                   data-number="${searchProductAdminResponse.nextNum()}"><i class="entypo-right-open-mini"></i></a>
            </li>
        </ul>
    </div>
</div>