	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
    <h1 style="float:left;">Buscar inmuebles</h1>
    <form:form action="buscar" method="POST" commandName="listaInmuemble" cssClass="form-horizontal" >
    <div style="float:right;margin-bottom: 10px;">
    </div>
    <div class="clear"></div>
    
    <br/>
          
             <div class="control-group">
                <label>Distrito</label>
                <div class="controls">
                    <form:select path="distrito" id="distrito">
					<form:option value="0" >Todos</form:option>
					<form:options items="${listDistrito}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                </div>
            </div> 
            <div class="control-group">
                <label>Tipo  Inmueble:</label>
                 <div class="controls">
					<form:select path="tipoInmueble" id="tipoInmueble">
					<form:option value="0" >Todos</form:option>
					<form:options items="${listTipoInmueble}"  itemValue="codigo" itemLabel="descripcion"/>
					</form:select>
                </div>
            </div>
            <div class="control-group">
                <label>Area:</label>
                 <div class="controls">
					Desde:  <form:input path="areade" style="width:50px"  onkeypress="return PriceMask(this)"  onBlur ="fn_formatDecimal(2);"></form:input> 
					Hasta:  <form:input path="areahasta" style="width:50px"  onkeypress="return PriceMask(this)"  onBlur ="fn_formatDecimal(2);"></form:input> 
                </div>
            </div>
            <div class="control-group">
                <label>Nro Habitaciones:</label>
                 <div class="controls">
					Desde:  <form:input path="nroHabde" style="width:50px"  onkeypress="return PriceMask(this)"  onBlur ="fn_formatDecimal(0);"></form:input> 
					Hasta:  <form:input path="nroHabhasta" style="width:50px"  onkeypress="return PriceMask(this)"  onBlur ="fn_formatDecimal(0);"></form:input> 
                </div>
            </div> 
                <input name="" value="Buscar" type="submit" class="btn btn-primary">
               <table class="table table-striped" >
        <tr>
        	<th>Tipo Inmueble</th>
            <th>Distrito</th>
            <th>Dirección</th>
            <th>Area</th>
            <th>Nro Habit.</th>
            <th style="width: 150px;"></th>
            <th style="width: 150px;"></th>
        </tr>
        <c:forEach var="inmueble" items="${listaInmuemble.inmuebles}">
            <tr>
                <td>${inmueble.tipoInmuebleDesc}</td>
                <td>${inmueble.distritoDesc}</td>
                <td>${inmueble.direccion}</td>
                <td>${inmueble.area}</td>
                <td>${inmueble.nroHab}</td>
                <td><a href="<c:url value='/pages/inmuebles/separa?id=${inmueble.codigo}'/>">Separa inmueble</a></td>
            </tr>
        </c:forEach>
    </table>
            
       </form:form>       
    </div>
    
    
