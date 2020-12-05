package main

import (
	"fmt"
	"math"
)
func main() {
	fmt.Print("gib input: ")
	var input int
	fmt.Scan(&input)
	i := 1
	for i * i < input {
		i = i + 2
	}
	ringIndex := i / 2
	s := fmt.Sprintf("Aantal stappen naar binnen: %d. ", ringIndex)
	fmt.Println(s)
	zuid := i*i-ringIndex
	west := i*i-3*ringIndex
	noord := i*i-5*ringIndex
	oost := i*i-7*ringIndex
	s2 := fmt.Sprintf("Dichtsbijzijnde in zelfde ring: %d, %d, %d, %d", zuid, west, noord, oost)
	fmt.Println(s2)
	dichtsbijzijnde := math.MaxUint32
	for j:=0; j<4; j++ {
		if math.Abs(float64(input - (i*i-j*2*ringIndex-ringIndex))) < float64(dichtsbijzijnde) {
			dichtsbijzijnde =  int(math.Abs(float64(input - (i*i-j*2*ringIndex-ringIndex))))
		}
	}
	s3 := fmt.Sprintf("Dichtsbijzijnde: %d", dichtsbijzijnde)
	fmt.Println(s3)
	aantalStappen := ringIndex + dichtsbijzijnde
	s4 := fmt.Sprintf("Aantal stappen: %d", aantalStappen)
	fmt.Println(s4)
}