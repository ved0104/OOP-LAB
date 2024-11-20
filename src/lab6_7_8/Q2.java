package lab6_7_8;// lab6_7_8.Q2.) Create a class called invoice that hardware store might use to represent an invoice for an item sold at
// the store. An invoice should include four pieces of information as instance variable 
//  a part number(type string)
//  a part description(type string)
//  a quantity of the item being purchased(type int) 
//  a price per item(double)
// Your class should have a constructor that initialization the four instance variable . Provide a set and a get 
// method for each instance variable . In addition provide method named getInvoiceAmount that calculate 
// the invoice amount(i.e. multiplies the quantity per item ), then return the amount as a double value.If the 
// quantity is not positive it should be set to 0. If the price per item is not positive it should be set to 0.0. 
// Write test application named invoice test that demonstration class invoice capabilities.

import java.util.Scanner;

class Invoice {
    private String partNumber;
    private String partDescription;
    private double pricePerItem;
    private int purchasedItem;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (pricePerItem < 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }

    public String getPartNumber() {
        return partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public int getPurchasedItem() {
        return purchasedItem;
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public void setPurchasedItem(int purchasedItem) {
        this.purchasedItem = purchasedItem;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem < 0) {
            this.pricePerItem = 0;
        } else {
            this.pricePerItem = pricePerItem;
        }

    }

    public double getInvoiceAmount() {
        double amount = quantity * pricePerItem;
        return amount;

    }

    Invoice() {
        partNumber = "";
        partDescription = "";
        quantity = 0;
        pricePerItem = 0.0;
    }

};

public class Q2 {
    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the part no: ");
        String partNumber = sc.nextLine();
        System.out.println("Enter the description:");
        String partDescription = sc.nextLine();
        System.out.println("Enter the quantity of item:");
        int quantity = sc.nextInt();
        System.out.println("Enter the price per item:");
        double pricePerItem = sc.nextDouble();

        invoice.setPartDescription(partDescription);
        invoice.setPricePerItem(pricePerItem);
        invoice.setPartNumber(partNumber);
        invoice.setQuantity(quantity);
        System.out.println(invoice.getInvoiceAmount());

    }
}