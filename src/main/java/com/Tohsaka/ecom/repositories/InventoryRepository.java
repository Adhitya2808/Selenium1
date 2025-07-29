package com.Tohsaka.ecom.repositories;

import org.openqa.selenium.By;

public class InventoryRepository {
        public static By inventoryItem = By.xpath("//div[@class='inventory_item']");
        public static By inventoryItemName = By.xpath("//div[@class='inventory_item_name']");
        public static By productSortContainer = By.xpath("//select[@class='product_sort_container']");
        public static By ProductAdd = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[3]/button");
        public static By ProductCart = By.id("shopping_cart_container");
        public static By CartList = By.className("cart_item");
        public static By RemoveBtn = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/button");
}