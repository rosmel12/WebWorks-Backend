package com.upc.webworksbackend.dtoaux;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionCheck {
    private boolean status = false;
    private float amount = -1;
}
