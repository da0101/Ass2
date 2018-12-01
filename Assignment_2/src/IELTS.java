// -------------------------------------------------------
// Assignment_2 Question_1
// Written by: Danil Ulmashev 27033389
// For COMP 248 Section EE – Fall 2018
// --------------------------------------------------------
// --------------------------------------------------------
// A simple Java program to welcome the user and evaluate
// the Language Proficiency. The program welcomes the user 
// and allows to enter the scores for each appropriate test. 
// Afterwards the program calculates the average and outputs
// the the decision based on the calculation of the scores. 
// The program uses several nested if statements with precise 
// conditions while evaluating the scores of the user.  
// --------------------------------------------------------
// --------------------------------------------------------

import java.util.Scanner;

public class IELTS {

	// Main method.
	public static void main(String[] args) {
		// calling method printMessageWelcome().
		printMessageWelcome();
		// calling method usersChoice();
		usersChoice();
	}
	
	// Printing welcoming message for user.
	private static void printMessageWelcome() {
		System.out.println("-------****-------****-------****-------****-----****-----\n"
				         + "      Welcome to Concordia Language Proficiency Evaluator!\n"
				         + "              based on IELTS exam\n"
				         + "-------****-------****-------****-------****-----****-----\n");
		System.out.println("Here are the available options:\n"
				         + "       1 – Language Proficiency Requirements for the Applicant\n"
				         + "       2 – Evaluation of your language proficiency \n");
	}
	
	// Allowing user to choose from the menu options.
	private static void usersChoice() {
		System.out.print("Please enter the digit corresponding to your case: ");
		Scanner input = new Scanner(System.in);
		// Starting the loop and evaluating the input for options.
		while (true) {
			switch (input.nextInt()) {
			case 1:
				printRequirements();
				input.close();
				return;
			case 2:
				calculatingScores();
				input.close();
				return;
			}
			System.out.println("Please enter either 1 or 2 to make your choice.\n");
		}
	}
	
	// Printing the message with the requirements.
	private static void printRequirements() {
		System.out.println("- The overall score of IELTS exam of applicants needs to be equal or above 6.5 and the scores\n"
		         + "for writing and reading skills should not be below 6.0. If your overall score is 6, and your\n"
		         + "reading and writing scores are at least 6, you will be eligible for conditional admission. So\n"
		         + "you need to take an English course in the first semester. Otherwise you have to retake the IELTS\n"
		         + "exam.\n"
		         + "Thanks for choosing Concordia.\n");
	}
	
	// Calculating the scores of the tests.
	public static void calculatingScores() {
		// initializing the string array for types of scores.
		String[] scoreTypes = {"Listening Score", "Speaking Score", "Reading Score", "Writing Score"};
		// initializing float array to store the data for each score type.
		float[] scoreValues = new float[scoreTypes.length];
		float overAllScore = 0;
		Scanner input = new Scanner(System.in);
		// Starting the loop to allow the user to enter all score values and calculating the sum.
		for (int i = 0; i < scoreValues.length; i++) {
			System.out.print("Please enter your " + scoreTypes[i] + ": ");
			scoreValues[i] = input.nextFloat();
			overAllScore += scoreValues[i];
		    System.out.println();
		}
		input.close();	
		// Calculating the average of all scores.
		float average = overAllScore / scoreValues.length;
		// calling method printresult() to display all of the results.
		printresult(roundedNumber(average), scoreValues[2], scoreValues[3]);
	}
	
	// rounding the numbers to the nearest integer or half.
	private static float roundedNumber(float averageResult) {
		int wholeNumber = (int)averageResult;
		float decimalNumber = averageResult - wholeNumber;
		if (decimalNumber < 0.25) {
			return wholeNumber;
		}
		else if (decimalNumber < 0.75) {
			return (float)(wholeNumber + 0.5);
		}
		return (float)(wholeNumber + 1);
	}
	
	// Printing the results of the scores calculations.
	private static void printresult(float averageResult, float readingScore, float writingScore) {
		System.out.println("	Your overall score is: " + averageResult);
		System.out.println("	Your reading score is: " + readingScore);
		System.out.println("	Your writing score is: " + writingScore + "\n");
		if (averageResult >= 6.5) {
			if (readingScore >= 6.0 && writingScore >= 6.0) {
				System.out.println("	Congratulations: You are eligible for Admission.");
			}
			else {
				System.out.println("	You are eligible for Conditional Admission.");
			}	
		}
		else if (averageResult == 6.0) {
			if (readingScore >= 6.0 && writingScore >= 6.0) {
				System.out.println("You are eligible for Conditional Admission and have to take an English class.");
			}
			else {
				System.out.println("Sorry, you have to retake the exam.");
			}
		}
		else {
			System.out.println("Sorry, you have to retake the exam.");
		}
	}
}
