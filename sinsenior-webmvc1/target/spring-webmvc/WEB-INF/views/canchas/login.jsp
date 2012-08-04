<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="navbar">      
    <div class="navbar-inner">
        <div class="container">
            <a href="javascript:void(0);" class="brand">Canchas Online</a>
        </div>
    </div><!-- /topbar-inner -->
</div>
<div class="container">
    <form:form action="autenticar" method="post" commandName="credential" cssClass="form-horizontal">
        <div class="row">
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
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Ingresar" type="submit" class="btn btn-primary">            
        </div>                
    </form:form>
</div>
