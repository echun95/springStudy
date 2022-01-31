package spring.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import spring.core.annotation.MainDiscountPolicy;
import spring.core.discount.DiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //@RequiredArgsConstructor 어노테이션은 final로 선언된 멤버변수를 생성자로 만들어준다.
    //의존성 주입 시 같은 타입이 존재하면 빈 중복 오류가 남 -> 생성자 파라미터 이름, 필드 명을 빈 이름과 같게하면 같은 이름을 가진 빈이 주입된다.
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
    //@Qualifier 어노테이션에 부여한 이름과 같은 이름을 Qulifier에 등록한 빈을 주입한다. 만약에 없을시 Qulifier에 등록된 이름과 같은 이름을 가진 빈을 주입한다.(Qualifier는 Qualifier를 찾는 용도로 사용하는게 좋음)
//    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) {
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
