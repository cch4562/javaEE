package com.springmvcDemo.pojo;

public class QueryVo {
    private Item item;
    private Integer []ids;

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "item=" + item +
                '}';
    }
}
