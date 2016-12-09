<%@ Page Title="" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Dashboard.aspx.cs" Inherits="Lake_Shore_Market.Dashboard" %>
<asp:Content ID="Content1" ContentPlaceHolderID="MainContent" runat="server">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js" type="text/javascript"></script>
    <div class="jumbotron">
        <h1 style="text-align: center;">Lake Shore Market</h1>
        <p class="lead" style="text-align: center;">All of your orders can be found below.</p>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <h2>Order history:</h2>
        </div>
        <p style="text-align: center;"><asp:Literal ID="TxtOrders" runat="server"></asp:Literal></p>
    </div>
</asp:Content>
