using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Security;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Xml;


namespace Lake_Shore_Market
{
    public partial class CustomerLogin : System.Web.UI.Page
    {
        UserSession session;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (Session["session"] != null)
            {
                Response.Redirect("~/Default.aspx");
            }
        }

        protected void LoginButton(object sender, EventArgs e)
        {

            session = new UserSession();

            string url = "http://localhost:8081/Sessions/Login";

            WebClient client = new WebClient();

            // Add a user agent header in case the 
            // requested URI contains a query.

            client.Headers.Add("Username", TxtUsername.Text.ToString());
            client.Headers.Add("Password", TxtPassword.Text.ToString());

            Stream data = client.OpenRead(url);
            StreamReader reader = new StreamReader(data);
            string result = reader.ReadToEnd();
            TxtErrorMessage.Text = result;
            data.Close();
            reader.Close();


            XmlDocument xmldoc = new XmlDocument();

            xmldoc.LoadXml(result);
                XmlNodeList id = xmldoc.GetElementsByTagName("id");
                XmlNodeList username = xmldoc.GetElementsByTagName("username");
                XmlNodeList authorized = xmldoc.GetElementsByTagName("authorized");
                XmlNodeList type = xmldoc.GetElementsByTagName("type");

                session.id = Convert.ToInt32(id[0].InnerText);
                session.userName = username[0].InnerText;
                if (authorized[0].InnerText.Equals("Authorized"))
                {
                    session.isAuthorized = true;
                }
                else
                {
                    session.isAuthorized = false;
                }

                session.type = type[0].InnerText;

            if (!session.isAuthorized)
                TxtErrorMessage.Text = "Bad Login Info";
            else
            {
                Session["session"] = session;
                Response.Redirect("~/Default.aspx");
            }
            //Response.Redirect

        }//close loginButton
    }
}