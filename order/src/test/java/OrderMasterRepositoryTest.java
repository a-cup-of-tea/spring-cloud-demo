import com.xproject.order.dataobject.OrderMaster;
import com.xproject.order.enums.OrderStatusEnum;
import com.xproject.order.enums.PayStatusEnum;
import com.xproject.order.repository.OrderApplicationTests;
import com.xproject.order.repository.OrderMasterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.math.BigDecimal;

@Component
class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567890");
        orderMaster.setBuyerName("肥仔");
        orderMaster.setBuyerPhone("120");
        orderMaster.setBuyerAddress("医院");
        orderMaster.setBuyerOpenid("wx123");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());


        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.isTrue(result != null);
    }
}