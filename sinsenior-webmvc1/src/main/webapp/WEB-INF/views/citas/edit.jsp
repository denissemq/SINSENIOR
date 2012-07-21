<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Editar Citas</h1><br/><br/>
    <form:form action="edit" method="post" commandName="inmuebles" cssClass="form-horizontal">
        <div class="row">
            <form:hidden path="id"></form:hidden>
              <div class="control-group">
                <label>Id:</label>
                <div class="controls">
                    <form:input path="id"></form:input>
                    <form:errors path="id" cssstyle="color:red"></form:errors>
                </div>
            </div>
              <div class="control-group">
                <label>Nombre/Razon Social:</label>
                <div class="controls">
                    <form:input path="nombre"></form:input>
                    <form:errors path="nombre" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>DNI/RUC:</label>
                <div class="controls">
                    <form:input path="doc"></form:input>
                    <form:errors path="doc" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Correo electrónico:</label>
                <div class="controls">
                    <form:input path="correo"></form:input>
                    <form:errors path="correo" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Telefono:</label>
                <div class="controls">
                    <form:input path="telefono"></form:input>
                    <form:errors path="telefono" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Tipo  Inmueble:</label>
                <div class="controls">
                    <form:input path="tipoInmueble"></form:input>
                    <form:errors path="tipoInmueble" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Descripción:</label>
                <div class="controls">
                    <form:input path="descripcion"></form:input>
                    <form:errors path="descripcion" cssstyle="color:red"></form:errors>
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
                <label>Fecha</label>
                <div class="controls">
                    <form:input path="dia"></form:input>
                    <form:errors path="dia" cssstyle="color:red"></form:errors>
                </div>
            </div>   
            <div class="control-group">
                <label>Hora</label>
                <div class="controls">
                    <form:input path="hora"></form:input>
                    <form:errors path="hora" cssstyle="color:red"></form:errors>
                </div>
            </div>   
            <div class="control-group">
                <label>Usuario</label>
                <div class="controls">
                    <form:input path="corredor"></form:input>
                    <form:errors path="corredor" cssstyle="color:red"></form:errors>
                </div>
            </div>   
            <div class="control-group">
                <label>Usuario</label>
                <div class="controls">
                    <form:input path="usuarioId" value="${credential.correo}"></form:input>
                    <form:errors path="usuarioId"  cssstyle="color:red"></form:errors>
                </div>
            </div>  
            <div class="control-group" >
                <label>Activo</label>
                <div class="controls">
                    <form:input path="activo" value="0"></form:input>
                </div>
            </div>  
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Editar" type="submit" class="btn btn-primary">
            <a style="margin-left: 5px;" href="<c:url value='/pages/citas/index'/>">Cancelar</a>
        </div>
    </form:form>
</div>