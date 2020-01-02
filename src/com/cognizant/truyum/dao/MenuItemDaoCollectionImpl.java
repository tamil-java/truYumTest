package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
    private static List<MenuItem> menuItemList;

    public MenuItemDaoCollectionImpl() {
        if (menuItemList == null) {
            MenuItem menuItem1 = new MenuItem(1, "Sandwich", 99.00f, true,
                    DateUtil.convertToDate("15/03/2017"), "Main Course", true);
            MenuItem menuItem2 = new MenuItem(2, "Burger", 129.00f, true,
                    DateUtil.convertToDate("23/12/2017"), "Main Course", false);
            MenuItem menuItem3 = new MenuItem(3, "Pizza", 149.00f, true,
                    DateUtil.convertToDate("21/08/2018"), "Main Course", false);
            MenuItem menuItem4 = new MenuItem(4, "French Fries", 57.00f, false,
                    DateUtil.convertToDate("02/07/2017"), "Starters", true);
            MenuItem menuItem5 = new MenuItem(5, "Chocolate", 32.00f, true,
                    DateUtil.convertToDate("02/11/2022"), "Dessert", true);
            menuItemList = new ArrayList<MenuItem>();
            menuItemList.add(menuItem1);
            menuItemList.add(menuItem2);
            menuItemList.add(menuItem3);
            menuItemList.add(menuItem4);
            menuItemList.add(menuItem5);
        }
    }

    @Override
    public List<MenuItem> getMenuItemListAdmin() {
        return menuItemList;
    }

    @Override
    public List<MenuItem> getMenuItemListCustomer() {
        ArrayList<MenuItem> getMenuItems = new ArrayList<MenuItem>();
        for (MenuItem menuItem : menuItemList) {
            if ((menuItem.getDateOfLaunch().before(new Date())
                    || menuItem.getDateOfLaunch().equals(new Date()))
                    && (menuItem.isActive() == true)) {
                getMenuItems.add(menuItem);
            }
        }
        return getMenuItems;
    }

    @Override
    public void editMenuItem(MenuItem menuItem) {
        for (int i = 0; i < menuItemList.size(); i++) {
            if (menuItemList.get(i).getId() == menuItem.getId()) {
                menuItemList.set(i, menuItem);
            }
        }
    }

    @Override
    public MenuItem getMenuItem(long menuItemId) {
        for (MenuItem menu : menuItemList) {
            if (menu.getId() == menuItemId) {
                return menu;
            }
        }
        return null;
    }
}
