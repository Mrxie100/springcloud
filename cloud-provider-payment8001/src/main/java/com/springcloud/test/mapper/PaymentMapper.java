package com.springcloud.test.mapper;

import com.springcloud.test.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {
    int  create(Payment payment);
    Payment getPaymentID(@Param("id") Integer id);
}
