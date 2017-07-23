<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="b" uri="http://www.itkt.com/boss"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%@ page import="com.threefiveninetong.mchh.util.*" %>
<%
 String imageUrl = ConstantUtil.imageBaseUrl;
%>
<c:set var="imageUrl" value="<%= imageUrl%>"/>