package com.cognizant.truyum.dao;

public class CartEmptyException extends Exception {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Cart is Empty"; // If cart is empty
    }
}
