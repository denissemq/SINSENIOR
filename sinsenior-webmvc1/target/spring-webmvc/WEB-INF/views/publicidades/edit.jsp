<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Editar Publicidad</h1><br/><br/>
    <form:form action="edit" method="post" commandName="publicidad" cssClass="form-horizontal">
        <div class="row">
            <form:hidden path="id"></form:hidden>
            <div class="control-group">
                <label>Titulo:</label>
                <div class="controls">
                    <form:input path="titulo"></form:input>
                    <form:errors path="titulo" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Contenido:</label>
                <div class="controls">
                    <form:input path="contenido"></form:input>
                    <form:errors path="contenido" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>fechainicio:</label>
                <div class="controls">
                    <form:input path="fechainicio"></form:input>
                    <form:errors path="fechainicio" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>fechafinal:</label>
                <div class="controls">
                    <form:input path="fechafinal"></form:input>
                    <form:errors path="fechafinal" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>tarifa:</label>
                <div class="controls">
                    <form:input path="tarifa"></form:input>
                    <form:errors path="tarifa" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>clicks:</label>
                <div class="controls">
                    <form:input path="clicks"></form:input>
                    <form:errors path="clicks" cssstyle="color:red"></form:errors>
                </div>
            </div>                
            <div class="control-group">
                <label>ubicacion:</label>
                <div class="controls">
                    <form:input path="ubicacion"></form:input>
                    <form:errors path="ubicacion" cssstyle="color:red"></form:errors>
                </div>
            </div>  
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Editar" type="submit" class="btn btn-primary">
            <a style="margin-left: 5px;" href="<c:url value='/pages/publicidades/index'/>">Cancelar</a>
        </div>
    </form:form>
</div>
