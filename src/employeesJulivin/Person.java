package employeesJulivin;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
    private BigDecimal timeAtWork;
    private int absences;
    private int tardiness;
    private LocalTime timeIn;
	private Instant start; 
    private Instant end;      
    private ArrayList<String> arriveLeave;
	private String dayOff;
	private BigDecimal totalTimeToWork;
	private BigDecimal sdf;

	
	
	
	public Person(int id, String name, BigDecimal timeAtWork,BigDecimal sdf, int absences,int tardiness,BigDecimal totalTimeToWork, String dayOff,Instant start,Instant end,ArrayList<String> arriveLeave) {
		
		this.id = id;
		this.name = name;
		this.timeAtWork = timeAtWork;
		this.absences = absences;
		this.tardiness = tardiness;
		this.start = start;
		this.end = end;  
		this.arriveLeave= arriveLeave;  
		this.dayOff = dayOff; 
		this.totalTimeToWork = totalTimeToWork;
		this.sdf = sdf;
	}  
	public BigDecimal getSdf() { 
		return sdf;
	}
	public void setSdf(BigDecimal sdf) {
		this.sdf = sdf; 
	}
	public BigDecimal getTotalTimeToWork() {
		return totalTimeToWork;
	}
	public void setTotalTimeToWork(BigDecimal totalTimeToWork) { 
		this.totalTimeToWork = totalTimeToWork;
	}
	public String getDayOff() {
		return dayOff;
	}
	public void setDayOff(String dayOff) {
		this.dayOff = dayOff; 
	}
	public ArrayList<String> getArriveLeave() {
		return arriveLeave;
	}

	public void setArriveLeave(ArrayList<String> arriveLeave) {
		this.arriveLeave = arriveLeave;
	}
	 public BigDecimal getTimeAtWork() {
			return timeAtWork;
		}

		public void setTimeAtWork(BigDecimal timeAtWork) { 
			this.timeAtWork = timeAtWork;  
		}
          public int getId() {
			return id; 
		}
		public void setId(int id) { 
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public int getAbsences() {
			return absences;
		}
		public void setAbsences(int absences) {
			this.absences = absences;
		}
		public int getTardiness() {
			return tardiness;
		}
		public void setTardiness(int tardiness) {
			this.tardiness = tardiness;
		}
		public Instant getStart() {
			return start;
		}
		public void setStart(Instant start) {
			this.start = start;
		}
		public LocalTime getTimeIn() {
			return timeIn;
		}
		public void setTimeIn(LocalTime timeIn) {
			this.timeIn = timeIn;
		}
		public Instant getEnd() {
			return end;
		}
		public void setEnd(Instant end) {
			this.end = end;
		}
		public void addToTimeAtWork(BigDecimal time) {
			setTimeAtWork(getTimeAtWork().add(time));
		}
}
