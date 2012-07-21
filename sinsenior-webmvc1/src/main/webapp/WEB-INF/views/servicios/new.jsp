<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Nuevo Servicio Adicional</h1><br/><br/>
    <form:form action="new" method="post" commandName="servicio" cssClass="form-horizontal">
        <div class="row">
            <div class="control-group">
                <label>tiposervicio:</label>
                <div class="controls">
                    <form:input path="tiposervicio"></form:input>
                    <form:errors path="tiposervicio" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>descripcion:</label>
                <div class="controls">
                    <form:input path="descripcion"></form:input>
                    <form:errors path="descripcion" cssstyle="color:red"></form:errors>
                </div>
            </div>
             <div class="control-group">
                <label>tarifa:</label>
                <div class="controls">
                    <form:input path="tarifa"></form:input>
                    <form:errors path="tarifa" cssstyle="color:red"></form:errors>
                </div>
            </div>
                
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Save" type="submit" class="btn btn-primary">
            <a style="margin-left: 5px;" href="<c:url value='/pages/servicios/index'/>">Cancelar</a>
        </div>                
    </form:form>
</div>
