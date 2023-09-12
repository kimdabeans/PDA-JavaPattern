
import com.example.practice.domain.Member;
import com.example.practice.repository.MemberRepository;

/**
 * MemberServiceImpl class
 * 이 클래스는 회원 관련 서비스를 구현하는 서비스 클래스입니다.
 *
 * @author kim sungbum
 */
public class MemberServiceImpl implements MemberService {
    /**
     * 회원 저장 및 조회를 위한 리포지토리 인터페이스를 구현하는 멤버 변수입니다.
     */
    private final MemberRepository memberRepository;

    /**
     * MemberServiceImpl 객체를 생성할 때 주입받는 리포지토리를 설정하는 생성자입니다.
     *
     * @param memberRepository 회원 정보를 저장하고 조회하는 데 사용되는 리포지토리 인터페이스
     */
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 정보를 저장하는 메서드입니다.
     *
     * @param member 저장할 회원 정보를 담은 Member 객체
     */
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    /**
     * 주어진 회원 식별자(ID)에 해당하는 회원을 조회하는 메서드입니다.
     *
     * @param memberId 조회할 회원의 고유 식별자(ID)
     * @return 조회된 회원 정보를 담은 Member 객체 (해당 ID에 해당하는 회원이 없으면 null 반환)
     */
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
