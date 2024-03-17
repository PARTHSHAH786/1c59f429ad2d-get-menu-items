package com.scaler.services;

import com.scaler.exceptions.Invaliddietarypreference;
import com.scaler.models.DietaryRequirement;
import com.scaler.models.MenuItem;
import com.scaler.repositories.MenuRepository;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements MenuService{
    MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuItem> getMenuItems(String itemType) {
        List<MenuItem> menuItems = new ArrayList<>();
        if(itemType==null||itemType.isEmpty())
        {
            return menuRepository.getAll();
        }

        if (itemType.equals(DietaryRequirement.VEG.name()) ||
                itemType.equals(DietaryRequirement.NON_VEG.name()) ||
                itemType.equals(DietaryRequirement.VEGAN.name())) {
            menuItems = menuRepository.getByDietaryRequirement(DietaryRequirement.valueOf(itemType));
        }
        else {
            throw new RuntimeException("Invalid dietary preference");
        }
        return menuItems;

    }
}
