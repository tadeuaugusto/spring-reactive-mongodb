package ie.com.reactive.reactivemongoexample1.model;

import java.util.Date;

/**
@NoArgsConstructor
@AllArgsConstructor
@Data
*/
public class EmployeeEvent {

	public EmployeeEvent(Employee employee, Date date) {
		// TODO Auto-generated constructor stub
		this.employee = employee;
		this.date = date;
	}
	
	private Employee employee;
	private Date date;
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
