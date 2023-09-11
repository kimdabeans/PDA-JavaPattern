package StateAndSingleton;

public enum TimeType {
    OPEN_TIME{
        public Time getTime(){
            return OpenTime.getInstance();
        }
    },
    CLOSE_TIME{
        public Time getTime(){
            return CloseTime.getInstance();
        }
    };
    abstract Time getTime();
}
