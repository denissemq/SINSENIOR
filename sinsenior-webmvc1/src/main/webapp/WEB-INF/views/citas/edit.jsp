<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<<<<<<< HEAD
function validateInfo(){
	  var VDataOK = false;

    var sMensaje = '';
    
    if (document.all("lugar").value==""){
  	  sMensaje = sMensaje + '\n' + ' * Lugar';  	  
    }

    if (document.all("fecha").value=="" ){
  	  sMensaje = sMensaje + '\n' + ' * Fecha';  	  
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

=======
function fn_formatDecimal(nDecimal){
    fn_formatNumberDecimal(nDecimal,true,true,true,true,true);
}

>>>>>>> 74eea3a6b3d863bb64df89d620e35f3a4c36de2a
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
		alert("El valor ingresado no es valido para este campo. Sólo acepta números válidos");
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
		alert("El valor ingresado no es valido para este campo. Sólo acepta e-mails válidos (test@test.com).");
		element.focus();
		return false;
	}

	return true;
}
function elementDateOnBlur(){
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

	var valid = formatDate(tmpValue);

	if (valid == false){
		ErrorInProgress = true;
		ObjectError = element;
		alert("El valor ingresado no es valido para este campo. Sólo acepta fechas válidas (dd/mm/yy).");
		element.focus();
		return false;
	}else{
		element.value = valid;
		return true;
	}
}
function formatDate(date){
	var tmpValue = date.toString().replace(/\/|\./g,'');
    var tmpDate = "";

	if (isNaN(tmpValue)) return false;
	if (tmpValue.length < 6) return false;

	if (tmpValue.length == 6){
		var DateTmp = new Date();
		var sYear = new String(DateTmp.getFullYear());

		tmpDate = tmpValue.substr(0,2) + "/" + tmpValue.substr(2,2) + "/" + sYear.substr(0,2) + tmpValue.substr(4,2);
	}else{
		var n=0;
		var tmpYear="";
		var tmpMonth="";
		var tmpDay="";

		for (var i = tmpValue.length-1; i>=0; i--){
			if (n < 4) tmpYear = tmpValue.substr(i,1) + tmpYear;
			if ((n > 3) && (n < 6)) tmpDay = tmpValue.substr(i,1) + tmpDay;
			if (n > 5) tmpMonth = tmpValue.substr(i,1) + tmpMonth;
			n+=1;
		}

		tmpDate = (tmpMonth <= 9 ? "0" : "") + Math.abs(tmpMonth) + "/" + (tmpDay <= 9 ? "0" : "") + Math.abs(tmpDay) + "/" + tmpYear;
	}

	return IsValidDate(tmpDate);
}
function IsValidDate(PossibleDate){	
	var PDate = new String(PossibleDate);
	var regex = /(^\d{1,2})\/(\d{1,2})\/(\d{4,4})|(^\d{1,2})\/(\d{1,2})\/(\d{2,2})/;

	if( regex.test(PDate)){
		var month = new String(RegExp.$2);
		var day = new String(RegExp.$1);
		var year = new String(RegExp.$3);
		if( month.length == 0 ){
			month = new String(RegExp.$5);
			day = new String(RegExp.$4);
			year = new String(RegExp.$6);
		}
		var today = new Date();
		var thisYear = new String(today.getFullYear());
		if( year.length == 2 ){
			if( year > 50 ){year = String(Number(thisYear.substring(0,2))-1) + year;}
			else{year = thisYear.substring(0,2) + year;}
		}
		if( month < 1 || month > 12 ) return false;
		if( day < 1 || day > 31 ) return false;
		if ((month==4 || month==6 || month==9 || month==11) && day>30) return false;

		if (month == "2" || month == "02") // check for february 29th
		{
			var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
			
			if (day>29 || (day==29 && !isleap)) return false;
		}
		if((Number(year) < Number(thisYear) - 250) || (Number(year) > Number(thisYear) + 250)) return false;

		return PossibleDate;
	}

	return false;
}
</script>
<style>

