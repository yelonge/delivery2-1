package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Rejected extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long menuId;
    private String menuName;
    private String userId;
    private String status;

    public Rejected(Store aggregate) {
        super(aggregate);
    }

    public Rejected() {
        super();
    }
}
