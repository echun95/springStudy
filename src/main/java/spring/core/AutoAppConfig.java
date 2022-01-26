package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
        basePackages = "spring.core",
        basePackageClasses = AutoAppConfig.class, //basePackages 지정안하면 default로 현재 패키지가 시작 위치
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
