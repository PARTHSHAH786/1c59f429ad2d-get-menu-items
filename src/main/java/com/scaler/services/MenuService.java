package com.scaler.services;

import com.scaler.exceptions.Invaliddietarypreference;
import com.scaler.models.DietaryRequirement;
import com.scaler.models.MenuItem;

import java.util.List;

public interface MenuService {


    List<MenuItem> getMenuItems(String itemType);
}
