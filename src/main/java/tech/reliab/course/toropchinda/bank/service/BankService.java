package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.User;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public interface BankService {
	Bank insert(int id, String name);

	ArrayList<Bank> select(Function<Bank, Boolean> filter);

	ArrayList<Bank> remove(Function<Bank, Boolean> filter);

	void update(Function<Bank, Boolean> filter, Consumer<Bank> action);

	int getFreeId();

	BankOffice addOffice(Bank bank);

	void addClient(Bank bank, User user);
}
