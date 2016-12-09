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
    public partial class Dashboard : System.Web.UI.Page
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
                updateOrders();
            }
        }//close Page_Load()

        private void updateOrders()
        {
            

            string url = "http://localhost:8081/API/Orders/Customer/" + session.id.ToString();

            WebClient client = new WebClient();



            Stream data = client.OpenRead(url);
            StreamReader reader = new StreamReader(data);
            string result = reader.ReadToEnd();

            data.Close();
            reader.Close();


            XmlDocument xmldoc = new XmlDocument();

            xmldoc.LoadXml(result);
            XmlNodeList ids = xmldoc.GetElementsByTagName("id");
            XmlNodeList quantity = xmldoc.GetElementsByTagName("quantity");
            XmlNodeList product = xmldoc.GetElementsByTagName("productID");
            XmlNodeList price = xmldoc.GetElementsByTagName("price");
            XmlNodeList status = xmldoc.GetElementsByTagName("status");

            List<Order> orders = new List<Order>();
            for (int x = 0; x < quantity.Count; x++)
            {
                orders.Add(new Order());
                orders[x].id = Convert.ToInt32(ids[x].InnerText.ToString());
                orders[x].quantity = Convert.ToInt32(quantity[x].InnerText.ToString());
                orders[x].itemID = Convert.ToInt32(product[x].InnerText.ToString());
                orders[x].price = Convert.ToDouble(price[x].InnerText.ToString());
                orders[x].status = status[x].InnerText.ToString();
                orders[x].getItemInfo();
            }//close for loop

            for (int y = 0; y < orders.Count; y++)
            {
                Double total = (Double)orders[y].quantity * orders[y].price;
                if (y % 2 == 0)
                {
                    TxtOrders.Text = TxtOrders.Text +
               String.Format("<div class=\"col-xs-12\">" +
               "<div class=\"div-icon\">" +
                   "<img src=\"/Images/Placeholder.png\" />" +
               "</div>" +
               "<div class=\"item-info\">" +
                   "<div class=\"item-title\"><h3>" + orders[y].pName + "</h3></div>" +
                   "<div class=\"item-description\">" + orders[y].pDescription + "</div>" +
               "</div>" +
               "<div class=\"item-actions\"><div class=\"item-action\"><div class=\"btn btn-primary btn-large\">" + orders[y].status + "</div></div>" +
                   "<div class=\"item-action\"><a href=\"#\" class=\"btn btn-primary btn-large\">" + total.ToString() + "</a></div>" +
                   "<div class=\"item-action\"><a href=\"CancelOrder.aspx?id={0} \"  class=\"btn btn-primary btn-large\">Cancel</a></div>" +
               "</div>" +
               "</div>", orders[y].id);
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
                        "<div class=\"item-actions\"><div class=\"item-action\"><div class=\"btn btn-primary btn-large\">" + orders[y].status + "</div></div>" +
                        "<div class=\"item-action\"><a href=\"#\" class=\"btn btn-primary btn-large\">" + total + "</a></div>" +
                        "<div class=\"item-action\"><a href=\"CancelOrder.aspx?id=" + orders[y].id + "\" class=\"btn btn-primary btn-large\">Cancel</a></div>" +
                        "</div>" +
                        "</div>";
                }//else
            }//for loop

        }//updateOrders()


        
    }
}