</style>
<div class="container">
    <h1>Editar Citas</h1><br/><br/>
    <form:form action="edit" method="post" commandName="cita" cssClass="form-horizontal">
         <div class="row">
            <div class="control-group">
                <div class="controls">
                    DATOS INMUEBLE
                </div>
            </div>
            
              <div class="control-group">
                <label>Tipo  Estado:</label>
                 <div class="controls">
					<form:select path="codigoEstado" id="codigoEstado"  >
					<form:options items="${listTipoEstado}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoInmueble" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            
            <div class="control-group">
                <label>Tipo  Inmueble:</label>
                 <div class="controls">
					<form:select path="tipoInmueble" id="tipoInmueble" disabled="true" >
					<form:options items="${listTipoInmueble}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoInmueble" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Area:</label>
                <div class="controls">
                    <form:input path="area" disabled="true" ></form:input>
                    <form:errors path="area" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Distrito</label>
                <div class="controls">
                    <form:select path="distrito" id="distrito" disabled="true">
					<form:options items="${listDistrito}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="distrito" cssstyle="color:red"></form:errors>
                </div>
            </div>  
            <div class="control-group">
                <label>Dirección</label>
                <div class="controls">
                    <form:textarea path="direccion" disabled="true"  rows="2" style="width:450px" ></form:textarea>
                    <form:errors path="direccion" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Habitaciones</label>
                <div class="controls">
                    <form:input path="nroHab" disabled="true"></form:input>
                    <form:errors path="nroHab" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nro. Baños</label>
                <div class="controls">
                    <form:input path="nroBanos" disabled="true"></form:input>
                    <form:errors path="nroBanos" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Patio</label>
                <div class="controls">
                    <form:checkbox path="hPatio"  disabled="true"></form:checkbox>
                </div>
            </div> 
            <div class="control-group">
                <label>Jardin</label>
                <div class="controls">
                    <form:checkbox path="hJardin" disabled="true" ></form:checkbox>
                </div>
            </div> 
            <div class="control-group">
                <label>Observaciones</label>
                <div class="controls">
                    <form:input path="observaciones" disabled="true"></form:input>
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
                    
                    <form:select path="tipoPersona" id="tipoPersona" disabled="true">
					<form:options items="${listTipoPersona}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                    <form:errors path="tipoPersona" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label>Nombre/Razon Social:</label>
                <div class="controls">
                    <form:input path="numRazSocial" disabled="true"></form:input>
                    <form:errors path="numRazSocial" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>DNI/RUC:</label>
                <div class="controls">
                    <form:input path="docId" disabled="true"></form:input>
                    <form:errors path="docId" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Correo electrónico:</label>
                <div class="controls">
                    <form:input path="correo" disabled="true"></form:input>
                    <form:errors path="correo" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Telefono:</label>
                <div class="controls">
                    <form:input path="telefono" disabled="true"></form:input>
                    <form:errors path="telefono" cssstyle="color:red"></form:errors>
                </div>
            </div>    
            <div class="control-group">
                <label>Celular:</label>
                <div class="controls">
                    <form:input path="celular" disabled="true"></form:input>
                    <form:errors path="celular" cssstyle="color:red"></form:errors>
                </div>
            </div>     
            <div class="control-group" style="display:none">
                <label>Estado:</label>
                <div class="controls">
                    <form:input path="estado" value="4"></form:input>
                    <form:errors path="estado" cssstyle="color:red"></form:errors>
                </div>
            </div>      
            <div class="control-group">
                <label>Fecha:</label>
                <div class="controls">
                    <form:input path="fecha" onBlur="javascript:elementDateOnBlur();"></form:input>
                    <form:errors path="fecha" cssstyle="color:red"></form:errors>
                </div>
            </div>     
            <div class="control-group">
                <label>Lugar:</label>
                <div class="controls">
                    <form:textarea path="lugar"  rows="4" style="width:450px"  ></form:textarea>
                    <form:errors path="lugar" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group"  style="display:none">
                <label>Codigo:</label>
                <div class="controls">
                    <form:input path="codigoDetalle" ></form:input>
                    <form:errors path="codigoDetalle" cssstyle="color:red"></form:errors>
                </div>
            </div>    
            <div class="control-group" style="display:none">
                <label>Codigo usuario:</label>
                <div class="controls">
                    <form:input path="codigoUsuario" value="${credential.id}" ></form:input>
                    <form:errors path="codigoUsuario" cssstyle="color:red"></form:errors>
                </div>
            </div>         
        </div>
        <div class="actions" style="margin-left: 160px;">
           
            <input name="" value="Grabar" type="submit" class="btn btn-primary" onclick="javascript:return validateInfo()">
           <a  class="btn btn-primary" href="<c:url value='/pages/citas/anular?id=${cita.codigoDetalle}&codigoUsuario=${credential.id}'/>">Anular</a>
            <a class="btn btn-primary"  href="<c:url value='/pages/citas/disponibles'/>">Cancelar</a>
        </div>
    </form:form>
</div>