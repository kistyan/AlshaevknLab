package tech.reliab.course.toropchinda.bank.entity;

import java.util.Date;

public class CreditAccount {
	private int id, monthNumber;
	private double creditAmount, monthlyPayment, interestRate;
	private User user;
	private String bankName;
	private Date startDate, endDate;
	private Employee employee;
	private PaymentAccount paymentAccount;

	public CreditAccount(int id) {
		this.id = id;
		creditAmount = monthlyPayment = interestRate = 0;
		user = null;
		startDate = endDate = null;
		employee = null;
		paymentAccount = null;
		bankName = new String();
	}

	// Возвращает идентификатор кредитного счёта
	public int getId() {
		return id;
	}

	// Присваивает идентификатору кредитного счёта значение id
	public void setId(int id) {
		this.id = id;
	}

	// Возвращает количество месяцев, на которое взят кредит
	public int getMonthNumber() {
		return monthNumber;
	}

	// Присваивает количеству месяцев, на которое взят кредит, значение monthNumber
	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}

	// Возвращает сумму кредита
	public double getCreditAmount() {
		return creditAmount;
	}

	// Присваивает сумме кредита значение creditAmount
	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	// Возвращает сумму ежемесячного платежа
	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	// Присваивает сумме ежемесячного платежа значение monthlyPayment
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	// Возвращает процентную ставку
	public double getInterestRate() {
		return interestRate;
	}

	// Присваивает процентной ставке значение interestRate
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	// Возвращает пользователя, за которым закреплён кредитный счёт
	public User getUser() {
		return user;
	}

	// Присваивает пользователю, за которым закреплён кредитный счёт, значение user
	public void setUser(User user) {
		this.user = user;
	}

	// Возвращет название банка
	public String getBankName() {
		return bankName;
	}

	// Присваивает названию банка значение bankName
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	// Возвращает дату начала кредита
	public Date getStartDate() {
		return startDate;
	}

	// Присваивает дате начала кредита значение startDate
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	// Возвращает дату окончания кредита
	public Date getEndDate() {
		return endDate;
	}

	// Присваивает дате окончания кредита значение endDate
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	// Возвращает сотрудника, который выдал кредит
	public Employee getEmployee() {
		return employee;
	}

	// Присваивает сотруднику, который выдал кредит, значение employee
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// Возвращает платёжный счёт, с которого будет осуществляться погашение кредита
	public PaymentAccount getPaymentAccount() {
		return paymentAccount;
	}

	// Присваивает платёжному счёту, с которого будет осуществляться погашение кредита, значение paymentAccount
	public void setPaymentAccount(PaymentAccount paymentAccount) {
		this.paymentAccount = paymentAccount;
	}
}
