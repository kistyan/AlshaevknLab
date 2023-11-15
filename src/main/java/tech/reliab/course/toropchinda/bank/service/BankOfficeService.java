package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.BankOffice;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public interface BankOfficeService {
	BankOffice insert(int id, String name);

	ArrayList<BankOffice> select(Function<BankOffice, Boolean> filter);

	ArrayList<BankOffice> remove(Function<BankOffice, Boolean> filter);

	void update(Function<BankOffice, Boolean> filter, Consumer<BankOffice> action);
}
