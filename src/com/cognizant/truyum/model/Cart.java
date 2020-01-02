package com.cognizant.truyum.model;

import java.util.List;

public class Cart {
    private List<MenuItem> menuItemList;
    private double total;

    public Cart() {
        // TODO Auto-generated constructor stub
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return new StringBuffer(menuItemList + ", total=" + total).toString();
    }

}
