package com.scaler.repositories;

import com.scaler.models.DietaryRequirement;
import com.scaler.models.MenuItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRepositoryImpl implements MenuRepository{
    List<MenuItem> menuItems = new ArrayList<>();
    @Override
    public MenuItem add(MenuItem menuItem) {
        menuItems.add(menuItem);
        return menuItem;
    }

    @Override
    public List<MenuItem> getAll() {
        return menuItems;
    }

    @Override
    public List<MenuItem> getByDietaryRequirement
            (DietaryRequirement dietaryRequirement) {
        List<MenuItem> menuItems1 = new ArrayList<>();
        for (MenuItem menuItem : menuItems)
        {
            if(menuItem.getDietaryRequirement().equals(dietaryRequirement))
            {
                menuItems1.add(menuItem);
            }
        }
        return menuItems1;
    }

    @Override
    public MenuItem save(MenuItem menuItem) {
        menuItems.add(menuItem);
        return menuItem;
    }
}
