package com.devsuperior.hrpayroll.resources;

import com.devsuperior.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/{workerId}/days/{days}")
    public Double getPayment(@PathVariable long workerId, @PathVariable int days) {
        var payment = paymentService.getPayment(workerId, days);
        return payment.getTotal();
    }
}