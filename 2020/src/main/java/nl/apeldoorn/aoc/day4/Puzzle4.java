package nl.apeldoorn.aoc.day4;

import lombok.NoArgsConstructor;
import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

@NoArgsConstructor
public class Puzzle4 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		long valid = 0;
		ArrayList<String> cleanedLines = new ArrayList<>();
		String tempLine = "";
		for(int i=0; i<inputLines.length; i++) {
			tempLine = tempLine.concat(inputLines[i] + " ");
			if (inputLines[i].isEmpty()) {
				cleanedLines.add(tempLine);
				tempLine = "";
			}
		}
		valid = cleanedLines.stream().filter(inputLine ->
				Arrays.stream(inputLine.split(" ")).filter(field -> !(field.startsWith("cid:"))).count() == 7).count();
		return valid;
	}

	@Override
	protected long solveSecond() {
		long valid;
		ArrayList<String> cleanedLines = new ArrayList<>();
		String tempLine = "";
		for(int i=0; i<inputLines.length; i++) {
			tempLine = tempLine.concat(inputLines[i] + " ");
			if (inputLines[i].isEmpty()) {
				cleanedLines.add(tempLine);
				tempLine = "";
			}
		}
		valid = cleanedLines.stream().filter(inputLine ->
				Arrays.stream(inputLine.split(" "))
						.filter(field -> !(field.startsWith("cid:")))
						.filter(this::isvalid)
						.count() == 7).count();
		return valid;
	}

	private boolean isvalid(String field) {
		try {
			String key = field.split(":")[0];
			String value = field.split(":")[1];
			if (key.equals("byr")) {
				return Integer.parseInt(value) >= 1920 && Integer.parseInt(value) <= 2002;
			} else if (key.equals("iyr")) {
				return Integer.parseInt(value) >= 2010 && Integer.parseInt(value) <= 2020;
			} else if (key.equals("eyr")) {
				return Integer.parseInt(value) >= 2020 && Integer.parseInt(value) <= 2030;
			} else if (key.equals("hgt")) {
				if (value.endsWith("cm")) {
					int parsedValue = Integer.parseInt(value.split("cm")[0]);
					return parsedValue >= 150 && parsedValue <= 193;
				} else if (value.endsWith("in")){
					int parsedValue = Integer.parseInt(value.split("in")[0]);
					return parsedValue >= 59 && parsedValue <= 76;
				}
			} else if (key.equals("hcl")) {
				return Pattern.compile("#[0-9a-f]{6}").matcher(value).matches();
			} else if (key.equals("ecl")) {
				String[] eyeColors = {"amb","blu", "brn", "gry", "grn", "hzl", "oth"};
				return Arrays.asList(eyeColors).contains(value);
			} else if (key.equals("pid")) {
				return Pattern.compile("[0-9]{9}").matcher(value).matches();
			}
		} catch (Exception e) {
		}
		return false;
	}

	public static void main(String args[]) {
		new Puzzle4().solve();
	}
}
