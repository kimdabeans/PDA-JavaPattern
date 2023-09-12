package commandPattern1.command;

import java.util.List;

/**
 * 성공 여부에 따라 의존적으로 여러 명령을 실행하는 복수의 명령을 모은 명령을 표현하는 클래스
 *
 * @author Lee Sohyeong
 */
public class DependentCompositeCommand extends CompositeCommand{

    public DependentCompositeCommand() {
    }

    /**
     * DependentCompositeCommand 인스턴스를 생성한다.
     *
     * @param items 명령 목록
     */
    public DependentCompositeCommand(List<Command> items) {
        super(items);
    }

    @Override
    public void call() {
        boolean ok = true;
        for (Command cmd : commands) {
            if (ok) {
                // 이전 명령이 성공했을 때 다음 명령을 실행한다.
                cmd.call();
                ok = cmd.isSucceeded();
            } else {
                // 이전 명령이 실패했을 때
                succeeded = false;
                return;
            }
        }
    }

}
