package com.springmvcDemo.service.impl;

import com.springmvcDemo.mapper.ItemMapper;
import com.springmvcDemo.pojo.Item;
import com.springmvcDemo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> getItemList() {
//        传参null为查询全部
        return itemMapper.selectByExample(null);
    }

    @Override
    public void updateItem(Item item) {
        itemMapper.updateByPrimaryKeySelective(item);
    }

    @Override
    public Item getItemById(Integer id) {
        return itemMapper.selectByPrimaryKey(id);
    }
}
