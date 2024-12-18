package tech.reliab.course.toropchinda.bank.entity;

import java.util.Date;

public class Employee {
	private int id;
	private String fullName, jobTitle;
	private Date birthDate;
	private Bank bank;
	private BankOffice office;
	private boolean isWorksRemotely, isGivingLoan;
	private double salary;

	public Employee(int id, String fullName, Date birthDate) {
		this.id = id;
		this.fullName = fullName;
		this.birthDate = birthDate;
		bank = null;
		jobTitle = new String();
		office = null;
		isWorksRemotely = isGivingLoan = false;
		salary = 0;
	}

	// Возвращает идентификатор сотрудника
	public int getId() {
		return id;
	}

	// Присваивает идентификатору сотрудника значение id
	public void setId(int id) {
		this.id = id;
	}

	// Возвращает ФИО сотрудника
	public String getFullName() {
		return fullName;
	}

	// Присваивает ФИО сотрудника значение fullName
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	// Возвращает должность сотрудника
	public String getJobTitle() {
		return jobTitle;
	}

	// Присваивает должности сотрудника значение jobTitle
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	// Возвращает дату рождения сотрудника
	public Date getBirthDate() {
		return birthDate;
	}

	// Присваивает дате рождения сотрудника значение birthDate
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	// Возвращает банк, в котором сотрудник работает
	public Bank getBank() {
		return bank;
	}

	// Присваивает банку, в котором сотрудник работает, значение bank
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	// Возвращает офис банка, в котором работает сотрудник
	public BankOffice getOffice() {
		return office;
	}

	// Присваивает офису банка, в котором работает сотрудник, значение office
	public void setOffice(BankOffice office) {
		this.office = office;
	}

	// Возвращает true, если сотрудник работает удалённо, иначе false
	public boolean isWorksRemotely() {
		return isWorksRemotely;
	}

	// Присваивает удалённому режиму работы сотрудника значение isWorksRemotely
	public void setWorksRemotely(boolean isWorksRemotely) {
		this.isWorksRemotely = isWorksRemotely;
	}

	// Возвращает true, если сотрудник может выдавать кредиты, иначе false
	public boolean isGivingLoan() {
		return isGivingLoan;
	}

	// Присваивает возможности сотрудника выдавать кредит значение isGivingLoan
	public void setGivingLoan(boolean isGivingLoan) {
		this.isGivingLoan = isGivingLoan;
	}

	// Возвращает размер заработной платы сотрудника
	public double getSalary() {
		return salary;
	}

	// Присваивает размеру заработной платы сотрудника значение salary
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
