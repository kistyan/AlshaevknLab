package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;

import java.util.Date;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public interface UserService {
	User insert(int id, String fullName, Date birthDate);

	ArrayList<User> select(Function<User, Boolean> filter);

	ArrayList<User> remove(Function<User, Boolean> filter);

	void update(Function<User, Boolean> filter, Consumer<User> action);
}
