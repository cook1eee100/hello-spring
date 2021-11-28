package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    /*  jdbc
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    */

    /*  JPA
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        // return new MemberService(memberRepository());    // 메모리, jdbc JPA
        return new MemberService(memberRepository); // 스프링 데이터 JPA
    }

//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();      // 메모리 repository
////        return new JdbcMemberRepository(dataSource);    // 순수 jdbc
////        return new JdbcTemplateMemberRepository(dataSource);  // JdbcTemplate
////        return new JpaMemberRepository(em);   // JPA
//
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

}
