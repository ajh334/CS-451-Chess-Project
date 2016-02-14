package panels;
  //BTG Database
 //Name: Kofi Lewis; March 2010; South Lakes High School
 //Computer: HP Compaq dc5100 MT(ED42OUC), Windows XP Professional
 //IDE: JGrasp
 //Purpose: Create the screens that are viewed by the user  
	
	import javax.swing.JFrame;
    public class DriverCard
   {
      static JFrame frame = new JFrame("Welcome!");
       
       public static void main(String[] args)
      {   
         /*CardUtilities.flash = CardUtilities.readFile("CardData.txt", CardUtilities.flash);    
         CardUtilities.addition = CardUtilities.readFileAdd("CardData.txt", CardUtilities.addition);  
         CardUtilities.subtraction = CardUtilities.readFileSub("CardData.txt", CardUtilities.subtraction);  
         CardUtilities.division = CardUtilities.readFileDiv("CardData.txt", CardUtilities.division);  
         CardUtilities.multiplication = CardUtilities.readFileMult("CardData.txt", CardUtilities.multiplication); */       
         
         System.out.println(CardUtilities.flash.size());
         
         for (int i = 0; i < CardUtilities.flash.size(); i++) 
         {
            System.out.println("objects were read in" + CardUtilities.flash.get(i));
         }
      
         frame = new JFrame("Welcome!");
         frame.setSize(600, 500);
         frame.setLocation(200, 100);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new CardPanel());
         frame.setVisible(true);
      }
   }