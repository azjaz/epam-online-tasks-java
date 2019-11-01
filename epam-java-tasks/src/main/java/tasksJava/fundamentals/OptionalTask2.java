package tasksJava.fundamentals;
/*
 * Java Fundamentals Optional Task2
 * # 3
 * arg == 4
 */
import java.util.Random;

public class OptionalTask2 {

	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Input correct int number");
		}
		int size = Integer.parseInt(args[0]);
		Random rand = new Random();
		int[][] matrix = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				matrix[i][j] = rand.nextInt(20) - 10;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		matrixCount(matrix, size);

	}
	
	public static void matrixCount(int[][] matrix, int size) {
		int first;
		int second;
		int sum = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(matrix[i][j] > 0) {
					if(j < size) {
					first = j;
					second = first+1;
						while(second < size) {
							if(matrix[i][second] > 0) {
								j = second-1;
								for(int k = first+1; k < second; k++) {
									sum += matrix[i][k];
								}
								System.out.println("Sum is " + sum);
								sum = 0;
								break;
							}
							second++;
						}
					
					}
					
				}
				}
			}
		
	}

}
