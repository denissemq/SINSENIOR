	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1 style="float:left;">Listar Suscripciones</h1>
    <form:form action="buscarSusc" method="POST" commandName="listaInmuemble" cssClass="form-horizontal" >
    <div style="float:right;margin-bottom: 10px;">
    </div>
    <div class="clear"></div>
    
    <br/>
          
  
           <table class="table table-striped" >
        <tr  border="1" cellpadding="0" cellspacing="0"  bordercolor="#333333">
          <th rowspan="2" align="center" valign="middle">Contacto</th>
          <th rowspan="2" align="center" valign="middle">Correo</th>
          <th rowspan="2" align="center" valign="middle">Tipo Inmueble</th>
          <th rowspan="2" align="center" valign="middle">Distrito</th>
          <th colspan="2" align="center" valign="middle">Area</th>
          <th colspan="2" align="center" valign="middle">Nro Hab.</th>
          <th colspan="2" align="center" valign="middle">Nro. Baños</th>
          <th rowspan="2" align="center" valign="middle">Jardín</th>
          <th rowspan="2" align="center" valign="middle">Patio</th>
          </tr>
        <tr  border="1" cellpadding="0" cellspacing="0"  bordercolor="#333333">
        	<th align="center" valign="middle">De</th>
            <th align="center" valign="middle">Hasta</th>
            <th align="center" valign="middle">De.</th>
            <th align="center" valign="middle">Hasta</th>
            <th align="center" valign="middle">De</th>
            <th align="center" valign="middle">Hasta</th>
            </tr>
        <c:forEach var="inmueble" items="${listaInmuemble}">
            <tr>
                <td>${inmueble.numRazSocial}</td>
                <td>${inmueble.correo}</td>
                <td>${inmueble.tipoInmuebleDesc}</td>
                <td>${inmueble.distritoDesc}</td>
                <td>${inmueble.areade}</td>
                <td>${inmueble.areahasta}</td>
                <td>${inmueble.nroHabde}</td>
                <td>${inmueble.nroHabhasta}</td>
                <td>${inmueble.nroBanosde}</td>
                <td>${inmueble.nroBanoshasta}</td>
                <td>${inmueble.hJardin}</td>
                <td>${inmueble.hPatio}</td>
                <td><a href="<c:url value='/pages/inmuebles/AnulSuscrip?id=${inmueble.codigo}'/>">Anular</a></td>
                
                
            </tr>
        </c:forEach>
    </table>
            
       </form:form>       
    </div>
    
    
