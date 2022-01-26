package spring.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.core.order.Order;
import spring.core.order.OrderService;

@SpringBootTest
class CoreApplicationTests {

	@Autowired
	OrderService orderService;
	
	@Test
	void contextLoads() {
//		Order itemA = orderService.createOrder(1L, "itemA", 10000);
//		System.out.println("itemA = " + itemA);
	}

}
