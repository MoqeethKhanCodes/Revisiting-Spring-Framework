package org.moqeeth.service;

import org.moqeeth.dao.PaymentRepository;
import org.moqeeth.model.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<PaymentInfo> getAllPayments() {
        return paymentRepository.findAll();
    }

    public void addPayment(PaymentInfo payment) {
        paymentRepository.save(payment);
    }
}
