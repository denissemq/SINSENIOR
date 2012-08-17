using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using RegistrosPublicos.Logica;
using RegistrosPublicos.Entidades;

namespace RegistrosPublicos
{

    public class RegPublicos : IRegPublicos
    {
       
        #region IRegPublicos Members

        public String BuscarPersonaNatural(String nroDoc)
        {
            PropiedadesBL proBL = new PropiedadesBL();
            String strPropiedades = String.Empty;
            List<Propiedades> listaProp = proBL.Buscar(nroDoc, "NATURAL").listaPropiedades;
            foreach (Propiedades prop1 in listaProp) {
                strPropiedades = strPropiedades + ";" + prop1.Direccion + " " + prop1.Distrito + " " + prop1.tipoInmueble + " " + prop1.caracteristicas;
            }

            return strPropiedades;
        }
        public String BuscarPersonaJuridica(String nroDoc)
        {
            PropiedadesBL proBL = new PropiedadesBL();
            String strPropiedades = String.Empty;
            List<Propiedades> listaProp = proBL.Buscar(nroDoc, "JURIDICA").listaPropiedades;
            foreach (Propiedades prop1 in listaProp)
            {
                strPropiedades = strPropiedades + ";" + prop1.Direccion + " " + prop1.Distrito + " " + prop1.tipoInmueble + " " + prop1.caracteristicas;
            }

            return strPropiedades;

        }

        #endregion
    }
}
