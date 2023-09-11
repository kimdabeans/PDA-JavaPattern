import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//게임 프레임 클래스 정의
public class BirdGameFrame extends Frame implements ActionListener, GameContext {
 private Button buttonStart = new Button("게임 시작");   // 게임 시작 버튼
 private Button buttonPause = new Button("일시정지");   // 일시정지 버튼
 private Button buttonResume = new Button("재개");       // 재개 버튼
 private Button buttonGameOver = new Button("게임 종료"); // 게임 종료 버튼

 private GameState state = new PlayingState();           // 현재 게임 상태

 // 생성자
 public BirdGameFrame(String title) {
     super(title);
     setBackground(Color.lightGray);
     setLayout(new FlowLayout());

     // 버튼 추가
     add(buttonStart);
     add(buttonPause);
     add(buttonResume);
     add(buttonGameOver);

     // 리스너 설정
     buttonStart.addActionListener(this);
     buttonPause.addActionListener(this);
     buttonResume.addActionListener(this);
     buttonGameOver.addActionListener(this);

     // 표시
     pack();
     setVisible(true);
 }

 // 버튼이 눌리면 여기로 온다
 @Override
 public void actionPerformed(ActionEvent e) {
     if (e.getSource() == buttonStart) {
         state.start(this);
     } else if (e.getSource() == buttonPause) {
         state.pause(this);
     } else if (e.getSource() == buttonResume) {
         state.resume(this);
     } else if (e.getSource() == buttonGameOver) {
         state.gameOver(this);
     } else {
         System.out.println("?");
     }
 }

 // 게임 컨텍스트 메서드 구현

 @Override
 public void setState(GameState state) {
     this.state = state;
 }

 @Override
 public void startGame() {
     System.out.println("게임이 시작되었습니다.");
 }

 @Override
 public void pauseGame() {
     System.out.println("게임이 일시정지 상태입니다.");
 }

 @Override
 public void resumeGame() {
     System.out.println("게임이 재개되었습니다.");
 }

 @Override
 public void gameOver() {
     System.out.println("게임이 종료되었습니다.");
 }

 public static void main(String[] args) {
     BirdGameFrame frame = new BirdGameFrame("게임 예제");
 }
}