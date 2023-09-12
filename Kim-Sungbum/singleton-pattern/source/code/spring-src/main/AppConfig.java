
import com.example.practice.repository.MemoryMemberRepository;
import com.example.practice.service.MemberService;
import com.example.practice.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig class
 * 이 클래스는 Spring Framework에서 사용되는 설정 클래스입니다.
 * Spring Framework의 컨테이너에 빈(Bean)을 정의하고 구성합니다.
 *
 * @author kim sungbum
 */
@Configuration
public class AppConfig {

    /**
     * MemberService 인터페이스를 구현한 MemberServiceImpl 빈을 생성하고 반환하는 메서드입니다.
     * MemoryMemberRepository를 주입하여 MemberServiceImpl 객체를 생성합니다.
     *
     * @return MemberService 인터페이스를 구현한 MemberServiceImpl 빈
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
}
