using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Lake_Shore_Market
{
    public class UserSession
    {
        public int id { get; set; }
        public string userName { get; set; }
        public string firstName { get; set; }
        public bool isAuthorized { get; set; }
        public string type { get; set; }

        public UserSession()
        {

        }//close UserSession

        public UserSession(int id, string userName, string firstName, bool authorized, string type)
        {
            this.id = id;
            this.userName = userName;
            this.firstName = firstName;
            this.isAuthorized = authorized;
            this.type = type;
        }


    }//close class
}//close namespace