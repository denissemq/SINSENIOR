<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
    function deletecancha() {
        if (confirm("Desea eliminar esta cancha")) {
            return true;
        }
        return false;
    }
</script>

<div class="container">
    <h1 style="float:left;">Administrador de Canchas</h1>
    <div style="float:right;margin-bottom: 10px;">
        <a href="<c:url value='/pages/canchas/new'/>" class="btn btn-primary">Nueva cancha</a>        
    </div>
    <div class="clear"></div>
    <br/>
   <table class="table table-striped">
        <tr>
            <th>Nombre</th>
            <th>Caracteristica</th>
            <th>fechaatencion</th>
            <th>tarifa</th>
            <th>promocion</th> 
         <th style="width: 150px;"></th>
            <th style="width: 150px;"></th>
        </tr>
        <c:forEach var="cancha" items="${canchas}">
            <tr>
                <td>${cancha.nombre}</td>
                <td>${cancha.caracteristica}</td>
                <td>${cancha.fechaatencion}</td>
                <td>${cancha.tarifa}</td>
                <td>${cancha.promocion}</td>
    <td><a href="<c:url value='/pages/canchas/edit?id=${cancha.id}'/>">Editar cancha</a></td>
                <td><a href="<c:url value='/pages/canchas/delete?id=${cancha.id}'/>" onclick="if (deleteCancha()) { return true; } else { return false; }">Eliminar cancha</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
