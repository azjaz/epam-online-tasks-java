package tasksJava.fundamentals.mainTask;
//task5
// args == 7
public class ChooseMonth {

	public static void main(String[] args) {
			
		if(args.length == 1) {
			
		for(int i = 0; i < args[0].length(); i++) {
			if(!Character.isDigit(args[0].charAt(i))) {
				System.out.println("Should be an Integer!");	
				return;
			}
		}
			int numb = Integer.parseInt(args[0]);
			if(numb > 0 && numb <=12) {
				String month = "";
				switch(Integer.parseInt(args[0])) {
				
				case 1: month = "January";
						break;
				case 2: month = "February";
						break;
				case 3: month = "March";
						break;
				case 4: month = "April";
						break;
				case 5: month = "May";
						break;
				case 6: month = "June";
						break;
				case 7: month = "July";
						break;
				case 8: month = "August";
						break;
				case 9: month = "September";
						break;
				case 10: month = "October";
						break;
				case 11: month = "November";
						break;
				default: month = "December";
				}
				System.out.println(month);
			} else {
				System.out.println("Number in bounds of 1 and 12");
				return;
			}
		
		} else System.out.println("Incorrect input");

		}
}
