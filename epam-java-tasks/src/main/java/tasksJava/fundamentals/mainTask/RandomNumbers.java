package tasksJava.fundamentals.mainTask;
//task3
//args 3 5 99 45
public class RandomNumbers {

	public static void main(String[] args) {
		
		if(args.length == 0)
			System.out.println("Input numbers");
		else {
			for(int i = 0; i < args.length; i++) {
				System.out.print(args[i] + " ");
			}
			System.out.println();
			
			for(int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}
			
		}

	}

}
