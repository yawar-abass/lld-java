package Solid;

import Basics.OOPs.PaymentMethod;

// single responsibility principle
public class Invoice {
    public double amount;

    public  Invoice(double amount){
        this.amount = amount;
    }

    public  void generateInvoice(){
        System.out.println("Invoice generated" + amount);
    }
}
