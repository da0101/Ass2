// -------------------------------------------------------
// Assignment_2 Question_2
// Written by: Danil Ulmashev 27033389
// For COMP 248 Section EE – Fall 2018
// --------------------------------------------------------
// --------------------------------------------------------
// A simple Java program to welcome the user and calculate 
// the sum of digits of a large integer number as well as 
// providing all possible divisors of the sum of the digits.
// The program is using various loops to prompt the user to
// continue or stop the program; the calculation itself uses
// another loop to separate the large integer number into 
// single digits and then sum them up. After wards the another
// method computes the divisors.
// --------------------------------------------------------
// --------------------------------------------------------

import java.util.Scanner;

public class IntDivisions {

	// Declaring global Scanner object for input.
	private static Scanner input = new Scanner(System.in);

	// Main method
	public static void main(String[] args) {

		

		// Calling method printingMessageWelcome().
		printingMessageWelcome();
		// Activating the loop.
		do {
			// Calling method userInput().
			userInput();
			// Evaluating boolean method shouldRetry() in the loop condition.
		} while (shouldRetry(false));
		input.close();
	}

	// Printing the Welcome message.
	private static void printingMessageWelcome() {
		System.out.println(
				"      Welcome to our Calculation Program!\n" 
			  + "----------------------------------------------\n");
	}

	// Allowing the user to input the number.
	private static void userInput() {
		System.out.print("Enter a number with at most 7-digits: ");
		int num = input.nextInt();
		// Calling method printResults().
		printResults(sumOfDigits(num), num);
	}

	// Boolean method to test if the user wishes to continue the program.
	private static boolean shouldRetry(boolean warning) {
		if (!warning) {
			System.out.println("\n\nDo yo want to try multiply another number?");
		} else {
			System.out.println("Please enter 'yes' or 'no'");
		}
		String answer = input.nextLine();
		if (answer.equalsIgnoreCase("no")) {
			System.out.println("\nThanks and have a great day!");
			return false;
		}
		if (answer.equalsIgnoreCase("yes")) {
			return true;
		}
		return shouldRetry(true);
	}

	// Printing the results of the calculations. 
	private static void printResults(int sum, int input) {
		System.out.println("Sum of the digits of " + input + " is: " + sum + "\n");
		// Calling method printDivisers().
		printDivisors(sum);
	}


	// Printing all divisors of the number.
	private static void printDivisors(int sum) {
		System.out.println("The divisors of " + sum + " are as follows:");
		// Activating the loop to evaluate the number.
		for (int i = 1; i <= sum; i++) {
			if (sum % i == 0) {
				System.out.print(i + " ");
			}
		}
	}


	// Computing the sum of digits in a number.
	private static int sumOfDigits(final int inputNumber) {
		int digit;
		int sum = 0;
		int number = inputNumber;

		// Starting the loop to evaluate the number and computer the sum of digits.
		while (number > 0) {
			digit = number % 10;
			sum += digit;
			number /= 10;
		}
		return sum;
	}
}