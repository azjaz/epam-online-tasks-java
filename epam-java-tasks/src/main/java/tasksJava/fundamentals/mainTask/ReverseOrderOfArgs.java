package tasksJava.fundamentals.mainTask;
//task2
//args 6 8 90 12
public class ReverseOrderOfArgs {

	public static void main(String[] args) {
		
		if(args.length <= 0) {
			System.out.println("Input arguments");
		} else {
			
		for(int i = args.length-1; i >= 0 ; i--) {
			System.out.print(args[i] + " ");
		}
		System.out.println();
		}	

	}

}
