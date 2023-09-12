package DollProcess;

abstract class DollProcess {
	public abstract void assembleHead();
	public abstract void assembleBody();
	public abstract void assembleArms();
	public abstract void assembleLegs();
	
	public final void createDoll() {
		assembleHead();
		assembleBody();
		
		for (int i = 0; i < 2; i++) {
			assembleArms();
			assembleLegs();
		}
	}
}
