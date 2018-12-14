package hu.martinfejes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Dog dog = new Dog("Buksi");
        
        try {
            FileOutputStream fileOut =
            new FileOutputStream("/tmp/dog.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(dog);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/dog.ser");
         } catch (IOException i) {
            i.printStackTrace();
         }
    }
}
