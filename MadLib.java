import java.util.*;

public class MadLib {
  private static Scanner sc = new Scanner(System.in);
  private static String username;
  private static String password;
  private static String litChoice;
  private static ArrayList account = new ArrayList<>();
  private static String[][] lit = new String[1][];
  private static String color;//poem libs
  private static String typeOfEvent;//story libs
  private static String secondTypeOfEvent;//story libs
  private static ArrayList<String> numbers = new ArrayList<String>();//story libs
  private static ArrayList<String> nouns = new ArrayList<String>();//both
  private static ArrayList<String> adjectives = new ArrayList<String>();//both
  private static ArrayList<String> verbs = new ArrayList<String>();//both

  //sets username and password for the user. They're not important tho
  public static void createAccount() {
    boolean finishedAccount = false;
    System.out.println("First let's create your account.");
    while (finishedAccount == false) {
      account = new ArrayList<>();
      System.out.println("What is your name? ");
      int ran = (int) ((Math.random() * (1000 - 1)) + 1);
      username = sc.nextLine() + ran;
      System.out.println("Now, tell me your favorite color: ");
      ran = (int) ((Math.random() * (1000 - 1)) + 1);
      password = sc.nextLine() + "lover" + ran;
      System.out.println("Okay! Here's your account:\nUsername: " + username + "\nPassword: " + password);
      System.out.println("Are you satisfied with your account? ");
      String answer = sc.nextLine();
      if (answer.equalsIgnoreCase("yes")) {
        finishedAccount = true;
        account.add(username);
        account.add(password);
        System.out.println("Please write your username and password somewhere safe");
        System.out.println("You will need them when switching through mad libs.");
      }
      else {System.out.println("Let's try again.");}
    }
  }

  //allows user to log in
  public static void login() {
    boolean login = false;
    while (login == false) {
      System.out.println("Username:");
      String uName = sc.nextLine();
      System.out.println("Password: ");
      String pWord = sc.nextLine();
      if (username.equalsIgnoreCase(uName) && password.equalsIgnoreCase(pWord)) {login = true;}
      else {System.out.println("Try again!");}
    }
  }

  //Where uses picks MadLib choice
  public static void chooseMadLib() {
    //sets all ArrayLists to size 0
    numbers.clear();
    nouns.clear();
    adjectives.clear();
    verbs.clear();
    System.out.println("Now let's choose a MadLib");
    System.out.println("Disclaimer: Not all properties used as mad lib material belong to me.");
    System.out.println("There are two options: (a) Poem (b) Short Story.");
    System.out.println("Please pick a choice. ");
    String answer = sc.nextLine();
    boolean isAChoice = false;
    while (isAChoice == false) {
      if (answer.equals("a")) {
        System.out.println("You have chosen the poem.");
        String[][] poem = new String[3][];
        poem[0] = new String[9];//nouns
        poem[1] = new String[3];//adjectives 
        poem[2] = new String[4];//verbs
        lit = poem;
        isAChoice = true;
        litChoice = "a";
      }
      else if (answer.equals("b")) {
        System.out.println("You have chosen the short story.");
        String[][] story = new String[4][];
        story[0] = new String[7];//numbers
        story[1] = new String[4];//nouns
        story[2] = new String[3];//adjectives
        story[3] = new String[2];//verbs
        lit = story;
        isAChoice = true;
        litChoice = "b";
      }
      else {
        System.out.println("That is not an option. Try again. ");
        System.out.println("Please pick a viable choice. ");
        answer = sc.nextLine();
      }
    }
  }

  public static String getChoice() {
    return litChoice;
  }
  //runs if user chooses poem
  public static void poemLibs() {
    System.out.println("Type in a color: ");
    color = sc.nextLine();
    //lines 87 - 92 set the arraylists to viable values
    nouns = setArrayListValues(9, nouns, "nouns");
    nouns = removeAnItem(9, nouns, "noun");
    adjectives = setArrayListValues(3, adjectives, "adjectives");
    adjectives = removeAnItem(3, adjectives, "adjective");
    verbs = setArrayListValues(4, verbs, "verbs");
    verbs = removeAnItem(4, verbs, "verbs");
    //lines 94 - 100 print out the contents of these lists
    System.out.println("Here are the values you have so far: ");
    System.out.print("Nouns: ");
    printArrList(nouns);
    System.out.print("\nAdjectives: ");
    printArrList(adjectives);
    System.out.print("\nVerbs: ");
    printArrList(verbs);
    poemOptions();
    changePoemArrayListTo2DArray();
    printPoemLib();
  }
  
