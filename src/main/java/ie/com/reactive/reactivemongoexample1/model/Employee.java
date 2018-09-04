package ie.com.reactive.reactivemongoexample1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@Data
*/
@Document
public class Employee {

	public Employee(String id, String name, long salary) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Id
	private String id;
	private String name;
	private Long salary;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
}
