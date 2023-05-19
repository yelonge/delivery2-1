package delivery.infra;

import delivery.config.kafka.KafkaProcessor;
import delivery.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoViewHandler {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            OrderInfo orderInfo = new OrderInfo();
            // view 객체에 이벤트의 Value 를 set 함
            orderInfo.setOrderId(orderPlaced.getId());
            orderInfo.setMenuId(orderPlaced.getMenuId());
            orderInfo.setMenuName(orderPlaced.getMenuName());
            orderInfo.setUserId(orderPlaced.getUserId());
            // view 레파지 토리에 save
            orderInfoRepository.save(orderInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_1(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
            // view 객체 조회

            List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(
                accepted.getOrderId()
            );
            for (OrderInfo orderInfo : orderInfoList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderInfo.setStatus(accepted.getStatus());
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_2(
        @Payload CookStarted cookStarted
    ) {
        try {
            if (!cookStarted.validate()) return;
            // view 객체 조회

            List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(
                cookStarted.getOrderId()
            );
            for (OrderInfo orderInfo : orderInfoList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderInfo.setStatus(cookStarted.getStatus());
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_3(
        @Payload CookFinished cookFinished
    ) {
        try {
            if (!cookFinished.validate()) return;
            // view 객체 조회

            List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(
                cookFinished.getOrderId()
            );
            for (OrderInfo orderInfo : orderInfoList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderInfo.setStatus(cookFinished.getStatus());
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliverySelected_then_UPDATE_4(
        @Payload DeliverySelected deliverySelected
    ) {
        try {
            if (!deliverySelected.validate()) return;
            // view 객체 조회

            List<OrderInfo> orderInfoList = orderInfoRepository.findByOrderId(
                deliverySelected.getOrderId()
            );
            for (OrderInfo orderInfo : orderInfoList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                orderInfo.setStatus(deliverySelected.getStatus());
                // view 레파지 토리에 save
                orderInfoRepository.save(orderInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
