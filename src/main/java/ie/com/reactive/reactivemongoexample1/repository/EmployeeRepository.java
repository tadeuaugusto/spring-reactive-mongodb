package ie.com.reactive.reactivemongoexample1.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import ie.com.reactive.reactivemongoexample1.model.Employee;

public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String>{

}
