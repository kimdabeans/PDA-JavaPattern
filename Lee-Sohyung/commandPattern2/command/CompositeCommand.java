package commandPattern2.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 복수의 명령을 모은 명령을 표현하는 클래스 (Composite)
 * 여러 개의 하위 명령(Command)을 관리하고 실행하는 역할을 한다.
 *
 * @author Lee Sohyeong
 */
public class CompositeCommand implements Command {

    // 명령의 배열
    protected List<Command> commands = new ArrayList<>();
    // 모든 명령이 성공했는지 여부를 저장하는 변수
    protected boolean succeeded = true;

    /**
     * CompositeCommand 인스턴스를 생성한다.
     * 생성된 CompositeCommand 인스턴스는 비어 있는 명령 목록을 가진다.
     */
    public CompositeCommand() {
    }

    /**
     * CompositeCommand 인스턴스를 생성한다.
     * 명령 목록(items)을 받아서 CompositeCommand 를 초기화한다.
     *
     * @param items 명령 목록
     */
    public CompositeCommand(List<Command> items) {
        commands.addAll(items);

        // 모든 명령이 성공했는지 여부를 초기화합니다.
        for (Command cmd : commands) {
            if (!cmd.isSucceeded()) {
                succeeded = false;
                break;
            }
        }
    }

    /**
     * 명령(Command)을 CompositeCommand 에 추가한다.
     *
     * @param command 추가할 명령(Command) 객체
     */
    public void addCommand(Command command) {
        commands.add(command);

        // 추가된 명령이 성공했는지 여부를 업데이트합니다.
        if (!command.isSucceeded()) {
            succeeded = false;
        }

    }

    /**
     * 모아진 모든 명령(Command)을 순차적으로 실행한다.
     */
    @Override
    public void call() {
        for (Command cmd : commands) {
            cmd.call();

            // 명령 실행 후 성공 여부를 업데이트합니다.
            if (!cmd.isSucceeded()) {
                succeeded = false;
            }
        }
    }

    /**
     * 모아진 명령(Command)을 실행한 역순으로 실행하여 되돌린다.
     */
    @Override
    public void undo() {
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }

    /**
     * CompositeCommand 의 성공 여부를 반환한다.
     *
     * @return 모든 명령이 성공했으면 true, 그렇지 않으면 false
     */
    @Override
    public boolean isSucceeded() {
        return false;
    }

}
