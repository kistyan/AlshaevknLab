package tech.reliab.course.toropchinda.bank.entity;

public class Bank {
	private int id, officeCount, atmCount, employeeCount, clientCount;
	private float rating, totalMoney, interestRate;
	private String name;

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
		officeCount = atmCount = employeeCount = clientCount = 0;
		rating = totalMoney = interestRate = 0;
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
	public float getRating() {
		return rating;
	}

	// Присваивает рейтингу банка значение rating
	public void setRating(float rating) {
		this.rating = rating;
	}

	// Возвращает общее количество денег в банке
	public float getTotalMoney() {
		return totalMoney;
	}

	// Присваивает общему количеству денег в банке значение totalMoney
	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	// Возвращает процентную ставку банка
	public float getInterestRate() {
		return interestRate;
	}

	// Присваивает процентной ставке банка значение interestRate
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
}
