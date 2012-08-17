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
           
    </div>
    <div class="clear"></div>
    <br/>
     <table class="table table-striped">
        <tr>
            <th>Codigo</th>
            <th>Tipo Inmueble</th>
            <th>Distrito</th>
            <th>Dirección</th>
            <th>Estado</th>
        </tr>
        <c:forEach var="inmueble" items="${inmuebles}">
            <tr>
                <td>${inmueble.codigo}</td>
                <td>${inmueble.tipoInmuebleDesc}</td>
                <td>${inmueble.distritoDesc}</td>
                <td>${inmueble.direccion}</td>
                <td>${inmueble.tipoEstadoDesc}</td>
                
            </tr>
        </c:forEach>
    </table>
</div>
