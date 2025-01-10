package com.upc.webworksbackend.controller;
import com.upc.webworksbackend.dto.SubscriptionDbo;
import com.upc.webworksbackend.dtoaux.SubscriptionCheck;
import com.upc.webworksbackend.dtoaux.SubscriptionSummaryDto;
import com.upc.webworksbackend.serviceinterface.SubscriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/webworks/subscription")
@CrossOrigin
public class SubscriptionController {
   final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping("/user/subscriptionActive/{id}")
    public ResponseEntity<SubscriptionCheck> SubscriptionsActives(@PathVariable Integer id) {
        return new ResponseEntity<>(subscriptionService.SubscriptionActive(id), HttpStatus.OK);
    }

    @PostMapping("/user/addSubscription")
    public ResponseEntity<Boolean> addSubscription(@RequestBody SubscriptionDbo subscriptionDbo) {
        return new ResponseEntity<>(subscriptionService.addSubscription(subscriptionDbo), HttpStatus.CREATED);
    }
    @GetMapping("/user/listSubscriptionsByUser/{idUser}")
    private ResponseEntity<List<SubscriptionSummaryDto>> listSubscriptionsByUser(@PathVariable Integer idUser) {
        return new ResponseEntity<>(subscriptionService.listSubscriptionsByUser(idUser),HttpStatus.OK);
    }

}
