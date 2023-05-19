package delivery.domain;

import delivery.StoreApplication;
import delivery.domain.Accepted;
import delivery.domain.CookFinished;
import delivery.domain.CookStarted;
import delivery.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Store_table")
@Data
public class Store {

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
        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();

        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        delivery.external.Delivery delivery = new delivery.external.Delivery();
        // mappings goes here
        StoreApplication.applicationContext
            .getBean(delivery.external.DeliveryService.class)
            .select(delivery);

        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    public static StoreRepository repository() {
        StoreRepository storeRepository = StoreApplication.applicationContext.getBean(
            StoreRepository.class
        );
        return storeRepository;
    }
}
