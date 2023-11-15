package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public interface PaymentAccountService {
	PaymentAccount insert(int id, User user, String bankName);

	ArrayList<PaymentAccount> select(Function<PaymentAccount, Boolean> filter);

	ArrayList<PaymentAccount> remove(Function<PaymentAccount, Boolean> filter);

	void update(Function<PaymentAccount, Boolean> filter, Consumer<PaymentAccount> action);
}
