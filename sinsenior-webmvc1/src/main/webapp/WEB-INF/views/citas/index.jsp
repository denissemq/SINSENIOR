<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
    function deletecitas() {
        if (confirm("Desea eliminar esta Cita")) {
            return true;
        }
        return false;
    }
</script>

<div class="container">
    <h1 style="float:left;">Administrador de citas</h1>
    <div style="float:right;margin-bottom: 10px;">
        <a href="<c:url value='/pages/citas/new'/>" class="btn btn-primary">Nueva cita</a>        
    </div>
    <div class="clear"></div>
    <br/>
   <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Documento</th>
            <th>Correo</th>
            <th>Teléfono</th>
            <th>Tipo Inmueble</th>
            <th>Descripcion</th> 
            <th>Direccion</th> 
            <th>Activo</th> 
         <th style="width: 150px;"></th>
            <th style="width: 150px;"></th>
        </tr>
        <c:forEach var="inmueble" items="${inmuebles}">
            <tr>
                <td>${inmueble.id}</td>
                <td>${inmueble.nombre}</td>
                <td>${inmueble.doc}</td>
                <td>${inmueble.correo}</td>
                <td>${inmueble.telefono}</td>
                <td>${inmueble.tipoInmueble}</td>
                <td>${inmueble.descripcion}</td>
                <td>${inmueble.direccion}</td>
                <td>${inmueble.activo}</td>
    <td><a href="<c:url value='/pages/citas/edit?id=${inmueble.id}'/>">Editar Cita</a></td>
                <td><a href="<c:url value='/pages/inmuebles/delete?id=${inmueble.id}'/>" onclick="if (deletecitas()) { return true; } else { return false; }">Eliminar citas</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
