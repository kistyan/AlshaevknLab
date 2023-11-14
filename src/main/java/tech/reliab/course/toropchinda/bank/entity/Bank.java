package tech.reliab.course.toropchinda.bank.entity;

public class Bank {
	private int id, officeCount, atmCount, employeeCount, clientCount;
	private double rating, totalMoney, interestRate;
	private String name;

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
		officeCount = atmCount = employeeCount = clientCount = 0;
		double normalizedRating = Math.random();
		rating = normalizedRating * 100;
		totalMoney = Math.random() * 1_000_000;
		interestRate = Math.random() * 20 * normalizedRating;
	}

	// Возвращает идентификатор банка
	public int getId() {
		return id;
	}

	// Присваивает идентификатору банка значение id
	public void setId(int id) {
		this.id = id;
	}

	// Возвращает имя банка
	public String getName() {
		return name;
	}

	// Присваивает имени банка значение name
	public void setName(String name) {
		this.name = name;
	}

	// Возвращает количество офисов банка
	public int getOfficeCount() {
		return officeCount;
	}

	// Присваивает количеству офисов банка значение officeCount
	public void setOfficeCount(int officeCount) {
		this.officeCount = officeCount;
	}

	// Возвращает количество банкоматов банка
	public int getAtmCount() {
		return atmCount;
	}

	// Присваивает количеству банкоматов банка значение atmCount
	public void setAtmCount(int atmCount) {
		this.atmCount = atmCount;
	}

	// Возвращает количество сотрудников банка
	public int getEmployeeCount() {
		return employeeCount;
	}

	// Присваивает количеству сотрудников банка значение employeeCount
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}

	// Возвращает количество клиентов банка
	public int getClientCount() {
		return clientCount;
	}

	// Присваивает количеству клиентов банка значение clientCount
	public void setClientCount(int clientCount) {
		this.clientCount = clientCount;
	}

	// Возвращает рейтинг банка
	public double getRating() {
		return rating;
	}

	// Присваивает рейтингу банка значение rating
	public void setRating(double rating) {
		this.rating = rating;
	}

	// Возвращает общее количество денег в банке
	public double getTotalMoney() {
		return totalMoney;
	}

	// Присваивает общему количеству денег в банке значение totalMoney
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	// Возвращает процентную ставку банка
	public double getInterestRate() {
		return interestRate;
	}

	// Присваивает процентной ставке банка значение interestRate
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
