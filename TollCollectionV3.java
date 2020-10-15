/* Toll CollectionV3 Assignment
 * This program computes the toll rate for each passing vehicle, the total toll
 * for each booth, the total tolls for all the booths, and the total tolls for each 
 * payment type. It writes the totals to a file and then reads from that file to output a report.
 * author Rachel Matthews
 */

package TollCollectionV3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TollCollectionV3 {
	
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		// Variables to keep track of totals
		double tollRateTotal = 0, totalCredit = 0, totalCash = 0, totalES = 0, totalAllBooths = 0;
		double boothTotal = (double) 0;

		// Greeting to the user
		System.out.println("***** Welcome to the Toll Booth Data Collection! ***********");
		System.out.println("If you would like to start the program press 1: ");
		int answer = keyboard.nextInt();

		// Loop that controls the program flow
		while (answer == 1) {

			// Gets number of toll booths from user
			System.out.println("Please enter the amount of Toll Booths: ");
			int amountOfBooths = keyboard.nextInt();

			// Loop that keeps track of toll booths
			for (int i = 0; i < amountOfBooths; i++) {
				int displayArray;
				displayArray = i + 1;
				boothTotal = boothTotal * 0;

				// Gets user input about the number of vehicles using a booth
				System.out.println("Please enter the number of vehicles entering Booth " + displayArray + ":");
				int numVehicles = keyboard.nextInt();

				// Loop that gets user input about vehicle
				for (int x = 0; x < numVehicles; x++) {
					System.out.println("Please enter the number of axels:");
					int axlesCount = keyboard.nextInt();
					System.out.println("Please enter vehicle type (1. Gas, 2. Hybrid, or 3. Electric) : ");
					int vehicleType = keyboard.nextInt();
					System.out.println(
							"Please  enter payment method (1. Credit/Debit, 2. Cash, or 3. Electronic Payment): ");
					int paymentType = keyboard.nextInt();
					Vehicle info = new Vehicle(axlesCount, vehicleType, paymentType);
					tollRateTotal = info.getToll();
					
					// Displays individual toll rates
					System.out.println("************ Individual Vehicle Tolls **********************\n");
					System.out.printf("Vehicle " + (x + 1) + " Toll Rate: $%1.2f\n", tollRateTotal);
					
					// Keeps track of running totals of the different payment types
					boothTotal += tollRateTotal;
					if (paymentType == 1)
						totalCredit += tollRateTotal;
					else if (paymentType == 2)
						totalCash += tollRateTotal;
					else if (paymentType == 3)
						totalES += tollRateTotal;
					
					// Displays individual booth total
					Booth info1 = new Booth(boothTotal, paymentType);
					boothTotal = info1.getBoothTotal();
					System.out.printf("Booth " + (i + 1) + " total: $%1.2f\n" , boothTotal);
				}
			}

			// asks if they would like to enter another transaction / controls loop
			System.out.println("\nIf you would like to make an transasction press 1, if done press 0: ");
			int newAnswer = keyboard.nextInt();

			if (newAnswer == 0) {
				// prints totals
				// System.out.println("Booth " + (i + 1) + " Total: $" + boothTotal);
				totalAllBooths = totalCredit + totalCash + totalES;
				
				// Writes to report file
				File outputFile = null;
				FileOutputStream outputFileStream = null;
				PrintWriter outputFileWriter = null;
				try {
					// write vehicle data/values to a file
					outputFile = new File("totalsReport.txt");
					outputFileStream = new FileOutputStream(outputFile);
					outputFileWriter = new PrintWriter(outputFileStream);
				}
				catch (IOException e) {
					System.out.println("FileWriter:main" + e.getMessage());
					System.exit(1);
				}	
					//writes information for each vehicle passing through
					outputFileWriter.println("************ Total for all Booths **************************\n");
					outputFileWriter.printf("Overall Booth Total: $%1.2f\n", totalAllBooths);
					outputFileWriter.println("\n************ Payment Type Totals *********************************\n");
					outputFileWriter.printf("Credit Payments: $%1.2f\n", totalCredit);
					outputFileWriter.printf("Cash Payments: $%1.2f\n", totalCash);
					outputFileWriter.printf("Electronic Payments: $%1.2f\n", totalES);
					
					//close the stream
					outputFileWriter.close();
				
				// Reads from Totals Report
				try {
					// reads from vehicle report
					Scanner fileReader = new Scanner(new File("totalsReport.txt"));
				
					System.out.println(fileReader.nextLine());
					System.out.println(fileReader.nextLine());
					System.out.println(fileReader.nextLine());
					System.out.println(fileReader.nextLine());
					System.out.println(fileReader.nextLine());
					System.out.println(fileReader.nextLine());
					System.out.println(fileReader.nextLine());
					System.out.println(fileReader.nextLine());
					System.out.println(fileReader.nextLine());
					
					
					// close the stream
					fileReader.close();
				}
				catch (IOException e) {
					System.out.println("In catch block two, reading from file");
					System.out.println("FileWriter:main" + e.getMessage());
					System.exit(1);
				}
				break;
			}

			else if (newAnswer == 1) {
				continue;
			} else {
				System.out.println("Please enter 1 to enter a transaction, or 0 if done: ");
				newAnswer = keyboard.nextInt();
			}

		}
		// close the keyboard
		keyboard.close();

	}


}
