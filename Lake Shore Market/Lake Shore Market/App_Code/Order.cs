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
    public class Order
    {
        public int id { get; set; }
        public string seller { get; set; }
        public string pDescription{get;set;}
        public int itemID{get;set;}
        public double price {get;set;}
        public string pName { get; set; }
        public int quantity {get;set;}
        public double total { get; set; }
        public string status { get; set; }

        public Order()
        {

        }


         public void populateOrder(){

         }//close populateOrder()

         public void getItemInfo()
         {

             string url = "http://localhost:8081/API/Products/" + itemID.ToString();

             WebClient client = new WebClient();

             Stream data = client.OpenRead(url);
             StreamReader reader = new StreamReader(data);
             string result = reader.ReadToEnd();
             data.Close();
             reader.Close();


             XmlDocument xmldoc = new XmlDocument();

             xmldoc.LoadXml(result);
             XmlNodeList name = xmldoc.GetElementsByTagName("name");
             XmlNodeList description = xmldoc.GetElementsByTagName("description");
             XmlNodeList quantity = xmldoc.GetElementsByTagName("quantity");


             this.pName = name[0].InnerText.ToString();
             this.pDescription = description[0].InnerText.ToString();
             this.quantity = Convert.ToInt32(quantity[0].InnerText.ToString());
         }



    }//close class


}//close namespace