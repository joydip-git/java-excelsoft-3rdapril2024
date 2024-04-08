import java.util.Arrays;
import java.util.Scanner;

public class App {

	static int getValue(String message, Scanner scanner) {
		System.out.print(message);
		return scanner.nextInt();
	}

	private static int[][] saveValuesInMatrixArray(Scanner scanner, int rowCount, int elementCount) {
		int[][] matrixArray = new int[rowCount][elementCount];
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			for (int elementIndex = 0; elementIndex < elementCount; elementIndex++) {
				int value = getValue("enter value at matrixArray[" + rowIndex + "][" + elementIndex + "]: ", scanner);
				matrixArray[rowIndex][elementIndex] = value;
			}
			System.out.println("\n");
		}
		return matrixArray;
	}

	static int[] arrangeElementsInArray(int[][] matrixArray, int rowCount, int elementCount) {
		//copying all elements from matrix array to a single dimensional array
		int[] temporary = new int[matrixArray.length * matrixArray.length];
		int index = 0;
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < elementCount; j++) {
				temporary[index] = matrixArray[i][j];
				index++;
			}
		}
		//sorting the elements
		Arrays.sort(temporary);

		//arranging the elements from the temporary into a new single dimensional array
		int[] result = new int[temporary.length];
		int midPosition = temporary.length / 2;
		result[midPosition] = temporary[0];

		int leftIndex = midPosition - 1;
		int rightIndex = midPosition + 1;

		for (int i = 1; i < temporary.length; i++) {
			if (i % 2 != 0) {
				result[rightIndex] = temporary[i];
				rightIndex++;
			} else {
				result[leftIndex] = temporary[i];
				leftIndex--;
			}
		}
		return result;
	}

	static void printValues(int[] array) {
		for (int element : array) {
			System.out.print(element + "\t");
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int rowCount = getValue("no of rows", scanner);
		int elementCount = getValue("no of element per row", scanner);

		int[][] matrixArray = saveValuesInMatrixArray(scanner, rowCount, elementCount);
		int[] resultant = arrangeElementsInArray(matrixArray, rowCount, elementCount);
		printValues(resultant);
		scanner.close();
	}

}
