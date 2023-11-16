package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public interface CreditAccountService {
	CreditAccount insert(int id);

	ArrayList<CreditAccount> select(Function<CreditAccount, Boolean> filter);

	ArrayList<CreditAccount> remove(Function<CreditAccount, Boolean> filter);

	void update(Function<CreditAccount, Boolean> filter, Consumer<CreditAccount> action);

	int getFreeId();
}
