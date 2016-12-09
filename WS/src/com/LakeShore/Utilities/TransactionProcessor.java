package com.LakeShore.Utilities;

public class TransactionProcessor {
	public TransactionProcessor(){
		
	}//close TransactionProcessor
	
	//Dummy Charge method for credit cards using an order number and card number...
	//In an ideal situation, a 'Transactions' table can be created to know whether or not an order has been paid.
	//Additionally, this information would go through some charging API such as Braintree or PayPal to actually charge the card.
	public void chargeCreditCard(String cardNumber, int orderID){
		System.out.println("Charging credit card number: " + cardNumber + "for order: " + orderID + "........");
	}//close chargeCreditCard()

}//close TransactionProcessor
