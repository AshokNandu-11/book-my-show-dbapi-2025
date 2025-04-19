package com.dbapi.bookmyshow.dbapi.controller;



import com.dbapi.bookmyshow.dbapi.model.Bill;
import com.dbapi.bookmyshow.dbapi.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/db/bill")
public class BillController {

    @Autowired
    BillRepository billRepository;

    @PostMapping("/create")
    public ResponseEntity createBill(@RequestBody Bill bill){

        billRepository.save(bill);
        return  new ResponseEntity(bill, HttpStatus.CREATED);

    }
    @GetMapping("/{billId}")
    public ResponseEntity getBillById(@PathVariable UUID billId){

        Bill bill = billRepository.findById(billId).orElse(null);
        return new ResponseEntity(bill,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity updateBillById(@RequestBody Bill bill){
        billRepository.save(bill);
        return new ResponseEntity(bill,HttpStatus.CREATED);
    }
    @DeleteMapping("/{billId}")
    public ResponseEntity deleteBillById(@PathVariable UUID billId){
        billRepository.deleteById(billId);
        return new ResponseEntity(null,HttpStatus.NO_CONTENT);
    }

}
