package employeesJulivin;

public enum MenuChoices {
	EXIT(0, "Exit"),
    TIME_IN(1, "Time In"), 
    TIME_OUT(2, "Time out"), 
    SHOW_EMPLOYEE_DATA(3, "Show Employee's Info"),
    SHOW_TIMECARD(4, "Show Timecard"),
    LIST_EMPLOYEES(5,"List Employees");
   
    
      
private int id;  
private String displayValue;

private MenuChoices(int id, String displayValue){ 
this.id = id;    
this.displayValue = displayValue; 
}    
public int getId() { 
   return this.id;     
}
public String getDisplayValue() {
   return this.displayValue;    
}
public static MenuChoices fromOptionId(int optionId){
   for (MenuChoices value : values()) { 
	   if (optionId == value.getId()) {  
	   return value;
	   
   } 
} 
      return null;
   
} 
}
