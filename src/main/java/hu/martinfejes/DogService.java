package hu.martinfejes;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DogService extends Remote
{
	public String sendDogName() throws RemoteException;
	public Dog sendDog() throws RemoteException;
}
