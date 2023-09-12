package StateAndSingleton;
/**
 * StateTpye enum입니다.
 * 고객 계좌 잔액 상태에 따른 신용도 유형을 정의합니다.
 */
public enum StateType {
	/**
	 * 일반 상태를 나타내는 상태 유형.
	 */
	NORMAL{
		/**
		 * 일반 상태에 해당하는 상태 객체를 반환합니다.
		 *
		 * @return 일반 상태를 처리하는 State 인터페이스 구현체
		 */
		public State getState(){
			return NormalState.getInstance();
		}
	},
	/**
	 * 경고 상태를 나타내는 상태 유형.
	 */
	WARNING {
		/**
		 * 경고 상태에 해당하는 상태 객체를 반환합니다.
		 *
		 * @return 경고 상태를 처리하는 State 인터페이스 구현체
		 */
		public State getState() {
			return WarningState.getInstance();
		}
	},

	/**
	 * 위험 상태를 나타내는 상태 유형.
	 */
	DANGER {
		/**
		 * 위험 상태에 해당하는 상태 객체를 반환합니다.
		 *
		 * @return 위험 상태를 처리하는 State 인터페이스 구현체
		 */
		public State getState() {
			return DangerState.getInstance();
		}
	};

	/**
	 * 해당 상태 유형에 대한 상태 객체를 반환하는 추상 메서드입니다.
	 *
	 * @return 상태 객체 (State 인터페이스 구현체)
	 */
	abstract State getState();
}