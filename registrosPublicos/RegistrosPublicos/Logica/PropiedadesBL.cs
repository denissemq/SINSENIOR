using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using RegistrosPublicos.Entidades;

namespace RegistrosPublicos.Logica
{
    public class PropiedadesBL
    {
        public Persona Buscar(String nroDoc, String tipoPersona)
        {

            List<Persona> lista = ListarPersonas();
            Persona persona1 = null;
            foreach(Persona per in lista) {
                if (per.nroDoc==nroDoc && per.tipoPersona==tipoPersona){
                    persona1 = per;

                }
            }

            return persona1;
            
           
        }

        public List<Persona> ListarPersonas()
        {
            List<Propiedades> listaPropiedades = new List<Propiedades>();
            List<Persona> listaPersonas = new List<Persona>(); 

            Propiedades prop1 = new Propiedades("CASA", "SAN MIGUEL", "AV. LA MARINA 3205", "2 HABITACIONES, 2 BAÑOS, 2 PISOS");
            Propiedades prop2 = new Propiedades("DEPARTAMENTO", "SAN ISIDRO", "AV. ANDRES REYES 437", "5 HABITACIONES, 2 BAÑOS, 6 PISOS");
            listaPropiedades.Add(prop1);
            listaPropiedades.Add(prop2);
            Persona persona1 = new Persona("44547116", "NATURAL", "DENISSE MARQUEZ", listaPropiedades);
            listaPersonas.Add(persona1);

            listaPropiedades = new List<Propiedades>();
            prop1 = new Propiedades("CASA", "SAN MARTIN DE PORRES", "JR. AREQUIPA 3866", "2 HABITACIONES, 2 BAÑOS, 4 PISOS");
            listaPropiedades.Add(prop1);
            persona1 = new Persona("1044547116", "JURIDICA", "ROCIO MARQUEZ", listaPropiedades);
            listaPersonas.Add(persona1);


            listaPropiedades = new List<Propiedades>();
            prop1 = new Propiedades("DEPARTAMENTO", "SAN JUAN DE MIRAFLORES", "AV. CANTO REY 455", "10 HABITACIONES, 1 BAÑOS, 3 PISOS");
            listaPropiedades.Add(prop1);
            persona1 = new Persona("44547118", "NATURAL", "JOSE MARIN", listaPropiedades);
            listaPersonas.Add(persona1);


            listaPropiedades = new List<Propiedades>();
            prop1 = new Propiedades("DEPARTAMENTO", "SAN ISISDRO", "AV. AREQUIPA 3650 ", "10 HABITACIONES, 1 BAÑOS, 3 PISOS");
            prop2 = new Propiedades("CASA", "MIRAFLORES", "AV. LARCO 880", "4 HABITACIONES, 1 BAÑOS, 3 PISOS");
            Propiedades prop3 = new Propiedades("DEPARTAMENTO", "LINCE", "AV. ALEJANDRO TIRADO 456", "4 HABITACIONES, 1 BAÑOS, 3 PISOS");
            listaPropiedades.Add(prop1);
            listaPropiedades.Add(prop2);
            listaPropiedades.Add(prop3);
            persona1 = new Persona("1044547117", "JURIDICA", "STEAM WASH", listaPropiedades);
            listaPersonas.Add(persona1);




            listaPropiedades = new List<Propiedades>();
            prop1 = new Propiedades("CASA", "LOS OLIVOS", "AV UNIVERSITARIA 1550 ", "3 HABITACIONES, 1 BAÑOS, 3 PISOS");
            prop2 = new Propiedades("CASA", "COMAS", "AV. SAN FELIPE 1313", "6 HABITACIONES, 1 BAÑOS, 3 PISOS");
            prop3 = new Propiedades("CASA", "RIMAC", "AV. LA CAPILLA 530", "4 HABITACIONES, 1 BAÑOS, 3 PISOS");
            listaPropiedades.Add(prop1);
            listaPropiedades.Add(prop2);
            listaPropiedades.Add(prop3);
            persona1 = new Persona("44959495", "NATURAL", "JEAN PAUL CANALES", listaPropiedades);
            listaPersonas.Add(persona1);
            

            return listaPersonas;
        }


    }
}