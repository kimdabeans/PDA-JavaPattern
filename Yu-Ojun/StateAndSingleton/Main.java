package StateAndSingleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static StateAndSingleton.Utility.*;
/**
 * 주식 트레이딩 시스템을 시뮬레이션하는 것을 구현한 State 패턴과 Singleton 패턴을 사용하는 서비스의 메인 클래스입니다.
 */
public class Main {
	public static void main(String[] args) {
		SafeFrame frame = new SafeFrame("주식 트레이딩 시스템");
		Map<Integer, StateType> balanceMap = new HashMap<>();
		Map<Integer, TimeType> timeMap = new HashMap<>();
		int stock = 5000;

		timeMap = initTimeMap(timeMap, 8, 16);
		balanceMap = initBalanceMap(balanceMap);

		for(int i : timeMap.keySet()){
			System.out.println(i + " " + timeMap.get(i));
		}
		while(true) {
			for(int i = 0; i < 25; i++) {
				frame.setInfo(i, timeMap.get(i), balanceMap.get(balance), stock);
				if(timeMap.get(i) == TimeType.OPEN_TIME) {
					stock += new Random().nextInt((1000 - (-1000)) / 500 + 1) * 500 - 1000;
				}
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e){}
			}
		}
	}
}
