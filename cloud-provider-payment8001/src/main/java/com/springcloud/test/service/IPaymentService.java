package com.springcloud.test.service;

import com.springcloud.test.entity.Payment;

public interface IPaymentService {
    int create(Payment payment);
    Payment getPatmentID(Integer id);

}
