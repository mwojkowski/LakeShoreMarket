<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="CustomerLogin.aspx.cs" Inherits="Lake_Shore_Market.CustomerLogin" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">

    <div class="jumbotron">
        <h1 style="text-align: center;">Lake Shore Market</h1>
        <p class="lead" style="text-align: center;">Please Login or Register to use the website</p>
    </div>

     <div class="row" style="text-align: center;">

        <div class="col-xs-5" style="margin-left: 10px;">
             <Center><h2>Login</h2></Center>
             <p style="text-align: center;"><asp:Literal ID="TxtErrorMessage" runat="server"></asp:Literal></p>
             <p style="text-align: center;"><asp:TextBox id="TxtUsername" text="Username" runat="server" />  </p>
             <p style="text-align: center;"><asp:TextBox id="TxtPassword" TextMode="Password" text="Password" runat="server" />   </p>
             <p style="text-align: center;"><asp:Button ID="Button1" runat="server" CssClass="btn btn-primary btn-large" onclick="LoginButton" Text="Login &raquo;" /></p>

        </div>

         <div class="col-xs-5" style="margin-left: 10%;">
             <Center><h2>Register</h2></Center>
             <p style="text-align: center;"><asp:Literal ID="Literal1" runat="server"></asp:Literal></p>
             <p style="text-align: center;"><asp:TextBox id="TxtRUsername" text="Username" runat="server" />  </p>
             <p style="text-align: center;"><asp:TextBox id="TxtRPassword" text="Password" runat="server" />   </p>
             <p style="text-align: center;"><asp:TextBox id="TxtRFirstName" text="First Name" runat="server" />   </p>
             <p style="text-align: center;"><asp:TextBox id="TxtRLastName" text="Last Name" runat="server" />   </p>
             <p style="text-align: center;"><a href="http://www.asp.net" class="btn btn-primary btn-large">Login &raquo;</a></p>

        </div>
       
    </div>


</asp:Content>
