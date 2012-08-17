	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Compra</h1><br/><br/>
    <form:form action="edit" method="post" commandName="inmuebles" cssClass="form-horizontal">
        <div class="row">
            <div class="control-group">
                <label>Tipo  Inmueble:</label>
                 <div class="controls">
					<form:input path="tipoInmuebleDesc" readonly="true"></form:input>
                    <form:errors path="tipoInmueble" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Area:</label>
                <div class="controls">
                    <form:input path="area" readonly="true"></form:input>
                    <form:errors path="area" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Distrito</label>
                <div class="controls">
					<form:input path="distritoDesc" readonly="true"></form:input>
                    <form:errors path="distrito" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Dirección</label>
                <div class="controls">
                    <form:input path="direccion" readonly="true"></form:input>
                    <form:errors path="direccion" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Habitaciones</label>
                <div class="controls">
                    <form:input path="nroHab" readonly="true"></form:input>
                    <form:errors path="nroHab" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Baños</label>
                <div class="controls">
                    <form:input path="nroBanos" readonly="true"></form:input>
                    <form:errors path="nroBanos" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Patio</label>
                <div class="controls">
                    <form:checkbox path="hPatio"  disabled="disabled"></form:checkbox>
                </div>
            </div> 
            <div class="control-group">
                <label>Jardin</label>
                <div class="controls">
                    <form:checkbox path="hJardin"  readonly="true" ></form:checkbox>
                </div>
            </div> 
            <div class="control-group">
                <label>Observaciones</label>
                <div class="controls">
                    <form:input path="observaciones" readonly="true"></form:input>
                    <form:errors path="observaciones" cssstyle="color:red"></form:errors>
                </div>
            </div> 
        </div>
        <div class="actions" style="margin-left: 160px;">
            <a style="margin-left: 5px;" href="<c:url value='/pages/inmuebles/suscribe?id=${inmuebles.codigo}'/>" class="btn btn-primary">Suscribir</a>
            <a style="margin-left: 5px;" href="<c:url value='/pages/inmuebles/compra'/>" class="btn btn-primary">Cancelar</a>
        </div>   
    </form:form>             
</div>
