package spring.core.discount;

import spring.core.member.Grade;
import spring.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int prince) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else{
            return 0;
        }
    }
}