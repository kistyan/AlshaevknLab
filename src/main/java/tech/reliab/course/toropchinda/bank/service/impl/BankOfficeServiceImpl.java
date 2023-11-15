package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.service.BankOfficeService;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

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
}
