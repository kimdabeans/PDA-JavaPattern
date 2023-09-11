package StateAndSingleton;

public enum StateType {
	NORMAL{
		public State getState(){
			return NormalState.getInstance();
		}
	},
	WARNING{
		public State getState(){
			return WarningState.getInstance();
		}
	},
	DANGER{
		public State getState(){
			return DangerState.getInstance();
		}
	};
	abstract State getState();
}
