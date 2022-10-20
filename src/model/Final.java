package model;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Final {
	protected static final int[] RED = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
	protected static final int[] BLACK = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };
	protected static ArrayList<Integer> group1_1to12 = new ArrayList<Integer>();
	protected static ArrayList<Integer> group2_13to24 = new ArrayList<Integer>();
	protected static ArrayList<Integer> group3_25to36 = new ArrayList<Integer>();
	protected static ArrayList<Integer> resultInRed = new ArrayList<Integer>();
	protected static ArrayList<Integer> resultInBlack = new ArrayList<Integer>();
	protected static ArrayList<Integer> result_1to18 = new ArrayList<Integer>();
	protected static ArrayList<Integer> result_19to36 = new ArrayList<Integer>();
	private static ArrayList<Row> table = new ArrayList<Row>();
	private static Row row;
	private static ArrayList<Integer> numbers = new ArrayList<Integer>();

	public static void main(String args[]) {
		readTxt();
		
		for (int i = 0; i < 37; i++) {
			try {
				row = new Row(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
				ArrayList<Integer> result = count(numbers, i);
				row.setNumber(i);

				clasify(result);

				redOrBlack(result);

				calculatePercentage(result.size());

				printRedAndBlackPercentage(result.size());

				clasifyEvenAndOdd(result);

				finalClasification(result);
				printLastClasification(result.size());

				table.add(row);

				resultInRed = new ArrayList<Integer>();
				resultInBlack = new ArrayList<Integer>();
				result_1to18 = new ArrayList<Integer>();
				result_19to36 = new ArrayList<Integer>();
			} catch (Exception e) {
			}
		}
		print();
		
		//System.out.println(numbers);
	}

	public static void print() {
		System.out.printf(
				"----------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("|\t\t\t\t\t\t\tREPORT\t\t\t\t\t\t\t     |%n");
		System.out.printf(
				"----------------------------------------------------------------------------------------------------------------------%n");

		System.out.printf("| %6s | %8s | %8s | %8s | %8s | %8s | %8s | %8s | %8s | %8s | %6s | %n", "NUMERO",
				"DOCENA 1", "DOCENA 2", "DOCENA 3", "ROJO", "NEGRO", "PAR", "IMPAR", "1 AL 18", "19 AL 36", "NUMERO");
		System.out.printf(
				"----------------------------------------------------------------------------------------------------------------------%n");

		for (int i = 0; i < table.size(); i++) {
			System.out.printf(
					"| %6s | %8.0f | %8.0f | %8.0f | %8.0f | %8.0f | %8.0f | %8.0f | %8.0f | %8.0f | %6s | %n",
					table.get(i).getNumber(), table.get(i).getDozen1(), table.get(i).getDozen2(),
					table.get(i).getDozen3(), table.get(i).getRed(), table.get(i).getBlack(), table.get(i).getEven(),
					table.get(i).getOdd(), table.get(i).getT1to18(), table.get(i).getT19to36(),
					table.get(i).getNumber());
		}

		System.out.printf(
				"----------------------------------------------------------------------------------------------------------------------%n");
	}

	protected static ArrayList<Integer> count(ArrayList<Integer> array, int num) {
		ArrayList<Integer> resultTmp = new ArrayList<Integer>();
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) == num) {
				try {
					resultTmp.add(array.get(i + 1));
				} catch (Exception e) {
				}
			}
		}
		return resultTmp;
	}

	protected static void clasify(ArrayList<Integer> result) {
		group1_1to12 = new ArrayList<Integer>();
		group2_13to24 = new ArrayList<Integer>();
		group3_25to36 = new ArrayList<Integer>();

		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) >= 1 && result.get(i) <= 12) {
				group1_1to12.add(result.get(i));
			} else if (result.get(i) >= 13 && result.get(i) <= 24) {
				group2_13to24.add(result.get(i));
			} else if (result.get(i) >= 25 && result.get(i) <= 36) {
				group3_25to36.add(result.get(i));
			}
		}
	}

	protected static void redOrBlack(ArrayList<Integer> result) {
		for (int i = 0; i < result.size(); i++) {
			if (search(RED, result.get(i))) {
				resultInRed.add(result.get(i));
			} else if (search(BLACK, result.get(i))) {
				resultInBlack.add(result.get(i));
			}
		}
	}

	protected static boolean search(int[] array, int num) {
		boolean tmp = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == num) {
				tmp = true;
			}
		}
		return tmp;
	}

	protected static void calculatePercentage(int result) {
		int group1to12 = group1_1to12.size();
		int group13to24 = group2_13to24.size();
		int group25to36 = group3_25to36.size();

		double tmpPercentageGroup1 = (double) 100 * group1to12 / result;
		double tmpPercentageGroup2 = (double) 100 * group13to24 / result;
		double tmpPercentageGroup3 = (double) 100 * group25to36 / result;

		row.setDozen1(tmpPercentageGroup1);
		row.setDozen2(tmpPercentageGroup2);
		row.setDozen3(tmpPercentageGroup3);
	}

	protected static void printRedAndBlackPercentage(int total) {
		int tmpRed = resultInRed.size();
		int tmpBlack = resultInBlack.size();

		double red = (double) 100 * tmpRed / total;
		double black = (double) 100 * tmpBlack / total;

		row.setRed(red);
		row.setBlack(black);
	}

	protected static void finalClasification(ArrayList<Integer> result) {
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) >= 1 && result.get(i) <= 18) {
				result_1to18.add(result.get(i));
			} else if (result.get(i) >= 19 && result.get(i) <= 36) {
				result_19to36.add(result.get(i));
			}
		}
	}

	protected static void printLastClasification(int total) {
		int tmp1to18 = result_1to18.size();
		int tmp19to36 = result_19to36.size();

		double final1to18 = (double) 100 * tmp1to18 / total;
		double final19to36 = (double) 100 * tmp19to36 / total;

		row.setT1to18(final1to18);
		row.setT19to36(final19to36);
	}

	protected static boolean itsEven(int number) {
		return number % 2 == 0;
	}

	protected static void clasifyEvenAndOdd(ArrayList<Integer> result) {
		int even = 0;
		int odd = 0;

		for (int i = 0; i < result.size(); i++) {
			if (result.get(i) != 0) {
				if (itsEven(result.get(i))) {
					even++;
				} else {
					odd++;
				}
			}
		}

		double evenPercentage = (double) 100 * even / result.size();
		double oddPercentage = (double) 100 * odd / result.size();

		row.setEven(evenPercentage);
		row.setOdd(oddPercentage);
	}

	protected static void readTxt() {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(new File("numbers.txt")));

			String linea;
			while ((linea = br.readLine()) != null) {
				numbers.add(Integer.parseInt(linea));
			}
		} catch (Exception e) {}
	}
}
