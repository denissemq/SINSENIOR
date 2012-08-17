<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="container">
    <h1 style="float:left;">Buscar inmuebles</h1>
    <div style="float:right;margin-bottom: 10px;">
    </div>
    <div class="clear"></div>
    
    <br/>
          
            <%-- <div class="control-group">
                <label>Distrito</label>
                <div class="controls">
                    <form:select path="distrito" id="distrito">
					<form:options items="${listDistrito}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                </div>
            </div> 
            <div class="control-group">
                <label>Tipo  Inmueble:</label>
                 <div class="controls">
					<form:select path="tipoInmueble" id="tipoInmueble">
					<form:options items="${listTipoInmueble}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                </div>
            </div>
            <div class="control-group">
                <label>Area:</label>
                 <div class="controls">
					Desde:  <form:input path="Dearea"></form:input> 
					Hasta:  <form:input path="Hastaarea"></form:input> 
                </div>
            </div>
            <div class="control-group">
                <label>Nro Habitaciones:</label>
                 <div class="controls">
					Desde:  <form:input path="DeHab"></form:input> 
					Hasta:  <form:input path="HastaHab"></form:input> 
                </div>
            </div> --%>
                <input name="" value="Buscar" type="submit" class="btn btn-primary">
    <table class="table table-striped">
        <tr>
            <th>Codigo</th>
            <th>Tipo Inmueble</th>
            <th>Distrito</th>
            <th>Dirección</th>
            <th>Contacto</th>
            <th style="width: 150px;"></th>
            <th style="width: 150px;"></th>
        </tr>
        <c:forEach var="inmueble" items="${inmuebles}">
            <tr>
                <td>${inmueble.codigo}</td>
                <td>${inmueble.tipoInmuebleDesc}</td>
                <td>${inmueble.distritoDesc}</td>
                <td>${inmueble.direccion}</td>
                <td>${inmueble.numRazSocial}</td>
                <td><a href="<c:url value='/pages/inmuebles/separaInmueble?id=${inmueble.codigo}'/>">Separa inmueble</a></td>
            </tr>
        </c:forEach>
    </table>
              
    </div>
