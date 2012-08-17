var patron = new Array(2,2,4)
var patron1 = new Array(2,2)
var nav4 = window.Event ? true : false;
var ErrorInProgress;
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
    	function getResult(value, decimales){
		var vNum = new Number(value);
		if (isNaN(vNum)) vNum = 0;
		vNum = formatNumber(vNum, decimales, false, false, true);
		if (vNum == "NaN") vNum = "0.00";
		return vNum;
	}
    function RecorrerFormExcep(formName,excep)
{
	var nombre="";
	var tipo="";
	var valor="";
	var frm = document.getElementById(formName);
	for (i=0;i<frm.elements.length;i++)
	{
	    nombre =  frm.elements[i].name ;
	    tipo =  frm.elements[i].type ;
	    valor =  frm.elements[i].value ;
	    if (nombre.substring(0,excep.length) !=excep){
	    if (tipo == "text" || tipo == "textarea") {
		    document.all(nombre).readOnly = true;
		    document.all(nombre).className = "readOnly";
		}
		if (tipo == "checkbox"  ) {
		    document.all(nombre).disabled = "disabled";
		}
		
		if(nombre.split("$").length>2){
		    if (nombre.split("$")[2].substring(0,3) == "cbo") {
		          document.all(nombre).disabled = "disabled";
                document.all(nombre).className = "comboboxReadOnly";
		    }
		}else{
		    if (nombre.substring(0,3) == "cbo") {
		          document.all(nombre).disabled = "disabled";
                document.all(nombre).className = "comboboxReadOnly";
		    }
		}
		}
	}
}
   function RecorrerForm(formName)
{
	var nombre="";
	var tipo="";
	var valor="";
	var frm = document.getElementById(formName);
	for (i=0;i<frm.elements.length;i++)
	{
	    nombre =  frm.elements[i].name ;
	    tipo =  frm.elements[i].type ;
	    valor =  frm.elements[i].value ;
	    if (tipo == "text" || tipo == "textarea") {
		    document.all(nombre).readOnly = true;
		    document.all(nombre).className = "readOnly";
		}
		if (tipo == "checkbox"  ) {
		    document.all(nombre).disabled = "disabled";
		}
		
		if(nombre.split("$").length>2){
		    if (nombre.split("$")[2].substring(0,3) == "cbo") {
		          document.all(nombre).disabled = "disabled";
                document.all(nombre).className = "comboboxReadOnly";
		    }
		}else{
		    if (nombre.substring(0,3) == "cbo") {
		          document.all(nombre).disabled = "disabled";
                document.all(nombre).className = "comboboxReadOnly";
		    }
		}
	}
}

    
    function getElementsSelected(IFrameGrid, FormName, Collection){
	var form = IFrameGrid.document.all(FormName);
	var values = "";

	for (var i = 0; i < form.elements.length; i++){
		var obj = form.elements[i];
		var type = obj.type.toLowerCase();
		if (type == "checkbox"){
			if (obj.id != "chkAllItems"){
			    if (obj.id != "chkCheck"){
				    if (obj.value !== "-99999" && obj.checked && ! findControlIDInCollection(obj.id, Collection)){
					    values += (values == "" ? "" : ";") + obj.text;
				    }
			    }
			}
		}
	}
	
	return values;
}
function CheckAllDataGridCheckBoxes(checkVal, Collection) {
	for(i = 0; i < document.forms[0].elements.length; i++) {
		elm = document.forms[0].elements[i];
		
		if (elm.value !== "-99999" && elm.type == 'checkbox' && elm.className!=='cCheckBoxHide' && elm.id!="chkCheck"&& elm.id!="chkACC") {
		
			if (! findControlIDInCollection(elm.id, Collection)){
				elm.checked = checkVal;
			}
		}
	}
}
function CheckOneDataGridCheckBoxes(checkVal, Collection, obj,valorb) {
	for(i = 0; i < document.forms[0].elements.length; i++) {
		elm = document.forms[0].elements[i];
		
		if (elm.value !== "-99999" && elm.type == 'checkbox' && elm.className!=='cCheckBoxHide' && elm.id=="chkACC") {
		
			if (! findControlIDInCollection(elm.id, Collection)){
				elm.checked = checkVal;
			}
		}
		obj.checked=valorb;
	}
}
function findControlIDInCollection(ControlID, Collection){
	var counter;
	if (typeof(Collection) == "undefined" || Collection == null) return false;

	for(counter in Collection){ 
		//alert(Collection[counter].toString())
		if (counter.toString() == ControlID) return true; 
	} 

	return false;
}

    //CheckPrice    elementNumberOnBlur
    function CheckPrice(DecimalNum,LeadingZero){
	/*
	var element = event.srcElement;
	var tmpValue = element.value;

	if (ErrorInProgress && element.id != ObjectError.id) {
	   ErrorInProgress = false
	   return true;
	}

	ErrorInProgress = false;

	if (tmpValue == "" && DefaultValue) tmpValue = "0";
    if (tmpValue == "") return true;

	tmpValue = tmpValue.toString().replace(/\$|\,/g,'');
	tmpValue = formatNumber(tmpValue,DecimalNum,LeadingZero,Parens,Commas);

	if (tmpValue == "NaN"){
		ErrorInProgress = true;
		ObjectError = element;
		alert("The value you entered isn't valid for this field. This field only accepts numeric values.");
		element.focus();
		return false;
	}else{
		if (typeof(PreserveValue) != "undefined" || PreserveValue == false) element.value = tmpValue;
		return true;
	}*/
}
    function pr_eliminar(s){}
    function formatInt(s){}
    

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
		alert("The value you entered isn't valid for this field. This field only accepts numeric values.");
		element.focus();
		return false;
	}else{
		if (typeof(PreserveValue) != "undefined" || PreserveValue == false) element.value = tmpValue;
		return true;
	}
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

	function FormatoFecha(obj){
	
			if (formatDate(document.all(obj).value)!=false){
			document.all(obj).value=formatDate(document.all(obj).value)
			}else{
			document.all(obj).value="";
			}
	}
	
	
