package nl.apeldoorn.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractPuzzle {

	public int[] inputLines;

	protected void solve() {
		getInput("input1.txt");
		System.out.println("answer to first Puzzle is: " + solveFirst());
		getInput("input2.txt");
		System.out.println("answer to second Puzzle is: " + solveSecond());
	}

	private void getInput(String inputFile) {
		String[] folder = this.getClass().getPackage().getName().split("\\.");
		String inputPath = folder[folder.length-1] +  "/" + inputFile;
		try {
			Path path = Paths.get(this.getClass().getClassLoader()
					.getResource(inputPath).toURI());
			inputLines = Files.lines(path).map(s -> Integer.parseInt(s)).mapToInt(i -> i).toArray();
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}

	protected abstract int solveFirst();

	protected abstract int solveSecond();


}
