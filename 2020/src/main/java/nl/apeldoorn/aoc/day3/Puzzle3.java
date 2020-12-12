package nl.apeldoorn.aoc.day3;

import nl.apeldoorn.aoc.AbstractPuzzle;

public class Puzzle3 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		long trees = 0;
		boolean [][]forest = new boolean[1000][1000];
		for(int i=0; i<inputLines.length; i++) {
			boolean []treeline = new boolean[100];
			for(int j=0; j<inputLines[i].length(); j++) {
				treeline[j] = inputLines[i].charAt(j) == '#';
			}
			forest[i] = treeline;
		}
		int x = 0,y = 0;
		while (y < inputLines.length) {
			trees += forest[y][x] ? 1 : 0;
			x += 3;
			y += 1;
			while (x >= inputLines[0].length()) {
				x -= inputLines[0].length();
			}
		}
		return trees;
	}

	@Override
	protected long solveSecond() {
		int directionsX[] = {1,3,5,7,1};
		int directionsY[] = {1,1,1,1,2};
		long totalTrees = 1;
		for(int a = 0; a < directionsX.length; a++) {
			int trees = 0;
			boolean [][]forest = new boolean[1000][1000];
			for (int i = 0; i < inputLines.length; i++) {
				boolean[] treeline = new boolean[100];
				for (int j = 0; j < inputLines[i].length(); j++) {
					treeline[j] = inputLines[i].charAt(j) == '#';
				}
				forest[i] = treeline;
			}
			int x = 0, y = 0;
			while (y < inputLines.length) {
				trees += forest[y][x] ? 1 : 0;
				x += directionsX[a];
				y += directionsY[a];
				while (x >= inputLines[0].length()) {
					x -= inputLines[0].length();
				}
			}
			totalTrees *= trees;
		}
		return totalTrees;
	}

	public static void main(String args[]) {
		new Puzzle3().solve();
	}
}
