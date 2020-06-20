package com.springcloud.test.service.impl;

import com.springcloud.test.mapper.PaymentMapper;
import com.springcloud.test.entity.Payment;
import com.springcloud.test.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceimpl implements IPaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPatmentID(Integer id) {
        return paymentMapper.getPaymentID(id);
    }

}
