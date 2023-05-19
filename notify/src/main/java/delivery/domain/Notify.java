package delivery.domain;

import delivery.NotifyApplication;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Notify_table")
@Data
public class Notify {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long menuId;

    private String menuName;

    private String userId;

    private String status;

    public static NotifyRepository repository() {
        NotifyRepository notifyRepository = NotifyApplication.applicationContext.getBean(
            NotifyRepository.class
        );
        return notifyRepository;
    }

    public static void changeOrderStatus(CookStarted cookStarted) {
        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }

    public static void changeOrderStatus(CookFinished cookFinished) {
        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }

    public static void changeOrderStatus(Picked picked) {
        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(picked.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }

    public static void changeOrderStatus(DeliveryCompleted deliveryCompleted) {
        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(deliveryCompleted.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }

    public static void changeOrderStatus(Rejected rejected) {
        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }

    public static void changeOrderStatus(Accepted accepted) {
        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(accepted.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }

    public static void changeOrderStatus(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Notify notify = new Notify();
        repository().save(notify);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(notify->{
            
            notify // do something
            repository().save(notify);


         });
        */

    }
}
