using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.IO;
using System.Linq;
using System.Net;
using System.Security;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;
using RestSharp;

namespace Lake_Shore_Market
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        UserSession session;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["session"] == null)
            {
                Response.Redirect("~/CustomerLogin.aspx");
            }//
            else
            {
                session = (UserSession)Session["session"];
                String queryV = Request.QueryString["id"].ToString();

                string url = "http://localhost:8081/API/Orders/" + queryV;


                var client = new RestClient(url);



                var request = new RestRequest(Method.DELETE);


                client.Execute(request);

                Response.Redirect("~/Dashboard.aspx");
                

            }//close else
        }







    }
}