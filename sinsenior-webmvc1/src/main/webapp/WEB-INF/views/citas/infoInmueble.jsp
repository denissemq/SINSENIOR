<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Paso 3-Aceptación</h1><br/><br/>
    <form:form action="Aceptar" method="post" commandName="cita" cssClass="form-horizontal">
         <div class="row">
            <div class="control-group">
                <div class="controls">
                    DATOS INMUEBLE
                </div>
            </div>
            
              <div class="control-group">
                <label>Tipo  Estado:</label>
                 <div class="controls">
					<form:select path="codigoEstado" id="codigoEstado">
					<form:options items="${listTipoEstado}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoInmueble" cssstyle="color:red"></form:errors>
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
                    <form:input path="area"  readOnly="true"></form:input>
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
                    <form:input path="direccion"  readOnly="true"></form:input>
                    <form:errors path="direccion" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Habitaciones</label>
                <div class="controls">
                    <form:input path="nroHab"  readOnly="true"></form:input>
                    <form:errors path="nroHab" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Baños</label>
                <div class="controls">
                    <form:input path="nroBanos"  readOnly="true"></form:input>
                    <form:errors path="nroBanos" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Patio</label>
                <div class="controls">
                    <form:checkbox path="hPatio"  readOnly="true" ></form:checkbox>
                </div>
            </div> 
            <div class="control-group">
                <label>Jardin</label>
                <div class="controls">
                    <form:checkbox path="hJardin"   readOnly="true"></form:checkbox>
                </div>
            </div> 
            <div class="control-group">
                <label>Observaciones</label>
                <div class="controls">
                    <form:input path="observaciones"  readOnly="true"></form:input>
                    <form:errors path="observaciones" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <div class="controls">
                    DATOS CONTACTO
                </div>
            </div>
            
            <div class="control-group">
                <label>Tipo persona:</label>
                <div class="controls">
                    
                    <form:select path="tipoPersona" id="tipoPersona">
					<form:options items="${listTipoPersona}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoPersona" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nombre/Razon Social:</label>
                <div class="controls">
                    <form:input path="numRazSocial"  readOnly="true"></form:input>
                    <form:errors path="numRazSocial" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>DNI/RUC:</label>
                <div class="controls">
                    <form:input path="docId"  readOnly="true"></form:input>
                    <form:errors path="docId" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Correo electrónico:</label>
                <div class="controls">
                    <form:input path="correo"  readOnly="true"></form:input>
                    <form:errors path="correo" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Telefono:</label>
                <div class="controls">
                    <form:input path="telefono"  readOnly="true"></form:input>
                    <form:errors path="telefono" cssstyle="color:red"></form:errors>
                </div>
            </div>    
            <div class="control-group">
                <label>Celular:</label>
                <div class="controls">
                    <form:input path="celular"  readOnly="true"></form:input>
                    <form:errors path="celular" cssstyle="color:red"></form:errors>
                </div>
            </div>     
            <div class="control-group" style="display:none">
                <label>Estado:</label>
                <div class="controls">
                    <form:input path="estado" value="4"></form:input>
                    <form:errors path="estado" cssstyle="color:red"></form:errors>
                </div>
            </div>      
            <div class="control-group">
                <label>Fecha:</label>
                <div class="controls">
                    <form:input path="fecha"   readOnly="true"></form:input>
                    <form:errors path="fecha" cssstyle="color:red"></form:errors>
                </div>
            </div>     
            <div class="control-group">
                <label>Lugar:</label>
                <div class="controls">
                    <form:input path="lugar"   readOnly="true"></form:input>
                    <form:errors path="lugar" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group" style="display:none">
                <label>Codigo:</label>
                <div class="controls">
                    <form:input path="codigoDetalle" ></form:input>
                    <form:errors path="codigoDetalle" cssstyle="color:red"></form:errors>
                </div>
            </div>    
            <div class="control-group" style="display:none">
                <label>Codigo usuario:</label>
                <div class="controls">
                    <form:input path="codigoUsuario" value="${credential.id}" ></form:input>
                    <form:errors path="codigoUsuario" cssstyle="color:red"></form:errors>
                </div>
            </div>         
        </div>
        <div class="actions" style="margin-left: 160px;">
           
            <input name="" value="Grabar" type="submit" class="btn btn-primary">
           <a style="margin-left: 5px; " class="btn btn-primary" href="<c:url value='/pages/citas/anular?id=${cita.codigoDetalle}&codigoUsuario=${credential.id}'/>">Anular</a>
            <a style="margin-left: 5px;" class="btn btn-primary"  href="<c:url value='/pages/citas/pendientes'/>">Cancelar</a>
        </div>
    </form:form>
</div>