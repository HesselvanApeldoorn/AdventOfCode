package nl.apeldoorn.aoc;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractPuzzle {

	public String[] inputLines;

	protected void solve() {
		getInput("input1.txt");
		System.out.println("answer to first puzzle is: " + solveFirst());
		getInput("input1.txt");
		System.out.println("answer to second puzzle is: " + solveSecond());
	}

	private void getInput(String inputFile) {
		String[] folder = this.getClass().getPackage().getName().split("\\.");
		String inputPath = folder[folder.length-1] +  "/" + inputFile;
		try {
			Path path = Paths.get(this.getClass().getClassLoader()
					.getResource(inputPath).toURI());
			inputLines = Files.lines(path).toArray(String[]::new);
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}

	protected abstract long solveFirst();

	protected abstract long solveSecond();


}
