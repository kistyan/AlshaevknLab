package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;
import tech.reliab.course.toropchinda.bank.service.CreditAccountService;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.Collections;

public class CreditAccountServiceImpl implements CreditAccountService {
	private static final CreditAccountServiceImpl INSTANCE = new CreditAccountServiceImpl();

	private final ArrayList<CreditAccount> creditAccounts;

	private CreditAccountServiceImpl() {
		creditAccounts = new ArrayList<>();
	}

	public static CreditAccountServiceImpl getInstance() {
		return INSTANCE;
	}

	@Override
	public CreditAccount insert(int id) {
		CreditAccount creditAccount = new CreditAccount(id);
		creditAccounts.add(creditAccount);
		return creditAccount;
	}

	@Override
	public ArrayList<CreditAccount> select(Function<CreditAccount, Boolean> filter) {
		ArrayList<CreditAccount> results = new ArrayList<>();
		for (CreditAccount creditAccount : creditAccounts)
			if (filter.apply(creditAccount) == true)
				results.add(creditAccount);
		return results;
	}

	@Override
	public ArrayList<CreditAccount> remove(Function<CreditAccount, Boolean> filter) {
		ArrayList<CreditAccount> results = select(filter);
		creditAccounts.removeAll(results);
		return results;
	}

	@Override
	public void update(Function<CreditAccount, Boolean> filter, Consumer<CreditAccount> action) {
		for (CreditAccount creditAccount : creditAccounts)
			if (filter.apply(creditAccount) == true)
				action.accept(creditAccount);
	}

	@Override
    public int getFreeId() {
		Collections.sort(creditAccounts, (first, second) -> first.getId() - second.getId());
		int freeId = 0;
		for (CreditAccount creditAccount : creditAccounts)
			if (creditAccount.getId() == freeId)
				freeId++;
			else
				if (freeId < creditAccount.getId())
					break;
		return freeId;
	}
}
