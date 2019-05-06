package com.springmvcDemo.service;

import com.springmvcDemo.pojo.Item;

import java.util.List;

public interface ItemService {
    List<Item> getItemList();
    void updateItem(Item item);
    Item getItemById(Integer id);
}
