<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar">      
    <div class="navbar-inner">
        <div class="container">
        <a href="javascript:void(0);" class="brand">SinSenior Online</a>


        <ul class="nav">
			<li class=""><a href="<c:url value='/pages/inmuebles/venta'/>">Venta</a></li>
			<li class=""><a href="<c:url value='/pages/inmuebles/compra'/>">Compra</a></li>
			<li class=""><a href="<c:url value='/pages/inmuebles/suscripcion'/>">Suscripcion</a></li>
           
        </ul>



            <div class="right" style="color:white;line-height: 40px;">
            Bienvenido ${credential.nombre}  ${credential.apellidos} | <a href="<c:url value='/pages/usuarios/logout'/>">Salir</a>
        </div>
        </div>
    </div><!-- /topbar-inner -->
</div>