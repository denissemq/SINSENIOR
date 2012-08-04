<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
    function deleteServicio() {
        if (confirm("Desea eliminar este servicio")) {
            return true;
        }
        return false;
    }
</script>

<div class="container">
    <h1 style="float:left;">Administrador de Servicios Adicionales</h1>
    <div style="float:right;margin-bottom: 10px;">
        <a href="<c:url value='/pages/servicios/new'/>" class="btn btn-primary">Nuevo Servicio</a>        
    </div>
    <div class="clear"></div>
    <br/>
    <table class="table table-striped">
        <tr>
            <th>Tipo Servicio</th>
            <th>Descripcion</th>
            <th>Tarifa</th>
            <th style="width: 150px;"></th>
            <th style="width: 150px;"></th>
        </tr>
        <c:forEach var="servicio" items="${servicios}">
            <tr>
                <td>${servicio.tiposervicio}</td>
                <td>${servicio.descripcion}</td>
                <td>${servicio.tarifa}</td>
                <td><a href="<c:url value='/pages/servicios/edit?id=${servicio.id}'/>">Editar Servicio</a></td>
                <td><a href="<c:url value='/pages/servicios/delete?id=${servicio.id}'/>" onclick="if (deleteServicio()) { return true; } else { return false; }">Eliminar Servicio</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
