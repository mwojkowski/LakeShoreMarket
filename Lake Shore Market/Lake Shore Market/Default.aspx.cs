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
    public partial class _Default : Page
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
            }


        }//Page_Load


        protected void SearchButton(object sender, EventArgs e)
        {
            string id = TxtSearchBox.Text.ToString();

            string url = "http://localhost:8081/API/Products/Product/";

            WebClient client = new WebClient();

            client.Headers.Add("Name", id);

            Stream data = client.OpenRead(url);
            StreamReader reader = new StreamReader(data);
            string result = reader.ReadToEnd();
            data.Close();
            reader.Close();


            XmlDocument xmldoc = new XmlDocument();

            xmldoc.LoadXml(result);
            XmlNodeList name = xmldoc.GetElementsByTagName("name");
            XmlNodeList description = xmldoc.GetElementsByTagName("description");
            XmlNodeList price = xmldoc.GetElementsByTagName("price");


            List<Order> orders = new List<Order>();
            for(int x = 0; x < name.Count; x++)
            {
                orders.Add(new Order());
                orders[x].pName = name[x].InnerText.ToString();
                orders[x].pDescription = description[x].InnerText.ToString();
                orders[x].price = Convert.ToDouble(price[x].InnerText.ToString());
            }
            for (int y = 0; y < orders.Count; y++)
            {
                if (y % 2 == 0)
                {
                    TxtOrders.Text = TxtOrders.Text +
                "<div class=\"col-xs-12\">" +
                    "<div class=\"div-icon\">" +
                        "<img src=\"/Images/Placeholder.png\" />" +
                    "</div>" +
                    "<div class=\"item-info\">" +
                        "<div class=\"item-title\"><h3>" + orders[y].pName + "</h3></div>" +
                        "<div class=\"item-description\">" + orders[y].pDescription + "</div>" +
                    "</div>" +
                    "<div class=\"item-actions\">" +
                        "<div class=\"item-action\"><div class=\"btn btn-primary btn-large\">$" + orders[y].price + "</a></div>" +
                        "<div class=\"item-action\"><a href=\"~/BuyNow.aspx?id=\"" + orders[y].id + "\" class=\"btn btn-primary btn-large\">Buy now!</a></div>" +
                    "</div>"+
                "</div>";
                }
                else
                {
                    TxtOrders.Text = TxtOrders.Text +
                "<div class=\"col-xs-12-alt\">" +
                    "<div class=\"div-icon\">" +
                        "<img src=\"/Images/Placeholder.png\" />" +
                    "</div>" +
                    "<div class=\"item-info\">" +
                        "<div class=\"item-title\"><h3>" + orders[y].pName + "</h3></div>" +
                        "<div class=\"item-description\">" + orders[y].pDescription + "</div>" +
                    "</div>" +
                    "<div class=\"item-actions\">" +
                        "<div class=\"item-action\"><div class=\"btn btn-primary btn-large\">$" + orders[y].price + "</a></div>" +
                        "<div class=\"item-action\"><a href=\"~/BuyNow.aspx?id=\"" + orders[y].id + "\" class=\"btn btn-primary btn-large\">Buy now!</a></div>" +
                    "</div>" +
                "</div>";
                }//else
            }//for lopp

        }//method

    }//class
}//namespace