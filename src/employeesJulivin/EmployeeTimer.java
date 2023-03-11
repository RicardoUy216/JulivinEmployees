package employeesJulivin;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeTimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ArrayList<Person> person = new ArrayList<Person>();
person.add(new Person(1, "JayR",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Sunday",null,null,new ArrayList<String>()));	
person.add(new Person(2, "Johnny",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Saturday",null,null,new ArrayList<String>()));
person.add(new Person(3, "Ruby",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Tuesday",null,null,new ArrayList<String>()));
person.add(new Person(4, "Ailyn",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Monday",null,null,new ArrayList<String>()));	
person.add(new Person(5, "Ramil",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Wednesday",null,null,new ArrayList<String>()));
person.add(new Person(6, "Dave",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Thursday",null,null,new ArrayList<String>()));
person.add(new Person(7, "Cario",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Friday",null,null,new ArrayList<String>()));	
person.add(new Person(8, "Jannah",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Saturday",null,null,new ArrayList<String>()));
person.add(new Person(9, "Jaymark",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Tuesday",null,null,new ArrayList<String>()));
person.add(new Person(10, "Gilbert",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Sunday",null,null,new ArrayList<String>()));	
person.add(new Person(11, "Vanessa",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Wednesday",null,null,new ArrayList<String>()));
person.add(new Person(12, "Eppie",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Thursday",null,null,new ArrayList<String>()));
person.add(new Person(13, "Jenir",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Friday",null,null,new ArrayList<String>()));	
person.add(new Person(14, "Andrea",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Saturday",null,null,new ArrayList<String>()));
person.add(new Person(15, "Robert",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Tuesday",null,null,new ArrayList<String>()));
person.add(new Person(16, "Jelo",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Sunday",null,null,new ArrayList<String>()));	
person.add(new Person(17, "Trishamae",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Wednesday",null,null,new ArrayList<String>()));
person.add(new Person(18, "Carlo",BigDecimal.valueOf(0),BigDecimal.valueOf(0),(0),0,BigDecimal.valueOf(0),"Thursday",null,null,new ArrayList<String>()));



 


Timer timer = new Timer("shopName", person);
	Menu menu = new Menu(new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8"))),timer);

	menu.greet();
	menu.executeMenu();     
	} 	
}
