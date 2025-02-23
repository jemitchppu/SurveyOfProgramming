package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	fmt.Println("What is your favorite NFL Team?")
	in := bufio.NewReader(os.Stdin)
	s, _ := in.ReadString('\n')
	s = strings.TrimSpace(s)
	s = strings.ToUpper(s)

	fmt.Println("Who are the " + s + " biggest rival?")
	r, _ := in.ReadString('\n')
	r = strings.TrimSpace(r)
	r = strings.ToUpper(r)

	fmt.Println("What is Hometown NFL Team?")
	h, _ := in.ReadString('\n')
	h = strings.TrimSpace(h)
	h = strings.ToUpper(h)

	fmt.Println("Who are the " + h + " biggest rival?")
	j, _ := in.ReadString('\n')
	j = strings.TrimSpace(j)
	j = strings.ToUpper(j)

	fmt.Println(s + " are your favorite team!")
	fmt.Println(r + " are the " + s + " biggest rival!")
	fmt.Println(h + " are your hometown team!")
	fmt.Println(j + " are the " + h + " biggest rival!")
}
