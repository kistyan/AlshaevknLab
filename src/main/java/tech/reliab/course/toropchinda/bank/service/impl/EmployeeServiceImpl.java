package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.service.EmployeeService;

import java.util.Date;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public class EmployeeServiceImpl implements EmployeeService {
	private static final EmployeeServiceImpl INSTANCE = new EmployeeServiceImpl();

	private final ArrayList<Employee> employees;

	private EmployeeServiceImpl() {
		employees = new ArrayList<>();
	}

	public static EmployeeServiceImpl getInstance() {
		return INSTANCE;
	}

	@Override
	public Employee insert(int id, String fullName, Date birthDate) {
		Employee employee = new Employee(id, fullName, birthDate);
		employees.add(employee);
		return employee;
	}

	@Override
	public ArrayList<Employee> select(Function<Employee, Boolean> filter) {
		ArrayList<Employee> results = new ArrayList<>();
		for (Employee employee : employees)
			if (filter.apply(employee) == true)
				results.add(employee);
		return results;
	}

	@Override
	public ArrayList<Employee> remove(Function<Employee, Boolean> filter) {
		ArrayList<Employee> results = select(filter);
		employees.removeAll(results);
		return results;
	}

	@Override
	public void update(Function<Employee, Boolean> filter, Consumer<Employee> action) {
		for (Employee employee : employees)
			if (filter.apply(employee) == true)
				action.accept(employee);
	}
}
