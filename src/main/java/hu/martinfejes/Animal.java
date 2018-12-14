package hu.martinfejes;

public class Animal 
{
	/* #break-rmi
 	 * 
	 * Remove this to break the RMI serialization
	 */
	public Animal() {
		this.legs = 4;
	}
	
	public Animal(int legs) {
		this.legs = legs;
	}
	
	private int legs;

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}
	
	
}
