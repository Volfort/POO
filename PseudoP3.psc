Algoritmo Main
	Escribir 'Escribe un número de 5 dígitos'
	Leer number
	Si number>1000 O number<99999 Entonces
		Palindromo(number)
		// Evaluar en la función auxiliar
		// Comprobar si retorna True or False
		Si Palindromo(number)==Verdadero Entonces
			Escribir 'El número', number, 'es un palíndromo'
		SiNo
			Escribir 'El número', number, 'no es palíndromo'
		FinSi
	SiNo
		Escribir 'Número no válido'
	FinSi
FinAlgoritmo

Función Palindromo(number)
	// Si pos 1 == pos5
	// Si pos 2 == pos 4
	Si (number MOD 10==(number/10000)) O ((number/10) MOD 10==(number/1000) MOD 10) Entonces
		Escribir Verdadero
	SiNo
		Escribir Falso
	FinSi
FinFunción
