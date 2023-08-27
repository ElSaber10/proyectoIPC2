<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 25/08/23
  Time: 03:20
  To change this template use File | Settings | File Templates.
--%>
<c:if test="${!empty(libro)}">
    <div class="mb-3">
        <label for="isbn" class="form-label">isbn:</label>
        <input type="text" class="form-control" name="isbn" id="isbn" value="${libro.isbn}" readonly>
    </div>
</c:if>

<div class="mb-3">
    <label for="nombre" class="form-label">*Nombre:</label>
    <input type="text" class="form-control" name="nombre" id="nombre" value="${libro.nombre}" required>
</div>
<div class="mb-3">
    <label for="costo" class="form-label">Costo:</label>
    <textarea class="form-control" name="costo" id="costo" rows="3">${libro.costo}</textarea>
</div>
<div class="mb-3">
    <label for="autor" class="form-label">*Autor:</label>
    <input type="text" class="form-control" name="autor" id="autor" value="${libro.autor}" required>
</div>
<div class="mb-3">
    <label for="categoria_id" class="form-label">*Categoria:</label>
    <input type="text" class="form-control" name="autor" id="categoria_id" value="${libro.categoria}" required>
</div>

</form>
