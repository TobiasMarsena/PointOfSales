package com.rks.project.pointofsales.users;

import com.rks.project.pointofsales.item.Item;

public class Cart {
    private Item item;
    private int quantity;
    private long total;

    public Cart() {
    }

    public Cart(Item item) {
        this.item = item;
        this.quantity = 1;
        this.total = this.item.getPrice();
    }

    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.total = this.item.getPrice() * this.quantity;
    }
    public void incrementQuantity() {
        this.quantity++;
        this.total = this.item.getPrice() * this.quantity;
    }
    public void decrementQuantity() {
        this.quantity--;
        this.total = this.item.getPrice() * this.quantity;
    }

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "item=" + item +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
