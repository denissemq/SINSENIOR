<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
    function deleteinmueble() {
        if (confirm("Desea eliminar esta inmueble")) {
            return true;
        }
        return false;
    }
</script>

<div class="container">
    <h1 style="float:left;">Administrador de inmuebles</h1>
    <div style="float:right;margin-bottom: 10px;">
        <a href="<c:url value='/pages/inmuebles/new'/>" class="btn btn-primary">Nueva inmueble</a>        
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
        <c:forEach var="inmueble" items="${inmuebles}">
            <tr>
                <td>${inmueble.nombre}</td>
                <td>${inmueble.caracteristica}</td>
                <td>${inmueble.fechaatencion}</td>
                <td>${inmueble.tarifa}</td>
                <td>${inmueble.promocion}</td>
    <td><a href="<c:url value='/pages/inmuebles/edit?id=${inmueble.id}'/>">Editar inmueble</a></td>
                <td><a href="<c:url value='/pages/inmuebles/delete?id=${inmueble.id}'/>" onclick="if (deleteinmueble()) { return true; } else { return false; }">Eliminar inmueble</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
