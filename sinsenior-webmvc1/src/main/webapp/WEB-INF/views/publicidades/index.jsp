<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
    function deletePublicidad() {
        if (confirm("Desea eliminar esta publicidad")) {
            return true;
        }
        return false;
    }
</script>

<div class="container">
    <h1 style="float:left;">Administrador de Publicidad</h1>
    <div style="float:right;margin-bottom: 10px;">
        <a href="<c:url value='/pages/publicidades/new'/>" class="btn btn-primary">Nueva Publicidad</a>        
    </div>
    <div class="clear"></div>
    <br/>
    <table class="table table-striped">
        <tr>
            <th>Titulo</th>
            <th>Contenido</th>
            <th>fechainicio</th>
            <th>fechafinal</th>
            <th>tarifa</th>
            <th>clicks</th>
            <th>ubicacion</th>
            <th style="width: 150px;"></th>
            <th style="width: 150px;"></th>
        </tr>
        <c:forEach var="publicidad" items="${publicidades}">
            <tr>
                <td>${publicidad.titulo}</td>
                <td>${publicidad.contenido}</td>
                <td>${publicidad.fechainicio}</td>
                <td>${publicidad.fechafinal}</td>
                <td>${publicidad.tarifa}</td>
                <td>${publicidad.clicks}</td>
                <td>${publicidad.ubicacion}</td>               
                <td><a href="<c:url value='/pages/publicidades/edit?id=${publicidad.id}'/>">Editar publicidad</a></td>
                <td><a href="<c:url value='/pages/publicidades/delete?id=${publicidad.id}'/>" onclick="if (deletePublicidad()) { return true; } else { return false; }">Eliminar publicidad</a></td>
            </tr>
        </c:forEach>
    </table>
</div>