	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script type="text/javascript" src="../include/JScript.js"></script>
<script type="text/javascript" >
var ErrorInProgress = false;
var ObjectError = false;
function PriceMask( toField )
{  
    if (window.event.keyCode!=13)
    {
     var llRetVal = false;
     if ((window.event.keyCode>=48 && window.event.keyCode<=57) ||
        (window.event.keyCode==44) || (window.event.keyCode==46))
     {	llRetVal = true; }
     return llRetVal;	
    }
    else
    {
      return false;
    }
    
}
function validateInfo(){
	  var VDataOK = false;

      var sMensaje = '';
      
      if (document.all("tipoInmueble").value=="" || document.all("tipoInmueble").value=="0"){
    	  sMensaje = sMensaje + '\n' + ' * Tipo Inmueble';  	  
      }

      if (document.all("area").value=="" || document.all("area").value=="0"){
    	  sMensaje = sMensaje + '\n' + ' * Area';  	  
      }
      if (document.all("distrito").value=="" || document.all("distrito").value=="0"){
    	  sMensaje = sMensaje + '\n' + ' * Distrito';  	  
      }
      if (document.all("direccion").value==""){
    	  sMensaje = sMensaje + '\n' + ' * Dirección';  	  
      }

      if (document.all("nroHab").value==""|| document.all("nroHab").value=="0"){
    	  sMensaje = sMensaje + '\n' + ' * Nro. de Habitaciones';  	  
      }

      if (document.all("numRazSocial").value==""){
    	  sMensaje = sMensaje + '\n' + ' * Nombre o razón social';  	  
      }

      if (document.all("docId").value==""){
    	  sMensaje = sMensaje + '\n' + ' * Documento de Identida o RUC';  	  
      }

      if (document.all("telefono").value=="" && document.all("celular").value==""){
    	  sMensaje = sMensaje + '\n' + ' * Telefono fijo o celular';  	  
      }
      
	  if (sMensaje != '') {
          alert("No puede continuar si no ha llenado todos los campos obligatorios: " + sMensaje);
          return false;
      } else {
          document.all("txtGrabar").value = "1"
          return true;
      }
}
function fn_formatDecimal(nDecimal){
    fn_formatNumberDecimal(nDecimal,true,true,true,true,true);
}

function fn_formatNumberDecimal(DecimalNum,LeadingZero,Parens,Commas,DefaultValue, PreserveValue){
	var element = event.srcElement;
	var tmpValue = element.value;

if (tmpValue != ''){

	if (tmpValue == "" && DefaultValue) tmpValue = "0";
    if (tmpValue == "") return true;

	tmpValue = tmpValue.toString().replace(/\$|\,/g,'');
	tmpValue = formatNumber(tmpValue,DecimalNum,LeadingZero,Parens,Commas);

	if (tmpValue == "NaN"){
		ObjectError = element;
		alert("El valor ingresado no es válido. Este campo sólo acepta cvalores numéricos.");
		element.focus();
		return false;
	}else{
		if (typeof(PreserveValue) != "undefined" || PreserveValue == false) element.value = tmpValue;
		return true;
	}
	}
}

