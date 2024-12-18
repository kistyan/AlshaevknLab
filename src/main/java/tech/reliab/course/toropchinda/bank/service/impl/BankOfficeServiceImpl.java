package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.service.BankOfficeService;
import tech.reliab.course.toropchinda.bank.service.impl.BankServiceImpl;
import tech.reliab.course.toropchinda.bank.service.impl.BankAtmServiceImpl;
import tech.reliab.course.toropchinda.bank.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.Collections;
import java.util.Date;

public class BankOfficeServiceImpl implements BankOfficeService {
	private static final BankOfficeServiceImpl INSTANCE = new BankOfficeServiceImpl();

	private final ArrayList<BankOffice> bankOffices;

	private BankOfficeServiceImpl() {
		bankOffices = new ArrayList<>();
	}

	public static BankOfficeServiceImpl getInstance() {
		return INSTANCE;
	}

	@Override
	public BankOffice insert(int id, String name) {
		BankOffice bankOffice = new BankOffice(id, name);
		bankOffices.add(bankOffice);
		return bankOffice;
	}

	@Override
	public ArrayList<BankOffice> select(Function<BankOffice, Boolean> filter) {
		ArrayList<BankOffice> results = new ArrayList<>();
		for (BankOffice bankOffice : bankOffices)
			if (filter.apply(bankOffice) == true)
				results.add(bankOffice);
		return results;
	}

	@Override
	public ArrayList<BankOffice> remove(Function<BankOffice, Boolean> filter) {
		ArrayList<BankOffice> results = select(filter);
		bankOffices.removeAll(results);
		return results;
	}

	@Override
	public void update(Function<BankOffice, Boolean> filter, Consumer<BankOffice> action) {
		for (BankOffice bankOffice : bankOffices)
			if (filter.apply(bankOffice) == true)
				action.accept(bankOffice);
	}

	@Override
	public int getFreeId() {
		Collections.sort(bankOffices, (first, second) -> first.getId() - second.getId());
		int freeId = 0;
		for (BankOffice bankOffice : bankOffices)
			if (bankOffice.getId() == freeId)
				freeId++;
			else
				if (freeId < bankOffice.getId())
					break;
		return freeId;
	}

	@Override
	public Bank getBank(BankOffice office) {
		BankServiceImpl bankService = BankServiceImpl.getInstance();
		ArrayList<Bank> banks = bankService.select((bank) ->
				bank.getName().equals(office.getName()));
		return banks.get(0);
	}

	@Override
	public BankAtm addBankAtm(BankOffice office, String name) {
		Bank bank = getBank(office);
		BankAtmServiceImpl bankAtmService = BankAtmServiceImpl.getInstance();
		BankAtm atm = bankAtmService.insert(
				bankAtmService.getFreeId(),
				name,
				bank
		);
		atm.setLocation(office);
		office.setAtmCount(office.getAtmCount() + 1);
		bank.setAtmCount(bank.getAtmCount() + 1);
		return atm;
	}

	@Override
	public Employee addEmployee(
			BankOffice office,
			String name,
			Date birthDate,
			String jobTitle
	) {
		Bank bank = getBank(office);
		EmployeeServiceImpl employeeService = EmployeeServiceImpl.getInstance();
		Employee employee = employeeService.insert(
				employeeService.getFreeId(),
				name,
				birthDate
		);
		employee.setBank(bank);
		employee.setOffice(office);
		employee.setJobTitle(jobTitle);
		bank.setEmployeeCount(bank.getEmployeeCount() + 1);
		return employee;
	}
}
