package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Print("gib input: ")
	var input string
	fmt.Scan(&input)
	lastDigit := string(input[len(input)-1])
	sum := 0
	for _, digit := range input {
		digitString := string(digit)
		if digitString == lastDigit {
			number, _ := strconv.Atoi(digitString)
			sum = sum + number
		}
		lastDigit = digitString
	}
	s := fmt.Sprintf("som van gelijke opeenvolgendegetallen %d. ", sum)
	fmt.Println(s)
}