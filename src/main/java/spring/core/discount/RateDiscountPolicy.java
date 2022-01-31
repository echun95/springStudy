package spring.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring.core.annotation.MainDiscountPolicy;
import spring.core.member.Grade;
import spring.core.member.Member;

@Component
@MainDiscountPolicy //커스텀 애노테이션
//@Qualifier("mainDiscountPolicy")
//@Primary //같은 타입의 빈이 존재하면 우선적으로 Primary가 부여된 빈이 주입된다.
// 만약 Qualifier와 Primary를 동시에 사용하게되면 Qualifier가 우선권을 가진다.(자동 < 수동, 넓은 범위 선택권 < 좁은 범위 선택권)
public class RateDiscountPolicy implements DiscountPolicy {

    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
