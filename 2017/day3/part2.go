package main

import (
	"fmt"
)

 var array = make([][]int, 1000)
func main() {
	fmt.Print("gib input: ")
	var input int
	fmt.Scan(&input)
	for i := range array {
		array[i] = make([]int, 1000)
	}
	answer := fillArray(input)
	s := fmt.Sprintf("Eerste cijfer hoger dan input: %d. ", answer)
	fmt.Println(s)
}
func fillArray(input int)(int) {
	startx := 500
	starty := 500
	array[startx][starty] = 1
	x := startx
	y := starty
	for (array[x][y] < input) {
		x, y = determineDirection(startx, starty, x, y)
		fillNext(x, y)
	}
	return array[x][y]

}
func determineDirection(startx int, starty int, x int, y int)(int, int) {
	if x <= startx && y >= starty {
		if array[x+1][y] == 0 {
			x = x + 1
		} else {
			y = y + 1
		}
	} else if x <= startx && y <= starty {
		if array[x][y+1] == 0 {
			y = y + 1
		} else {
			x = x - 1
		}
	} else if x >= startx && y <= starty {
		if array[x-1][y] == 0 {
			x = x - 1
		} else {
			y = y - 1
		}
	} else if x >= startx && y >= starty {
		if array[x][y-1] == 0 {
			y = y - 1
		} else {
			x = x + 1
		}
	}
	return x, y
}
func fillNext(x int, y int) {
	array[x][y] = array[x-1][y] + array[x+1][y] + array[x][y-1] +  array[x-1][y-1] +  array[x+1][y-1] +  array[x-1][y + 1] +  array[x][y + 1] +  array[x+1][y + 1]
	s := fmt.Sprintf("Volgende cijfer gevuld: %d. ", array[x][y])
	fmt.Println(s)
	}
