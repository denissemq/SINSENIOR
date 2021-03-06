<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Paso 1-Información Contacto</h1><br/><br/>
    <form:form action="editPendiente" method="post" commandName="cita" cssClass="form-horizontal">
         <div class="row">
            
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
                <div class="controls">
                    DATOS CONTACTO
                </div>
            </div>
            
            <div class="control-group">
                <label>Tipo persona:</label>
                <div class="controls">
                    
                    <form:select path="tipoPersona" id="tipoPersona" readOnly="true">
					<form:options items="${listTipoPersona}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoPersona" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nombre/Razon Social:</label>
                <div class="controls">
                     <form:textarea path="numRazSocial" rows="2" style="width:450px"  readOnly="true"></form:textarea>
                    <form:errors path="numRazSocial" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>DNI/RUC:</label>
                <div class="controls">
                    <form:input path="docId" readOnly="true"></form:input>
                    <form:errors path="docId" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Correo electrónico:</label>
                <div class="controls">
                    <form:input path="correo" readOnly="true"></form:input>
                    <form:errors path="correo" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Telefono:</label>
                <div class="controls">
                    <form:input path="telefono" readOnly="true"></form:input>
                    <form:errors path="telefono" cssstyle="color:red"></form:errors>
                </div>
            </div>    
            <div class="control-group">
                <label>Celular:</label>
                <div class="controls" >
                    <form:input path="celular"readOnly="true"></form:input>
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
                    <form:input path="fecha" readOnly="true"></form:input>
                    <form:errors path="fecha" cssstyle="color:red"></form:errors>
                </div>
            </div>     
            <div class="control-group">
                <label>Lugar:</label>
                <div class="controls">
                    <form:input path="lugar" readOnly="true"></form:input>
                    <form:errors path="lugar" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group"  style="display:none">
                <label>Codigo:</label>
                <div class="controls">
                    <form:input path="codigoDetalle" ></form:input>
                    <form:errors path="codigoDetalle" cssstyle="color:red"></form:errors>
                </div>
            </div>    
            <div class="control-group"   style="display:none">
                <label>Codigo usuario:</label>
                <div class="controls">
                    <form:input path="codigoUsuario" value="${credential.id}" ></form:input>
                    <form:errors path="codigoUsuario" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group" >
                <label></label>
                <div class="controls">
                     <a style="margin-left: 5px; " class="btn btn-primary" href="<c:url value='/pages/citas/ValidarDocumento?tipoPersona=${cita.tipoPersona}&docId=${cita.docId}&id=${cita.codigo}'/>">Validar</a>
            
                </div>
            </div> 
                 
            <div class="control-group">
                <label>Observaciones:</label>
                <div class="controls">
                    <form:textarea  path="observacionesic" rows="5" style="width:450px" ></form:textarea>
                    <form:errors path="observacionesic" cssstyle="color:red"></form:errors>
                </div>
            </div>        
        </div>
        <div class="actions" style="margin-left: 160px;">
           
           <a style="margin-left: 5px; " class="btn btn-primary" href="<c:url value='/pages/citas/validarOperacion?id=${cita.codigo}&codigoUsuario=${credential.id}&codigoEstado=${cita.codigoEstado}'/>">Siguiente</a>
             <a style="margin-left: 5px; " class="btn btn-primary" href="<c:url value='/pages/citas/anularOperacion?id=${cita.codigoDetalle}&codigoUsuario=${credential.id}&codigoEstado=${cita.codigoEstado}'/>">Anular</a>
            <a style="margin-left: 5px;" class="btn btn-primary"  href="<c:url value='/pages/citas/pendientes'/>">Cancelar</a>
        </div>
    </form:form>
</div>