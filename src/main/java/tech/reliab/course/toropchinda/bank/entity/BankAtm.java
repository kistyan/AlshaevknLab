package tech.reliab.course.toropchinda.bank.entity;

public class BankAtm {
	public enum Status {
		NOT_WORKING,
		WORKING,
		NO_MONEY
	}

	private int id;
	private double moneyAmount, servicePrice;
	private String name, address;
	private Status status;
	private Bank bank;
	private BankOffice location;
	private Employee serviceEmployee;
	private boolean isReceivingMoney, isGivingMoney;

	public BankAtm(int id, String name, Bank bank) {
		this.id = id;
		this.name = name;
		this.bank = bank;
		moneyAmount = servicePrice = 0;
		address = new String();
		status = Status.NOT_WORKING;
		location = null;
		serviceEmployee = null;
		isReceivingMoney = isGivingMoney = false;
	}

	// Возвращает идентификатор банкомата
	public int getId() {
		return id;
	}

	// Присваивает идентификатору банкомата значение id
	public void setId(int id) {
		this.id = id;
	}

	// Возвращает количество денег в банкомате
	public double getMoneyAmount() {
		return moneyAmount;
	}

	// Присваивает количеству денег банкомата значение moneyAmount
	public void setMoneyAmount(double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}

	// Возвращает цену обслуживания банкомата
	public double getServicePrice() {
		return servicePrice;
	}

	// Присваивает цене обслуживания банкомата значение servicePrice
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}

	// Возвращает имя банкомата
	public String getName() {
		return name;
	}

	// Присваивает имени банкомата значение name
	public void setName(String name) {
		this.name = name;
	}

	// Возвращает адрес банкомата
	public String getAddress() {
		return address;
	}

	// Присваивает адресу банкомата значение address
	public void setAddress(String address) {
		this.address = address;
	}

	// Возвращает статус банкомата
	public Status getStatus() {
		return status;
	}

	// Присваивает статусу банкомата значение status
	public void setStatus(Status status) {
		this.status = status;
	}

	// Возвращает банк банкомата
	public Bank getBank() {
		return bank;
	}

	// Присваивает банку банкомата значение bank
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	// Возвращает офис, в котором расположен банкомат
	public BankOffice getLocation() {
		return location;
	}

	// Присваивает офису, в котором расположен банкомат, значение location
	public void setLocation(BankOffice location) {
		this.location = location;
	}

	// Возвращает сотрудника, обслуживающего банкомат
	public Employee getServiceEmployee() {
		return serviceEmployee;
	}

	// Присваивает сотруднику, обслуживающего банкомат, значение serviceEmployee
	public void setServiceEmployee(Employee serviceEmployee) {
		this.serviceEmployee = serviceEmployee;
	}

	// Возвращает true, если банкомат может принимать деньги, иначе false
	public boolean isReceivingMoney() {
		return isReceivingMoney;
	}

	// Присваивает возможности банкомата принимать деньги значение receivingMoney
	public void setReceivingMoney(boolean receivingMoney) {
		isReceivingMoney = receivingMoney;
	}

	// Возвращает true, если банкомат может выдавать деньги, иначе false
	public boolean isGivingMoney() {
		return isGivingMoney;
	}

	// Присваивает возможности банкомата выдавать деньги значение givingMoney
	public void setGivingMoney(boolean givingMoney) {
		isGivingMoney = givingMoney;
	}
}
