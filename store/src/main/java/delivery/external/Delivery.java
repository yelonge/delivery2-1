package delivery.external;

import java.util.Date;
import lombok.Data;

@Data
public class Delivery {

    private Long id;
    private Long orderId;
    private Long menuId;
    private String menuName;
    private String userId;
    private String status;
}
