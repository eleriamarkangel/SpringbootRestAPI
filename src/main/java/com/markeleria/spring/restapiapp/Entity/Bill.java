package com.markeleria.spring.restapiapp.Entity;

import java.util.List;

public class Bill {
    double totalBill;

    List<Order> orderList;
    Staff staff;

    public Bill(){
        //empty constructor
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public Staff getStaff(){
        return staff;
    }

    public void setOrderList(List<Order> orderList){
        this.orderList = orderList;
    }

    public double getTotalBill() {
        for(int i=0; i<getOrderList().size()-1; i++){
            totalBill += getOrderList().get(i).getPrice();
        }
        return totalBill;
    }
}
