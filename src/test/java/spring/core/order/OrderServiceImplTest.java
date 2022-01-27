package spring.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.core.discount.FixDiscountPolicy;
import spring.core.member.Grade;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    //생성자 주입을 통해 순수한 자바 테스트가 가능함
    @Test
    void createOrder(){
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L, "name", Grade.VIP ));
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new FixDiscountPolicy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}