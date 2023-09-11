package StateAndSingleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
	static int balance = 5000;
	public static void main(String[] args) {
		SafeFrame frame = new SafeFrame("주식 트레이딩 시스템");
		Map<Integer, StateType> balanceMap = new HashMap<>();
		Map<Integer, TimeType> timeMap = new HashMap<>();
		int stock = 5000;

		initTimeMap(timeMap);
		initBalanceMap(balanceMap);

		while(true) {
			for(int i = 0; i < 25; i++) {
				frame.setInfo(i, timeMap.get(i), balanceMap.get(balance), stock);
				frame.setTimeType(timeMap.get(i));
				if(timeMap.get(i) == TimeType.OPEN_TIME) {
					stock += new Random().nextInt((1000 - (-1000)) / 1000 + 1) * 1000 - 1000;
				}
				try {
					Thread.sleep(1000);
				}
				catch(InterruptedException e){}
			}
		}
	}

	private static void initBalanceMap(Map<Integer, StateType> balanceMap) {
		for(int i = 0; i < 100000; i += 1000) {
			if (i <= 1000)
				balanceMap.put(i, StateType.DANGER);
			else if (1000 < i && i <= 3000)
				balanceMap.put(i, StateType.WARNING);
			else
				balanceMap.put(i, StateType.NORMAL);
		}
	}

	private static void initTimeMap(Map<Integer, TimeType> timeMap) {
		for (int i = 0; i < 25; i++) {
			if(7 < i && i < 17)
				timeMap.put(i, TimeType.OPEN_TIME);
			else
				timeMap.put(i, TimeType.CLOSE_TIME);
		}
	}

}
