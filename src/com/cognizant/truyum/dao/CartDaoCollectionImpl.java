package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
    public static HashMap<Long, Cart> userCarts;

    public CartDaoCollectionImpl() {
        super();
        if (userCarts == null) {
            HashMap<Long, Cart> map = new HashMap<Long, Cart>();
            userCarts = map;
        }
    }

    @Override
    public void addCartItem(long userId, long menuItemId) {
        MenuItemDao menuDao = new MenuItemDaoCollectionImpl();
        MenuItem menuItem = menuDao.getMenuItem(menuItemId);
        if (userCarts.containsKey(userId)) {
            userCarts.get(userId).getMenuItemList().add(menuItem);
        } else {
            Cart cart = new Cart();
            ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
            menuItems.add(menuItem);
            cart.setMenuItemList(menuItems);
            userCarts.put(userId, cart);
        }
    }

    @Override
    public Cart getAllCartItems(long userId) throws CartEmptyException {
        Cart cart = userCarts.get(userId);
        if (cart == null || cart.getMenuItemList().isEmpty()) {
            throw new CartEmptyException();
        }
        List<MenuItem> menu = cart.getMenuItemList();
        float totalPrice = 0;
        for (MenuItem menuItem : menu) {
            totalPrice += menuItem.getPrice();
        }
        cart.setTotal(totalPrice);
        return cart;
    }

    @Override
    public void removeCartItem(long userId, long menuItemId) {
        List<MenuItem> menuItem = userCarts.get(userId).getMenuItemList();
        for (int i = 0; i < menuItem.size(); i++) {
            if (menuItem.get(i).getId() == menuItemId) {
                menuItem.remove(i);
                break;
            }
        }
    }
}
