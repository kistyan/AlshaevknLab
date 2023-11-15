package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.Employee;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public interface BankAtmService {
	BankAtm insert(int id, String name, Bank bank);

	ArrayList<BankAtm> select(Function<BankAtm, Boolean> filter);

	ArrayList<BankAtm> remove(Function<BankAtm, Boolean> filter);

	void update(Function<BankAtm, Boolean> filter, Consumer<BankAtm> action);
}
