package StateAndSingleton;

import java.util.HashMap;
import java.util.Map;
/**
 * Utility 클래스입니다.
 * 주식 거래 시스템을 위한 기초 설정을 위한 유틸리티 클래스입니다.
 */
public class Utility {
    /** 잔고를 나타내는 staic 변수 */
    public static int balance = 5000;
    /**
     * 시간에 따라 개장, 마감 상태를 다루는 map을 초기화하고 반환하는 메서드입니다.
     *
     * @param timeMap   초기화할 시간 맵
     * @param openTime  오픈 시간
     * @param closeTime 클로즈 시간
     * @return 초기화된 시간 맵
     */
    public static Map initTimeMap(Map<Integer, TimeType> timeMap, int openTime, int closeTime){
        for (int i = 0; i < 25; i++) {
            if(openTime <= i && i <= closeTime)
                timeMap.put(i, TimeType.OPEN_TIME);
            else
                timeMap.put(i, TimeType.CLOSE_TIME);
        }
        return timeMap;
    }
    /**
     * 잔고 상태에 따라 해당 고객의 신용도 위험 상태가 어떤지를 다루는 map을 초기화하고 반환하는 메서드입니다.
     *
     * @param balanceMap 초기화할 잔고 맵
     * @return 초기화된 잔고 맵
     */
    public static Map initBalanceMap(Map<Integer, StateType> balanceMap){
        for(int i = 0; i < 100000; i += 500) {
            if (i <= 1000)
                balanceMap.put(i, StateType.DANGER);
            else if (1000 < i && i <= 3000)
                balanceMap.put(i, StateType.WARNING);
            else
                balanceMap.put(i, StateType.NORMAL);
        }
        return balanceMap;
    }
}
