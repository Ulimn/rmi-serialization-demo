package hu.martinfejes;

import java.io.Serializable;

/*
 * #break-rmi
 * 
 * Remove the "extends Animal" part to break the RMI
 */
public class Dog extends Animal implements Serializable
{
	private static final long serialVersionUID = -6783971179417150931L;

	private String name;
	
//	private Dog() {
//		
//	}
	
	public Dog(String name) {
		super(4); // SUPERCLASS CONSTRUCTOR CALLED HERE (#break-rmi)
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}