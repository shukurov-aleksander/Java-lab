package com.ku.business.dtomapper;

import com.ku.business.dto.OrderDto;
import com.ku.business.dto.OrderListDto;
import com.ku.business.dto.OrderSaveOrUpdateDto;
import com.ku.business.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDtoMapper implements Mapper<Order, OrderDto, OrderListDto, OrderSaveOrUpdateDto> {

    @Override
    public OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getOrderStatus(),
                order.getCreatedAtUtc(),
                order.getCompletedAtUtc(),
                new ContentDtoMapper().toDtoList(order.getContents())
        );
    }

    @Override
    public OrderListDto toListDto(Order order) {
        return new OrderListDto(
                order.getId(),
                order.getOrderStatus()
        );
    }

    @Override
    public List<OrderListDto> toDtoList(List<Order> orders) {
        List<OrderListDto> orderListDtos = new ArrayList<>();
        for (Order order : orders) {
            orderListDtos.add(toListDto(order));
        }
        return orderListDtos;
    }

    @Override
    public OrderSaveOrUpdateDto toSaveOrUpdateDto(Order order) {
        return new OrderSaveOrUpdateDto(
                order.getId(),
                order.getOrderStatus(),
                order.getCreatedAtUtc(),
                order.getCompletedAtUtc()
        );
    }

    @Override
    public Order fromSaveOrUpdateDto(OrderSaveOrUpdateDto saveOrUpdateDto) {
        return new Order(
                saveOrUpdateDto.getId(),
                saveOrUpdateDto.getCreatedAtUtc(),
                saveOrUpdateDto.getCompletedAtUtc(),
                null,
                saveOrUpdateDto.getOrderStatus()
        );
    }
}
