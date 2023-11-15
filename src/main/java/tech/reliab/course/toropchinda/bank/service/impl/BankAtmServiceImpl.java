package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.service.BankAtmService;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public class BankAtmServiceImpl implements BankAtmService {
	private static final BankAtmServiceImpl INSTANCE = new BankAtmServiceImpl();

	private final ArrayList<BankAtm> bankAtms;

	private BankAtmServiceImpl() {
		bankAtms = new ArrayList<>();
	}

	public static BankAtmServiceImpl getInstance() {
		return INSTANCE;
	}

	@Override
	public BankAtm insert(int id, String name, Bank bank) {
		BankAtm bankAtm = new BankAtm(id, name, bank);
		bankAtms.add(bankAtm);
		return bankAtm;
	}

	@Override
	public ArrayList<BankAtm> select(Function<BankAtm, Boolean> filter) {
		ArrayList<BankAtm> results = new ArrayList<>();
		for (BankAtm bankAtm : bankAtms)
			if (filter.apply(bankAtm) == true)
				results.add(bankAtm);
		return results;
	}

	@Override
	public ArrayList<BankAtm> remove(Function<BankAtm, Boolean> filter) {
		ArrayList<BankAtm> results = select(filter);
		bankAtms.removeAll(results);
		return results;
	}

	@Override
	public void update(Function<BankAtm, Boolean> filter, Consumer<BankAtm> action) {
		for (BankAtm bankAtm : bankAtms)
			if (filter.apply(bankAtm) == true)
				action.accept(bankAtm);
	}
}
