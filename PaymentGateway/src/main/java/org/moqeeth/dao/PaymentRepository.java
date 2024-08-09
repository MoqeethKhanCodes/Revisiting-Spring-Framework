package org.moqeeth.dao;

import org.moqeeth.model.PaymentInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentInfo, String> {
}
