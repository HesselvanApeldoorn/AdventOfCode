package nl.apeldoorn.aoc.day3;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.ArrayList;
import java.util.Arrays;

public class Puzzle3 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		int[] common = new int[inputLines[0].length()];
		for (int i = 0; i < inputLines.length; i++) {
			for (int j = 0; j < inputLines[0].length(); j++) {
				common[j] += Character.getNumericValue(inputLines[i].charAt(j));
			}
		}
		String bits = "";
		for (int j =0; j < inputLines[0].length(); j++) {
			 if (common[j] * 2 > inputLines.length) {
				 bits += "1";
			 } else {
				 bits += "0";
			 }
		}
		int gamma = Integer.parseInt(bits, 2);
		int epsilon = Integer.parseInt(bits.replace('0', '2').replace('1', '0').replace('2', '1'), 2);
		return gamma * epsilon;
	}

	@Override
	protected long solveSecond() {
		ArrayList<String> remainder = new java.util.ArrayList<>(Arrays.asList(Arrays.copyOf(inputLines, inputLines.length)));
		for (int j =0; j < inputLines[0].length(); j++) {
			int common = 0;
			for (int i = 0; i < remainder.size(); i++) {
				common += Character.getNumericValue(remainder.get(i).charAt(j));
			}
			final int k = j;
			if (common * 2 >= remainder.size()) {
				remainder.removeIf(number -> number.charAt(k) == '0');
			} else {
				remainder.removeIf(number -> (number.charAt(k) == '1'));
			}
			if (remainder.size() == 1 ) {
				break;
			}
		}
		int oxygen = Integer.parseInt(remainder.get(0), 2);
		remainder = new java.util.ArrayList<>(Arrays.asList(Arrays.copyOf(inputLines, inputLines.length)));
		for (int j =0; j < inputLines[0].length(); j++) {
			int common = 0;
			for (int i = 0; i < remainder.size(); i++) {
				common += Character.getNumericValue(remainder.get(i).charAt(j));
			}
			final int k = j;
			if (common * 2 >= remainder.size()) {
				remainder.removeIf(number -> number.charAt(k) == '1');
			} else {
				remainder.removeIf(number -> (number.charAt(k) == '0'));
			}
			if (remainder.size() == 1 ) {
				break;
			}
		}
		int scrubber = Integer.parseInt(remainder.get(0),2 );
		return oxygen * scrubber;
	}

	public static void main(String args[]) {
		new Puzzle3().solve();
	}
}
