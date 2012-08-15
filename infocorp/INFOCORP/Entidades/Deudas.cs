using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Entidades
{
    public class Deudas
    {
        String _Monto;
        String _FechaInicio;
        String _Entidad;

        public Deudas(String Monto, String FechaInicio,  String Entidad)
        {
            this.Monto = Monto;
            this.FechaInicio = FechaInicio;
            this.Entidad = Entidad;
        }
        public String Monto
        {
            get { return _Monto; }
            set { _Monto = value; }
        }
        public String FechaInicio
        {
            get { return _FechaInicio; }
            set { _FechaInicio = value; }
        }
        public String Entidad
        {
            get { return _Entidad; }
            set { _Entidad = value; }
        }
    }
}