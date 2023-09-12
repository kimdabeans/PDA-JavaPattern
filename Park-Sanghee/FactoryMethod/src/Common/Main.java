package Common;

import Factory.Factory;
import Factory.Doll;
import Doll.TeddyBearFactory;

public class Main {
	public static void main(String[] args) {
		Factory teddyBearFactory = new TeddyBearFactory();
		
		Doll bearTeddy = teddyBearFactory.create("Bear", "Teddy");
		bearTeddy.getName();
		
		System.out.println();
		
		Doll bearLebby = teddyBearFactory.create("Bear", "Lebby");		
		bearLebby.getName();
	}
}
