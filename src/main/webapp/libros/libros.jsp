<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 25/08/23
  Time: 03:44
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ToDo Web - Libros</title>

    <!--CSS-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<jsp:include page="/WEB-INF/navBarMenu.jsp"/>

<c:if test="${empty(libro)}">
    <!-- Botón agregar Libro -->
    <div class="container-fluid py-3 mb-4 bg-secondary">
        <div class="row">
            <div class="col-3">
                <a href="#" class="btn btn-primary btn-block" data-bs-toggle="modal" data-bs-target="#clientModal"
                    data-controls-modal="clientModal" data-bs-backdrop="static" data-bs-keyboard="false">
                        <i class="fas fa-plus"></i> Agregar Libro
                </a>
            </div>
        </div>
    </div>


    <!-- Listado de libros -->
    <div class="container-fluid mb-5">
    <c:if test="${!empty(success)}">
                <div class="row">
                    <div class="col-10">
                        <div class="alert alert-success alert-dismissible">
                            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                                ${success}
                        </div>
                    </div>
                </div>
                    </c:if>
                    <div class="row">
                    <div class="col-10">
                    <div class="card">
                    <div class="card-header">
                    <h4>Listado de Libros</h4>
                    </div>
    <c:choose>
            <c:when test="${!empty(libro)}">
                <div class="card-body">
                                <table id="listLibros" class="table table-striped table-sm" cellspacing="0"
                                       width="100%">
                                    <thead class="bg-dark text-white">
                                    <tr>
                                        <th>Isbn</th>
                                        <th>Nombre</th>
                                        <th>Precio</th>
                                        <th>Categoria</th>
                                        <th>Autor</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="libros" items="${libros}" varStatus="status">
                                        <tr>
                                            <td>${status.count}</td>
                                            <td>${libros.isbn}</td>
                                            <td>${libros.nombre}</td>
                                            <td>${libros.precio}</td>
                                            <td>${libros.categoria}</td>
                                            <td>${libros.autor}</td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/editarLibro?action=get&id=${libros.isbn}"
                                                   class="btn btn-info btn-sm">Editar</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <h4 class="pl-4">No hay Libros</h4>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</c:if>





<!--JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>