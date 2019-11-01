package tasksJava.thread;

import java.util.concurrent.Semaphore;

public class CarParking {

	public static void main(String[] args) {
		boolean[] parking = new boolean[5];
		
			carParking(parking);

	}
	
	private static void carParking(boolean[] parking) {
		Semaphore gate = new Semaphore(parking.length);
		for(int i = 0; i < 19; i++) {
			new Thread(() -> {
				try {
				boolean nonParked = false;
				int parkingNumber = -1;
				
				if(!gate.tryAcquire()) {
					System.out.println(Thread.currentThread().getName() + " is waiting...");
						Thread.sleep(3000);
						if(!gate.tryAcquire()) {
							nonParked = true;
							System.out.println(Thread.currentThread().getName() + " doesn't park. Leaving the parking...");
					} 
				} 
				
				if(!nonParked) {
					synchronized(parking) {
					for(int j = 0; j < parking.length; j++) {
						if(!parking[j]) {
							parking[j] = true;
							parkingNumber = j;
							System.out.println(Thread.currentThread().getName() + " has parked");
							break;
						}
					}
				}
					
					Thread.sleep(3000);
					synchronized(parking) {		
							parking[parkingNumber] = false;
							gate.release();
							System.out.println(Thread.currentThread().getName() + " has left the parking");
					}
								
				}
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}, "car " + i).start();
			
		}
	}

}