  //runs if user chooses story
  public static void storyLibs() {
    System.out.println("Type in a type of event: ");
    typeOfEvent = sc.nextLine();
    System.out.println("Type out a second, more boring, type of event: ");
    secondTypeOfEvent = sc.nextLine();
    numbers = setArrayListValues(7, numbers, "numbers");
    numbers = removeAnItem(7, numbers, "number");
    nouns = setArrayListValues(4, nouns, "nouns");
    nouns = removeAnItem(4, nouns, "noun");
    adjectives = setArrayListValues(3, adjectives, "adjectives");
    adjectives = removeAnItem(3, adjectives, "adjective");
    verbs = setArrayListValues(2, verbs, "verbs");
    verbs = removeAnItem(2, verbs, "verbs");
    System.out.println("Here are the values you have so far: ");
    System.out.print("Numbers: ");
    printArrList(numbers);
    System.out.print("Nouns: ");
    printArrList(nouns);
    System.out.print("\nAdjectives: ");
    printArrList(adjectives);
    System.out.print("\nVerbs: ");
    printArrList(verbs);
    storyOptions();
    changeStoryArrayListTo2DArray();
    printStoryLib();
  }

  //options shown after user has put in their values for poem
  private static void poemOptions() {
    System.out.println("Here are some more options: ");
    String response = "yes";
    while (response.equalsIgnoreCase("yes")) {
      System.out.println("(a) Change MadLibs order, (b) Change MadLib value, (c) Finish");
      System.out.println("Type the choice you would like to carry out: ");
      String answer = sc.nextLine();
      if (answer.equals("a")) {
        nouns = changeArrayListOrder(nouns, "nouns");
        adjectives = changeArrayListOrder(adjectives, "adjectives");
        verbs = changeArrayListOrder(verbs, "verbs");
      }
      else if (answer.equals("b")) {
        nouns = changeArrayListValue(nouns, "Nouns");
        adjectives = changeArrayListValue(adjectives, "Adjectives");
        verbs = changeArrayListValue(verbs, "Verbs");
      }
      System.out.println("Would you like to go back to the previous options? ");
      response = sc.nextLine();
    }
    System.out.println("Finished!");
  }
  
  //options shown after user has put in their values for story
  private static void storyOptions() {
    System.out.println("Here are some more options: ");
    String response = "yes";
    while (response.equalsIgnoreCase("yes")) {
      System.out.println("(a) Change MadLibs order, (b) Change MadLib value, (c) Sort Integers, (d) Finish");
      System.out.println("Type the choice you would like to carry out: ");
      String answer = sc.nextLine();
      if (answer.equals("a")) {
        numbers = changeArrayListOrder(numbers, "numbers");
        nouns = changeArrayListOrder(nouns, "nouns");
        adjectives = changeArrayListOrder(adjectives, "adjectives");
        verbs = changeArrayListOrder(verbs, "verbs");
      }
      else if (answer.equals("b")) {
        numbers = changeArrayListValue(numbers, "Numbers");
        nouns = changeArrayListValue(nouns, "Nouns");
        adjectives = changeArrayListValue(adjectives, "Adjectives");
        verbs = changeArrayListValue(verbs, "Verbs");
      }
      else if (answer.equals("c")) {
        System.out.println("Would you like to sort the numbers in (a) Increasing order, or (b) Decreasing order?");
        String res = sc.nextLine();
        if (res.equals("a")) {
          numbers = sortAscend(numbers);
        }
        else {
          numbers = sortDescend(numbers);
          for (String num : numbers) {System.out.print(num + ", ");}
        }
      }
      System.out.println("Would you like to go back to the previous options? ");
      response = sc.nextLine();
    }
    System.out.println("Finished!");
  }

