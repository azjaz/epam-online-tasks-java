package tasksJava.fundamentals.mainTask;
//task4
// args == 23 3 8 12
public class ArgsNumbersSumAndTimes {

	public static void main(String[] args) {
		int sum = 0;
		int times = 1;
		if(args.length <= 0) {
			System.out.println("Input arguments");
		} else {
			for(int i = 0; i < args.length; i++) {
				sum += Integer.parseInt(args[i]);
				times *= Integer.parseInt(args[i]);
			}
			System.out.println("Sum is " + sum + " Times is " + times);
		}

	}

}
