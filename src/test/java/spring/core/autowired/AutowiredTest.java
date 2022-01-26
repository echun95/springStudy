package spring.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import spring.core.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean{
        //required = false Autowired로 넣을 의존관계가 없으면 수정자 자체가 호출이 안된다.
        @Autowired(required = false)
        public void setNoBean1(Member member){
            System.out.println("member1 = " + member);
        }
        //@Nullable 의존관계가 없으면 null로 주입됨
        @Autowired
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member2 = " + member);
        }
        //Optional<> java8 문법을 쓰면 Optional.empty가 주입됨
        @Autowired
        public void setNoBean3(Optional<Member> member) {
            System.out.println("member3 = " + member);
        }

    }

}
