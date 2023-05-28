package com.markeleria.spring.restapiapp.Implementation;

import com.markeleria.spring.restapiapp.Entity.Staff;
import com.markeleria.spring.restapiapp.Entity.Bill;

public class RegularBill extends Bill{
    public RegularBill(Staff staff){
        //empty constructor
    }

    @Override
    public double getTotalBill() {
        return super.getTotalBill();
    }
}
