package nl.apeldoorn.aoc.day6;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Puzzle6 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		ArrayList<Set<Character>> cleanedLines = new ArrayList<>();
		Set<Character> tempLine = new HashSet<>();
		for(int i=0; i<inputLines.length; i++) {
			tempLine.addAll(inputLines[i].chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
			if (inputLines[i].isEmpty()) {
				cleanedLines.add(tempLine);
				tempLine = new HashSet<>();
			}
		}
		return cleanedLines.stream().flatMap(Collection::stream).count();
	}

	@Override
	protected long solveSecond() {
		ArrayList<Set<Character>> cleanedLines = new ArrayList<>();
		Set<Character> tempLine = new HashSet<>();
		boolean newEntry = true;
		for(int i=0; i<inputLines.length; i++) {
			if (inputLines[i].isEmpty()) {
				cleanedLines.add(tempLine);
				tempLine = new HashSet<>();
				newEntry = true;
			} else {
				if (newEntry) {
					newEntry = false;
					tempLine.addAll(inputLines[i].chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
				} else {
					tempLine.retainAll(inputLines[i].chars().mapToObj(c -> (char) c).collect(Collectors.toList()));
				}
			}
		}
		return cleanedLines.stream().flatMap(Collection::stream).count();
	}

	public static void main(String args[]) {
		new Puzzle6().solve();
	}
}
