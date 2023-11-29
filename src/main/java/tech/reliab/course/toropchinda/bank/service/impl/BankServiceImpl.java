package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.User;
import tech.reliab.course.toropchinda.bank.service.BankService;
import tech.reliab.course.toropchinda.bank.service.impl.UserServiceImpl;
import tech.reliab.course.toropchinda.bank.service.impl.BankOfficeServiceImpl;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.Collections;

public class BankServiceImpl implements BankService {
	private static final BankServiceImpl INSTANCE = new BankServiceImpl();

	private final ArrayList<Bank> banks;

	private BankServiceImpl() {
		banks = new ArrayList<>();
	}

	public static BankServiceImpl getInstance() {
		return INSTANCE;
	}

	@Override
	public Bank insert(int id, String name) {
		Bank bank = new Bank(id, name);
		banks.add(bank);
		return bank;
	}

	@Override
	public ArrayList<Bank> select(Function<Bank, Boolean> filter) {
		ArrayList<Bank> results = new ArrayList<>();
		for (Bank bank : banks)
			if (filter.apply(bank) == true)
				results.add(bank);
		return results;
	}

	@Override
	public ArrayList<Bank> remove(Function<Bank, Boolean> filter) {
		ArrayList<Bank> results = select(filter);
		banks.removeAll(results);
		return results;
	}

	@Override
	public void update(Function<Bank, Boolean> filter, Consumer<Bank> action) {
		for (Bank bank : banks)
			if (filter.apply(bank) == true)
				action.accept(bank);
	}

	@Override
	public int getFreeId() {
		Collections.sort(banks, (first, second) -> first.getId() - second.getId());
		int freeId = 0;
		for (Bank bank : banks)
			if (bank.getId() == freeId)
				freeId++;
			else
				if (freeId < bank.getId())
					break;
		return freeId;
	}

	@Override
	public BankOffice addOffice(Bank bank) {
		BankOfficeServiceImpl officeService = BankOfficeServiceImpl.getInstance();
		BankOffice office = BankOfficeServiceImpl.getInstance().insert(
				officeService.getFreeId(),
				bank.getName()
		);
		bank.setOfficeCount(bank.getOfficeCount() + 1);
		return office;
	}

	@Override
	public void addClient(Bank bank, User user) {
		user.getBanks().add(bank);
		bank.setClientCount(bank.getClientCount() + 1);
	}
}
