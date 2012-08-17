using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;


namespace INFOCORP
{
    [ServiceContract]
    public interface IRegInfocorp
    {

        [OperationContract]
        [WebInvoke(Method="GET", UriTemplate="RegInfocorpN/{codigo}", ResponseFormat=WebMessageFormat.Json)]
        String BuscarDeudasN(String codigo);

        
        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "RegInfocorpJ/{codigo}", ResponseFormat = WebMessageFormat.Json)]
        String BuscarDeudasJ(String codigo);

    }


}
