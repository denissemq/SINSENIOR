<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Paso 2-Datos Venta</h1><br/><br/>
    <form:form action="edit" method="post" commandName="cita" cssClass="form-horizontal">
         <div class="row">
            <div class="control-group">
                <div class="controls">
                    DATOS REGISTROS PRUBLICOS
                </div>
            </div>
            <div class="control-group">
                <label>DNI/RUC:</label>
                <div class="controls">
                    <form:input path="docId"></form:input>
                    <form:errors path="docId" cssstyle="color:red"></form:errors>
                </div>
            </div>
           
            <div class="control-group">
                <label>Nombre/Razon Social:</label>
                <div class="controls">
                    <form:input path="numRazSocial"></form:input>
                    <form:errors path="numRazSocial" cssstyle="color:red"></form:errors>
                </div>
            </div>
            
            <div class="control-group">
                <label></label>
                <div class="controls">
                    <a style="margin-left: 5px; " class="btn btn-primary">Validar</a>
                </div>
            </div> 
            <div class="control-group">
                <label>Observaciones:</label>
                <div class="controls">
                    <form:input path="observacionesic"></form:input>
                    <form:errors path="observacionesic" cssstyle="color:red"></form:errors>
                </div>
            </div>
                         
            <div class="control-group">
                <label>Tipo  Inmueble:</label>
                 <div class="controls">
					<form:select path="tipoInmueble" id="tipoInmueble">
					<form:options items="${listTipoInmueble}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoInmueble" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Area:</label>
                <div class="controls">
                    <form:input path="area"></form:input>
                    <form:errors path="area" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Distrito</label>
                <div class="controls">
                    <form:select path="distrito" id="distrito">
					<form:options items="${listDistrito}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="distrito" cssstyle="color:red"></form:errors>
                </div>
            </div>  
            <div class="control-group">
                <label>Dirección</label>
                <div class="controls">
                    <form:input path="direccion"></form:input>
                    <form:errors path="direccion" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Habitaciones</label>
                <div class="controls">
                    <form:input path="nroHab"></form:input>
                    <form:errors path="nroHab" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Baños</label>
                <div class="controls">
                    <form:input path="nroBanos"></form:input>
                    <form:errors path="nroBanos" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Patio</label>
                <div class="controls">
                    <form:checkbox path="hPatio"  ></form:checkbox>
                </div>
            </div> 
            <div class="control-group">
                <label>Jardin</label>
                <div class="controls">
                    <form:checkbox path="hJardin"  ></form:checkbox>
                </div>
            </div> 
            <div class="control-group">
                <label>Observaciones</label>
                <div class="controls">
                    <form:input path="observaciones"></form:input>
                    <form:errors path="observaciones" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            
        </div>
        <div class="actions" style="margin-left: 160px;">
           
           <a style="margin-left: 5px; " class="btn btn-primary" href="<c:url value='/pages/citas/aceptarOperacion?id=${cita.codigo}&codigoUsuario=${credential.id}&codigoEstado=${cita.codigoEstado}'/>">Siguiente</a>
             <a style="margin-left: 5px; " class="btn btn-primary" href="<c:url value='/pages/citas/anularOperacion?id=${cita.codigoDetalle}&codigoUsuario=${credential.id}&codigoEstado=${cita.codigoEstado}'/>">Anular</a>
            <a style="margin-left: 5px;" class="btn btn-primary"  href="<c:url value='/pages/citas/pendientes'/>">Cancelar</a>
        </div>
    </form:form>
</div>