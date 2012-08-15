<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Paso 2-Datos Compra</h1><br/><br/>
    <form:form action="edit" method="post" commandName="cita" cssClass="form-horizontal">
         <div class="row">
            <div class="control-group">
                <div class="controls">
                    DATOS INFOCORP
                </div>
            </div>
            <div class="control-group">
                <label>Tipo persona:</label>
                <div class="controls">
                    
                    <form:select path="tipoPersona" id="tipoPersona" >
					<form:options items="${listTipoPersona}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoPersona" cssstyle="color:red"></form:errors>
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
                <label>Nombre/Razon Social:</label>
                <div class="controls">
                    <form:input path="numRazSocial" readOnly="true"></form:input>
                    <form:errors path="numRazSocial" cssstyle="color:red"></form:errors>
                </div>
            </div>
            
            <div class="control-group">
                <label></label>
                <div class="controls">
                     <a style="margin-left: 5px; " class="btn btn-primary" href="<c:url value='/pages/citas/ValidarDocumento?tipoPersona=${cita.tipoPersona}&docId=${cita.docId}&id=${cita.codigo}'/>">Validar</a>
            
                </div>
            </div> 
                 
            <div class="control-group">
                <label>Observaciones:</label>
                <div class="controls">
                    <form:textarea path="observacionesic"  rows="4" style="width:450px" ></form:textarea>
                    <form:errors path="observacionesic" cssstyle="color:red"></form:errors>
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
