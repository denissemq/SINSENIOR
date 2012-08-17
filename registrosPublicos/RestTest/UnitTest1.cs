using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Net;
using System.IO;

namespace RestTest
{
 
    [TestClass]
    public class RegPublicosTest
    {
    
        [TestMethod]
        public void ValidarpersonaN()
        {
           HttpWebRequest req = WebRequest.Create(
               "http://localhost:34667/RegPublicos.svc/RegPublicosN/44547116") as HttpWebRequest;
           HttpWebResponse res = req.GetResponse() as HttpWebResponse;
           StreamReader reader = new StreamReader(res.GetResponseStream());

           String Caracteristicas = reader.ReadToEnd();

           Assert.AreEqual(Caracteristicas, "\"¬CASA AV. LA MARINA 3205 SAN MIGUEL 2 HABITACIONES, 2 BAÑOS, 2 PISOS¬¬DEPARTAMENTO AV. ANDRES REYES 437 SAN ISIDRO 5 HABITACIONES, 2 BAÑOS, 6 PISOS¬\"");
         

        }
        [TestMethod]
        public void ValidarpersonaJ()
        {
            HttpWebRequest req = WebRequest.Create(
                "http://localhost:34667/RegPublicos.svc/RegPublicosJ/1044547116") as HttpWebRequest;
            HttpWebResponse res = req.GetResponse() as HttpWebResponse;
            StreamReader reader = new StreamReader(res.GetResponseStream());

            String Caracteristicas = reader.ReadToEnd();

            Assert.AreEqual(Caracteristicas, "\"¬CASA JR. AREQUIPA 3866 SAN MARTIN DE PORRES 2 HABITACIONES, 2 BAÑOS, 4 PISOS¬\"");


        }
    }
}