  /*sets ArrayLists values for each list of values,
  making sure it is not less than specific int value*/
  private static ArrayList setArrayListValues(int numOfValues, ArrayList arr, String arrType) {
    int numLeft = numOfValues;
    System.out.println("Type in " + Integer.toString(numLeft) + " " + arrType + ", seperated by commas: ");
    String list1 = sc.nextLine();
    String str[] = list1.split(", ");
    for (String item : str) {
      arr.add(item);
    }
    if (arr.size() < numOfValues) {
      while (arr.size() < numOfValues) {
        numLeft = numOfValues - arr.size();
        System.out.println("Type in " + Integer.toString(numLeft) + " more " + arrType + "(s): ");
        list1 = sc.nextLine();
        str = list1.split(", ");
        for (String item : str) {
          arr.add(item);
        }
      }
    }
    return arr;
  }

  //removes values of the input ArrayList until they reach an expected size
  private static ArrayList removeAnItem(int expectedSize, ArrayList arr, String arrType) {
    int extra = arr.size() - expectedSize;
    while (extra > 0) {
      System.out.println("You have too many " + arrType + "s.");
      System.out.println("You need to delete " + extra + " " + arrType + "s.");
      System.out.print("List: ");
      printArrList(arr);
      System.out.println("Which item would you like to delete? Type in the index: ");
      int index = Integer.valueOf(sc.nextLine());
      arr.remove(index);
      extra--;
      if (extra == 0) {System.out.println("You now have the apropriate number of " + arrType + "s.");}
    }
    return arr;
  }

  //prints out items in the arr ArrayList
  private static void printArrList(ArrayList arr) {
    System.out.print("[");
    for (int i = 0; i < arr.size(); i++) {
      if (i == arr.size() - 1) {System.out.print(arr.get(i));}
      else {System.out.print(arr.get(i) + ", ");}
    }
    System.out.println("]");
  }

  //Allows user to switch two present items with each other, using the index
  private static ArrayList changeArrayListOrder(ArrayList<String> arr, String arrType) {
    System.out.println("Would you like to change " + arrType + "?");
    String answer = sc.nextLine();
    if (answer.equalsIgnoreCase("yes")) {
      boolean contin = true;
      while (contin == true) {
        System.out.println("Type in the index of the first item you want to change: ");
        int index1 = Integer.valueOf(sc.nextLine());
        System.out.println("And the second: ");
        int index2 = Integer.valueOf(sc.nextLine());
        int ran = (int) ((Math.random() * (10 - 1)) + 1);
        if (ran % 2 == 0) {
          String temp = arr.set(index1, arr.get(index2));
          arr.set(index2, temp);
        }
        else {
          arr.add(index1, arr.get(index2));
          String temp = arr.remove(index1 + 1);
          arr.add(index2, temp);
          String nTemp = arr.remove(index2 + 1);//nTemp isn't used
        }
        System.out.println("Do you wanna continue changing the order of " + arrType + "?");
        answer = sc.nextLine();
        if (answer.equalsIgnoreCase("no")) {contin = false;}
      }
    }
    return arr;
  }

  //changes the value of an item in the list, using the value itself rather than it's index
  private static ArrayList changeArrayListValue(ArrayList<String> arr, String arrType) {
    System.out.println("Would you like to change a value from " + arrType + "?");
    String answer = sc.nextLine();
    if (answer.equalsIgnoreCase("yes")) {
      System.out.println(arrType + ": [");
      for (String item : arr) {
        if (arr.indexOf(item) == arr.size() - 1) {System.out.print(item);}
        else {System.out.print(item + ", ");}
      }
      System.out.println("]");
      boolean contin = true;
      while (contin == true) {
        System.out.println("Type in the item you would like to change");
        String item1 = sc.nextLine();
        boolean doesNotExist = false;
        for (String item : arr) {
          if (item.equalsIgnoreCase(item1)) {
            System.out.println("Now what you would like to change it to: ");
            String item2 = sc.nextLine();
            arr.set(arr.indexOf(item1), item2);
            doesNotExist = false;
            break;
          }
          else {doesNotExist = true;}
        }
        if (doesNotExist == true) {System.out.println("Sorry, that's not a value in this list");}
        System.out.println("Do you wanna change another value from " + arrType + "?");
        answer = sc.nextLine();
        if (answer.equalsIgnoreCase("no")) {contin = false;}
      }
    }
    return arr;
  }

