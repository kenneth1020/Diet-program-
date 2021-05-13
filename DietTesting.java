import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class DietTesting {

	static public ArrayList<DietReader> list = new ArrayList<DietReader>();

	//sizes of the file index for the id searching
	static int sizeDiet = 6348;
	//holding all data of the nurients userconsume
	static double[] nurients = new double [20];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Name of file
		String fileName = "diet.csv";
		readInData(fileName);

		//Test code for printing all the data from the file
		//for(int i = 0; i < list.size(); i++ )
		//{
		//System.out.println(list.get(i));
		//}
		//calling the method to seach for the food 
		Search();
		Interface();

	}//end of main

	public static void Interface()
	{
		//asking if the user like to search again
		System.out.println("like to search again?");
		Scanner inputs1 = new Scanner(System.in);
		String answers = inputs1.nextLine();

		//response if user want to search again
		if(answers.equalsIgnoreCase("yes")) {
			Search();	
			Interface();
		}
		//response if user want to search again
		else if(answers.equalsIgnoreCase("no")) { 
			//asking the user if they want make a replace
			System.out.println("Would you like to enter for weight of product");
			Scanner inputs2 = new Scanner(System.in);
			String answers2 = inputs2.nextLine();

			//response if user want to make a replacement
			if(answers2.equalsIgnoreCase("yes")) {
				System.out.println("Would you being used Ounce or Pounds. Type OUNCE || POUNDS");
				Scanner inputs3 = new Scanner(System.in);
				answers2 = inputs3.nextLine();
				String test = answers2.toUpperCase();
				if(test.equalsIgnoreCase("OUNCE"))
				{
					System.out.println("Type in Ounce weight");
					Scanner inputs4 = new Scanner(System.in);
					Double ounce = Double.parseDouble(inputs4.nextLine());
					ounce = ounce*28.3495;
					DataDiet(ounce, answers2);
				}
				if(test.equalsIgnoreCase("POUNDS"))
				{
					System.out.println("Type in pounds weight");
					Scanner inputs5 = new Scanner(System.in);
					Double pound = Double.parseDouble(inputs5.nextLine());
					pound = pound*453.592;
					DataDiet(pound, answers2);
				}

				if(!test.equalsIgnoreCase("pounds") && !test.equalsIgnoreCase("ounce")) {
					System.out.println("Sorry didn't get your answers. Sending you back to interface: ");
				}
				Interface();
			}

			//response if user want to make a replacement
			else if(answers2.equalsIgnoreCase("no")) {
				ExitSystem();
			}
			//response if user want to make a replacement but didnt type yes or no
			else {
				System.out.println("Sorry i didn't get that");
				Interface();
			}
		}
		//response if user want to search again but didnt type yes or no
		else {
			System.out.println("SUwUrry i didn't get that. . . Better stop typing anything else or you make me angry (>.< *) ");
			Interface();
		}
	}//end of interface

	public static void DataDiet(double grams, String answer)
	{

		System.out.println("Type in ID of the food");
		Scanner inputs1 = new Scanner(System.in);
		int id = Integer.parseInt(inputs1.nextLine());
		double protein = list.get(id).getProtein() * grams; //1 g
		double calories =  list.get(id).getCalories() * grams; //2  
		double fat =  list.get(id).getFat() * grams; //3 g
		double sauratedFat =  list.get(id).getSauratedFat() * grams; //4 g
		double cholesterol =  list.get(id).getCholesterol() * grams; //5 g
		double suger =  list.get(id).getSugar() * grams;//6
		double fiber =  list.get(id).getFiber() * grams;//7
		double vitaminA =  (list.get(id).getVitaminA() * grams *0.67) ; //8 mg
		double vitaminB5 =  list.get(id).getVitaminB5() * grams;//9 mg 
		double vitaminB6 =  list.get(id).getVitaminB6() * grams;//10 mg
		double vitaminB12 =  list.get(id).getVitaminB12() * grams;//11 mg
		double vitaminC =  list.get(id).getVitaminC() * grams;//12 mg
		double vitaminD =  list.get(id).getVitaminD() * grams;//13 mcg
		double vitaminE =  list.get(id).getVitaminE() * grams;//14 mg
		double iron =  list.get(id).getIron() * grams;//15 mg
		double netCarbs =  list.get(id).getNetCarbs() * grams; //16
		double potassium =  list.get(id).getPotassium() * grams; //17 mg
		double calcium =  list.get(id).getCalcium() * grams; //18 mg
		double sodium =  list.get(id).getSodium() * grams;//19 mg
		double zinc =  list.get(id).getZinc() * grams;//20 mg
		double carb =  list.get(id).getCarbohydrates() * grams;//20 g
		
		System.out.println( list.get(id).getFoodName());
		System.out.println(protein + " :your protein in grams" ); 
		System.out.println(calories + " :your calories"); 
		System.out.println(fat + " :your fat in grams"); 
		System.out.println(sauratedFat + " :your sauratedfat in grams");
		System.out.println(cholesterol + " :your cholesterol in grams");
		System.out.println( suger + " :your sugar in grams");
		System.out.println( fiber + " :your fiber in grams");
		System.out.println( vitaminA + " :your vitaminA in mg");
		System.out.println( vitaminB5 + " :your vitaminB5 in mg");
		System.out.println( vitaminB6 + " :your vitaminB6 in mg");
		System.out.println( vitaminB12 + " :your vitaminB12 in mg");
		System.out.println( vitaminC + " :your vitaminC in mg");
		System.out.println( vitaminD + " :your vitaminD in mg");
		System.out.println( vitaminE + " :your vitaminE in mg");
		System.out.println( iron + " :your iron in mg");
		System.out.println( netCarbs + " :your Net Carbs");
		System.out.println( potassium + " :your potassium in mg");
		System.out.println( calcium + " :your calcium in mg");
		System.out.println( sodium + " :your zinc in mg");
		System.out.println( carb + " :your carbohydrates in g");

		//asking user responds on inputing this data to his record
		System.out.println("Would you like to store this data in your dietary meal record");
		Scanner inputs2 = new Scanner(System.in);
		String answers2 = inputs2.nextLine();

		//saving all nurients user consume into an array
		if(answers2.equalsIgnoreCase("yes")) {
			nurients[0] = nurients[0] +  protein;
			nurients[1] = nurients[1] + calories;  
			nurients[2] = nurients[2] + fat;  
			nurients[3] = nurients[3] + sauratedFat;
			nurients[4] = nurients[4] + cholesterol;
			nurients[5] = nurients[5] + suger;  
			nurients[6] = nurients[6] + fiber;
			nurients[7] = nurients[7] + vitaminA;
			nurients[8] = nurients[8] + vitaminB5;
			nurients[9] = nurients[9] + vitaminB6;
			nurients[10] = nurients[10] + vitaminB12;
			nurients[11] = nurients[11] + vitaminC;
			nurients[12] = nurients[12] + vitaminD;
			nurients[13] = nurients[13] + vitaminE;
			nurients[14] = nurients[14] + iron;
			nurients[15] = nurients[15] + netCarbs;
			nurients[16] = nurients[16] + potassium;
			nurients[17] = nurients[17] + calcium;
			nurients[18] = nurients[18] + sodium;
			nurients[19] = nurients[19] + carb;  
			
			System.out.println("Data SAVED");
		}
		else if(answers2.equalsIgnoreCase("no")) {
			Interface();
		}
		else
		{
			System.out.println("Uwu that hurt you can't type yes or no. Try again");
		}
	}


	public static void ExitSystem()
	{
		System.out.println("Would you like to exit system");
		Scanner inputs1 = new Scanner(System.in);
		String response = inputs1.nextLine();
		//if they say yes to exit the system will save their work
		if(response.equalsIgnoreCase("yes")) {
			System.out.println("Total Nutrients");

			System.out.println(nurients[0] + " :your protein in grams" ); 
			System.out.println(nurients[1] + " :your calories"); 
			System.out.println(nurients[2] + " :your fat in grams"); 
			System.out.println(nurients[3] + " :your sauratedfat in grams");
			System.out.println(nurients[4] + " :your cholesterol in grams");
			System.out.println(nurients[5] + " :your sugar in grams");
			System.out.println(nurients[6] + " :your fiber in grams");
			System.out.println( nurients[7] + " :your vitaminA in mg");
			System.out.println( nurients[8]+ " :your vitaminB5 in mg");
			System.out.println( nurients[9]+ " :your vitaminB6 in mg");
			System.out.println( nurients[10] + " :your vitaminB12 in mg");
			System.out.println( nurients[11] + " :your vitaminC in mg");
			System.out.println( nurients[12] + " :your vitaminD in mg");
			System.out.println( nurients[13] + " :your vitaminE in mg");
			System.out.println( nurients[14] + " :your iron in mg");
			System.out.println( nurients[15] + " :your Net Carbs");
			System.out.println( nurients[16] + " :your potassium in mg");
			System.out.println( nurients[17] + " :your calcium in mg");
			System.out.println( nurients[18] + " :your zinc in mg");
			System.out.println( nurients[19] + " :your carbohydrates in g");

			System.exit(0);
		}//end of response of yes
		//system will send them back to the interface asking them if they want search or replace
		else if(response.equalsIgnoreCase("no")) {
			System.out.println("Ok heading back to search again");
			Interface();
		}
		//if user type anything else beside yes or no
		else {
			System.out.println("Sorry i didn't get that UwU Senpai Please type again. Yes || No");
			ExitSystem();
		}

	}//end of ExitSystem




	public static void Search()
	{
		System.out.println("Type in the food name you are searching for");
		Scanner inputs1 = new Scanner(System.in);
		String response = inputs1.nextLine();
		response =response.toUpperCase();
		int result[] = FileSearching(response);
		int count = 0; 
		for(int i =0; i < result.length-1; i++){
			if(result[i] != result[i+1] ) {
				System.out.println("File array number is: " + result[i] + ". Please remember this number of your product. You'll need it later");
				String temp = list.get(result[i]).getFoodName();
				System.out.println(temp);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("Sorry result lead to 0: Is this what you looking for?");
			System.out.println(list.get(0));
			//file.get(0).setFRDMDescription("hello");
		}

	}

	public static int[] FileSearching(String name)
	{
		//creating the array and variables
		int[] idCode = new int[sizeDiet]; //used to store all data of the id 
		String[] wordplay = new String[20]; //used to store all word up to ten of a company
		int detect = 0; //used as the integer to help increments for wordplay[] 
		for(int i =0; i < list.size(); i++ )
		{
			String company = list.get(i).getFoodName();
			String[] words = company.split("\\s+");
			for (int b = 0; b < words.length; b++) {
				// You may want to check for a non-word character before blindly
				// performing a replacement
				// It may also be necessary to adjust the character class
				words[b] = words[b].replaceAll("[^\\w]", "");
			}
			//checking every word in the company name
			for(int j = 0; j < words.length; j++ )
			{
				//System.out.println(words[j]);
				if(words[j].equalsIgnoreCase(name))
				{
					idCode[detect] = i;
					detect++;
				}

			}

		}
		//returning all the id of the matching word found in the search
		return idCode;
	}

	//reading all the data from the cvs file
	public static void readInData(String fileName) {
		// Create scanner 
		//read in the data from the file and opening the file and connecting it to the Scanner object
		//that I called input
		Scanner input = null;

		//catch out exception
		try {
			input = new Scanner(new File(fileName));
		}//end try

		//if reading can't find or detect file
		catch(FileNotFoundException e)
		{
			System.out.println( "Error opening the file. " + fileName + " Why you no, READ my file!!!");
			e.printStackTrace();
		}//end exception
		while(input.hasNext()) {
			String[] fields = input.nextLine().split(",");

			//adding the different types to the array
			list.add(new DietReader(Double.parseDouble(fields[0]), fields[1], fields[2], Double.parseDouble(fields[3]) 
					, Double.parseDouble(fields[4]) , Double.parseDouble(fields[5]) , Double.parseDouble(fields[6])
					, Double.parseDouble(fields[7]) , Double.parseDouble(fields[8]) , Double.parseDouble(fields[9])
					, Double.parseDouble(fields[10]) , Double.parseDouble(fields[11]), Double.parseDouble(fields[12])
					, Double.parseDouble(fields[13]), Double.parseDouble(fields[14]), Double.parseDouble(fields[15])
					, Double.parseDouble(fields[16]), Double.parseDouble(fields[17]), Double.parseDouble(fields[18])
					, Double.parseDouble(fields[19]), Double.parseDouble(fields[20]), Double.parseDouble(fields[21])
					, Double.parseDouble(fields[22]) , Double.parseDouble(fields[23]) , Double.parseDouble(fields[24])
					, Double.parseDouble(fields[25]) , Double.parseDouble(fields[26]) , Double.parseDouble(fields[27])
					, Double.parseDouble(fields[28]) , Double.parseDouble(fields[29]) , Double.parseDouble(fields[30])
					, Double.parseDouble(fields[31]), Double.parseDouble(fields[32]), Double.parseDouble(fields[33])
					, Double.parseDouble(fields[34]), Double.parseDouble(fields[35]), Double.parseDouble(fields[36])
					, Double.parseDouble(fields[37]), Double.parseDouble(fields[38]), Double.parseDouble(fields[39])
					, Double.parseDouble(fields[40]), Double.parseDouble(fields[41]), Double.parseDouble(fields[42])
					, Double.parseDouble(fields[43]), Double.parseDouble(fields[44]), Double.parseDouble(fields[45])
					, Double.parseDouble(fields[46]), Double.parseDouble(fields[47]), Double.parseDouble(fields[48])
					, Double.parseDouble(fields[49]), Double.parseDouble(fields[50]), Double.parseDouble(fields[51])
					, Double.parseDouble(fields[52]), Double.parseDouble(fields[53]), Double.parseDouble(fields[54])
					));
		}

	}


}
