Algoritmo Principal
	Escribir 'Ingresa un número de cinco dígitos'
	Leer number
	Si number>10000 O number<99999 Entonces
		Proceso Palíndromo(number)
		Si Palindromo == Verdadero Entonces
			Escribir number, ' es palíndromo'
		SiNo
			Escribir number, 'No es palíndromo'
		FinSi
	SiNo
		Escribir number, "No es un número válido
	FinSi
FinAlgoritmo

Proceso Palíndromo
	Si (number / 10) == (number mod 10) Y ((number/1000) mod 10) == ((number/10) mod 10)
		Retornar Verdadero
	SiNO
		Retornar Falso
	FinSi
FinProceso