<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Editar Locales</h1><br/><br/>
    <form:form action="edit" method="post" commandName="local" cssClass="form-horizontal">
        <div class="row">
            <form:hidden path="id"></form:hidden>
            <div class="control-group">
                <label>Nombre:</label>
                <div class="controls">
                    <form:input path="nombre"></form:input>
                    <form:errors path="nombre" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Direccion:</label>
                <div class="controls">
                    <form:input path="direccion"></form:input>
                    <form:errors path="direccion" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Distrito:</label>
                <div class="controls">
                    <form:input path="distrito"></form:input>
                    <form:errors path="distrito" cssstyle="color:red"></form:errors>
                </div>
            </div>
             <div class="control-group">
                <label>Direccion Google Maps:</label>
                <div class="controls">
                    <form:input path="direcciongooglemaps"></form:input>
                    <form:errors path="direcciongooglemaps" cssstyle="color:red"></form:errors>
                </div>
            </div>
             <div class="control-group">
                <label>Telefono (opcional):</label>
                <div class="controls">
                    <form:input path="telefono"></form:input>
                    <form:errors path="telefono" cssstyle="color:red"></form:errors>
                </div>
            </div>                
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Editar" type="submit" class="btn btn-primary">
            <a style="margin-left: 5px;" href="<c:url value='/pages/locales/index'/>">Cancelar</a>
        </div>
    </form:form>
</div>
