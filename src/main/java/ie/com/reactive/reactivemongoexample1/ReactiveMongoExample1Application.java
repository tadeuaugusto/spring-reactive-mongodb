package ie.com.reactive.reactivemongoexample1;

import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ie.com.reactive.reactivemongoexample1.model.Employee;
import ie.com.reactive.reactivemongoexample1.repository.EmployeeRepository;

@SpringBootApplication
public class ReactiveMongoExample1Application {

	@Bean
	CommandLineRunner employees(EmployeeRepository employeeRepository) {

		return args -> {
			employeeRepository.deleteAll()
				.subscribe(null, null, () -> {

					Stream.of(new Employee(UUID.randomUUID().toString(), "Peter", 23000L),
							new Employee(UUID.randomUUID().toString(), "Robert", 23000L),
							new Employee(UUID.randomUUID().toString(), "Alysson", 23000L),
							new Employee(UUID.randomUUID().toString(), "Rayka", 23000L),
							new Employee(UUID.randomUUID().toString(), "Debora", 23000L),
							new Employee(UUID.randomUUID().toString(), "Psy", 23000L),
							new Employee(UUID.randomUUID().toString(), "Fi", 23000L))
					.forEach(employee -> {
						employeeRepository
							.save(employee)
							.subscribe(System.out::println);
					});
				});
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(ReactiveMongoExample1Application.class, args);
	}
}
