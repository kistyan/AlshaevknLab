package tech.reliab.course.toropchinda.bank.entity;

import java.util.Date;
import java.util.ArrayList;

public class User {
	private int id;
	private String fullName, workPlace;
	private Date birthDate;
	private double monthlyIncome, creditRating;
	private ArrayList<Bank> banks;
	private ArrayList<CreditAccount> creditAccounts;
	private ArrayList<PaymentAccount> paymentAccounts;

	public User(int id, String fullName, Date birthDate) {
		this.id = id;
		this.fullName = fullName;
		this.birthDate = birthDate;
		workPlace = new String();
		monthlyIncome = Math.random() * 10_000;
		creditRating = monthlyIncome / 10 + 100 * (Math.random() - 1);
		banks = new ArrayList<>();
		creditAccounts = new ArrayList<>();
		paymentAccounts = new ArrayList<>();
	}

	// Возвращает идентификатор пользователя
	public int getId() {
		return id;
	}

	// Присваивает идентификатору пользователя значение id
	public void setId(int id) {
		this.id = id;
	}

	// Возвращает ФИО пользователя
	public String getFullName() {
		return fullName;
	}

	// Приваивает ФИО пользователя значение fullName
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	// Возвращает место работы пользователя
	public String getWorkPlace() {
		return workPlace;
	}

	// Присваивает месту работы пользователя значение workPlace
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	// Возвращает дату рождения пользователя
	public Date getBirthDate() {
		return birthDate;
	}

	// Присваивает дате рождения пользователя значение birthDate
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	// Возвращает ежемесячный доход пользователся
	public double getMonthlyIncome() {
		return monthlyIncome;
	}

	// Присваивает ежемесячному доходу пользователся значение monthlyIncome
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	// Возвращает кредитный рейтинг пользователя
	public double getCreditRating() {
		return creditRating;
	}

	// Присваивает кредитному рейтингу пользователя значение creditRating
	public void setCreditRating(double creditRating) {
		this.creditRating = creditRating;
	}

	// Возвращает список банков пользователя
	public ArrayList<Bank> getBanks() {
		return banks;
	}

	// Возвращает список кредитных счетов пользователя
	public ArrayList<CreditAccount> getCreditAccounts() {
		return creditAccounts;
	}

	// Возвращает список платёжных счетов пользователя
	public ArrayList<PaymentAccount> getPaymentAccounts() {
		return paymentAccounts;
	}
}