  //sorts numbers ArrayList into ascending order, using selection sort
  private static ArrayList sortAscend(ArrayList<String> arr) {
    ArrayList<Integer> newArr = new ArrayList<Integer>();
    //cast strings to ints first
    for (String let : arr) {
      int newLet = Integer.valueOf(let);
      newArr.add(newLet);
    }
    //then do selection sort
    int count = 0; //statement execution count
    for (int i = 0; i < newArr.size(); i++) {
      int pos = i;
      for (int j = i; j < newArr.size(); j++) {
        if (newArr.get(j) < newArr.get(pos)) {pos = j; count++;}
      }
      int min = newArr.get(pos);
      newArr.set(pos, newArr.get(i));
      newArr.set(i, min);
    }
    //then cast back to a String
    for (int i = 0; i < newArr.size(); i++) {
      String newValue = Integer.toString(newArr.get(i));
      arr.set(i, newValue);
    }
    return arr;
  }

  //sorts numbers ArrayList into descending order, using insertion sort
  private static ArrayList sortDescend(ArrayList<String> arr) {
    ArrayList<Integer> newArr = new ArrayList<Integer>();
    //cast strings to ints first
    for (String let : arr) {
      int newLet = Integer.valueOf(let);
      newArr.add(newLet);
    }
    //then do insertion sort
    int count = 0;//Statement Execution Count
    for (int j = 1; j < newArr.size(); j++) {
      int current = newArr.get(j);
      int i = j - 1;
      while ((i > -1) && ((newArr.get(i).compareTo(current)) == 1)) {
        newArr.set(i + 1, newArr.get(i));
        i--;
        count++;
      }
      newArr.set(i + 1, current);
    }
    //then cast back to a String
    int j = 0;
    for (int i = newArr.size() - 1; i >= 0; i--) {
      String newValue = Integer.toString(newArr.get(i));
      arr.set(j, newValue);
      j++;
    }
    return arr;
  }

  //does as the method says
  private static void changePoemArrayListTo2DArray() {
    for (int i = 0; i < 3; i++) {
      if (i == 0) {
        for (int j = 0; j < nouns.size(); j++) {lit[i][j] = nouns.get(j);}
      }
      else if (i == 1) {
        for (int j = 0; j < adjectives.size(); j++) {lit[i][j] = adjectives.get(j);}
      }
      else if (i == 2) {
        for (int j = 0; j < verbs.size(); j++) {lit[i][j] = verbs.get(j);}
      }
    }
  }

  //again, does as the method says
  private static void changeStoryArrayListTo2DArray() {
    for (int i = 0; i < 4; i++) {
      if (i == 0) {
        for (int j = 0; j < numbers.size(); j++) {lit[i][j] = numbers.get(j);}
      }
      else if (i == 1) {
        for (int j = 0; j < nouns.size(); j++) {lit[i][j] = nouns.get(j);}
      }
      else if (i == 2) {
        for (int j = 0; j < adjectives.size(); j++) {lit[i][j] = adjectives.get(j);}
      }
      else if (i == 3) {
        for (int j = 0; j < verbs.size(); j++) {lit[i][j] = verbs.get(j);}
      }
    }
  }

