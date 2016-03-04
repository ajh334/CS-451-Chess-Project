package panels;
  //Name: Kofi Lewis
 //Purpose: This block of code contains the methods used in the program
   import java.io.*;
   import java.util.*;
   import java.util.ArrayList; 
   import java.util.Collections;
	
    public class CardUtilities 
   { 
      static int index;
      public static CardList flash = new CardList();
      public static CardList addition = new CardList();
      public static CardList subtraction = new CardList();
      public static CardList division = new CardList();
      public static CardList multiplication = new CardList(); 
      
       public CardList createCardList(Card[] cards)
      { 
         for(int i = 0; i < cards.length; i++)
         {
            flash.add(cards[i]);
         }
         return flash;
      }
       //Purpose: readFile reads in all of the data that the user has saved from a text file, Company.txt, into the program     
     //Pre Condition: Have a text file with information to read and a LinkedList to read it into.
   //Post Condition: The information in the text file is read into the LinkedList 
       public static CardList readFile(String fileName, CardList flash) 
      {
         try 
         {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("%");
            index = 0;
         
            System.out.println ("reading in these problems:");
         
            while (scanner.hasNext())
            { 
               String hint = scanner.next();
               int number1 = scanner.nextInt();
               String operation = scanner.next();
               int number2 = scanner.nextInt();
               int answer = scanner.nextInt();
               String category = scanner.next();					
               System.out.println("constructor category:" + category);
            
               Card tempcard = new Card(category, number1, operation, number2, hint, answer);
               flash.add(tempcard);
            	
            }
            scanner.close();
         } 
             catch (FileNotFoundException e) 
            {
               e.printStackTrace();
               System.out.println("Can't find file");
            }
         System.out.println("size of flash is: " + flash.size());
      	
         return flash;
      }
       //Purpose: readFile reads in all of the data that the user has saved from a text file, Company.txt, with a category of addition into the program     
     //Pre Condition: Have a text file with information to read and a LinkedList to read it into.
   //Post Condition: The information in the text file is read into the LinkedList 
       public static CardList readFileAdd(String fileName, CardList addition) 
      {
         try 
         {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("%");
            index = 0;
         
            System.out.println ("reading in these problems:");
         
            while (scanner.hasNext())
            { 
               String hint = scanner.next();
               int number1 = scanner.nextInt();
               String operation = scanner.next();
               int number2 = scanner.nextInt();
               int answer = scanner.nextInt();
               String category = scanner.next();					
               System.out.println("constructor category:" + category);
            
               Card tempcard = new Card(category, number1, operation, number2, hint, answer);
               //**MASTERY FACTOR**\\ 3: Searching for specified data in a file
               if(tempcard.getCategory().toUpperCase().trim().equals("ADDITION"))
               {
                  addition.add(tempcard);
               }
            	
            }
            scanner.close();
         } 
             catch (FileNotFoundException e) 
            {
               e.printStackTrace();
               System.out.println("Can't find file");
            }
         System.out.println("size of flash is: " + flash.size());
         System.out.println("size of addition is: " + addition.size());
      	
         return addition;
      }
      //Purpose: readFile reads in all of the data that the user has saved from a text file, Company.txt, with a category of subtraction into the program     
     //Pre Condition: Have a text file with information to read and a LinkedList to read it into.
   //Post Condition: The information in the text file is read into the LinkedList
       public static CardList readFileSub(String fileName, CardList subtraction) 
      {
         try 
         {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("%");
            index = 0;
         
            System.out.println ("reading in these problems:");
         
            while (scanner.hasNext())
            { 
               String hint = scanner.next();
               int number1 = scanner.nextInt();
               String operation = scanner.next();
               int number2 = scanner.nextInt();
               int answer = scanner.nextInt();
               String category = scanner.next();					
               System.out.println("constructor category:" + category);
            
               Card tempcard = new Card(category, number1, operation, number2, hint, answer);
               
               if(tempcard.getCategory().toUpperCase().trim().equals("SUBTRACTION"))
               {
                  subtraction.add(tempcard);
               }
            	
            }
            scanner.close();
         } 
             catch (FileNotFoundException e) 
            {
               e.printStackTrace();
               System.out.println("Can't find file");
            }
         System.out.println("size of flash is: " + flash.size());
      
         System.out.println("size of subtraction is: " + subtraction.size());
      
      	
         return subtraction;
      }
      //Purpose: readFile reads in all of the data that the user has saved from a text file, Company.txt, with a category of division into the program     
     //Pre Condition: Have a text file with information to read and a LinkedList to read it into.
   //Post Condition: The information in the text file is read into the LinkedList
       public static CardList readFileDiv(String fileName, CardList division) 
      {
         try 
         {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("%");
            index = 0;
         
            System.out.println ("reading in these problems:");
         
            while (scanner.hasNext())
            { 
               String hint = scanner.next();
               int number1 = scanner.nextInt();
               String operation = scanner.next();
               int number2 = scanner.nextInt();
               int answer = scanner.nextInt();
               String category = scanner.next();					
               System.out.println("constructor category:" + category);
            
               Card tempcard = new Card(category, number1, operation, number2, hint, answer);
               
               if(tempcard.getCategory().toUpperCase().trim().equals("DIVISION"))
               {
                  division.add(tempcard);
               }
            	
            }
            scanner.close();
         } 
             catch (FileNotFoundException e) 
            {
               e.printStackTrace();
               System.out.println("Can't find file");
            }
         System.out.println("size of flash is: " + flash.size());
      
         System.out.println("size of division is: " + division.size());
      
      	
         return division;
      }
      //Purpose: readFile reads in all of the data that the user has saved from a text file, Company.txt, with a category of multiplication into the program     
     //Pre Condition: Have a text file with information to read and a LinkedList to read it into.
   //Post Condition: The information in the text file is read into the LinkedList
       public static CardList readFileMult(String fileName, CardList multiplication) 
      {
         try 
         {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("%");
            index = 0;
         
            System.out.println ("reading in these problems:");
         
            while (scanner.hasNext())
            { 
               String hint = scanner.next();
               int number1 = scanner.nextInt();
               String operation = scanner.next();
               int number2 = scanner.nextInt();
               int answer = scanner.nextInt();
               String category = scanner.next();					
               System.out.println("constructor category:" + category);
            
               Card tempcard = new Card(category, number1, operation, number2, hint, answer);
               
               if(tempcard.getCategory().toUpperCase().trim().equals("MULTIPLICATION"))
               {
                  multiplication.add(tempcard);
               }
            	
            }
            scanner.close();
         } 
             catch (FileNotFoundException e) 
            {
               e.printStackTrace();
               System.out.println("Can't find file");
            }
         System.out.println("size of flash is: " + flash.size());
         System.out.println("size of multiplication is: " + multiplication.size());
      	
         return multiplication;
      }
   
   	//Purpose: writeFile writes the data in the program to a txt file for later use
   //Pre Condition: A LinkedList with information, and a text file to be written to
   //Post Condition: A text file containing all the information from a LinkedList
       public static void writeFile (String fileName, CardList flash) 
      {   
      // write data
         try
         {
            File outFile = new File(fileName);
            PrintWriter outPrinter = new PrintWriter(outFile);
            
            Card[] hold = new Card[flash.size()];
            flash.toArray(hold);
            
            System.out.println ("writing these problems after add and del");
         
            for (int i = 0; i < flash.size(); i++) 
            {
               outPrinter.print(hold[i].getHint() + "%");
               outPrinter.print(hold[i].getNumber1() + "%");
               outPrinter.print(hold[i].getOperation() + "%");
               outPrinter.print(hold[i].getNumber2() + "%");
               outPrinter.print(hold[i].getAnswer() + "%");
               outPrinter.print(hold[i].getCategory() + "%");
               System.out.println(flash.get(i));
            
            }
            outPrinter.close();
         }
             catch (Exception e) {
               e.printStackTrace();
               System.exit(1);
            }
      
      }
   	//Purpose: to sort the objects of a CardList based on their category
   //Pre Condition: An unsorted CardList
   //Post Condition: A CardList sorted by category
	       public static CardList sortList()
      {
         Card[] temp = new Card[flash.size()];
         flash.toArray(temp);    
         for (int i = 0; i < flash.size(); i++)
         {
            for(int j = 0; j < flash.size() - 1; j++)
            {
            
               String a = temp[j].getCategory();
               String b = temp[j+1].getCategory();
               if(a.compareTo(b) > 0)
               {
                  Card temp2 = temp[j];
                  temp[j] = temp[j+1];
                  temp[j+1] = temp2;
               }
            }
         }
         CardList copy = new CardList();
         for(int i = 0; i <temp.length; i++)
         {
            copy.add(temp[i]);
         }
         flash.clear();
         flash = copy;  
      	
         return flash;
      } 
   
       public static void main(String[] args) throws IOException 
      { 
           
      }    
   }