package delivery.domain;

import delivery.DeliveryApplication;
import delivery.domain.DeliveryCompleted;
import delivery.domain.DeliverySelected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long menuId;

    private String menuName;

    private String userId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        DeliverySelected deliverySelected = new DeliverySelected(this);
        deliverySelected.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }
}
