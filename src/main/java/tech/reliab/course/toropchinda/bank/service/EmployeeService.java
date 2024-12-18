package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.Employee;

import java.util.Date;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public interface EmployeeService {
	Employee insert(int id, String fullName, Date birthDate);

	ArrayList<Employee> select(Function<Employee, Boolean> filter);

	ArrayList<Employee> remove(Function<Employee, Boolean> filter);

	void update(Function<Employee, Boolean> filter, Consumer<Employee> action);

	int getFreeId();
}
