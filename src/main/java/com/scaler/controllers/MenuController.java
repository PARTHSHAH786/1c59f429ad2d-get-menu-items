package com.scaler.controllers;

import com.scaler.dtos.*;
import com.scaler.exceptions.Invaliddietarypreference;
import com.scaler.models.MenuItem;
import com.scaler.services.MenuService;

import java.util.List;

public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }


    public GetMenuItemsResponseDto getMenuItems(GetMenuItemsRequestDto requestDto)   {
        GetMenuItemsResponseDto getMenuItemsResponseDto = new GetMenuItemsResponseDto();
        try {
            List<MenuItem> menuItems = menuService.getMenuItems(requestDto.getDietaryRequirement());
            getMenuItemsResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            getMenuItemsResponseDto.setMenuItems(menuItems);
        } catch (Exception e) {
            getMenuItemsResponseDto.setResponseStatus(ResponseStatus.FAILURE);

        }
        return getMenuItemsResponseDto;
    }
}
