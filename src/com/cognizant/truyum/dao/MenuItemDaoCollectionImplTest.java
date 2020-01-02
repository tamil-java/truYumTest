package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {
    public static void main(String[] args) {
        System.out.println("MenuItemDaoCollectionImplTest");
        testGetMenuItemListAdmin();
        testEditMenuItem();
        testGetMenuItemListCustomer();
        testGetMenuItem();
        testGetMenuItemListAdmin();
    }

    public static void testEditMenuItem() {
        System.out.println("\nEditMenuItem() Called ");
        MenuItem menuItem = new MenuItem(1, "Stone Ice", 1999.00f, true,
                DateUtil.convertToDate("15/03/2010"), "Smart Phones", true);
        System.out.println("Edited Menuitem to be added -->" + menuItem);
        MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        menuItemDao.editMenuItem(menuItem);
        System.out.println("All Menuitems After Edited");
        for (MenuItem menu : menuItemDao.getMenuItemListAdmin()) {
            System.out.println(menu);
        }
        System.out.println("New Menuitem->" + menuItemDao.getMenuItem(menuItem.getId()));
    }

    public static void testGetMenuItemListAdmin() {
        System.out.println("\nGetMenuItemListAdmin() Called");
        MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        for (MenuItem menu : menuItemDao.getMenuItemListAdmin()) {
            System.out.println(menu);
        }
    }

    public static void testGetMenuItemListCustomer() {
        System.out.println("\nGetMenuItemListCustomer() Called");
        MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        for (MenuItem menu : menuItemDao.getMenuItemListCustomer()) {
            System.out.println(menu);
        }
    }

    public static void testGetMenuItem() {
        System.out.println("\nGetMenuItem() Called");
        MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
        System.out.println(menuItemDao.getMenuItem(1));
    }
}
