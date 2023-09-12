package statePattern;

/**
 * @author  Cho hayoung
 * Context 인터페이스는 상태 패턴(State Pattern)에서 상태 객체(State)와 상호 작용하는 역할을 정의합니다.
 * 이 인터페이스를 구현한 클래스는 시계 시간 설정, 상태 변경, 보안 센터 호출, 로그 기록 등의 동작을 수행합니다.
 */
public interface Context {
    /**
     * 시계 시간을 설정하고 현재 시간에 따라 상태를 변경하는 메서드입니다.
     * 
     * @param hour 현재 시간
     */
    void setClock( int hour);

    /**
     * 상태를 변경하는 메서드로, 새로운 상태를 받아와 현재 상태를 변경합니다.
     *
     * @param state 새로운 상태
     */
    void changeState(State state);

    /**
     * 보안 센터에 메시지를 호출하는 메서드입니다.
     *
     * @param msg 호출할 메시지
     */
    void callSecurityCenter(String msg);

    /**
     * 로그를 기록하는 메서드입니다.
     *
     * @param msg 기록할 메시지
     */
    void recordLog(String msg);
}
