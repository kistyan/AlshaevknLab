package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;
import tech.reliab.course.toropchinda.bank.service.PaymentAccountService;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public class PaymentAccountServiceImpl implements PaymentAccountService {
	private static final PaymentAccountServiceImpl INSTANCE = new PaymentAccountServiceImpl();

	private final ArrayList<PaymentAccount> paymentAccounts;

	private PaymentAccountServiceImpl() {
		paymentAccounts = new ArrayList<>();
	}

	public static PaymentAccountServiceImpl getInstance() {
		return INSTANCE;
	}

	@Override
	public PaymentAccount insert(int id, User user, String bankName) {
		PaymentAccount paymentAccount = new PaymentAccount(id, user, bankName);
		paymentAccounts.add(paymentAccount);
		return paymentAccount;
	}

	@Override
	public ArrayList<PaymentAccount> select(Function<PaymentAccount, Boolean> filter) {
		ArrayList<PaymentAccount> results = new ArrayList<>();
		for (PaymentAccount paymentAccount : paymentAccounts)
			if (filter.apply(paymentAccount) == true)
				results.add(paymentAccount);
		return results;
	}

	@Override
	public ArrayList<PaymentAccount> remove(Function<PaymentAccount, Boolean> filter) {
		ArrayList<PaymentAccount> results = select(filter);
		paymentAccounts.removeAll(results);
		return results;
	}

	@Override
	public void update(Function<PaymentAccount, Boolean> filter, Consumer<PaymentAccount> action) {
		for (PaymentAccount paymentAccount : paymentAccounts)
			if (filter.apply(paymentAccount) == true)
				action.accept(paymentAccount);
	}
}
