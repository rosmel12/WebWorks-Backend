package com.upc.webworksbackend.controller;
import com.upc.webworksbackend.dto.MethodPaymentDto;
import com.upc.webworksbackend.serviceinterface.MethodPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webworks/methodpayment")
@CrossOrigin
public class MethodPaymentController {
    final MethodPaymentService methodPaymentService;

    public MethodPaymentController(MethodPaymentService methodPaymentService) {
        this.methodPaymentService = methodPaymentService;
    }
    @PostMapping("/user/addMethodPayment")
    public ResponseEntity<Boolean> addMethodPayment(@RequestBody MethodPaymentDto methodPaymentDto) {
        return new ResponseEntity<>(methodPaymentService.addMethodPayment(methodPaymentDto), HttpStatus.CREATED);
    }

    @GetMapping("/user/methodsPaymentByUser/{id}")
    public ResponseEntity<List<MethodPaymentDto>> methodsPaymentByUser(@PathVariable Integer id) {
        return new ResponseEntity<>(methodPaymentService.methodsPaymentByUser(id),HttpStatus.OK);
    }

    @GetMapping("/user/methodPaymentById/{id}")
    public ResponseEntity<MethodPaymentDto> methodPaymentById(@PathVariable Integer id) {
        return  new ResponseEntity<>(methodPaymentService.methodPaymentById(id),HttpStatus.OK);
    }

    @DeleteMapping("/user/deleteMethodPaymentById/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(methodPaymentService.deleteMethodPayment(id),HttpStatus.OK);
    }

    @PutMapping("/user/updateMethodPayment")
    public ResponseEntity<Boolean> methodPaymentUpdate(@RequestBody MethodPaymentDto methodPaymentDto) {
        return new ResponseEntity<>(methodPaymentService.updateMethodPayment(methodPaymentDto),HttpStatus.OK);
    }

}
