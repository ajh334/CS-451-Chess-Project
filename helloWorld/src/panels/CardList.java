package panels;
   //Name: Kofi Lewis
   //Purpose: This code creates my data structure, CardList, and constructs all of the methods that it uses
   import java.io.*;
   import java.util.*;
   import javax.swing.JFrame;
   
	//**MASTERY FACTOR**\\ 10: Implementing a hierarchical composite data structure
	//**MASTERY FACTOR**\\12-15: Implementation of Abstract Data Types
    public class CardList
   {
      private Card head;
      private Card tail;
      private int size = 0;
      private Card current;
      private Card blank;
   
       public CardList()
      {
         size = 0;
      }
      
       public int size()
      {
         return size;
      }
      
       public int indexOf(Card c)
      {
         current = head;
         
         for(int i = 0; i < size(); i++)
         {
            if( current == c)
            {
               return i;
            }
            else
            {
               current = current.getNext();
            }
         }
         return -1;
      }
      
       public boolean isEmpty()
      {
         if(size()==0)
         {
            return true;
         }
         else
         {
            return false;
         }	
      }
      
       public void add(Card toAdd)
      {
         if(isEmpty()!=true)
         {
            insertTail(toAdd);
         }
         else
         {
            head = toAdd;
            tail = toAdd;
            toAdd.setNext(toAdd);
            toAdd.setPrevious(toAdd);
            size++;
         }
      }
      
      
       public Card first()
      {
         return head;
      }
      
       public Card last()
      {
         return tail;
      }
   	
       public void insertHead(Card newHead)
      {
         if(isEmpty()!=true)
         {
            head.setPrevious(newHead);
            newHead.setNext(head);
            head = newHead;
            tail.setNext(newHead);
            newHead.setPrevious(tail);
         }
         else
         {
            add(newHead);
         }
      	
         size++;
      
      }
   	
       public void insertTail(Card newTail)	
      {
         if(isEmpty()!=true)
         {
            tail.setNext(newTail);
            newTail.setPrevious(tail);
            head.setPrevious(newTail);
            newTail.setNext(head);
            tail = newTail;      
         }
         else
         {
            add(newTail);
         }
         size++;	
      }
   
       public Card before(Card c)
      {
         return c.getPrevious();
      }
      
       public Card after(Card c)
      {
         return c.getNext();
      }
   
       public void insertBefore(Card inserted, Card c)
      {
         if(isEmpty()!=true)
         {
            before(c).setNext(inserted);
            inserted.setPrevious(before(c));
            c.setPrevious(inserted);
            inserted.setNext(c);
         }
         else
         {
            add(inserted);
         }
      	
         size++;
      
      }
      
       public void insertAfter(Card inserted, Card c)
      {
         if(isEmpty()!=true)
         {
            after(c).setPrevious(inserted);
            inserted.setNext(after(c));
            c.setNext(inserted);
            inserted.setPrevious(c);
         }
         else
         {
            add(inserted);
         }
      	
         size++;
      
      }
      
       public void remove(Card removed)
      {
         before(removed).setNext(after(removed));
         
         after(removed).setPrevious(before(removed));
         
         size--;
      }
      
       public void remove(int r)
      { 
         current = head;
         
         for(int i = 0; i < size; i++)
         {
            if(r == indexOf(current))
            {
               before(current).setNext(after(current));
               
               after(current).setPrevious(before(current));
               
               size--;  
            }
            else
            {
               current = current.getNext();
            }
         }
      }
      
       public Card get(int i)
      {
         try
         {
            
            current = head;
         
            for(int r = 0; r < size(); r++)
            {
               if(i == indexOf(current))
               {
                  return current;
               }
               else
               {
                  current = current.getNext();
               }
            }
         }
             catch(IndexOutOfBoundsException e)
            {
               e.printStackTrace();
            }
         return blank;
      }
      
      
       public Card[] toArray(Card[] created)
      {
         current = head;
       //**MASTER FACTOR**\\ 11: The use of any five standard level mastery factors
       //Standard Level Master Factor 6: Loops 
         for(int a = 0; a < size(); a++)
         {
            created[a] = current;
            current = current.getNext();
         }
         return created;
      }
   	
       public void clear()
      {
         // for(int i = 0; i < size(); i++)
         // {
            // get(i).setPrevious(null);
            // get(i).setNext(null);
         // }
         size = 0;
      }
   }
