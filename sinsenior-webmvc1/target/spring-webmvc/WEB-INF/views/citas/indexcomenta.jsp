<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="container">
    <h1 style="float:left;">Buscar inmuebles</h1>
    <div style="float:right;margin-bottom: 10px;">
    </div>
    <div class="clear"></div>
    
    <br/>
                   Nombre:
                <INPUT TYPE="text" NAME="NOMBRE" SIZE=40>
                <input name="" value="Buscar" type="submit" class="btn btn-primary">
    <table class="table table-striped">
        <tr>
            <th>Tipo Inmueble</th>
            <th>Descripcion</th>
            <th>Dirección</th>
            <th style="width: 150px;"></th>
            <th style="width: 150px;"></th>
        </tr>
        <c:forEach var="inmueble" items="${citas}">
            <tr>
                <td>${citas.tipoInmueble}</td>
                <td>${citas.descripcion}</td>
                <td>${citas.direccion}</td>
                <td><a href="<c:url value='/pages/citas/separaInmueble?id=${citas.id}'/>">Separa citas</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
