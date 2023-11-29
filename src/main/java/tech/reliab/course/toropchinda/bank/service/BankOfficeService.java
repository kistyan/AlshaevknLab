package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.Employee;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.Date;

public interface BankOfficeService {
	BankOffice insert(int id, String name);

	ArrayList<BankOffice> select(Function<BankOffice, Boolean> filter);

	ArrayList<BankOffice> remove(Function<BankOffice, Boolean> filter);

	void update(Function<BankOffice, Boolean> filter, Consumer<BankOffice> action);

	int getFreeId();

	Bank getBank(BankOffice office);

	BankAtm addBankAtm(BankOffice office, String name);

	Employee addEmployee(
			BankOffice office,
			String name,
			Date birthDate,
			String jobTitle
	);
}
