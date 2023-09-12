
import com.example.practice.domain.Member;

/**
 * MemberRepository interface
 * 이 인터페이스는 회원 정보를 저장하고 조회하는데 필요한 메서드를 정의한 리포지토리 인터페이스입니다.
 *
 * @author kim sungbum
 */
public interface MemberRepository {

    /**
     * 회원 정보를 저장합니다.
     *
     * @param member 저장할 회원 정보를 담은 Member 객체
     */
    void save(Member member);

    /**
     * 주어진 회원 식별자(ID)에 해당하는 회원 정보를 조회합니다.
     *
     * @param memberId 조회할 회원의 고유 식별자(ID)
     * @return 회원 정보를 담은 Member 객체 (해당 ID에 해당하는 회원이 없으면 null 반환)
     */
    Member findById(Long memberId);
}
