using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace RegistrosPublicos.Entidades
{
    public class Propiedades
    {
        String _tipoInmueble;
        String _Distrito;
        String _Direccion;
        String _caracteristicas;


        public Propiedades(String tipoInmueble, String Distrito, String Direccion, String caracteristicas)
        {
            this.tipoInmueble = tipoInmueble;
            this.Distrito = Distrito;
            this.Direccion = Direccion;
            this.caracteristicas = caracteristicas;
        }
        public String tipoInmueble
        {
            get { return _tipoInmueble; }
            set { _tipoInmueble = value; }
        }
        public String Distrito
        {
            get { return _Distrito; }
            set { _Distrito = value; }
        }
        public String Direccion
        {
            get { return _Direccion; }
            set { _Direccion = value; }
        }
        public String caracteristicas
        {
            get { return _caracteristicas; }
            set { _caracteristicas = value; }
        }
    }
}