package com.poo.ficha3;

public class PackageLine {
    private String reference, description;
    private double price;
    private int quantityOrdered, taxPercentage, discountPercentage;

    public PackageLine() {
        this.discountPercentage = 0;
        this.quantityOrdered = 0;
        this.taxPercentage = 0;
        this.price = 0;
        this.reference = "No Reference";
        this.description = "No Description";
    }

    public PackageLine(PackageLine p) {
        this.description = p.getDescription();
        this.reference = p.getReference();
        this.price = p.getPrice();
        this.quantityOrdered = p.getQuantityOrdered();
        this.taxPercentage = p.getTaxPercentage();
        this.discountPercentage = p.getDiscountPercentage();
    }

    public PackageLine(String reference, String description, double price, int quantityOrdered, int taxPercentage, int discountPercentage) {
        this.reference = reference;
        this.description = description;
        this.price = price;
        this.quantityOrdered = quantityOrdered;
        this.taxPercentage = taxPercentage;
        this.discountPercentage = discountPercentage;
    }

    @Override
    public PackageLine clone() {
        return new PackageLine(this);
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public int getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(int taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double calculaValorLinhaEnc() {
        return (this.price * (1 - ((double) this.discountPercentage/100))) * (1 + ((double) this.taxPercentage/100));
    }

    public double calculaValorDesconto() {
        return (this.price) * ((double) this.discountPercentage/100);
    }
}
