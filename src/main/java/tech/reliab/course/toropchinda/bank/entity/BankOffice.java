package tech.reliab.course.toropchinda.bank.entity;

public class BankOffice {
	public enum Status {
		NOT_WORKING,
		WORKING
	}

	private int id, atmCount;
	private double amountMoney, rentPrice;
	private String name, address;
	private Status status;
	private boolean isPossibleToPlaceAtm, isGivingLoan, isReceivingMoney, isGivingMoney;

	public BankOffice(int id, String name) {
		this.id = id;
		this.name = name;
		this.address = new String();
		status = Status.NOT_WORKING;
		atmCount = 0;
		amountMoney = rentPrice = 0;
		isPossibleToPlaceAtm = isGivingLoan = isReceivingMoney = isGivingMoney = false;
	}

	// Возвращает идентификатор офиса банка
	public int getId() {
		return id;
	}

	// Присваивает идентификатору офиса банка значение id
	public void setId(int id) {
		this.id = id;
	}

	// Возвращает количество банкоматов в офиса банка
	public int getAtmCount() {
		return atmCount;
	}

	// Присваивает количеству банкоматов в офиса банка значение atmCount
	public void setAtmCount(int atmCount) {
		this.atmCount = atmCount;
	}

	// Возвращает количество денег в офиса банка
	public double getAmountMoney() {
		return amountMoney;
	}

	// Присваивает количеству денег в офиса банка значение amountMoney
	public void setAmountMoney(double amountMoney) {
		this.amountMoney = amountMoney;
	}

	// Возвращает цену аренды офиса банка
	public double getRentPrice() {
		return rentPrice;
	}

	// Присваивает цене аренды офиса банка значение rentPrice
	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	// Возвращает название офиса банка
	public String getName() {
		return name;
	}

	// Присваивает названию офиса банка значение name
	public void setName(String name) {
		this.name = name;
	}

	// Возвращает адрес офиса банка
	public String getAddress() {
		return address;
	}

	// Присваивает адресу офиса банка значение address
	public void setAddress(String address) {
		this.address = address;
	}

	// Возвращает статус офиса банка
	public Status getStatus() {
		return status;
	}

	// Присваивает статусу офиса банка значение status
	public void setStatus(Status status) {
		this.status = status;
	}

	// Возвращает true, если в офисе банка можно установить банкомат, иначе false
	public boolean isPossibleToPlaceAtm() {
		return isPossibleToPlaceAtm;
	}

	// Присваивает возможности установки банкомата в офис банка значение isPossibleToPlaceAtm
	public void setPossibleToPlaceAtm(boolean isPossibleToPlaceAtm) {
		this.isPossibleToPlaceAtm = isPossibleToPlaceAtm;
	}

	// Возвращает true, если в офисе банка можно оформить кредит, иначе false
	public boolean isGivingLoan() {
		return isGivingLoan;
	}

	// Присваивает возможности оформить кредит в офисе банка значение isGivingLoan
	public void setGivingLoan(boolean isGivingLoan) {
		this.isGivingLoan = isGivingLoan;
	}

	// Возвращает true, если в офис банка можно внести деньги, иначе false
	public boolean isReceivingMoney() {
		return isReceivingMoney;
	}

	// Присваивает возможности офиса банка принимать деньги значение isReceivingMoney
	public void setReceivingMoney(boolean isReceivingMoney) {
		this.isReceivingMoney = isReceivingMoney;
	}

	// Возвращает true, если офис банка работает на выдачу денег, иначе false
	public boolean isGivingMoney() {
		return isGivingMoney;
	}

	// Присваивает возможности офиса банка выдавать деньги значение isGivingMoney
	public void setGivingMoney(boolean isGivingMoney) {
		this.isGivingMoney = isGivingMoney;
	}
}