function formatNumber(num,decimalNum,bolLeadingZero,bolParens,bolCommas){ 
    if (isNaN(parseInt(num))) return "NaN";

	var tmpNum = num;
	var iSign = num < 0 ? -1 : 1;		// Get sign of number

	// Adjust number so only the specified number of numbers after
	// the decimal point are shown.
	tmpNum *= Math.pow(10,decimalNum);
	tmpNum = Math.round(Math.abs(tmpNum))
	tmpNum /= Math.pow(10,decimalNum);
	tmpNum *= iSign;					// Readjust for sign
	
	if (isNaN(parseInt(tmpNum))) return "NaN";

	// Create a string object to do our formatting on
	var tmpNumStr = new String(tmpNum);

	// See if we need to strip out the leading zero or not.
	if (!bolLeadingZero && num < 1 && num > -1 && num != 0){
		
		if (num > 0){
			
			tmpNumStr = tmpNumStr.substring(0,tmpNumStr.length);
		}else{
			tmpNumStr = "-" + tmpNumStr.substring(2,tmpNumStr.length);
		}
	}
	// See if we need to put in the commas
	
	if (bolCommas && (num >= 1000 || num <= -1000)) {
		var iStart = tmpNumStr.indexOf(".");
		if (iStart < 0)
			iStart = tmpNumStr.length;

		iStart -= 3;
		while (iStart >= 1) {
			tmpNumStr = tmpNumStr.substring(0,iStart) + "" + tmpNumStr.substring(iStart,tmpNumStr.length)
			iStart -= 3;
		}		
	}

	if (decimalNum > 0){
		var pos = tmpNumStr.indexOf(".");
		var zeros = ".";
		var decimalpart = "";

		if (pos > 0){
			decimalpart = tmpNumStr.substr(pos + 1,tmpNumStr.length); 
	
			zeros = "";
		}
		for (var i=decimalpart.length; i<decimalNum;i++) zeros += "0"; 

		tmpNumStr += zeros; 
	}

	// See if we need to use parenthesis
	if (bolParens && num < 0)
		tmpNumStr = "(" + tmpNumStr.substring(1,tmpNumStr.length) + ")";

	return tmpNumStr;		// Return our formatted string!
}
function RTrim(Value) {
	var nwvl = "";
	for (var i = Value.length-1;i >= 0;i--){
	  if (Value.charCodeAt(i) != 32){
	    nwvl = Value.substring(0,i+1);
	    break;
	  }
	}    
	return nwvl;
}
function LTrim(Value) {
	var nwvl = "";
	for (var i = 0;i < Value.length;i++){
		if (Value.charCodeAt(i) != 32){
			nwvl = Value.substring(i,Value.length);
			break;
		}
	}    
	return nwvl;
}
function Trim(Value){
	var nwvl = LTrim(RTrim(Value))
	return nwvl;
}
function echeck(str){
	var at="@";
	var dot=".";
	var lat=str.indexOf(at);
	var lstr=str.length;
	var ldot=str.indexOf(dot);

	if (str.indexOf(at)==-1) return false;
	if (str.indexOf(at)==-1 || str.indexOf(at)==0 || str.indexOf(at)==lstr) return false;
	if (str.indexOf(dot)==-1 || str.indexOf(dot)==0 || str.indexOf(dot)==lstr) return false;
	if (str.indexOf(at,(lat+1))!=-1) return false;
	if (str.substring(lat-1,lat)==dot || str.substring(lat+1,lat+2)==dot) return false;
	if (str.indexOf(dot,(lat+2))==-1) return false;
	if (str.indexOf(" ")!=-1) return false;

 	return true;
}
function elementEmailOnBlur(){
	var element = event.srcElement;
	var tmpValue = element.value;

	if (ErrorInProgress && element.id != ObjectError.id) {
	   ErrorInProgress = false
	   return true;
	}

	ErrorInProgress = false;

    if (Trim(tmpValue) == ""){
		element.value = "";
		return true;
    }

	var valid = echeck(tmpValue);

	if (! valid){
		ErrorInProgress = true;
		ObjectError = element;
		alert("El valor ingresado no es válido. Este campo sólo acepta correos válido. Ejm(correo2@gmail.com).");
		element.focus();
		return false;
	}

	return true;
}
</script>
<div class="container">
    <h1>Venta inmueble</h1><br/><br/>
    <form:form action="new" method="post" commandName="inmuebles" cssClass="form-horizontal" >
        <div class="row">
            <div class="control-group">
                <div class="controls">
                    DATOS INMUEBLE
                </div>
            </div>
            <div class="control-group">
                <label>Tipo  Inmueble:</label>
                 <div class="controls">
					<form:select path="tipoInmueble" id="tipoInmueble">
					<form:option value="0" >Seleccionar</form:option>
					<form:options items="${listTipoInmueble}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoInmueble" cssstyle="color:red" ></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Area:</label>
                <div class="controls">
                    <form:input path="area" onkeypress="return PriceMask(this);"  onBlur ="fn_formatDecimal(2);" ></form:input>
                    <form:errors path="area" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Distrito</label>
                <div class="controls">
                    <form:select path="distrito" id="distrito">
					<form:option value="0" >Seleccionar</form:option>
					<form:options items="${listDistrito}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="distrito" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Dirección</label>
                <div class="controls">
                    <form:textarea path="direccion" rows="3" style="width:450px"  ></form:textarea>
                    <form:errors path="direccion" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Habitaciones</label>
                <div class="controls">
                    <form:input path="nroHab"  onkeypress="return PriceMask(this)"  onBlur ="fn_formatDecimal(0);"></form:input>
                    <form:errors path="nroHab" cssstyle="color:red" ></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Baños</label>
                <div class="controls">
                    <form:input path="nroBanos"  onkeypress="return PriceMask(this)"  onBlur ="fn_formatDecimal(0);"></form:input>
                    <form:errors path="nroBanos" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Patio</label>
                <div class="controls">
                    <form:checkbox path="hPatio"  ></form:checkbox>
                </div>
            </div> 
            <div class="control-group">
                <label>Jardin</label>
                <div class="controls">
                    <form:checkbox path="hJardin"  ></form:checkbox>
                </div>
            </div> 
           
            
            
            <div class="control-group">
                <label>Observaciones</label>
                <div class="controls">
                     <form:textarea path="observaciones" rows="5" style="width:450px"  ></form:textarea>
                    <form:errors path="observaciones" cssstyle="color:red"></form:errors>
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
                    
                    <form:select path="tipoPersona" id="tipoPersona">
					<form:options items="${listTipoPersona}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoPersona" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Nombre/Razon Social:</label>
                <div class="controls">
                     <form:textarea path="numRazSocial" rows="2" style="width:450px"  ></form:textarea>
                    <form:errors path="numRazSocial" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>DNI/RUC:</label>
                <div class="controls">
                    <form:input path="docId"></form:input>
                    <form:errors path="docId" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Correo electrónico:</label>
                <div class="controls">
                    <form:input path="correo" onblur="elementEmailOnBlur()"></form:input>
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
                <label>Celular:</label>
                <div class="controls">
                    <form:input path="celular"></form:input>
                    <form:errors path="celular" cssstyle="color:red"></form:errors>
                </div>
            </div>     
            <div class="control-group" style="display:none">
                <label>Estado:</label>
                <div class="controls">
                    <form:input path="estado" value="2"></form:input>
                    <form:errors path="estado" cssstyle="color:red"></form:errors>
                </div>
            </div>         
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Save" type="submit" class="btn btn-primary" onclick="javascript:return validateInfo()">
            <a style="margin-left: 5px;" href="<c:url value='/pages/usuarios/logout'/>">Cancelar</a>
        </div>                
    </form:form>
</div>
