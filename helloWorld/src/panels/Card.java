package panels;
//Name: Kofi Lewis
//Purpose: This block of code contains the methods and fields inside of my Card object
	 public class Card
   {
      private String category; 
      private int catNumb;
      private int number1; 
      private String operation; 
      private int number2; 
      private String hint; 
      private int answer;
      private Card next;
      private Card previous;
   	
   //**Mastery Factor**\\ 8: Encapsulation    
		 public Card (String c, int n1, String  o, int n2, String h, int a) 
      {
         category = c;
         number1 = n1; 
         operation = o; 
         number2 = n2; 
         hint = h;
         answer = a;
         System.out.println("c.subtring:" + c.substring(1,2));
         if(c.substring(0,1).equals("A"))
            catNumb = 1;
         else if(c.substring(0,1).equals("S"))
            catNumb = 2;
         else if(c.substring(0,1).equals("D"))
            catNumb = 3;
         else if(c.substring(0,1).equals("M"))
            catNumb = 4;
         else
            catNumb = 9;
         System.out.println("Catnumb is:" + catNumb);
      }
   
       public String getCategory()
      {
         return category;
      }
       
       public int getCatNumb()
      {
         return catNumb;
      }
   	 
       public int getNumber1()
      {
         return number1;
      }
       
       public String getOperation()
      {
         return operation;
      }
       
       public int getNumber2()
      {
         return number2;
      }
       
       public String getHint()
      {
         return hint;
      }
   
       public int getAnswer()
      {
         return answer;
      }
   	
       public Card getNext()
      {
         return next;
      }
   
       public Card getPrevious()
      {
         return previous;
      }
   
   	       
       public void setCategory(String c)
      {
         category = c;
         if(c.substring(0,1).equals("A"))
            catNumb = 1;
         else if(c.substring(0,1).equals("S"))
            catNumb = 2;
         else if(c.substring(0,1).equals("D"))
            catNumb = 3;
         else if(c.substring(0,1).equals("M"))
            catNumb = 4;
         else
            catNumb = 9;
         System.out.println("Catnumb is:" + catNumb);
      }
       public void setNumber1(int n1)
      {
         number1 = n1;
      }
   
       public void setOperation(String o)
      {
         operation = o;
      }
   
       public void setNumber2(int n2)
      {
         number2 = n2;
      }
   
       public void setHint(String h)
      {
         hint = h;
      }
   
       public void setAnswer(int a)
      {
         answer = a;
      }
   
       public Card setNext(Card n)
      {
         next = n;
         return n;
      }
         
       public Card setPrevious(Card p)
      {
         previous = p;
         return p;
      }	
   
       public String toString()
      {
         return category + ": " + number1 + operation + number2;
      }
              
   }
