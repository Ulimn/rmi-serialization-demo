package hu.martinfejes;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class RmiTest 
{
	@BeforeClass
	public static void whenRunServer_thenServerStarts() {
		
		try {
			DogServiceImpl server = new DogServiceImpl();
			server.createStubAndBind();
		} catch (RemoteException e) {
			Assert.fail("Exception Occurred");
		}
	}
	
	@Test
	public void shouldPrintDogsName() {
		try {
			Registry registry = LocateRegistry.getRegistry();	
			DogService server = (DogService) registry.lookup("DogService");			
			String responseMessage = server.sendDogName();		
			
			String expectedMessage = "Dexter";			
			Assert.assertEquals(responseMessage, expectedMessage);
		} catch (RemoteException e) {
			Assert.fail("Remote Exception Occurred");
		} catch (NotBoundException nb) {
			Assert.fail("Exception Occurred");
		}
	}
	
	@Test
	public void shouldPrintDogObject() {
		try {
			Registry registry = LocateRegistry.getRegistry();	
			DogService server = (DogService) registry.lookup("DogService");			
			Dog responseDog = server.sendDog();	
					
			Assert.assertEquals(responseDog.getName(), "Dexter");
		} catch (RemoteException e) {
			Assert.fail("Remote Exception Occurred");
		} catch (NotBoundException nb) {
			Assert.fail("Exception Occurred");
		}
	}
}