  //self explanatory
  private static void printPoemLib() {
    ArrayList<String> poem = new ArrayList<>(Arrays.asList("color", " is the color of ", "noun", ".", "Of ", "noun", " and ", "noun", ".", "The color of the ", "noun", " as I wake.", "To ", "verb", " myself to work, walking down the street.", "It’s the color of my ", "adjective", " eyes and his ", "adjective", " tears.", "Eyes void of ", "verb", ", hiding ", "verb", ".", "With his fists ", "adjective", ", drawing ", "color", " from his hands.", "It’s the color of ", "noun", ".", "Stained on his fists, his head, and the ", "noun", " before him.", "Rushing to the faces of bystanders.", "And as the ", "noun", " arrives, it’s the color of the ", "noun", ".", "If ", "color", " were an emotion, it would be called ", "noun", ".", "The color I felt, as I watched them ", "verb", " him away.", "As his eyes never left mine."));
    int nounIndex = 0;
    int adjIndex = 0;
    int verbIndex = 0;
    for (int i = 0; i < poem.size(); i++) {
      if (poem.get(i).equals("color")) {poem.set(i, color);}
      else if (poem.get(i).equals("noun")) {
        poem.set(i, lit[0][nounIndex]);
        nounIndex++;
      }
      else if (poem.get(i).equals("adjective")) {
        poem.set(i, lit[1][adjIndex]);
        adjIndex++;
      }
      else if (poem.get(i).equals("verb")) {
        poem.set(i, lit[2][verbIndex]);
        verbIndex++;
      }
    }
    ArrayList<String> fixedPoems = new ArrayList<String>();
    String cs = "";
    for (int i = 0; i < poem.size(); i++) {
      if (poem.get(i).contains(".") == false) {
        cs += poem.get(i);
      }
      else {
        cs += poem.get(i);
        fixedPoems.add(cs);
        cs = "";
      }
    }
    for (String sentence : fixedPoems) {
      slowTypesetter(sentence);
      System.out.println();
      waiting(1);
    }
  }

  //self explanatory
  private static void printStoryLib() {
    ArrayList<String> story = new ArrayList<>(Arrays.asList("The weirdest thing happened to me the other day.", "Well, not really the other day.", "It was February ", "number", ", so over a month ago.", "I walked along ", "number", " street with my ", "noun", " ", "noun", " when I saw a ", "noun", " on the alley wall.", "It read: ", "\"", "type of event", " Event at 6:30 pm, at ", "number", " Flatbush.", "Bring a friend or ", "number", ".\"", "And me, who has a friend or ", "number", ", thought it would be ", "adjective", " if I went to this event with them.", "Fast forward to the event.", "I ", "verb", " into the venue with ", "number", " of my friends.", "To find only ", "number", " other people there.", "Which I found ", "adjective", ", because this was a ", "type of event", " event.", "So I ", "verb", " one ", "noun", " there, \"Where is everyone? I thought this was a ", "type of event", " event\" ", ".", "It arched an eyebrow at me and said, \"No, this is a ", "boring event", " event.", "But I don’t remember reading that in the alley.", "...", "Then again, it was ", "adjective", " in that alley."));
    int numIndex = 0;
    int nounIndex = 0;
    int adjIndex = 0;
    int verbIndex = 0;
    for (int i = 0; i < story.size(); i++) {
      if (story.get(i).equals("type of event")) {story.set(i, typeOfEvent);}
      else if (story.get(i).equals("boring event")) {story.set(i, secondTypeOfEvent);}
      else if (story.get(i).equals("number")) {
        story.set(i, lit[0][numIndex]);
        numIndex++;
      }
      else if (story.get(i).equals("noun")) {
        story.set(i, lit[1][nounIndex]);
        nounIndex++;
      }
      else if (story.get(i).equals("adjective")) {
        story.set(i, lit[2][adjIndex]);
        adjIndex++;
      }
      else if (story.get(i).equals("verb")) {
        story.set(i, lit[3][verbIndex]);
        verbIndex++;
      }
    }
    ArrayList<String> fixedStory = new ArrayList<String>();
    String cs = "";
    for (int i = 0; i < story.size(); i++) {
      if (story.get(i).contains(".") == false) {
        cs += story.get(i);
      }
      else {
        cs += story.get(i);
        fixedStory.add(cs);
        cs = "";
      }
    }
    for (String sentence : fixedStory) {
      slowTypesetter(sentence);
      System.out.println();
      waiting(1);
    }
  }


  //These ones don't need to be reviewed
  public static void slowTypesetter(String b) {
    for (int i = 0; i < b.length(); i++) {
      System.out.print(b.substring(i, i + 1));
      try {Thread.sleep(64);}
      catch (Exception e) {System.out.println(e);}
    }
  }

  public static void waiting(int a) {
    try {Thread.sleep(a * 1000);}
    catch (Exception e) {System.out.println(e);}
  }



}