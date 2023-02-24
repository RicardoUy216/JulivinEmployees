package employeesJulivin;

public enum MenuChoices {
	EXIT(0, "Exit"),
    TIME_IN(1, "Time In"), 
    TIME_OUT(2, "Time out"), 
    LIST_EMPLOYEES(3, "List Employees"),
    SHOW_TIMECARD(4, "Show Timecard"),
    SHOW_EMPLOYEE_DATA(5,"Show Employee's Info");
   
    
     
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
