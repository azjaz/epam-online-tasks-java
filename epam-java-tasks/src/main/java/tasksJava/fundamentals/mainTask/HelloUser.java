package tasksJava.fundamentals.mainTask;
//task1
// arg = Andy
public class HelloUser {

	public static void main(String[] args) {
		if(args.length == 0) {
			System.out.println("Input your name in cmd!");
		} else {
			String delim = " ";
		System.out.println("Hello, " + String.join(delim, args));
		}
	}
	
}
