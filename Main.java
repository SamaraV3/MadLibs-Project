import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println();
    Scanner cr = new Scanner(System.in);
    System.out.println("Hello! Welcome to my Mad Libs program! Let's get started.");
    MadLib.createAccount();
    String cont = "yes";
    int tries = 1;
    while (cont.equalsIgnoreCase("yes")) {
      if (tries > 1) {MadLib.login();}
      MadLib.chooseMadLib();
      String choice = MadLib.getChoice();
      if (choice.equals("a")) {MadLib.poemLibs();}
      else {MadLib.storyLibs();}
      System.out.println("Would you like to try again?");
      cont = cr.nextLine();
      tries++;
    }
    System.out.println("Hope you had fun!");
    cr.close();
  }
}