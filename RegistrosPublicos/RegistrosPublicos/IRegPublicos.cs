using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using RegistrosPublicos.Entidades;

namespace RegistrosPublicos
{
    [ServiceContract]
    public interface IRegPublicos
    {

        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "RegPublicosN/{codigo}", ResponseFormat = WebMessageFormat.Json)]
        String BuscarPersonaNatural(String codigo);

        
        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "RegPublicosJ/{codigo}", ResponseFormat = WebMessageFormat.Json)]
        String BuscarPersonaJuridica(String codigo);

    }


}
