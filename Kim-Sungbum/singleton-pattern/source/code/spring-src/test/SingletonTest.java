
import com.example.practice.service.MemberService;
import com.example.practice.service.SingletonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * SingletonTest 클래스는 싱글톤 패턴과 스프링 컨테이너를 비교하고 테스트하는 테스트 클래스입니다.
 */
public class SingletonTest {
    /**
     * 순수 DI 컨테이너를 테스트하는 메서드입니다.
     */
    @Test
    @DisplayName("순수 DI 컨테이너")
    void pureContainer() {
        // given
        AppConfig appConfig = new AppConfig();

        // when
        // 호출 할 때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // then
        // 참조값 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        assertThat(memberService1).isNotEqualTo(memberService2);
    }

    /**
     * 싱글톤 패턴을 적용한 객체 사용을 테스트하는 메서드입니다.
     */
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonService() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        assertThat(instance1).isSameAs(instance2);
    }

    /**
     * 스프링 컨테이너와 싱글톤을 비교하는 메서드입니다.
     */
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 참조값 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // memberService1과 memberService2는 동일한 객체 참조
        assertThat(memberService1).isSameAs(memberService2);
    }
}
