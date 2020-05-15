package com.sagar.designpatterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 
 * Example Runtime class, all spring bean are by default singleton
 * 
 * @author sitapsha
 *
 */
public class SingletonDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//breakByReflection(); uncomment code in private construtor.
		
		//breakBySerialization();
		
		Runnable r1 = () -> {
			DbSingleton dbSingleton = DbSingleton.getInstance();
		};
		Runnable r2 = () -> {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbSingleton dbSingleton = DbSingleton.getInstance();
		};

//		new Thread(r1).start();
//		new Thread(r2).start();
		
		
	}

	private static void breakBySerialization() {
		try
        { 
			DbSingleton instance1 = DbSingleton.getInstance(); 
            ObjectOutput out 
                = new ObjectOutputStream(new FileOutputStream("file.text")); 
            out.writeObject(instance1); 
            out.close(); 
      
            // deserailize from file to object 
            ObjectInput in  
                = new ObjectInputStream(new FileInputStream("file.text")); 
              
            DbSingleton instance2 = (DbSingleton) in.readObject(); 
            in.close(); 
      
            System.out.println("instance1 hashCode:- "
                                                 + instance1.hashCode()); 
            System.out.println("instance2 hashCode:- " 
                                                 + instance2.hashCode()); 
        }  
          
        catch (Exception e)  
        { 
            e.printStackTrace(); 
        } 
		
	}

	private static void breakByReflection() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<?>[] cs =DbSingleton.class.getDeclaredConstructors();
		DbSingleton dbSingleton = DbSingleton.getInstance();
		DbSingleton dbSingleton2=null;
		for (Constructor constructor : cs)  
        { 
            // Below code will destroy the singleton pattern 
            constructor.setAccessible(true); 
            dbSingleton2 = (DbSingleton) constructor.newInstance(); 
            break; 
        } 
		
		System.out.println(dbSingleton);
		System.out.println(dbSingleton2);
		
	}
	
	
}

class DbSingleton implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Suppose one thread, Thread-1 is inside synchronized block and it's creating
	 * Singleton instance and assigning reference to _instance variable. In the mean
	 * time, Thread scheduler stops the Thread-1. Now, a second thread, Thread-2
	 * enters and come to 1st check point which is not synchronized, now there is a
	 * possibility that it can see half-initialized _instnace field and return that
	 * to the client, leading to subtle bugs in your program. This issue was fixed
	 * by introducing happens-before guarantee provided by the volatile variable in
	 * Java 1.5. According to this rule, write to a volatile field will happen
	 * before any read, which negates the possibility of seeing half initialized
	 * instance of Singleton class. Read more:
	 * https://www.java67.com/2016/04/why-double-checked-locking-was-broken-before-java5.html#ixzz6MGFbCC4w
	 */
	private static volatile DbSingleton instance = null;

	private DbSingleton() {
		// to safe guard from breaking it using reflection
		if (instance != null) {
			//throw new RuntimeException("Use getInstance()");
		}
	}
	
	// implement readResolve method 
    protected Object readResolve() 
    { 
    	// to safe guard from breaking it in de-serialization
        return instance; 
    } 

	/**
	 * Second check is inside synchronized block and only execute one time during
	 * lifespan of Singleton.<br>
	 * That's why you get the performance boost becuase locking only happen one time
	 * during lifespan of Singleton instance.<br>
	 * 
	 * So if we had made method synchronized then suppose 1 lakh concurrent thread
	 * access getInstance then all will be handled one ata time.
	 * 
	 */
	public static DbSingleton getInstance() {
		if (instance == null) {
			synchronized (DbSingleton.class) {
				if (instance == null) {
					instance = new DbSingleton();
				}
			}
		}
		return instance;
	}

//	public synchronized static DbSingleton getInstance() {
//		if (instance == null) {
//			instance = new DbSingleton();
//		}
//		return instance;
//	}

}
