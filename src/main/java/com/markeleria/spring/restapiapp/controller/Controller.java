package com.markeleria.spring.restapiapp.controller;

import com.markeleria.spring.restapiapp.Entity.Order;
import com.markeleria.spring.restapiapp.Entity.Staff;
import com.markeleria.spring.restapiapp.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
public class Controller {
    @Autowired
    OrderRepository orderRepository;

    public Controller(Staff staff){
        //empty constructor
    }

    public Controller(){
        //empty constructor
    }

    //test to retrieve msg from backend
    @GetMapping("/index")
    public String getMessageFromBackend(){
        return "Hello from backend!";
    }

    //get all list of orders
    @GetMapping("/orders")
    public List<Order> getOrderList(){
        return orderRepository.findAll();
    }

    //get only "one" using order id
    @GetMapping("/orders/{id}")
    public Optional<Order> getOrderById(@PathVariable String id){
        return orderRepository.findById(Long.parseLong(id));
    }

    //add "one" order
    @PostMapping("/orders/add")
    public void addOrder(@RequestBody Order order){
        orderRepository.save(order);
    }

    //delete "one" order using order id
    @PutMapping("orders/update/{id}")
    public void updateOrder(@PathVariable long id, @RequestBody Order order){
        Order updateOrder = new Order();
        updateOrder.setId(id);
        updateOrder.setOrderName(order.getOrderName());
        updateOrder.setPrice(order.getPrice());
        updateOrder.setDiscounted(order.isDiscounted());
        orderRepository.save(updateOrder);
    }

    @DeleteMapping("/orders/delete/{id}")
    public void deleteOrderById(Order order){
        orderRepository.deleteById(order.getId());
    }

    public ResponseEntity<String> returnResponseByRequestType(String requestType, int responseType) {
        if((requestType == "addOrder") && (responseType == 1)){
            return new ResponseEntity<>("Add order success!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Add order failed!", HttpStatus.BAD_REQUEST);
        }

//        return new ResponseEntity<String>("Invalid Response", HttpStatus.BAD_REQUEST);
//        if (isInFuture(yearOfBirth)) {
//            return new ResponseEntity<>(
//                    "Year of birth cannot be in the future",
//                    HttpStatus.BAD_REQUEST);
//        }
//
//        return new ResponseEntity<>(
//                "Your age is " + calculateAge(yearOfBirth),
//                HttpStatus.OK);
    }


}
