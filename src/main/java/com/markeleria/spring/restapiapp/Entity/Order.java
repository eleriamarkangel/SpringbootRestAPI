package com.markeleria.spring.restapiapp.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "order_tbl")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "order_price")
    private double price;

    @Column(name = "is_discounted")
    private boolean isDiscounted;

    private static final double DISCOUNT = 5.0;

    public Order(){
        //empty constructor
    }

    public Order(String orderName, double price, boolean isDiscounted){
        this.orderName = orderName;
        this.price = price;
        this.isDiscounted = isDiscounted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean discounted) {
        isDiscounted = discounted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(order.price, price) == 0 && isDiscounted == order.isDiscounted && Objects.equals(orderName, order.orderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderName, price, isDiscounted);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderName='" + orderName + '\'' +
                ", price=" + price +
                ", isDiscounted=" + isDiscounted +
                '}';
    }
}
