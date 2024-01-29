import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
 /*
    1. Import groceries.txt file, [Beverages,Condiments,Fruits,Protein,Spices,Vegetables] (done)
    2. Allow user to view grocery items of different categories (done)
    3. Allow user to enter new grocery item  and write to new file (done)
    4. Allow user to view original grocery list (done)
    5. Allow user to have options of actions (done)
    6. Allow user to update/ modify item (done)
    7. Allow user to remove item from list (done)
    Complex methods: 
    8. Allow user to search for existing item (done) 
    9. Write to a second txt file (done)
   10. Allow user to view updated grocery list (done)
     */

  
     public static void main(String[] args) throws FileNotFoundException {
        //2
        while(true) {
        System.out.println("\n" + "Please enter the number to view items for each category\n" +
                            "1 - Beverages \n2 - Condiments \n3 - Fruits \n4 - Protein \n5 - Spices \n6 - Vegetables \nEnter '0' to quit viewing and start adding item to your new grocery list");
        Scanner console = new Scanner(System.in);
        int userInput = console.nextInt();
            if (userInput == 1) {
                String[] beverages = beverageChoices();
                System.out.println(Arrays.toString(beverages));
            }else if (userInput == 2) {
                String[] condiments = condimentChoices();
                System.out.println(Arrays.toString(condiments));
            }else if (userInput == 3) {
                String[] fruits = fruitChoices();
                System.out.println(Arrays.toString(fruits));
            }else if (userInput == 4) {
                String[] protein = proteinChoices();
                System.out.println(Arrays.toString(protein));
            }else if (userInput == 5) {
                String[] spices = spiceChoices();
                System.out.println(Arrays.toString(spices));
            }else if (userInput == 6) {
                String[] vegetables = vegetableChoices();
                System.out.println(Arrays.toString(vegetables));
            } else if (userInput == 0){
                break;
            }
        }

        addGrocery();

        String[] groceryList = viewGrocery();
        userOptions(groceryList);

    }

  //1
    //Array for beverage category
    public static String[] beverageChoices() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Beverages.txt"));
        String[] beverageChoicesArray = new String[15];
        for (int i=0; i< beverageChoicesArray.length; i++){
            beverageChoicesArray[i]= input.nextLine();
        }
        return  beverageChoicesArray;
    }

    //Array for condiment category
    public static String[] condimentChoices() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Condiments.txt"));
        String[] condimentChoicesArray = new String[16];
        for (int i=0; i< condimentChoicesArray.length; i++){
            condimentChoicesArray[i]= input.nextLine();
        }
        return  condimentChoicesArray;
    }

    //Array for fruit category
    public static String[] fruitChoices() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Fruits.txt"));
        String[] fruitChoicesArray = new String[15];
        for (int i=0; i< fruitChoicesArray.length; i++){
            fruitChoicesArray[i]= input.nextLine();
        }
        return  fruitChoicesArray;
    }

    //Array for protein category
    public static String[] proteinChoices() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Protein.txt"));
        String[] proteinChoicesArray = new String[17];
        for (int i=0; i< proteinChoicesArray.length; i++){
            proteinChoicesArray[i]= input.nextLine();
        }
        return  proteinChoicesArray;
    }

    //Array for spice category
    public static String[] spiceChoices() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Spices.txt"));
        String[] spicesChoicesArray = new String[13];
        for (int i=0; i< spicesChoicesArray.length; i++){
            spicesChoicesArray[i]= input.nextLine();
        }
        return  spicesChoicesArray;
    }


    //Array for vegetable category
    public static String[] vegetableChoices() throws FileNotFoundException {
        Scanner input = new Scanner(new File("Vegetables.txt"));
        String[] vegetableChoicesArray = new String[16];
        for (int i=0; i< vegetableChoicesArray.length; i++){
            vegetableChoicesArray[i]= input.nextLine();
        }
        return  vegetableChoicesArray;
    }


    //3
    public static void addGrocery () throws FileNotFoundException {
        PrintStream output = new PrintStream(new File("Personal Grocery list.txt"));
        while(true) {
            System.out.println("\n" + "Please enter one food name at a time to add them your grocery list. Enter 'Done' when finished");
            Scanner userOutput = new Scanner(System.in);
            String foodOutput = userOutput.nextLine();
            if (foodOutput.equalsIgnoreCase("done")){
                break;
            }
            output.println(foodOutput);

        }
        System.out.println("\n" + "Items added successfully!");
    }

  //5
    public static void userOptions (String [] groceryList) throws FileNotFoundException {
        while (true) {
            System.out.println("\n" + "Enter '1' to view original grocery list \n"
                    + "Enter '2' to replace grocery item \n" 
                    + "Enter '3' to remove grocery item \n"
                    + "Enter '4' to search for existing grocery item \n"
                    + "Enter '5' to view updated grocery list \n"
                    + "Enter '0' to quit");
            Scanner choices = new Scanner(System.in);
            int userChoices = choices.nextInt();
            if (userChoices == 1) {
                viewGrocery();
            } else if (userChoices == 2) {
                replaceGrocery(groceryList);
            } else if (userChoices == 3) {
                removeGrocery(groceryList);
            } else if (userChoices ==4) {
                searchGrocery(groceryList);
            } else if (userChoices == 5) {
                viewUpdatedGroceryLists(groceryList);
            } else if (userChoices ==0){
                break;
            }
        }

    }

    //4
    public static String [] viewGrocery () throws FileNotFoundException {
        System.out.println("\n" + "Below is your grocery list:");
        ArrayList<String> groceryListArrayList = new ArrayList<String>(); //create an array list
        Scanner fileOutput = new Scanner(new File("Personal Grocery list.txt"));

        while (fileOutput.hasNextLine()) {

        groceryListArrayList.add(fileOutput.nextLine()); //adding grocery items into array list to allow unlimited item number
            //Citation: https://www.geeksforgeeks.org/read-file-into-an-array-in-java/
       }

        String [] groceryListArray = groceryListArrayList.toArray(new String[0]);
      
        System.out.println(Arrays.toString(groceryListArray)); //convert Array list to array

        return groceryListArray;
    }




    //6
    public static void replaceGrocery (String [] groceryList) throws FileNotFoundException {
        Scanner userInput = new Scanner(System.in);
      
            System.out.println("Enter item name that you would like to replace");
            String oldItem = userInput.nextLine();

            for ( int i=0; i< groceryList.length; i++) {
                if (groceryList[i].equalsIgnoreCase(oldItem)) {
                    System.out.println("Enter the new item to replace it with");
                    String newItem = userInput.nextLine();
                    groceryList[i] = newItem;
                    System.out.println("Item replaced successfully! \n");

                }
            }

        System.out.println("Below is your updated grocery list after replacement: ");
        System.out.println(Arrays.toString(groceryList));

        }



    //7
    public static void removeGrocery (String [] groceryList) throws FileNotFoundException {
        Scanner userInput = new Scanner(System.in);

            System.out.println("Enter item name that you would like to remove ");
            String oldItem = userInput.nextLine();

        for ( int i=0; i< groceryList.length; i++) {
            if (groceryList[i].equalsIgnoreCase(oldItem)) {
                    groceryList[i] = "";
                System.out.println("Item removed successfully \n");
            }
        }

        System.out.println("Below is your updated grocery list after removal: ");
        System.out.println(Arrays.toString(groceryList));

    }

    //8
    public static void searchGrocery (String [] groceryList) throws FileNotFoundException {  
        Scanner userInput = new Scanner(System.in);
      
            System.out.println("Enter item name that you would like to search, Or enter 'Q' to go back to menu");
            String oldItem = userInput.nextLine();

        for (int i=0; i< groceryList.length; i++) {
            if (groceryList[i].equalsIgnoreCase(oldItem)) {
                System.out.println("Item already added to list");

            }

        }
    }
  
  //9, 10
    public static void viewUpdatedGroceryLists (String [] groceryList) throws FileNotFoundException {
      
        PrintStream fileOutTwo = new PrintStream(new File("Updated Grocery List.txt"));
        fileOutTwo.println(Arrays.toString(groceryList));
        System.out.println("Below is your updated grocery list: ");
        System.out.println(Arrays.toString(groceryList));



    }
  
}