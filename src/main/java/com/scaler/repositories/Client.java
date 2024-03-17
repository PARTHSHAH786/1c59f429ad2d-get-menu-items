package com.scaler.repositories;

import com.scaler.models.DietaryRequirement;
import com.scaler.models.ItemType;
import com.scaler.models.MenuItem;

import java.util.List;

public class Client {
    public static void main(String[] args) {
        MenuRepositoryImpl menuRepository = new MenuRepositoryImpl();
        MenuItem menuItem = new MenuItem();
        menuItem.setName("vegmeal");
        menuItem.setItemType(ItemType.REGULAR);
        menuItem.setDietaryRequirement(DietaryRequirement.VEG);
        menuItem.setPrice(1.0);
        menuRepository.add(menuItem);

        List<MenuItem> menuItemList = menuRepository.getByDietaryRequirement(DietaryRequirement.VEG);
        System.out.println(menuItemList);
        String itemType = "VEG";
        if (itemType.equals(DietaryRequirement.VEG.name()) ||
                itemType.equals(DietaryRequirement.NON_VEG.name()) ||
                itemType.equals(DietaryRequirement.VEGAN.name())) {

            List<MenuItem> menuItems = menuRepository.getByDietaryRequirement(DietaryRequirement.valueOf(itemType));
            System.out.println(menuItems);
        }


    }
}
