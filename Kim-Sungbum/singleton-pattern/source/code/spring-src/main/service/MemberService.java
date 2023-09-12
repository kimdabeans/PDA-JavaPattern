
import com.example.practice.domain.Member;

/**
 * MemberService interface
 * 이 인터페이스는 회원 가입 및 회원 조회와 관련된 서비스 메서드를 정의한 서비스 인터페이스입니다.
 *
 * @author kim sungbum
 */
public interface MemberService {

    /**
     * 회원 가입을 처리하는 메서드입니다.
     *
     * @param member 가입할 회원 정보를 담은 Member 객체
     */
    void join(Member member);

    /**
     * 주어진 회원 식별자(ID)에 해당하는 회원을 조회하는 메서드입니다.
     *
     * @param memberId 조회할 회원의 고유 식별자(ID)
     * @return 조회된 회원 정보를 담은 Member 객체 (해당 ID에 해당하는 회원이 없으면 null 반환)
     */
    Member findMember(Long memberId);
}
