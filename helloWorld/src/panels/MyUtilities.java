package panels;
   import java.io.*;
   import java.util.*;
    public class MyUtilities 
   {
      static int index;
      public static Card[] cards = new Card[200];
   
      public static Card[] readFile(String fileName, Card[] cards) 
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
                cards[index] = new Card(scanner.next(),scanner.nextInt(),scanner.next(),scanner.nextInt(),scanner.next(),scanner.nextInt());   cards[index].setCategory(scanner.next());
                System.out.println(cards[index].getCategory());
                index = index + 1;
             }
             scanner.close();
          } 
              catch (FileNotFoundException e) 
             {
                e.printStackTrace();
                System.out.println("Can't find file");
             }
          System.out.println("cards index is: " + index);
          return cards;
       
       }
   	
       public static Card[] deleteFromArray(int entryToDelete, Card[] cards)
      {
         for (int i = entryToDelete; i < index-1; i++) 
         {
            cards[i]=  cards[i+1];
                          
         }
         index = index - 1;
         return cards;
      }		
      
       public static Card[] addToArray(Card cardToAdd, Card[] cards)
      {
         cards[index]=  cardToAdd;
         index = index + 1;
         return cards;
                          
      }
   	
       public static void writeFile (String fileName, Card[] cards) 
      {   
      // write data
         try
         {
            File outFile = new File(fileName);
            PrintWriter outPrinter = new PrintWriter(outFile);
            
            System.out.println ("writing these problems after add and del");
         
            for (int i = 0; i < index; i++) {
               outPrinter.println(cards[i].getCategory());
               System.out.println(cards[i].getCategory());
            
            }
            outPrinter.close();
         }
             catch (Exception e) {
               e.printStackTrace();
               System.exit(1);
            }
      
      }
       public static void main(String[] args) 
      {
         Card[] cards = new Card[200];   
         cards = readFile("CardData.txt", cards);
         
         Card newCard = cards[4];
         cards = addToArray(newCard, cards);
         cards = addToArray(newCard, cards);
         cards = addToArray(newCard, cards);
         for (int i = 0; i < index; i++) {
            System.out.println("after add " + cards[i].getCategory().trim());
            
         }
      
      	
         cards = deleteFromArray ( 1,cards);
         for (int i = 0; i < index; i++) {
            System.out.println("after del when index = 1" + cards[i].getCategory().trim());
            
         }      	
      	
         writeFile("CardOut.txt", cards);
      
      
      }
   
   
   }

