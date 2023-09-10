package publication;

import printer.Printer;

public abstract class Publication {
	protected Printer printer;
	
	public Publication(Printer printer) {
		this.printer = printer;
	}
	
	public abstract void print();
}
