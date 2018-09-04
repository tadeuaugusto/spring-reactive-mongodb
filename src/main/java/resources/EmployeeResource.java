package resources;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ie.com.reactive.reactivemongoexample1.model.Employee;
import ie.com.reactive.reactivemongoexample1.model.EmployeeEvent;
import ie.com.reactive.reactivemongoexample1.repository.EmployeeRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
@RequestMapping("/rest/employee")
public class EmployeeResource {

	private EmployeeRepository employeeRepository;
	
	public EmployeeResource(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@GetMapping("/all")
	public Flux<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Mono<Employee> getId(@PathVariable("id") final String empId) {
		return employeeRepository.findById(empId);
	}
	
	@GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<EmployeeEvent> getEvents(@PathVariable("id") final String empId) {
		return employeeRepository.findById(empId)
			.flatMapMany(employee -> {
				Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));				
				Flux<EmployeeEvent> employeeEventFlux = Flux.fromStream(
						Stream.generate(() -> new EmployeeEvent(employee, new Date()))
				);
				
				return Flux.zip(interval, employeeEventFlux)
				// returns a map only the second tuple's object - employeeEvent
				.map(Tuple2::getT2);

				/*
				.map(objects -> {		
						return objects.getT2();
					});
				*/
			});
	}
	
}
