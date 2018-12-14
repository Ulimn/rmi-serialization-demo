package hu.martinfejes;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DogServiceImpl implements DogService {

	public String sendDogName() throws RemoteException {
		System.out.println("Sending dog's name over.");
		
		return new Dog("Dexter").getName();
	}

	public Dog sendDog() throws RemoteException {
		System.out.println("Sending dog over.");
		
		return new Dog("Dexter");
	}

	public void createStubAndBind() throws RemoteException {

		DogService stub = (DogService) UnicastRemoteObject.exportObject((DogService) this, 0);
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("DogService", stub);
	}
}
