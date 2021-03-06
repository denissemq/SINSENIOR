﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using Logica;
using Entidades;

namespace INFOCORP
{

    public class RegInfocorp : IRegInfocorp
    {

        #region IRegInfocorp Members

        public String BuscarDeudasN(String nroDoc)
        {
            DeudasBL proBL = new DeudasBL();
            String strPropiedades = String.Empty;

            List<Deudas> listaProp = proBL.Buscar(nroDoc, "NATURAL").listaPropiedades;
            if (listaProp != null)
            {
                foreach (Deudas prop1 in listaProp)
                {
                    strPropiedades = strPropiedades + "¬" + prop1.Entidad + " " + prop1.FechaInicio + " " + prop1.Monto;
                }
            }
                 
            return strPropiedades;
        }
        public String BuscarDeudasJ(String nroDoc)
        {
            DeudasBL proBL = new DeudasBL();
            String strPropiedades = String.Empty;
            List<Deudas> listaProp = proBL.Buscar(nroDoc, "JURIDICA").listaPropiedades;
            if (listaProp != null)
            {
                foreach (Deudas prop1 in listaProp)
                {
                    strPropiedades = strPropiedades + "¬" + prop1.Entidad + " " + prop1.FechaInicio + " " + prop1.Monto;
                }
            }
            return strPropiedades;

        }

        #endregion
    }
}
