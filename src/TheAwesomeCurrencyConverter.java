import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

 public class TheAwesomeCurrencyConverter {

    ArrayList<String> results = new ArrayList<>();

    public void start() {
        String startOver;
        System.out.println("Welcome to the Awesome Currency Converter!");
        do {
            showResultScreen();
            startOver = getRestartOption();
        }
        while (startOver.equals("Y"));
        showEndScreen();
    }

    private String converterScreen() {
         int choice = choiceScreen();
         double amount = getUserAmount();
         return dollarToShekelConverter(choice, amount);
     }

    private int choiceScreen() {
        int userChoice = 0;
        boolean invalidChoice;
        do {
            System.out.println("Please choose an option (1/2):");
            System.out.println("1. Dollars to Shekels.");
            System.out.println("2. Shekels to Dollar.");
            Scanner userInput1 = new Scanner(System.in);
            try {
                userChoice = userInput1.nextInt();
                if (userChoice == 1 || userChoice == 2) {
                    invalidChoice = false;
                } else {
                    System.out.println("Invalid choice, please try again.");
                    invalidChoice = true;
                }
            } catch (InputMismatchException a) {
                System.out.println("Invalid input, please try again.");
                invalidChoice = true;
            }
        }
        while (invalidChoice);
        return userChoice;
    }

    private double getUserAmount(){
        double amount = 0;
        boolean invalidInput;
        do {
            System.out.println("Please enter an amount to convert:");
            Scanner userInput2 = new Scanner(System.in);
            try {
                amount = userInput2.nextDouble();
                invalidInput = false;
            } catch (InputMismatchException b) {
                System.out.println("Invalid input, please try again.");
                invalidInput = true;
            }
        }
        while (invalidInput);
        return amount;
    }

    private void showResultScreen() {
        String result = converterScreen();
        System.out.println("The result is: " + result);
        results.add(result);
    }

     private String getRestartOption(){
         String startOver;
         boolean invalidChoice;
         do {
             System.out.println("Do you want to start over (Y/N)?");
             Scanner userInput3 = new Scanner(System.in);
             startOver = userInput3.next();
             if (!startOver.equals("Y") && !startOver.equals("N")) {
                 System.out.println("Invalid choice, please try again.");
                 invalidChoice = true;
             }
             else invalidChoice = false;
         }
         while (invalidChoice);
         return startOver;
     }

    private void showEndScreen(){
        System.out.println("Thank you for using the Awesome Currency Converter!");
        System.out.println("Your results were:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println((i+1)+". "+results.get(i));
        }
        results.clear();
    }

    private String dollarToShekelConverter(int choice, double sumToConvert) {
        if (choice == 1) {
            return String.valueOf(sumToConvert * 3.76 +" Shekels.");
        }
        return String.valueOf(sumToConvert / 3.76 +" Dollars.");
    }

}
