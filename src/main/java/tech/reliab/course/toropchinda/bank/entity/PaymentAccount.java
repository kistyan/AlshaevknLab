package tech.reliab.course.toropchinda.bank.entity;

public class PaymentAccount {
	private int id;
	private User user;
	private String bankName;
	private float moneyAmount;

	public PaymentAccount(int id, User user, String bankName) {
		this.id = id;
		this.user = user;
		this.bankName = bankName;
		moneyAmount = 0;
	}

	// Возвращает идентификатор платёжного счёта
	public int getId() {
		return id;
	}

	// Присваивает идентификатору платёжного счёта значение id
	public void setId(int id) {
		this.id = id;
	}

	// Возвращает пользователя платёжного счёта
	public User getUser() {
		return user;
	}

	// Присваивает пользователю платёжного счёта значение user
	public void setUser(User user) {
		this.user = user;
	}

	// Возвращает название банка, в котором открыт платёжный счёт
	public String getBankName() {
		return bankName;
	}

	// Присваивает названию банка, в котором открыт платёжный счёт, значение bankName
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	// Возвращает денежную сумму на счету
	public float getMoneyAmount() {
		return moneyAmount;
	}

	// Присваивает денежной сумме на счету значение moneyAmount
	public void setMoneyAmount(float moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
}
