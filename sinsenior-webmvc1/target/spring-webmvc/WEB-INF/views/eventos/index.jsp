<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
    function deleteEvento() {
        if (confirm("Desea eliminar este evento")) {
            return true;
        }
        return false;
    }
</script>

<div class="container">
    <h1 style="float:left;">Administrador de Eventos Deportivos</h1>
    <div style="float:right;margin-bottom: 10px;">
        <a href="<c:url value='/pages/eventos/new'/>" class="btn btn-primary">Nuevo Evento</a>        
    </div>
    <div class="clear"></div>
    <br/>
    <table class="table table-striped">
        <tr>
            <th>Nombre</th>
            <th>Premio</th>
            <th>Cantidad</th>
            <th>Plazo</th>
            <th style="width: 150px;"></th>
            <th style="width: 150px;"></th>
        </tr>
        <c:forEach var="evento" items="${eventos}">
            <tr>
                <td>${evento.nombre}</td>
                <td>${evento.premio}</td>
                <td>${evento.cantidad}</td>
                <td>${evento.plazo}</td>
                <td><a href="<c:url value='/pages/eventos/edit?id=${evento.id}'/>">Editar evento</a></td>
                <td><a href="<c:url value='/pages/eventos/delete?id=${evento.id}'/>" onclick="if (deleteEvento()) { return true; } else { return false; }">Eliminar evento</a></td>
            </tr>
        </c:forEach>
    </table>
</div>