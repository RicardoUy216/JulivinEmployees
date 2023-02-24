package employeesJulivin;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
   
    public class Menu {
    	   private Timer timer;
    	   private Scanner scanner;
    	   
  public Menu( Scanner scanner, Timer timer ) {
    			super();
    			this.timer = timer;
    			this.scanner = scanner;
    			
    		}   
      public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public Scanner getScanner() {
		return scanner;
	}
	public void setScanner(Scanner scanner) {
		this.scanner = scanner; 
	}
	public void executeMenu() {
		boolean again = true;
  	  while(again) {
  	  try {
		printMenu(); 
		 int choice = getNextIntFromUser();  
	       while (choice != 0) {
	          if (choice == 5) {
	        	  timer.listPersons();
	        	  System.out.println("Done. Please enter another OPTION.");	
	        	   choice = getNextIntFromUser(); 
	          }
	          else if (choice == 1) {
	        	  try {
	        	  System.out.println("Please enter your ID.");
	        	  int ID = getNextIntFromUser();
	        	  timer.timeIn(ID);
	        	 // System.out.println("Done.You have just time in");
	        	  choice = getNextIntFromUser();
	        	  } catch(Exception e)
			      {System.out.println("Invalid input.");
			     scanner.next();
			     } 
	          }
	          
	          else if (choice == 2) {
	        	  try {
	        	  System.out.println("Please enter your ID.");
	        	  int ID = getNextIntFromUser();
	        	  timer.timeOutTimeElapsed(ID);
	        	  System.out.println("Done.You have just time out");
	        	  choice = getNextIntFromUser();
	          } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	          } 
	          else if (choice == 3) {
	        	  timer.listPersons1();
	        	  choice = getNextIntFromUser();
	          }
	          else if (choice == 4) {
	        	  try {
	        	  System.out.println("Please enter your ID.");
	        	  int ID = getNextIntFromUser();
	        	 // System.out.println("Please enter the month, year.");
	        	//  String nameYear = getNextStringLineFromUser();
	        	  timer.printTimeCard(ID);
	        	  choice = getNextIntFromUser();
	          } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	          }
	         
	       else if (choice == 100) {
	    	   try {
	    	   System.out.println("Please enter the ID of the employee to add more time at work.");
	        	  int ID = getNextIntFromUser();
	        	  System.out.println("Please enter the time."); 
	        	  BigDecimal time =getNextBigDecimalFromUser();
	    	   timer.addToTimeAtWork(ID,  time);
	    	   System.out.println("Done.You have just add more time at work ");
	    	   choice = getNextIntFromUser();
	       } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	       }  
	       else if (choice == 101) {
	    	   try {
	    	   System.out.println("Please enter the ID of the employee to add one absence.");
	    	   int ID = getNextIntFromUser();
	          timer.addToAbsences(ID);
	          System.out.println("Done.You have just add one absent to employee no. " + ID);
	          choice = getNextIntFromUser();
	       } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	       }
	       else if (choice == 102) {
	    	   try {
	    	   System.out.println("Please enter the time."); 
	        	  BigDecimal time =getNextBigDecimalFromUser();
	          timer.setTotalTimeToWorkPerDay(time);
	          System.out.println("Done.You have just add total time work per day to all employees. ");
	          choice = getNextIntFromUser();
	       } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	       }
	       else if (choice == 103) { 
	    	   try {
	    	   System.out.println("Please enter the ID of the employee to set day off.");
	        	  int ID = getNextIntFromUser();
	        	  System.out.println("Please enter the day of the day off of the employee.");
	        	  String day = getNextStringLineFromUser();
	        	  timer.setDayOff(ID, day);
	        	  System.out.println("Done.You have just set dayoff of employee no. " + ID);
	        	  choice = getNextIntFromUser();
	       } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	       }
	       else if (choice == 104) { 
	    	   try {
	    	   System.out.println("Please enter the number of working days of this month."); 
	        	  BigDecimal ndfm =getNextBigDecimalFromUser();
	          timer.salDeductionFactorForAll( ndfm);
	          System.out.println("Done.You have just set the sdf for all employees");
        	  choice = getNextIntFromUser();
	       } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	       }
	       else if (choice == 105) { 
	    	   try {
	    	   System.out.println("Please enter the ttwpd."); 
	        	  BigDecimal ttwd =getNextBigDecimalFromUser();
	          timer.setTotalTimeToWorkPerDay(ttwd);
	          System.out.println("Done.You have just set the ttwpd for all employees");
        	  choice = getNextIntFromUser();
	       } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	       }
	       else if (choice == 106) { 
	    	   timer.addEmployee();
	    	   System.out.println("Done.You have just added a new employee.");
	        	  choice = getNextIntFromUser();
	       }
	       else if (choice == 107) {
	    	   try {
	    	   System.out.println("Please enter 100.");
	    	   int ID = getNextIntFromUser();
	    	   System.out.println("Please enter the ID of the new employee.");
	        	  int newID = getNextIntFromUser();
	    	   timer.setID( ID, newID);
	    	   System.out.println("Done.You have just set the ID number of the new employee.");
	        	  choice = getNextIntFromUser(); } catch(Exception e)
	    	      {System.out.println("Invalid input.");
	    		     scanner.next();
	    		     } 
	       }
	       else if (choice == 108) {
	    	   try {
	    	   System.out.println("Please enter the ID of the new employee.");
	        	  int ID = getNextIntFromUser();
	        	  System.out.println("Please enter the name of the new employee.");
	        	  String name = getNextStringLineFromUser();
	        	  timer.setName(ID, name);
	        	  System.out.println("Done.You have just added a name of a new employee.");
	        	  choice = getNextIntFromUser();
	        	  again = false;
	       } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	       }
	       else if (choice == 109) {
	    	   try {
	    	   System.out.println("Please enter the ID of the employee to be replace.");
	        	  int ID = getNextIntFromUser();
	        	  System.out.println("Please enter the name of the new employee.");
	        	  String newName = getNextStringLineFromUser(); 
	    	   timer.replaceEmployee(ID,newName);
	    	   
	        	  choice = getNextIntFromUser();
	        	  
	       } catch(Exception e)
		      {System.out.println("Invalid input.");
		     scanner.next();
		     } 
	       }
	    	   else if (choice == 110) {
	    		  try {
	    		   System.out.println("Please enter the ID of the employee to be remove.");
		        	  int ID = getNextIntFromUser();
	    		   timer.removeEmployee( ID); 
	    		   choice = getNextIntFromUser();
	    		   } catch(Exception e)
	 		      {System.out.println("Invalid input.");
	 		     scanner.next();
	 		     } 
	    	   }
	    	   else if (choice == 111) {
	    		   try {
	    	    	   System.out.println("Please enter the ID of the employee to add more time at work.");
	    	        	  int ID = getNextIntFromUser();
	    	        	  System.out.println("Please enter the time."); 
	    	        	  BigDecimal time =getNextBigDecimalFromUser();   
	          timer.subtractTimeAtWork( ID, time);
	          choice = getNextIntFromUser();
	    		   } catch(Exception e)
	 		      {System.out.println("Invalid input.");
	 		     scanner.next();
	 		     } 
	    	   }
	    	   else if (choice == 1000) {
	    		   timer.printAdminUse();
	    		   choice = getNextIntFromUser();
	    	   }
	    	   else if ((choice < 0 && choice > 5) || !(choice ==1000)){
	    		   System.out.println("Invalid input.");
	    	   }
	       if (choice == 0) {
	       exit(); 
      	  }  
  	   } again = false;
  	 } catch(Exception e)
	  {System.out.println("invalid input!");
	  scanner.next();}
	  }
	}  
	public void greet() {
		timer.deserializePerson();
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();

        System.out.println("Welcome " + name + "!");
       
    }
	public void exit() { 
		timer.serializePerson();
        System.out.println("Exiting now. Goodbye."); 
        scanner.close();
    }
	 private void printMenu() {  
	        System.out.println();
	        System.out.println("--Main Menu--");
	        System.out.println("Select an option using one of the numbers shown");
	        System.out.println("Please enter only the NUMBER.");
	        System.out.println();
	        MenuChoices[] values = MenuChoices.values();
	        for (MenuChoices v : values) {
	        	
           String s = String.format("%d: %s", v.getId(), v.getDisplayValue());
           System.out.println(s);
	       
	        }
	        
	    } 
	private int getNextIntFromUser() {
        
        return scanner.nextInt();
    }
	 private String getNextStringLineFromUser() { 
	        scanner.nextLine();
	        return scanner.nextLine();
	    }
	 private BigDecimal getNextBigDecimalFromUser() {
		 return scanner.nextBigDecimal();
	 }
	/* private Instant getNextInstantFromUser() {
		 //Scanner scanner = new Scanner(System.in);
		// System.out.print("Enter a date and time (in ISO-8601 format "2023-02-21T16:30:00Z"): ");
		 String input = scanner.nextLine();
		 Instant instant = Instant.parse(input);
   return instant;
	 }*/
}
