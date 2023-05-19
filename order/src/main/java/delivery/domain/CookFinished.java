package delivery.domain;

import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class CookFinished extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long menuId;
    private String menuName;
    private String userId;
    private String status;
}