function fn_formatDate(){
	var element = event.srcElement;
	var tmpValue = element.value;

    if (Trim(tmpValue) == ""){
		element.value = "";
		return true;
    }

	var valid = formatDate(tmpValue);

	if (valid == false){
		ObjectError = element;
		alert("The value you entered isn't valid for this field. This field only accepts valid dates (01/01/05).");
		element.focus();
		return false;
	}else{
		element.value = valid;
		return true;
	}
}
function Trim(Value){
	var nwvl = LTrim(RTrim(Value))
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

function IsValidDate(PossibleDate){	
	var PDate = new String(PossibleDate);
	var regex = /(^\d{1,2})\/(\d{1,2})\/(\d{4,4})|(^\d{1,2})\/(\d{1,2})\/(\d{2,2})/;

	if( regex.test(PDate)){
		var month = new String(RegExp.$1);
		var day = new String(RegExp.$2);
		var year = new String(RegExp.$3);
		if( month.length == 0 ){
			month = new String(RegExp.$4);
			day = new String(RegExp.$5);
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

    function fn_Submit(){       
        //document.form1['hiOperacion'].value='ACTI';
        //alert(document.form1['hiOperacion'].value);
        //alert("submit");
        document.form1.submit();  
    }
    
     function GotoPageSearch(nCurrentPage){
        document.form1['_Operacion'].value = "Page";
         document.form1['_NPage'].value = nCurrentPage;
       // alert(document.form1['Operacion'].value);        
        fn_Submit()
    }
    
    function GotoPageSearchtext(){
      //  document.form1['_Operacion'].value = "Page";
        nCurrentPage = document.all("Paging_txtPag").value
        if (parseInt(nCurrentPage)<=parseInt(document.all("record_id").value)){
        document.form1['_NPage'].value = nCurrentPage;
       // alert(document.form1['Operacion'].value);    
        document.all("Paging_txtPag").value="";    
        fn_Submit()
        }
    }
    
    function GotoPage(nCurrentPage, bSubmit){
       
        document.form1['_Operacion'].value = nCurrentPage;
        //document.form1['_NPage'].value = nCurrentPage;
       // alert(document.form1['Operacion'].value);        
       
        if (bSubmit == "True"){ fn_Submit();}
    }
    function openWindow(url, windowWidth,windowHeight,   Name){		
	var windowLeft = (screen.availWidth / 2) - (windowWidth / 2);
	var windowTop = ((screen.availHeight / 2) - (windowHeight / 2)) - 10;
	var mUrl = new String(window.location.pathname + url);
	var windowName = mUrl.replace(/\W/g, "_")
	var mResize = "";
	resize = null;
	
	var mVarUrl = url
	var mSimbUrl = ""
	var mPosIni = mVarUrl.indexOf("?")
	var mNewUrl 
	if (mPosIni != -1){
	mNewUrl= mVarUrl.substring(mPosIni+1,mVarUrl.length)+ "H3#@*ALMLLlk31q4l1ncL#@..."
	mSimbUrl="&"
	}else{
	mNewUrl="H3#@*ALMLLlk31q4l1ncL#@..."
	mSimbUrl="?"
	}
	
	url = url + mSimbUrl+ "varUrl=" + MD5(mNewUrl) 

	if (typeof(Mode) == "undefined" || Mode == 1){
		if (resize == null) mResize = "resizable=false"; else mResize = "resizable=" + (resize ? "yes":"no");
		
		var newWindow = window.open(url, windowName, mResize + ", height=" + windowHeight + ",width=" + windowWidth + ",status=yes, left=" + windowLeft + ", top=" + windowTop);

		newWindow.focus();
	}
	else{
		var WinSettings = "dialogTop=" + windowTop
			+ "; dialogLeft=" + windowLeft
			+  "; dialogWidth=" + (windowWidth + 25) + "px;" + "dialogHeight=" + (windowHeight + 25) + "px;"
			+ "center=yes; status=no; help=no; scroll=no;";

		url += "&WinID=" + getWinID();

		return window.showModalDialog(url, MySendArgs, WinSettings);
	}
}

//    function openWindow(sPagina, nWidth, nHeight,nombre){    
//        //window.open(sPagina, 650, 900, null, null, 1, null);
//        if (nWidth == ''){
//            nWidth = 650;
//        }
//        if (nHeight == ''){
//            nHeight = 900;
//        }
//        var windowLeft = (screen.availWidth / 2) - (nWidth / 2);
//        var windowTop = ((screen.availHeight / 2) - (nHeight / 2)) - 10;
//        //window.open(sPagina, nWidth, nHeight, null, null, 1, null);
//        
//        var nStyle;
//        nStyle = "toolbar=0,scrollbars=no,statusbar=0,menubar=0,resizable=false,width=" + nWidth + ",height=" + nHeight + ",left = " + windowLeft + //",top =  " + windowTop ;
//         var newWindow = window.open(sPagina,nombre,nStyle);
//          newWindow.focus();
//       //window.open(sPagina,'TITLE');
//        
//        
//    }
    
    
     function openExport(sPagina,sRecord){    
        window.open(sPagina,'TITLE');        
    }
    
    //Seleccionar todos los registros de la grilla
    function fn_SeleccionarTodos(sGridNombre,sRecord){
   // debugger;
	    var nContador;
	    var nRecordCount= new Number();
	    var sGrid = sGridNombre + '_ctl';
	    
	    if(sRecord=="")
	    {
	    nRecordCount = parseInt(document.all('_RecordCount').value)+1;
	    }else{
	    nRecordCount = parseInt(document.all(sRecord).value)+1;
	    }
	
	    
	    for (nContador = 2; nContador <= nRecordCount; nContador++){
	    
	           if (document.all(sGrid + '01' + "_chbDeleteAll").checked == true){
	            if (nContador < 10){	
	               if ( document.all(sGrid + '0' + nContador + "_chbDelete")!=null){
	                document.all(sGrid + '0' + nContador + "_chbDelete").checked = true;
	                }
	            }else{
	               if ( document.all(sGrid + nContador + "_chbDelete")!=null){
	                document.all(sGrid + nContador + "_chbDelete").checked = true;
	                }
	            }	        
	        }else{
	            if (nContador < 10){
	               if ( document.all(sGrid + '0' + nContador + "_chbDelete")!=null){
	                document.all(sGrid + '0' + nContador + "_chbDelete").checked = false;
	                }
	            }else{
	               if ( document.all(sGrid + nContador + "_chbDelete")!=null){
	                document.all(sGrid + nContador + "_chbDelete").checked = false;
	                }
	            }	        	        
	        }
	    }	    
	}
     function fn_SeleccionarTodos1(sGridNombre,sRecord){
   // debugger;
	    var nContador;
	    var nRecordCount= new Number();
	    var sGrid = sGridNombre + '_ctl';
	    
	    if(sRecord=="")
	    {
	    nRecordCount = parseInt(document.all('_RecordCount').value)+1;
	    }else{
	    nRecordCount = parseInt(document.all(sRecord).value)+1;
	    }
	
	    
	    for (nContador = 2; nContador <= nRecordCount; nContador++){
	    
	           if (document.all("chbDeleteAll").checked == true){
	            if (nContador < 10){	
	               if ( document.all(sGrid + '0' + nContador + "_chbDelete")!=null){
	                document.all(sGrid + '0' + nContador + "_chbDelete").checked = true;
	                }
	            }else{
	               if ( document.all(sGrid + nContador + "_chbDelete")!=null){
	                document.all(sGrid + nContador + "_chbDelete").checked = true;
	                }
	            }	        
	        }else{
	            if (nContador < 10){
	               if ( document.all(sGrid + '0' + nContador + "_chbDelete")!=null){
	                document.all(sGrid + '0' + nContador + "_chbDelete").checked = false;
	                }
	            }else{
	               if ( document.all(sGrid + nContador + "_chbDelete")!=null){
	                document.all(sGrid + nContador + "_chbDelete").checked = false;
	                }
	            }	        	        
	        }
	    }	    
	}
	 function fn_SeleccionarTodos2(sGridNombre,sRecord,sId){
   // debugger;
	    var nContador;
	    var nRecordCount= new Number();
	    var sGrid = sGridNombre + '_ctl';
	    
	    if(sRecord=="")
	    {
	    nRecordCount = parseInt(document.all('_RecordCount').value)+1;
	    }else{
	    nRecordCount = parseInt(document.all(sRecord).value)+1;
	    }
	
	    
	    for (nContador = 2; nContador <= nRecordCount; nContador++){
	    
	           if (document.all(sId).checked == true){
	            if (nContador < 10){	
	               if ( document.all(sGrid + '0' + nContador + "_chbDelete")!=null){
	                document.all(sGrid + '0' + nContador + "_chbDelete").checked = true;
	                }
	            }else{
	               if ( document.all(sGrid + nContador + "_chbDelete")!=null){
	                document.all(sGrid + nContador + "_chbDelete").checked = true;
	                }
	            }	        
	        }else{
	            if (nContador < 10){
	               if ( document.all(sGrid + '0' + nContador + "_chbDelete")!=null){
	                document.all(sGrid + '0' + nContador + "_chbDelete").checked = false;
	                }
	            }else{
	               if ( document.all(sGrid + nContador + "_chbDelete")!=null){
	                document.all(sGrid + nContador + "_chbDelete").checked = false;
	                }
	            }	        	        
	        }
	    }	    
	}
    function replace(sCadena, sOldLetra, sNewLetra){
    var nContador;
    var sNewCadena  ;
    sNewCadena="";
   
    for(nContador=0; nContador<sCadena.length; nContador++){
        if(sCadena.charAt(nContador) == sOldLetra){
            sNewCadena = sNewCadena + sNewLetra;
        }else{
            sNewCadena = sNewCadena + sCadena.charAt(nContador);
        }
    }
    return sNewCadena;
}

function validarEliminar(sGridNombre,sRecord){
	    var sMensaje='';
	    var nContador;	 
	    var nRecordCount= new Number();   
	    var sGrid = sGridNombre + '_ctl';
	     if(sRecord=="")
	    {
	    nRecordCount = parseInt(document.all('_RecordCount').value)+1;
	    }else{
	    nRecordCount = parseInt(document.all(sRecord).value)+1;
	    }
	    
	    
	    if (confirm("Are you sure you want to delete these items selected?")){
	        for (nContador = 2; nContador <= nRecordCount; nContador++){	            
                if (nContador < 10){	
                if(document.all(sGrid + '0' + nContador + "_chbDelete")!=null){    
                    if(document.all(sGrid + '0' + nContador + "_chbDelete").checked){                    
                        sMensaje='S';
                        break;
                    }
                    }
                }else{
                if(document.all(sGrid +  nContador + "_chbDelete")!=null){   
                    if (document.all(sGrid + nContador + "_chbDelete").checked){                   
                        sMensaje='S';
                        break;
                    }
                    }
                }	        	            
            }	
            
            if (sMensaje == '') {
                alert("You must select at least one item to continue. Please check it and try again.");
                return false;
            }else{
                return true;
            }  	
        }else{
            return false;
        }
    }   
   
    
function validarSeleccionar(sGridNombre,sRecord){
	    var sMensaje='';
	    var nContador;	 
	    var nRecordCount= new Number();   
	    var sGrid = sGridNombre + '_ctl';
	     if(sRecord=="")
	    {
	    nRecordCount = parseInt(document.all('_RecordCount').value)+1;
	    }else{
	    nRecordCount = parseInt(document.all(sRecord).value)+1;
	    }
	    
	    
	     for (nContador = 2; nContador <= nRecordCount; nContador++){	            
                if (nContador < 10){	
                     if(document.all(sGrid + '0' + nContador + "_chbDelete")!=null)    {
                        if(document.all(sGrid + '0' + nContador + "_chbDelete").checked){                    
                            sMensaje='S';
                            break;
                        }
                    }
                }else{
                 if(document.all(sGrid +  nContador + "_chbDelete")!=null)    {
                    if (document.all(sGrid + nContador + "_chbDelete").checked){                   
                        sMensaje='S';
                        break;
                    }
                  }
                }	        	            
            }	
            
            if (sMensaje == '') {
                alert("You must select at least one item to continue. Please check it and try again.");
                return false;
            }else{
                return true;
            }  	
        
    }  
function validarSeleccionarUno(sGridNombre,sRecord){
	    var sMensaje='';
	    var nContador;	 
	    var nRecordCount= new Number();   
	    var sGrid = sGridNombre + '_ctl';
	     if(sRecord=="")
	    {
	    nRecordCount = parseInt(document.all('_RecordCount').value)+1;
	    }else{
	    nRecordCount = parseInt(document.all(sRecord).value)+1;
	    }
	    
	    
	     for (nContador = 2; nContador <= nRecordCount; nContador++){	            
                if (nContador < 10){	    
                 if(document.all(sGrid + '0' +  nContador + "_chbDelete")!=null)    {
                    if(document.all(sGrid + '0' + nContador + "_chbDelete").checked){                    
                        sMensaje='S';
                        break;
                    }
                    }
                }else{
                 if(document.all(sGrid +  nContador + "_chbDelete")!=null)    {
                    if (document.all(sGrid + nContador + "_chbDelete").checked){                   
                        sMensaje='S';
                        break;
                    }
                    }
                }	        	            
            }	
            
            if (sMensaje == '') {
                return false;
            }else{
                return true;
            }  	
        
    }
    
 function validarModificar(sGridNombre,sRecord){
	    var sMensaje='';
	    var nContador;	 
	    var nContMarca=0;	 
	    var nRecordCount= new Number();   
	    var sGrid = sGridNombre + '_ctl';
	   
	     if(sRecord=="")
	    {
	    nRecordCount = parseInt(document.all('_RecordCount').value)+1;
	    }else{
	    
	    nRecordCount = parseInt(document.all(sRecord).value)+1;
	    }
	    
	     for (nContador = 2; nContador <= nRecordCount; nContador++){	            
                if (nContador < 10){	            
                        if(document.all(sGrid + '0' + nContador + "_chbDelete").checked){                    
                            nContMarca=nContMarca+1;
                          //  break;
                        }
                }else{
                    if (document.all(sGrid + nContador + "_chbDelete").checked){                   
                            nContMarca=nContMarca+1;
                            //break;
                    }
                }	        	            
         }	
                if (nContMarca >1) {
                    alert("You must select only one item to continue. Please check it and try again.");
                    return false;
                }else{
                    if (nContMarca ==0) {
                     alert("You must select only one item to continue. Please check it and try again.");
                      return false;
                    }else
                    {
                        return true;
                        }
                }  	
       
}
function validarAgregar(txtNombre){
     if(document.all(txtNombre).value==""){
                  alert("Must register the description");
                  return false;
     }else{
                return true;
     }
}

    
function elementDateOnBlurHora(){
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

	var valid = formatTime(tmpValue);

	if (valid == false){
		ErrorInProgress = true;
		ObjectError = element;
		alert("The value you entered isn't valid for this field. This field only accepts valid times (12:30).");
		element.focus();
		return false;
	}else{
		element.value = valid;
		return true;
	}
    }
    
    function formatTime(date){
	var tmpValue = date.toString().replace(/\:|\./g,'');
    var tmpTime = "";

	if (isNaN(tmpValue)) return false;

	var n=0;
	var tmpMinutes="";
	var tmpHours="";

	for (var i = 0; i<tmpValue.length; i++){
		if (n < 2) tmpHours += tmpValue.substr(i,1);
		if (n > 1) tmpMinutes += tmpValue.substr(i,1);
		n+=1;
	}

	tmpDate = (tmpHours <= 9 ? "0" : "") + Math.abs(tmpHours) + ":" + (tmpMinutes <= 9 ? "0" : "") + Math.abs(tmpMinutes);

	return validateTime(tmpDate);
}
function validateTime(value){
	var iToday = new Date();
	var iDay = iToday.getDate();
	var iMonth = iToday.getMonth();
	var iYear = iToday.getFullYear();
	var divisionPos = value.search(/:/i);
	var iHours = new String(value.substr(0, divisionPos));
	var iMinutes = new String(value.substr(divisionPos + 1));
		
	if ((iHours < 0 ||  iHours > 23) || (iMinutes < 0 || iMinutes > 59)) {
		return false;
	}

	var iDate = new Date(iYear, iMonth, iDay, iHours, iMinutes);
	if (isNaN(iDate)) return false;

	return value;
}
function mascara(d,sep,pat,nums){
if(d.valant != d.value){
	val = d.value
	largo = val.length
	val = val.split(sep)
	val2 = ''
	for(r=0;r<val.length;r++){
		val2 += val[r]	
	}
	if(nums){
		for(z=0;z<val2.length;z++){
			if(isNaN(val2.charAt(z))){
				letra = new RegExp(val2.charAt(z),"g")
				val2 = val2.replace(letra,"")
			}
		}
	}
	val = ''
	val3 = new Array()
	for(s=0; s<pat.length; s++){
		val3[s] = val2.substring(0,pat[s])
		val2 = val2.substr(pat[s])
	}
	for(q=0;q<val3.length; q++){
		if(q ==0){
			val = val3[q]
		}
		else{
			if(val3[q] != ""){
				val += sep + val3[q]
				}
		}
	}
	d.value = val
	d.valant = val
	}
}
  
function addDescrip(ruta,objetoV,tab){
	   var valor = document.all(tab+objetoV+"ID").value;
	   var texto = document.all(tab+objetoV+"Des").value;
	   openWindow(ruta+"?objeto="+ tab+objetoV + "&PersonID="+valor+"&PersonName="+texto,470,170,'EntityInfo')
	   
    }
    
function addWSDescrip(ruta,objetoV,tab){
	   var valor = document.all(tab+objetoV).value;
	   var texto=""
	   var Addresses = document.all(tab+objetoV)
	   	   if(Addresses.selectedIndex!=0 && Addresses.selectedIndex!=-1){
	   texto  = Addresses.options[Addresses.selectedIndex].text.replace("#","No.");
	   }
	   var doc;
	   openWindow(ruta+"?objeto="+ tab+objetoV + "&AddDesc="+texto+ "&AddID="+valor+ "&Index="+Addresses.selectedIndex,500,240,'AddressInfo')
	   
    }
function addCDescrip(ruta,objetoV,variable,tab){
	   var valor = document.all(tab+objetoV).value;
	   var texto =""
	   var fono =""
	   var mail =""
	   var fax =""
	   var Contactos = document.all(tab+objetoV)
	   if(Contactos.selectedIndex!=0){
	   texto  = Contactos.options[Contactos.selectedIndex].text;
	   }
	   if (document.all(tab+"txt"+ variable + "fono")!=null){
	   fono= document.all(tab+"txt"+ variable + "fono").value;
	   }
	   if (document.all(tab+"txt"+ variable + "phone")!=null){
	   fono= document.all(tab+"txt"+ variable + "phone").value;
	   }
	   if (document.all(tab+"txt"+ variable + "mail")!=null){
	   mail= document.all(tab+"txt"+ variable + "mail").value;
	   }
	   if (document.all(tab+"txt"+ variable + "fax")!=null){
	   fax= document.all(tab+"txt"+ variable + "fax").value;
	   }
	   openWindow(ruta+"?index=" + Contactos.selectedIndex + "&tab="+tab+"&variable="+variable+"&ContactID="+valor+"&ContactName="+texto +"&mail="+ mail + "&fono="+ fono +"&fax="+fax,400,220,'ContactInfo')
	   
    }
   function compare_dates(fecha, fecha2)  
     {  
       var xMonth=fecha.substring(0, 2);  
       var xDay=fecha.substring(3, 5);  
       var xYear=fecha.substring(6,10);  
       var yMonth=fecha2.substring(0, 2);  
       var yDay=fecha2.substring(3, 5);  
       var yYear=fecha2.substring(6,10);  
       if (xYear> yYear)  
       {  
           return(true)  
       }  
       else  
       {  
         if (xYear == yYear)  
         {   
           if (xMonth> yMonth)  
           {  
               return(true)  
           }  
           else  
           {   
             if (xMonth == yMonth)  
            {  
               if (xDay> yDay)  
                return(true);  
               else  
                 return(false);  
             }  
             else  
               return(false);  
           }  
         }  
         else  
           return(false);  
       }  
   }  
       function CompararHoras(sHora1, sHora2) {

       var arHora1 = sHora1.split(":");
       var arHora2 = sHora2.split(":");

       // Obtener horas y minutos (hora 1)
       var hh1 = parseInt(arHora1[0], 10);
       var mm1 = parseInt(arHora1[1], 10);

       // Obtener horas y minutos (hora 2)
       var hh2 = parseInt(arHora2[0], 10);
       var mm2 = parseInt(arHora2[1], 10);

       // Comparar
       if (hh1 < hh2 || (hh1 == hh2 && mm1 < mm2))
           return true
       else if (hh1 > hh2 || (hh1 == hh2 && mm1 > mm2)) {
           return false
       }
   } 
   
   
var MD5 = function (string) {
 
	function RotateLeft(lValue, iShiftBits) {
		return (lValue<<iShiftBits) | (lValue>>>(32-iShiftBits));
	}
 
	function AddUnsigned(lX,lY) {
		var lX4,lY4,lX8,lY8,lResult;
		lX8 = (lX & 0x80000000);
		lY8 = (lY & 0x80000000);
		lX4 = (lX & 0x40000000);
		lY4 = (lY & 0x40000000);
		lResult = (lX & 0x3FFFFFFF)+(lY & 0x3FFFFFFF);
		if (lX4 & lY4) {
			return (lResult ^ 0x80000000 ^ lX8 ^ lY8);
		}
		if (lX4 | lY4) {
			if (lResult & 0x40000000) {
				return (lResult ^ 0xC0000000 ^ lX8 ^ lY8);
			} else {
				return (lResult ^ 0x40000000 ^ lX8 ^ lY8);
			}
		} else {
			return (lResult ^ lX8 ^ lY8);
		}
 	}
 
 	function F(x,y,z) { return (x & y) | ((~x) & z); }
 	function G(x,y,z) { return (x & z) | (y & (~z)); }
 	function H(x,y,z) { return (x ^ y ^ z); }
	function I(x,y,z) { return (y ^ (x | (~z))); }
 
	function FF(a,b,c,d,x,s,ac) {
		a = AddUnsigned(a, AddUnsigned(AddUnsigned(F(b, c, d), x), ac));
		return AddUnsigned(RotateLeft(a, s), b);
	};
 
	function GG(a,b,c,d,x,s,ac) {
		a = AddUnsigned(a, AddUnsigned(AddUnsigned(G(b, c, d), x), ac));
		return AddUnsigned(RotateLeft(a, s), b);
	};
 
	function HH(a,b,c,d,x,s,ac) {
		a = AddUnsigned(a, AddUnsigned(AddUnsigned(H(b, c, d), x), ac));
		return AddUnsigned(RotateLeft(a, s), b);
	};
 
	function II(a,b,c,d,x,s,ac) {
		a = AddUnsigned(a, AddUnsigned(AddUnsigned(I(b, c, d), x), ac));
		return AddUnsigned(RotateLeft(a, s), b);
	};
 
	function ConvertToWordArray(string) {
		var lWordCount;
		var lMessageLength = string.length;
		var lNumberOfWords_temp1=lMessageLength + 8;
		var lNumberOfWords_temp2=(lNumberOfWords_temp1-(lNumberOfWords_temp1 % 64))/64;
		var lNumberOfWords = (lNumberOfWords_temp2+1)*16;
		var lWordArray=Array(lNumberOfWords-1);
		var lBytePosition = 0;
		var lByteCount = 0;
		while ( lByteCount < lMessageLength ) {
			lWordCount = (lByteCount-(lByteCount % 4))/4;
			lBytePosition = (lByteCount % 4)*8;
			lWordArray[lWordCount] = (lWordArray[lWordCount] | (string.charCodeAt(lByteCount)<<lBytePosition));
			lByteCount++;
		}
		lWordCount = (lByteCount-(lByteCount % 4))/4;
		lBytePosition = (lByteCount % 4)*8;
		lWordArray[lWordCount] = lWordArray[lWordCount] | (0x80<<lBytePosition);
		lWordArray[lNumberOfWords-2] = lMessageLength<<3;
		lWordArray[lNumberOfWords-1] = lMessageLength>>>29;
		return lWordArray;
	};
 
	function WordToHex(lValue) {
		var WordToHexValue="",WordToHexValue_temp="",lByte,lCount;
		for (lCount = 0;lCount<=3;lCount++) {
			lByte = (lValue>>>(lCount*8)) & 255;
			WordToHexValue_temp = "0" + lByte.toString(16);
			WordToHexValue = WordToHexValue + WordToHexValue_temp.substr(WordToHexValue_temp.length-2,2);
		}
		return WordToHexValue;
	};
 
	function Utf8Encode(string) {
		string = string.replace(/\r\n/g,"\n");
		var utftext = "";
 
		for (var n = 0; n < string.length; n++) {
 
			var c = string.charCodeAt(n);
 
			if (c < 128) {
				utftext += String.fromCharCode(c);
			}
			else if((c > 127) && (c < 2048)) {
				utftext += String.fromCharCode((c >> 6) | 192);
				utftext += String.fromCharCode((c & 63) | 128);
			}
			else {
				utftext += String.fromCharCode((c >> 12) | 224);
				utftext += String.fromCharCode(((c >> 6) & 63) | 128);
				utftext += String.fromCharCode((c & 63) | 128);
			}
 
		}
 
		return utftext;
	};
 
	var x=Array();
	var k,AA,BB,CC,DD,a,b,c,d;
	var S11=7, S12=12, S13=17, S14=22;
	var S21=5, S22=9 , S23=14, S24=20;
	var S31=4, S32=11, S33=16, S34=23;
	var S41=6, S42=10, S43=15, S44=21;
 
	string = Utf8Encode(string);
 
	x = ConvertToWordArray(string);
 
	a = 0x67452301; b = 0xEFCDAB89; c = 0x98BADCFE; d = 0x10325476;
 
	for (k=0;k<x.length;k+=16) {
		AA=a; BB=b; CC=c; DD=d;
		a=FF(a,b,c,d,x[k+0], S11,0xD76AA478);
		d=FF(d,a,b,c,x[k+1], S12,0xE8C7B756);
		c=FF(c,d,a,b,x[k+2], S13,0x242070DB);
		b=FF(b,c,d,a,x[k+3], S14,0xC1BDCEEE);
		a=FF(a,b,c,d,x[k+4], S11,0xF57C0FAF);
		d=FF(d,a,b,c,x[k+5], S12,0x4787C62A);
		c=FF(c,d,a,b,x[k+6], S13,0xA8304613);
		b=FF(b,c,d,a,x[k+7], S14,0xFD469501);
		a=FF(a,b,c,d,x[k+8], S11,0x698098D8);
		d=FF(d,a,b,c,x[k+9], S12,0x8B44F7AF);
		c=FF(c,d,a,b,x[k+10],S13,0xFFFF5BB1);
		b=FF(b,c,d,a,x[k+11],S14,0x895CD7BE);
		a=FF(a,b,c,d,x[k+12],S11,0x6B901122);
		d=FF(d,a,b,c,x[k+13],S12,0xFD987193);
		c=FF(c,d,a,b,x[k+14],S13,0xA679438E);
		b=FF(b,c,d,a,x[k+15],S14,0x49B40821);
		a=GG(a,b,c,d,x[k+1], S21,0xF61E2562);
		d=GG(d,a,b,c,x[k+6], S22,0xC040B340);
		c=GG(c,d,a,b,x[k+11],S23,0x265E5A51);
		b=GG(b,c,d,a,x[k+0], S24,0xE9B6C7AA);
		a=GG(a,b,c,d,x[k+5], S21,0xD62F105D);
		d=GG(d,a,b,c,x[k+10],S22,0x2441453);
		c=GG(c,d,a,b,x[k+15],S23,0xD8A1E681);
		b=GG(b,c,d,a,x[k+4], S24,0xE7D3FBC8);
		a=GG(a,b,c,d,x[k+9], S21,0x21E1CDE6);
		d=GG(d,a,b,c,x[k+14],S22,0xC33707D6);
		c=GG(c,d,a,b,x[k+3], S23,0xF4D50D87);
		b=GG(b,c,d,a,x[k+8], S24,0x455A14ED);
		a=GG(a,b,c,d,x[k+13],S21,0xA9E3E905);
		d=GG(d,a,b,c,x[k+2], S22,0xFCEFA3F8);
		c=GG(c,d,a,b,x[k+7], S23,0x676F02D9);
		b=GG(b,c,d,a,x[k+12],S24,0x8D2A4C8A);
		a=HH(a,b,c,d,x[k+5], S31,0xFFFA3942);
		d=HH(d,a,b,c,x[k+8], S32,0x8771F681);
		c=HH(c,d,a,b,x[k+11],S33,0x6D9D6122);
		b=HH(b,c,d,a,x[k+14],S34,0xFDE5380C);
		a=HH(a,b,c,d,x[k+1], S31,0xA4BEEA44);
		d=HH(d,a,b,c,x[k+4], S32,0x4BDECFA9);
		c=HH(c,d,a,b,x[k+7], S33,0xF6BB4B60);
		b=HH(b,c,d,a,x[k+10],S34,0xBEBFBC70);
		a=HH(a,b,c,d,x[k+13],S31,0x289B7EC6);
		d=HH(d,a,b,c,x[k+0], S32,0xEAA127FA);
		c=HH(c,d,a,b,x[k+3], S33,0xD4EF3085);
		b=HH(b,c,d,a,x[k+6], S34,0x4881D05);
		a=HH(a,b,c,d,x[k+9], S31,0xD9D4D039);
		d=HH(d,a,b,c,x[k+12],S32,0xE6DB99E5);
		c=HH(c,d,a,b,x[k+15],S33,0x1FA27CF8);
		b=HH(b,c,d,a,x[k+2], S34,0xC4AC5665);
		a=II(a,b,c,d,x[k+0], S41,0xF4292244);
		d=II(d,a,b,c,x[k+7], S42,0x432AFF97);
		c=II(c,d,a,b,x[k+14],S43,0xAB9423A7);
		b=II(b,c,d,a,x[k+5], S44,0xFC93A039);
		a=II(a,b,c,d,x[k+12],S41,0x655B59C3);
		d=II(d,a,b,c,x[k+3], S42,0x8F0CCC92);
		c=II(c,d,a,b,x[k+10],S43,0xFFEFF47D);
		b=II(b,c,d,a,x[k+1], S44,0x85845DD1);
		a=II(a,b,c,d,x[k+8], S41,0x6FA87E4F);
		d=II(d,a,b,c,x[k+15],S42,0xFE2CE6E0);
		c=II(c,d,a,b,x[k+6], S43,0xA3014314);
		b=II(b,c,d,a,x[k+13],S44,0x4E0811A1);
		a=II(a,b,c,d,x[k+4], S41,0xF7537E82);
		d=II(d,a,b,c,x[k+11],S42,0xBD3AF235);
		c=II(c,d,a,b,x[k+2], S43,0x2AD7D2BB);
		b=II(b,c,d,a,x[k+9], S44,0xEB86D391);
		a=AddUnsigned(a,AA);
		b=AddUnsigned(b,BB);
		c=AddUnsigned(c,CC);
		d=AddUnsigned(d,DD);
	}
 
	var temp = WordToHex(a)+WordToHex(b)+WordToHex(c)+WordToHex(d);
 
	return temp.toLowerCase();
}
