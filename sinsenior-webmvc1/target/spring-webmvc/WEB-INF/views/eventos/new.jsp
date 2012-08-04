<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Nuevo Evento</h1><br/><br/>
    <form:form action="new" method="post" commandName="evento" cssClass="form-horizontal">
        <div class="row">
            <div class="control-group">
                <label>Nombre:</label>
                <div class="controls">
                    <form:input path="nombre"></form:input>
                    <form:errors path="nombre" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Premio:</label>
                <div class="controls">
                    <form:input path="premio"></form:input>
                    <form:errors path="premio" cssstyle="color:red"></form:errors>
                </div>
            </div>
             <div class="control-group">
                <label>Cantidad:</label>
                <div class="controls">
                    <form:input path="cantidad"></form:input>
                    <form:errors path="cantidad" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Plazo:</label>
                <div class="controls">
                    <form:input path="plazo"></form:input>
                    <form:errors path="plazo" cssstyle="color:red"></form:errors>
                </div>
            </div>               
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Save" type="submit" class="btn btn-primary">
            <a style="margin-left: 5px;" href="<c:url value='/pages/eventos/index'/>">Cancelar</a>
        </div>                
    </form:form>
</div>
