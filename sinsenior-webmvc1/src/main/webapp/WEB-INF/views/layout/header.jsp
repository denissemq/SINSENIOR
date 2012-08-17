<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar">      
    <div class="navbar-inner">
        <div class="container">
        <a href="javascript:void(0);" class="brand">SinSenior Online</a>
        <ul class="nav">
            <li class=""><a href="<c:url value='/pages/citas/pendientes'/>">Citas Pendientes</a></li>
            <li class=""><a href="<c:url value='/pages/citas/disponibles'/>">Citas Disponibles</a></li>
            <li class=""><a href="<c:url value='/pages/inmuebles/index'/>">Inmuebles</a></li>
            <li class=""><a href="<c:url value='/pages/inmuebles/suscripciones'/>">Suscripciones</a></li>
            <li class=""><a href="<c:url value='/pages/usuarios/index'/>">Usuarios</a></li>
        </ul>





            <div class="right" style="color:white;line-height: 40px;">
            Bienvenido ${credential.nombre}  ${credential.apellidos}  | <a href="<c:url value='/pages/usuarios/logout'/>">Salir</a>
        </div>
        </div>
    </div><!-- /topbar-inner -->
</div>