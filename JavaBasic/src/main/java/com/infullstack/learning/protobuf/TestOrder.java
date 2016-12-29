package com.infullstack.learning.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;


/**
 * Created by Ray on 2016/12/28 0028.
 */
public class TestOrder {

    public static byte[] encode(OrderProto.Order order) {
        return order.toByteArray();
    }

    public static OrderProto.Order decode(byte[] body) throws InvalidProtocolBufferException {
        return OrderProto.Order.parseFrom(body);
    }


    public static OrderProto.Order createOrder() {
        OrderProto.Order.Builder builder = OrderProto.Order.newBuilder();
        builder.setUserid(1);
        builder.setTime(10);
        builder.setPrice(10);
        builder.setDesc("order test");
        return builder.build();
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {

        OrderProto.Order order = TestOrder.createOrder();
        System.out.println("before encode:" + order.toString());
        OrderProto.Order order2 = decode(encode(order));
        System.out.println("after encode:" + order2.toString());
        System.out.println("Assert equal: " + order2.equals(order));
    }

}
