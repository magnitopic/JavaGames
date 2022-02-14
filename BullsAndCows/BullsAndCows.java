package BullsAndCows;

import java.util.Scanner;

public class BullsAndCows {

  private int trys;
  public String num;
  private String userNum;
  public int bulls;
  public int cows;

  public BullsAndCows() {
    this.trys = 15;
    // Generates 4 dieferent Integers for num
    while (true) {
      String rnd = "";
      for (int i = 0; i < 4; i++) {
        rnd += String.valueOf((int) (Math.random() * 10));
      }
      boolean diferent = diferenceChecker(rnd);
      if (diferent) {
        this.num = rnd;
        break;
      }
    }
  }

  // This function checks that the user input is a number and will ask until it
  // gets one. Made it to simplify the code that deals with the user.
  // I added the condition that the number has to have 4 unique digits
  private String getUserInput(Scanner scanner) {
    while (true) {
      System.out.print("Give me a number with four diferent digits: ");
      String input = scanner.nextLine();
      if (input.length() == 4 && diferenceChecker(input)) {
        return input;
      } else {
        System.out.println("Invalid input. Try again.");
      }
    }
  }

  private void checkBullsCows() {
    // Checks the bulls and cows
    // If the userNum is in the same position as num it adds a Bull
    // Else it checks if userNum is in some other position, if so it adds a Cow

    this.cows = 0;
    this.bulls = 0;
    for (int i = 0; i < num.length(); i++) {
      if (userNum.charAt(i) == num.charAt(i)) {
        bulls++;
      } else {
        for (int j = 0; j < num.length(); j++) {
          if (userNum.charAt(i) == num.charAt(j)) {
            cows++;
          }
        }
      }
    }
  }

  private boolean diferenceChecker(String number) {
    boolean diferent = true;

    for (int j = 0; j <= number.length() - 1; j++) {
      for (int k = j + 1; k <= number.length() - 1; k++) {
        if (number.charAt(j) == number.charAt(k)) {
          diferent = false;
        }
      }
    }
    return diferent;
  }

  public void startGame() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("============= BullsAndCows Game =============");
    System.out.println(
      "I'm thinking of four diferent digits from cero to nine, bouth included."
    );
    System.out.println(
      "If you correctlly guess the value of a digit but not it's position it will be counted Cow"
    );
    System.out.println(
      "If you guess bouth the digits value and it's position it will be counted as Bull."
    );
    System.out.println(
      "You must get four Bulls to win and you have 15 trys. Good luck."
    );
    System.out.println("==========================");
    boolean playing = true;
    while (playing) {
      this.userNum = getUserInput(scanner);
      trys--;
      checkBullsCows();
      System.out.println("Bulls: " + this.bulls + " Cows: " + this.cows);
      System.out.println("You have " + this.trys + " trys left.");
      System.out.println("==========================");
      if (this.num.equals(userNum)) {
        System.out.println(
          "You win! You guessed " + this.num + " in " + (15 - this.trys) + " trys."
        );
        playing = false;
      } else if (trys <= 0) {
        System.out.println("You have run out of trys. You lose. The number was "+this.num);
        playing = false;
      }
    }
  }

  public static void main(String[] args) {
    BullsAndCows dead = new BullsAndCows();
    dead.startGame();
  }
}
