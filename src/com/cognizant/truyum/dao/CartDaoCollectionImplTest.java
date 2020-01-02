package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
    public static void main(String[] args) {
        testAddCartItem();
        testGetAllCartItems();
        testRemoveCartItem();
        testGetAllCartItems();
    }

    public static void testAddCartItem() {
        System.out.println("AddCartItem() Called");
        CartDao cartDao = new CartDaoCollectionImpl();
        cartDao.addCartItem(1, 1);
        cartDao.addCartItem(1, 2);
        cartDao.addCartItem(1, 3);
    }

    public static void testRemoveCartItem() {
        System.out.println("RemoveCartItem() Called");
        CartDao cartDao = new CartDaoCollectionImpl();
        cartDao.removeCartItem(1, 1);
    }

    public static void testGetAllCartItems() {
        System.out.println("GetAllCartItems() Called");
        CartDao cartDao = new CartDaoCollectionImpl();
        try {
            Cart cart = cartDao.getAllCartItems(1);
            List<MenuItem> menuItem = cart.getMenuItemList();
            for (MenuItem menu : menuItem) {
                System.out.println(menu);
            }
            System.out.println("Total: Rs." + cart.getTotal());
        } catch (CartEmptyException e) {
            System.out.println(e.getMessage());
        }
    }
}
