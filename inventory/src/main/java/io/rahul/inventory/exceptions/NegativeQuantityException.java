package io.rahul.inventory.exceptions;

public class NegativeQuantityException extends RuntimeException{

    public NegativeQuantityException(){
        super("Quantity cannot be negative");
    }

}
