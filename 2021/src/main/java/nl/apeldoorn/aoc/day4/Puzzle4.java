package nl.apeldoorn.aoc.day4;

import nl.apeldoorn.aoc.AbstractPuzzle;

import java.util.stream.IntStream;

public class Puzzle4 extends AbstractPuzzle {

	@Override
	public long solveFirst() {
		String[] bingoNumbers = inputLines[0].split(",");
		int[][][] boards = new int[inputLines.length/6][5][5];

		for(int i = 2; i < inputLines.length; i += 6) {
			for(int j = 0; j < 5; j++) {
				for(int k=0; k < 5; k++) {
					boards[i/6][j][k] = Integer.parseInt(inputLines[i+j].trim().split("\\s+")[k]);
				}
			}
		}
		for(int i=0; i < bingoNumbers.length; i++) {
			int bingonumber = Integer.parseInt(bingoNumbers[i]);
			for(int h = 0; h < boards.length; h++) {
				for(int j = 0; j < 5; j++) {
					for(int k=0; k < 5; k++) {
						if (boards[h][j][k] == bingonumber) {
							boards[h][j][k] = -1;
						}
						if (IntStream.of(boards[h][j]).sum() == -5 || boards[h][0][k] + boards[h][1][k] + boards[h][2][k] + boards[h][3][k]+ boards[h][4][k] == -5) {
							return calculateBingo(boards[h], bingonumber);
						}
					}
				}
			}
		}
		return -1;
	}

	private int calculateBingo(int[][] board, int bingonumber) {
		for(int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++) {
				if (board[j][k] == -1) {
					board[j][k] = 0;
				}
			}
		}
		int sum = 0;
		for(int i =0; i<5; i++) {
			sum += IntStream.of(board[i]).sum();
		}
		return sum * bingonumber;
	}

	@Override
	protected long solveSecond() {
		String[] bingoNumbers = inputLines[0].split(",");
		int[][][] boards = new int[inputLines.length/6][5][5];
		boolean[] bingoboards = new boolean[inputLines.length/6];

		for(int i = 2; i < inputLines.length; i += 6) {
			for(int j = 0; j < 5; j++) {
				for(int k=0; k < 5; k++) {
					boards[i/6][j][k] = Integer.parseInt(inputLines[i+j].trim().split("\\s+")[k]);
				}
			}
		}
		for(int i=0; i < bingoNumbers.length; i++) {
			int bingonumber = Integer.parseInt(bingoNumbers[i]);
			for(int h = 0; h < boards.length; h++) {
				for(int j = 0; j < 5; j++) {
					for(int k=0; k < 5; k++) {
						if (boards[h][j][k] == bingonumber) {
							boards[h][j][k] = -1;
						}
						if (IntStream.of(boards[h][j]).sum() == -5 || boards[h][0][k] + boards[h][1][k] + boards[h][2][k] + boards[h][3][k]+ boards[h][4][k] == -5) {
							bingoboards[h] = true;
							if (IntStream.range(0, bingoboards.length).allMatch(bol -> bingoboards[bol])) {
								return calculateBingo(boards[h], bingonumber);
							}
						}
					}
				}
			}
		}
		return -1;
	}

	public static void main(String args[]) {
		new Puzzle4().solve();
	}
}
