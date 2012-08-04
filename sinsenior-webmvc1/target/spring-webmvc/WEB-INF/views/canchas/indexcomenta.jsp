<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1 style="float:left;">Buscar, Comentar y Alquilar Canchas</h1>
    <div style="float:right;margin-bottom: 10px;">
    </div>
    <div class="clear"></div>
    <br/>
                   Nombre:
                <INPUT TYPE="text" NAME="NOMBRE" SIZE=40>
                <input name="" value="Buscar" type="submit" class="btn btn-primary">
    <table class="table table-striped">
        <tr>
            <th>Nombre</th>
            <th>Caracteristica</th>
            <th style="width: 150px;"></th>
            <th style="width: 150px;"></th>
        </tr>
        <c:forEach var="cancha" items="${canchas}">
            <tr>
                <td>${cancha.nombre}</td>
                <td>${cancha.caracteristica}</td>
                <td><a href="<c:url value='/pages/canchas/editcomenta?id=${cancha.id}'/>">Comentar cancha</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
