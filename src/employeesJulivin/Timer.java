package employeesJulivin;
import java.time.Duration;
import java.time.Instant;

import java.time.LocalTime;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class Timer {
	private String shopName;
   
    private ArrayList<Person> persons;
    private LocalTime presetTime = LocalTime.of(19, 15, 0);
    private LocalTime presetTime1 = LocalTime.of(20, 15, 0);
    private String timeInOut = "7:00 AM to 6:00 PM";
    private String timeInOut1 = "8:00 AM to 7:00 PM";
    
    
    public Timer(String shopName, ArrayList<Person> persons) {
	
		this.shopName = shopName;
		
		this.persons = persons;
		
	}	
   
    public void clearTimecardAll() {
    	for(Person p : persons) { 
    	(p.getArriveLeave()).clear();
    	}
    }
    
    public void clearTimecard(int ID) {
    	Person p = findEmployeeByID(ID);
    	p.getArriveLeave().clear();
    }
		public String getShopName() {
			return shopName;
		}

		public void setShopName(String shopName) {
			this.shopName = shopName;
		}

		
		public ArrayList<Person> getPersons() {
			return persons;
		}

		public void setPersons(ArrayList<Person> persons) {
			this.persons = persons;
		}
		public Person findEmployeeByID(int ID) {
			    Person personnel = null;
			for(Person p : persons) {
				if (p.getId() == ID) {
					personnel = p;
				}
			}return personnel;
		}
		public void replaceEmployee(int ID, String newName) {
			Person p = findEmployeeByID(ID);
			String n = p.getName();
			p.setName(newName);
			 System.out.println("Done.You have just replaced " + n + " with " + newName + ".");
       	  
		}
		public void removeEmployee(int ID) {
  	     Person p = findEmployeeByID(ID);
			persons.remove(p);
			 System.out.println("Done.You have just remove " + p.getName() + ".");
		}
		public void addEmployee() {
			
			Person person = new Person(100, "Pedro",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Monday",null,null,new ArrayList<String>());
		        persons.add(person);
		        System.out.println("You have just added another person. Please set the ID number, name, and dayOff");
		}
		public void setID(int ID, int newID) {
			Person p = findEmployeeByID(ID);
			if (p.getId() == ID) {
				p.setId(newID);
			}
		}
		public void setName(int newID, String name) {
			Person p = findEmployeeByID(newID);
			 p.setName(name);
		}public void listPersons1() {
			System.out.println( "ID No.        name                DayOff       TTWPD      Time to Work");
			for(Person p : persons) {
				System.out.println(String.format("%2d       %-15s  %15s   %8.1f    %8s", p.getId(),p.getName(),p.getDayOff(),p.getTotalTimeToWork(),timeInOut));
			}
		}
				public void listPersons() {
					
			System.out.println( "ID No.    name                   Absences   Tardiness        TimeAtWork   TTWPD        sdf     ");
			System.out.println( "                                    (this month)              (hours)                         ");
			for(Person p : persons) {
				System.out.println(String.format("%2d       %-12s      %12d   %8d   %15.4f  %8.1f    %8.2f", p.getId(),p.getName(),p.getAbsences(),p.getTardiness(), p.getTimeAtWork(),p.getTotalTimeToWork(),p.getSdf()));
			}
		}
		public void setDayOff(int ID, String day) {
			Person p = findEmployeeByID(ID);
			p.setDayOff(day);
		}
		public void setTotalTimeToWorkPerDayForOne(BigDecimal time, int ID) { 
			Person p = findEmployeeByID(ID);
			 
				p.setTotalTimeToWork(time);
			} 
		
		public void setTotalTimeToWorkPerDayForAll(BigDecimal time) { 
			for (Person p : persons) {
				p.setTotalTimeToWork(time);
			} 
		}
		public void timeIn(int ID) {
			Date date = new Date(); 
			Instant start = null;
		Person p =findEmployeeByID(ID);
			if( ID == p.getId()) {
			 start = Instant.now();
			 p.setStart(start);
			 System.out.println(date.toString());
			 if (((date.toString()).substring(0,2)).equalsIgnoreCase((p.getDayOff().substring(0,2)))){
                 System.out.println("You are not scheduled to work today!!! Please ask the manager for permit to work!");
                 p.setStart(null);
			 } else {  p.getArriveLeave().add((date.toString()).substring(0,20));
             System.out.println("Done.You have just time in");
                  LocalTime presetTime = p.getTimeIn();
                  LocalTime currentTime = LocalTime.now();
                  Duration elapsedTime = Duration.between(presetTime, currentTime);
                  Long time =  elapsedTime.toMinutes();
       		      double timehr =(double)(time);
                  // comparison = currentTime.compareTo(presetTime);
                  //if (currentTime.compareTo(presetTime) <= 0) {
       		      if (timehr <= 0) {
            System.out.println("Congrats! You are early. Keep it up!");
                   } 
       		      //else if (currentTime.compareTo(presetTime) > 0) {
       		      else if (timehr > 15 && timehr < 60) {
            System.out.println("You are late by " + timehr + " minutes, Please come on time next time!");
            	    p.setTardiness(p.getTardiness() + 1);
            	    System.out.println("Number of Tardiness for this month: " + p.getTardiness());
            	} else if (timehr > 60 && timehr < 600)
            	{ p.setAbsences(p.getAbsences()+1); 
            	}else { p.setStart(null);
            	}
             }
                   } 
		                         }
            
		public void timeIn1(int ID) {
			Date date = new Date(); 
			Instant start = null;
		Person p =findEmployeeByID(ID);
			if( ID == p.getId()) {
			 start = Instant.now();
			 p.setStart(start);
			 System.out.println(date.toString());
			if (((date.toString()).substring(0,2)).equalsIgnoreCase((p.getDayOff().substring(0,2)))){
                 System.out.println("You are not scheduled to work today!!! Please ask the manager for permit to work!");
              p.setStart(null);
			  }else{  p.getArriveLeave().add((date.toString()).substring(0,20));
            System.out.println("Done.You have just time in");
            } 
		}
         }       
		
		public void setAbsencesZeroAll() {
			for (Person p : persons) {
			p.setAbsences(0);
			}
		}
		public void setTardinessZeroAll() {
			for (Person p : persons) {
				 p.setTardiness(0);
			}
		}
		public void setTimeAtWorkZeroAll() {
			for (Person p : persons) {
				p.setTimeAtWork(BigDecimal.valueOf(0));
			}
		}
		public void setTimeAtWorkZero(int ID) {
			Person p = findEmployeeByID(ID);
			p.setTimeAtWork(BigDecimal.valueOf(0));
		}
		public void setTimeToTimeIn(int ID) {
			Person p = findEmployeeByID(ID);
			p.setTimeIn(presetTime);
		}
		public void setTimeToTimeIn1(int ID) {
			Person p = findEmployeeByID(ID);
			p.setTimeIn(presetTime1);
		}
		public void addToAbsences(int ID) {
			Person p = findEmployeeByID(ID);
			p.setAbsences(p.getAbsences() + 1);
		}
		public void addToTimeAtWork(int ID, BigDecimal time) {
			Person p = findEmployeeByID(ID); 
			p.setTimeAtWork(p.getTimeAtWork().add(time));
		}
		public void subtractTimeAtWork(int ID, BigDecimal time) {
			Person p = findEmployeeByID(ID); 
			p.setTimeAtWork(p.getTimeAtWork().subtract(time));
		}
		 
		public void salDeductionFactor(int ID, BigDecimal ndfm) {
			//BigDecimal sdf = null;
			Person p = findEmployeeByID(ID); 
			BigDecimal sdf = p.getTimeAtWork().divide(p.getTotalTimeToWork().multiply(ndfm));
			p.setSdf(sdf);
		}
		public void salDeductionFactorForAll( BigDecimal ndfm) {
			for (Person p : persons) {
				//BigDecimal sdf = p.getTimeAtWork().divide(p.getTotalTimeToWork().multiply(ndfm));
				BigDecimal sdf = p.getTimeAtWork().divide((p.getTotalTimeToWork().multiply(ndfm)), 2, RoundingMode.HALF_UP);

				p.setSdf(sdf);
			}
		}
		public void timeOutTimeElapsed1(int ID) { 
			Date date = new Date();
			BigDecimal d = BigDecimal.valueOf(0); 
		Person p =findEmployeeByID(ID); 
			if( ID == p.getId()) {
			Instant end = Instant.now(); 
			 p.setEnd(end);
			System.out.println(date.toString());
			System.out.println("Start: " + p.getStart() + "    End: " + p.getEnd());
		    Duration timeElapsed = Duration.between(p.getStart(),p.getEnd());
		       Instant en = p.getEnd();
		    if (en != null) {
		    	
		    
		     Long time = timeElapsed.toMinutes();
		     double timehr =(double)(time);
		     if ((timehr > 780) ||  (timehr <= 0)) {
		    	 p.addToTimeAtWork(BigDecimal.valueOf(0));
                         p.setAbsences(p.getAbsences() + 1);
                     
		     }else {
		      d = BigDecimal.valueOf(time);
		      System.out.println("You have worked for a total of " + time + " minutes.");
		      p.addToTimeAtWork(d);
		     } } else {
		    	 System.out.println("Forgot to time out!"); 
		    	// p.addToTimeAtWork(BigDecimal.valueOf(0));
		     }
		     p.getArriveLeave().add((date.toString()).substring(0,20));
		} 
} 
		public void timeOutTimeElapsed(int ID) { 
			Date date = new Date();
			BigDecimal d = BigDecimal.valueOf(0); 
		Person p =findEmployeeByID(ID); 
			if( ID == p.getId()) {
			Instant end = Instant.now(); 
			 p.setEnd(end);
			System.out.println(date.toString());
			Instant instant =  p.getStart(); // get The current time in instant object
			Timestamp t=java.sql.Timestamp.from(instant);
			Timestamp r=java.sql.Timestamp.from(end);
			//System.out.println("Start: " + p.getStart() + "    End: " + p.getEnd());
			System.out.println("Start: " + t + "    End: " + r);
		    Duration timeElapsed = Duration.between(p.getStart(),p.getEnd());
		       Instant en = p.getEnd();
		    if (en != null) {
		    	Long time = timeElapsed.toMinutes(); 
		     double timehr =(double)(time);
		     if (timehr > 780)  {
		    	 p.addToTimeAtWork(BigDecimal.valueOf(0));
		     }else {
		      d = BigDecimal.valueOf(time);
		      System.out.println("You have worked for a total of " + time + " minutes.");
		      p.addToTimeAtWork(d);
		     } } else {
		    	 System.out.println("Forgot to time out!"); 
		    	// p.addToTimeAtWork(BigDecimal.valueOf(0));
		     }
		    
		     p.getArriveLeave().add((date.toString()).substring(0,20));
		} 
} 
		public void convertTimeAtWorkToHour() {
			for (Person p : persons) {
				p.setTimeAtWork(p.getTimeAtWork().divide(BigDecimal.valueOf(60)));
			}
		}
		public void printTimeCard(int ID) {
			Person p = findEmployeeByID(ID);
			System.out.println("--------------------------------------------------------- ");
			 System.out.println(" Name: " + p.getName());
			 System.out.println("                    T I M E      C A R D ");
			// System.out.println(String.format(" %20s", nameYear ));
			 System.out.println("      --Arrive--            |            --Leave--");
			for(int i = 0; i< (p.getArriveLeave()).size(); i +=2) {
				System.out.println(String.format(" %2s         %4s",(p.getArriveLeave()).get(i),(p.getArriveLeave()).get(i +1)));
			}
		}
		public void serializePerson() {
			  try 
				 (FileOutputStream fos = new FileOutputStream("C:\\Users\\rvuy6\\OneDrive\\Documents\\SerializePerson.txt");
				     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				  oos.writeObject(persons);
				} catch (IOException e) {
				  e.printStackTrace();
				}
		}
		public void deserializePerson() {
			//ArrayList<Product> products = new ArrayList<Product>();

			try (FileInputStream fis = new FileInputStream("C:\\Users\\rvuy6\\OneDrive\\Documents\\SerializePerson.txt");
			     ObjectInputStream ois = new ObjectInputStream(fis)) {
			  ArrayList<Person> deserializedPerson = (ArrayList<Person>) ois.readObject();
			persons.clear();
			  persons.addAll(deserializedPerson);
			  
			} catch (EOFException e) {
				  System.out.println("Reached end of file.");
			} catch (IOException | ClassNotFoundException e) { 
			  e.printStackTrace();
			}
		}
		public void printAdminUse() { 
			System.out.println("");
			System.out.println(" 100  -  To add to an employee more time working on this day(in case of time card error).");
			System.out.println(" 111  -  To subtract to an employee some time working on this day(in case of time card error).");
			System.out.println(" 101  -  To add one absent to an employee.");
			System.out.println(" 102  -  To set the total time to work per day to all employees.");
			System.out.println(" 103  -  To set the day(for example: Saturday or Monday) of dayOff of an employee.");
			System.out.println(" 104  -  To calculate and set the salary deduction factor(sdf) for all employees ");
			System.out.println("         by entering the total number of working days of a certain month(by counting them in the calendar");
			System.out.println(" 105  -  To set the total time to work per day(ttwpd) for one employee.");
			System.out.println("");
			System.out.println(" 106  -  To add a new slot in the list for a new employee.");
			System.out.println(" 107  -  To assign an ID number for the new employee created by a new slot in Option 106.");
			System.out.println(" 108  -  To set the name of the new employee assigned with the ID number in Option 107.");
			System.out.println(" 109  -  To replace an employee with a new one.");
			System.out.println(" 110  -  To remove an employee from the list.");
			System.out.println(" 112  -  To set time 7:15 for Time In of an employee.");
			System.out.println(" 113  -  To set time 8:15 for Time In of an employee.");
			System.out.println(" 114  -  To set to zero the absences for all employee.");
			System.out.println(" 115  -  To set to zero the tardiness for all employee.");
			System.out.println(" 116  -  To clear the Timecard all employee.");
			System.out.println(" 117  -  To clear the Timecard of an employee.");
			System.out.println(" 118  -  To set Time At Work to Zero for all employees.");
			System.out.println(" 119  -  To set Time At Work to Zero for an employee.");
		}
}
			 