<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
    function deleteLocal() {
        if (confirm("Desea eliminar este local")) {
            return true;
        }
        return false;
    }
</script>

<div class="container">
    <h1 style="float:left;">Administrador de Locales</h1>
    <div style="float:right;margin-bottom: 10px;">
        <a href="<c:url value='/pages/locales/new'/>" class="btn btn-primary">Nuevo Local</a>        
    </div>
    <div class="clear"></div>
    <br/>
    <table class="table table-striped">
        <tr>
            <th>Nombre Descriptivo</th>
            <th>Direccion</th>
            <th>Distrito</th>
            <th>Direccion en Google Maps</th>
            <th>Telefono fijo (opcional)</th>
            <th style="width: 100px;"></th>
            <th style="width: 100px;"></th>

        </tr>
        <c:forEach var="local" items="${locales}">
            <tr>
                <td>${local.nombre}</td>
                <td>${local.direccion}</td>
                <td>${local.distrito}</td>
                <td>${local.direcciongooglemaps}</td>
                <td>${local.telefono}</td>
                <td><a href="<c:url value='/pages/locales/edit?id=${local.id}'/>">Editar local</a></td>
                <td><a href="<c:url value='/pages/locales/delete?id=${local.id}'/>" onclick="if (deleteLocal()) { return true; } else { return false; }">Eliminar local</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
