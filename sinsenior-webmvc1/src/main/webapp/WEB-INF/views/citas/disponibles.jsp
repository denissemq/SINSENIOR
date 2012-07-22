<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">
    function deletecitas() {
        if (confirm("Desea anular esta Cita")) {
            return true;
        }
        return false;
    }
</script>

<div class="container">
    <h1 style="float:left;">Administrador de citas</h1>
    <div style="float:right;margin-bottom: 10px;">
    <%--     <a href="<c:url value='/pages/citas/new'/>" class="btn btn-primary">Nueva cita</a> --%>        
    </div>
    <div class="clear"></div>
    <br/>
   <table class="table table-striped">
        <tr>
            <th>ID</th>
            <th>Nombre/Raz. Social</th>
            <th>Documento</th>
            <th>Distrito</th>
            <th>Tipo</th>
            <th>Fecha</th> 
         <th style="width: 100px;"></th>
        </tr>
        <c:forEach var="cita" items="${cita}">
            <tr>
                <td>${cita.codigo}</td>
                <td>${cita.numRazSocial}</td>
                <td>${cita.docId}</td>
                <td>${cita.distritoDesc}</td>
                <td>${cita.tipoEstadoDesc}</td>
                <td>${cita.credat}</td>
    <td><a href="<c:url value='/pages/citas/edit?id=${cita.codigo}'/>">Programar</a></td>
    
     
            </tr>
        </c:forEach>
    </table>
</div>
