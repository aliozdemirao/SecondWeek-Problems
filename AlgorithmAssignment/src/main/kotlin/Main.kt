package org.example

import java.util.*

fun main() {
    var isFirstRun = true
    while (true) {
        if (isFirstRun) {
            showWelcomeMessage()
            isFirstRun = false
        }
        val firstNumber = getNumberFromUser("Enter the first number:")
        val operation = getOperationFromUser("Enter the operation you want to perform (+, -, *, /):")
        val secondNumber = getNumberFromUser("Enter the second number:")
        try {
            val result = performOperation(firstNumber, secondNumber, operation)
            println("Result: $firstNumber $operation $secondNumber = $result")
        } catch (e: ArithmeticException) {
            println("Error: ${e.message}")
        }

        println("Do you want to continue? (Press 'y' for Yes, any other key for No)")
        val continueChoice = readlnOrNull()?.lowercase(Locale.getDefault())
        if (continueChoice != "y") break
    }
}

fun showWelcomeMessage() {
    println("*********************************")
    println("Welcome!")
    println("With this program, you can perform basic mathematical operations on two numbers.")
    println("*********************************")
}

fun getNumberFromUser(prompt: String): Double {
    while (true) {
        print("$prompt ")
        val input = readlnOrNull()
        try {
            return input?.toDouble() ?: throw NumberFormatException("Invalid input")
        } catch (e: NumberFormatException) {
            println("Please enter a valid number.")
        }
    }
}

fun getOperationFromUser(prompt: String): Char {
    val validOperations = setOf('+', '-', '*', '/')
    while (true) {
        print("$prompt ")
        val input = readlnOrNull()
        if (!input.isNullOrEmpty() && input[0] in validOperations) {
            return input[0]
        } else {
            println("Invalid operation character. Please enter +, -, * or /.")
        }
    }
}

fun performOperation(num1: Double, num2: Double, operation: Char): Double {
    return when (operation) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> {
            if (num2 == 0.0) throw ArithmeticException("Division by zero error")
            num1 / num2
        }
        else -> throw IllegalArgumentException("Invalid operation")
    }
}