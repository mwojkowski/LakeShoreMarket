<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Lake_Shore_Market._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <div class="jumbotron">
        <h1 style="text-align: center;">Lake Shore Market</h1>
        <p class="lead" style="text-align: center;">Search for items that fit your needs.</p>
        <p style="text-align: center;"><asp:TextBox id="TxtSearchBox" runat="server" /><asp:Button ID="Button1" runat="server" CssClass="btn btn-primary btn-large" onclick="SearchButton" Text="Search &raquo;" /></p>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <h2>Results:</h2>
        </div>
        <p style="text-align: center;"><asp:Literal ID="TxtOrders" runat="server"></asp:Literal></p>
       
    </div>

</asp:Content>