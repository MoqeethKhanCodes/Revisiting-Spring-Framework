package org.moqeeth.Controller;

import org.moqeeth.model.PaymentInfo;
import org.moqeeth.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getAllPayments")
    public ResponseEntity<List<PaymentInfo>> getAllPayments() {
        List<PaymentInfo> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    @PostMapping("/addPayment")
    public ResponseEntity<Void> addPayment(@RequestBody PaymentInfo payment) {
        paymentService.addPayment(payment);
        return ResponseEntity.status(201).build(); // HTTP 201 Created
    }

}
