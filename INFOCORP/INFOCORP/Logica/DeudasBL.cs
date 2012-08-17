using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Entidades;

namespace Logica
{
    public class DeudasBL
    {
        public Persona Buscar(String nroDoc, String tipoPersona)
        {

            List<Persona> lista = ListarPersonas();
            Persona persona1 = new Persona();
            foreach(Persona per in lista) {
                if (per.nroDoc==nroDoc && per.tipoPersona==tipoPersona){
                    persona1 = per;

                }
            }

            return persona1;
            
           
        }

        public List<Persona> ListarPersonas()
        {
            List<Deudas> listaDeudas = new List<Deudas>();
            List<Persona> listaPersonas = new List<Persona>(); 

            Deudas prop1 = new Deudas("5000", "01 Enero 2010", "BANCO FALABELLA");
            Deudas prop2 = new Deudas("3600", "02 Enero 2010", "RIPLEY");
            listaDeudas.Add(prop1);
            listaDeudas.Add(prop2);
            Persona persona1 = new Persona("44547116", "NATURAL", "DENISSE MARQUEZ", listaDeudas);
            listaPersonas.Add(persona1);


            listaDeudas = new List<Deudas>();
            prop1 = new Deudas("8000", "01 Enero 2011", "BANCO FALABELLA");
            prop2 = new Deudas("1000", "01 Junio 2011", "BANCO DE CREDITO DEL PERU");
            Deudas prop3 = new Deudas("1500", "01 Mayo 2012", "SCOTIABANK");
            listaDeudas.Add(prop1);
            listaDeudas.Add(prop2);
            listaDeudas.Add(prop3);
            persona1 = new Persona("20268512544", "JURIDICA", "ALEXIM TRADING", listaDeudas);
            listaPersonas.Add(persona1);

          

            listaDeudas = new List<Deudas>();
            prop1 = new Deudas("2000", "01 Enero 2012", "CLARO");
            prop2 = new Deudas("15.50", "01 Diciembre 2011", "TELEFONICA");
            listaDeudas.Add(prop1);
            listaDeudas.Add(prop2);
            persona1 = new Persona("1044547117", "JURIDICA", "STEAM WASH", listaDeudas);
            listaPersonas.Add(persona1);



            return listaPersonas;
        }


    }
}