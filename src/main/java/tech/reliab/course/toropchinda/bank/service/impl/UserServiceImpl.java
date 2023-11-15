package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;
import tech.reliab.course.toropchinda.bank.service.UserService;

import java.util.Date;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Consumer;

public class UserServiceImpl implements UserService {
	private static final UserServiceImpl INSTANCE = new UserServiceImpl();

	private final ArrayList<User> users;

	private UserServiceImpl() {
		users = new ArrayList<>();
	}

	public static UserServiceImpl getInstance() {
		return INSTANCE;
	}

	@Override
	public User insert(int id, String fullName, Date birthDate) {
		User user = new User(id, fullName, birthDate);
		users.add(user);
		return user;
	}

	@Override
	public ArrayList<User> select(Function<User, Boolean> filter) {
		ArrayList<User> results = new ArrayList<>();
		for (User user : users)
			if (filter.apply(user) == true)
				results.add(user);
		return results;
	}

	@Override
	public ArrayList<User> remove(Function<User, Boolean> filter) {
		ArrayList<User> results = select(filter);
		users.removeAll(results);
		return results;
	}

	@Override
	public void update(Function<User, Boolean> filter, Consumer<User> action) {
		for (User user : users)
			if (filter.apply(user) == true)
				action.accept(user);
	}
}
