using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Net;
using System.IO;

namespace RegInfocorp
{

    [TestClass]
    public class Test
    {

        [TestMethod]
        public void ValidarpersonaJ()
        {
            HttpWebRequest req = WebRequest.Create(
                "http://localhost:44008/RegInfocorp.svc/RegInfocorpJ/1044547116") as HttpWebRequest;
            HttpWebResponse res = req.GetResponse() as HttpWebResponse;
            StreamReader reader = new StreamReader(res.GetResponseStream());

            String Caracteristicas = reader.ReadToEnd();

            Assert.AreEqual(Caracteristicas, "\";BANCO FALABELLA 01 Enero 2011 8000\"");


        }
        [TestMethod]
        public void ValidarpersonaN()
        {
            HttpWebRequest req = WebRequest.Create(
                "http://localhost:44008/RegInfocorp.svc/RegInfocorpN/44547116") as HttpWebRequest;
            HttpWebResponse res = req.GetResponse() as HttpWebResponse;
            StreamReader reader = new StreamReader(res.GetResponseStream());

            String Caracteristicas = reader.ReadToEnd();

            Assert.AreEqual(Caracteristicas, "\";BANCO FALABELLA 01 Enero 2010 5000;RIPLEY 02 Enero 2010 3600\"");


        }
    }
}
