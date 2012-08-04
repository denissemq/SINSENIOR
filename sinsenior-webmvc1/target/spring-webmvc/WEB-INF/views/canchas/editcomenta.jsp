<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Editar Cancha</h1><br/><br/>
    <form:form action="editcomenta" method="post" commandName="cancha" cssClass="form-horizontal">
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
                <label>Caracteristica:</label>
                <div class="controls">
                    <form:input path="caracteristica"></form:input>
                    <form:errors path="caracteristica" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>fechaatencion:</label>
                <div class="controls">
                    <form:input path="fechaatencion"></form:input>
                    <form:errors path="fechaatencion" cssstyle="color:red"></form:errors>
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
                <label>promocion</label>
                <div class="controls">
                    <form:input path="promocion"></form:input>
                    <form:errors path="promocion" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>texto:</label>
                <div class="controls">
                    <form:input path="texto"></form:input>
                    <form:errors path="texto" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>calificacion</label>
                <div class="controls">
                    <form:input path="calificacion"></form:input>
                    <form:errors path="calificacion" cssstyle="color:red"></form:errors>
                </div>
            </div>
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Comentar" type="submit" class="btn btn-primary">
            <a style="margin-left: 5px;" href="<c:url value='/pages/canchas/indexcomenta'/>">Cancelar</a>
        </div>
    </form:form>
</div>