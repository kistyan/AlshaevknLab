package tech.reliab.course.toropchinda.bank;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;
import tech.reliab.course.toropchinda.bank.service.impl.BankServiceImpl;
import tech.reliab.course.toropchinda.bank.service.impl.BankAtmServiceImpl;
import tech.reliab.course.toropchinda.bank.service.impl.BankOfficeServiceImpl;
import tech.reliab.course.toropchinda.bank.service.impl.CreditAccountServiceImpl;
import tech.reliab.course.toropchinda.bank.service.impl.EmployeeServiceImpl;
import tech.reliab.course.toropchinda.bank.service.impl.PaymentAccountServiceImpl;
import tech.reliab.course.toropchinda.bank.service.impl.UserServiceImpl;

import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;

public class Main {
	private static class Menu {
		public static abstract class Entry {
			private String title;

			public Entry(String title) {
				this.title = title;
			}

			public abstract void run();

			@Override
			public String toString() {
				return title;
			}
		}

		private String title;
		private final ArrayList<Entry> entries;
		private Scanner scanner = new Scanner(System.in);
		private boolean isRunning;

		public Menu(String title) {
			this.title = title;
			entries = new ArrayList<>();
			scanner = new Scanner(System.in);
		}

		public int getEntriesCount() {
			return entries.size();
		}

		public Entry getEntry(int index) {
			return entries.get(index);
		}

		public void insertEntry(int index, Entry entry) {
			entries.add(index, entry);
		}

		public void addEntry(Entry entry) {
			entries.add(entry);
		}

		public Entry removeEntry(int index) {
			return entries.remove(index);
		}

		public boolean removeEntry(Entry entry) {
			return entries.remove(entry);
		}

		public void run() {
			isRunning = true;
			while (isRunning) {
				System.out.print(this);
				System.out.print("Choice: ");
				int choice = scanner.nextInt();
				System.out.println();
				if (choice >= 0 && choice < entries.size())
					entries.get(choice).run();
			}
		}

		public void close() {
			isRunning = false;
		}

		@Override
		public String toString() {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(title);
			stringBuilder.append('\n');
			for (int entryIndex = 0; entryIndex < entries.size(); entryIndex++) {
				stringBuilder.append('[');
				stringBuilder.append(entryIndex);
				stringBuilder.append(']');
				stringBuilder.append(' ');
				stringBuilder.append(entries.get(entryIndex));
				stringBuilder.append('\n');
			}
			return stringBuilder.toString();
		}
	}

	private static void printBank(Bank bank) {
		System.out.println(bank);
		System.out.printf("{\n    \"id\": %d,\n    \"name\": \"%s\",\n    \"officeCount\": %d,\n    \"atmCount\": %d,\n    \"employeeCount\": %d,\n    \"clientCount\": %d,\n    \"rating\": %.2f,\n    \"totalMoney\": %.2f,\n    \"interestRate\": %.2f\n}\n", bank.getId(), bank.getName(), bank.getOfficeCount(), bank.getAtmCount(), bank.getEmployeeCount(), bank.getClientCount(), bank.getRating(), bank.getTotalMoney(), bank.getInterestRate());
	}

	private static void printBankAtm(BankAtm bankAtm) {
		System.out.println(bankAtm);
		System.out.printf("{\n    \"id\": %d,\n    \"name\": \"%s\",\n    \"moneyAmount\": %.2f,\n    \"servicePrice\": %.2f,\n    \"address\": \"%s\",\n    \"status\": \"%s\",\n    \"bank\": \"%s\",\n    \"location\": \"%s\",\n    \"serviceEmployee\": \"%s\",\n    \"isReceivingMoney\": %b,\n    \"isGivingMoney\": %b\n}\n", bankAtm.getId(), bankAtm.getName(), bankAtm.getMoneyAmount(), bankAtm.getServicePrice(), bankAtm.getAddress(), bankAtm.getStatus(), bankAtm.getBank(), bankAtm.getLocation(), bankAtm.getServiceEmployee(), bankAtm.isReceivingMoney(), bankAtm.isGivingMoney());
	}

	private static void printBankOffice(BankOffice bankOffice) {
		System.out.println(bankOffice);
		System.out.printf("{\n    \"id\": %d,\n    \"name\": \"%s\",\n    \"atmCount\": %d,\n    \"amountMoney\": %.2f,\n    \"rentPrice\": %.2f,\n    \"address\": \"%s\",\n    \"status\": \"%s\",\n    \"isPossibleToPlaceAtm\": %b,\n    \"isGivingLoan\": %b,\n    \"isReceivingMoney\": %b,\n    \"isGivingMoney\": %b\n}\n", bankOffice.getId(), bankOffice.getName(), bankOffice.getAtmCount(), bankOffice.getAmountMoney(), bankOffice.getRentPrice(), bankOffice.getAddress(), bankOffice.getStatus(), bankOffice.isPossibleToPlaceAtm(), bankOffice.isGivingLoan(), bankOffice.isReceivingMoney(), bankOffice.isGivingMoney());
	}

	private static void printCreditAccount(CreditAccount creditAccount) {
		System.out.println(creditAccount);
		System.out.printf("{\n    \"id\": %d,\n    \"monthNumber\": %d,\n    \"creditAmount\": %.2f,\n    \"monthlyPayment\": %.2f,\n    \"interestRate\": %.2f,\n    \"user\": \"%s\",\n    \"bankName\": \"%s\",\n    \"startDate\": \"%s\",\n    \"endDate\": \"%s\",\n    \"employee\": \"%s\",\n    \"paymentAccount\": \"%s\"\n}\n", creditAccount.getId(), creditAccount.getMonthNumber(), creditAccount.getCreditAmount(), creditAccount.getMonthlyPayment(), creditAccount.getInterestRate(), creditAccount.getUser(), creditAccount.getBankName(), creditAccount.getStartDate(), creditAccount.getEndDate(), creditAccount.getEmployee(), creditAccount.getPaymentAccount());
	}

	private static void printEmployee(Employee employee) {
		System.out.println(employee);
		System.out.printf("{\n    \"id\": %d,\n    \"fullName\": \"%s\",\n    \"jobTitle\": \"%s\",\n    \"birthDate\": \"%s\",\n    \"bank\": %s,\n    \"office\": %s,\n    \"isWorksRemotely\": %b,\n    \"isGivingLoan\": %b,\n    \"salary\": %.2f\n}\n", employee.getId(), employee.getFullName(), employee.getJobTitle(), employee.getBirthDate(), employee.getBank(), employee.getOffice(), employee.isWorksRemotely(), employee.isGivingLoan(), employee.getSalary());
	}

	private static void printPaymentAccount(PaymentAccount paymentAccount) {
		System.out.println(paymentAccount);
		System.out.printf("{\n    \"id\": %d,\n    \"user\": %s,\n    \"bankName\": \"%s\",\n    \"moneyAmount\": %.2f\n}\n", paymentAccount.getId(), paymentAccount.getUser(), paymentAccount.getBankName(), paymentAccount.getMoneyAmount());
	}

	private static void printUser(User user) {
		System.out.println(user);
		System.out.printf("{\n    \"id\": %d,\n    \"fullName\": \"%s\",\n    \"workPlace\": \"%s\",\n    \"birthDate\": \"%s\",\n    \"monthlyIncome\": %.2f,\n    \"creditRating\": %.2f,\n    \"banks\": %s,\n    \"creditAccounts\": %s,\n    \"paymentAccounts\": %s\n}\n", user.getId(), user.getFullName(), user.getWorkPlace(), user.getBirthDate(), user.getMonthlyIncome(), user.getCreditRating(), user.getBanks(), user.getCreditAccounts(), user.getPaymentAccounts());
	}

	public static void main(String[] args) {
		BankServiceImpl bankService = BankServiceImpl.getInstance();
		BankAtmServiceImpl bankAtmService = BankAtmServiceImpl.getInstance();
		BankOfficeServiceImpl bankOfficeService = BankOfficeServiceImpl.getInstance();
		CreditAccountServiceImpl creditAccountService = CreditAccountServiceImpl.getInstance();
		EmployeeServiceImpl employeeService = EmployeeServiceImpl.getInstance();
		PaymentAccountServiceImpl paymentAccountService = PaymentAccountServiceImpl.getInstance();
		UserServiceImpl userService = UserServiceImpl.getInstance();

		for (int bankIndex = 0; bankIndex < 5; bankIndex++) {
			Bank bank = bankService.insert(bankIndex, "BANK_" + bankIndex);
			for (int officeIndex = 0; officeIndex < 3; officeIndex++) {
				int officeId = 3 * bankIndex + officeIndex;
				BankOffice office = bankOfficeService.insert(officeId, "BANK_" + bankIndex);
				BankAtm atm = bankAtmService.insert(officeId, "BANK_ATM_" + officeId, bank);
				atm.setLocation(office);
				office.setAtmCount(1);
				for (int employeeIndex = 0; employeeIndex < 5; employeeIndex++) {
					int employeeId = 5 * officeId + employeeIndex;
					Employee employee = employeeService.insert(employeeId, "EMPLOYEE_" + employeeId, new Date());
					employee.setBank(bank);
					employee.setOffice(office);
					employee.setJobTitle("Cleaner");
				}
			}
			bank.setOfficeCount(3);
			bank.setAtmCount(3);
			bank.setEmployeeCount(15);
			for (int userIndex = 0; userIndex < 5; userIndex++) {
				int userId = 5 * bankIndex + userIndex;
				User user = userService.insert(userId, "USER_" + userId, new Date());
				user.getBanks().add(bank);
				for (int paymentAccountIndex = 0; paymentAccountIndex < 2; paymentAccountIndex++) {
					int paymentAccountId = 2 * userId + paymentAccountIndex;
					PaymentAccount paymentAccount = paymentAccountService.insert(paymentAccountId, user, bank.getName());
					CreditAccount creditAccount = creditAccountService.insert(paymentAccountId);
					creditAccount.setUser(user);
					creditAccount.setPaymentAccount(paymentAccount);
					creditAccount.setStartDate(new Date());
					creditAccount.setMonthNumber(1);
					creditAccount.setEndDate(new Date(creditAccount.getStartDate().getTime() + creditAccount.getMonthNumber() * 30l * 24l * 60l * 60l * 1000l));
					user.getPaymentAccounts().add(paymentAccount);
					user.getCreditAccounts().add(creditAccount);
				}
			}
			bank.setClientCount(5);
		}

		bankService.getFreeId();

		Menu mainMenu = new Menu("┌──┬──┬─────┬─────┬──┐┌─┐  ┌──┬──┬─────┬──┐┌─┬─┐ ┌─┐\n│  ╵  │ ╶─╴ ├─┐ ┌─┤  └┤ │  │  ╵  │ ╶───┤  └┤ │ │ │ │\n│ ╷ ╷ │ ┌─┐ ├─┘ └─┤ ├┐  │  │ ╷ ╷ │ ╶───┤ ├┐  │ └─┘ │\n└─┴─┴─┴─┘ └─┴─────┴─┘└──┘  └─┴─┴─┴─────┴─┘└──┴─────┘");
		mainMenu.addEntry(new Menu.Entry("Exit") {
			@Override
			public void run() {
				mainMenu.close();
			}
		});

		Menu banksMenu = new Menu("┌────┐┌─────┬──┐┌─┬─┬───┬─────┐\n│ ╶╴ └┤ ╶─╴ │  └┤ │ ╵ ┌─┤ ╶───┤\n│ ╶─╴ │ ┌─┐ │ ├┐  │ ╷ └─┼───╴ │\n└─────┴─┘ └─┴─┘└──┴─┴───┴─────┘");
		banksMenu.addEntry(new Menu.Entry("Back") {
			@Override
			public void run() {
				banksMenu.close();
			}
		});
		ArrayList<Bank> banks = bankService.select(bank -> true);
		for (Bank bank : banks)
			banksMenu.addEntry(new Menu.Entry(bank.getName() + " info") {
				@Override
				public void run() {
					System.out.println("Bank:");
					printBank(bank);
					System.out.println("ATMs:");
					for (BankAtm atm : bankAtmService.select(item -> item.getBank() == bank))
						printBankAtm(atm);
					System.out.println("Offices:");
					for (BankOffice office : bankOfficeService.select(item -> item.getName().equals(bank.getName())))
						printBankOffice(office);
					System.out.println("Employees:");
					for (Employee employee : employeeService.select(item -> item.getBank() == bank))
						printEmployee(employee);
					System.out.println("Clients:");
					for (User user : userService.select(item -> item.getBanks().contains(bank)))
						printUser(user);
					System.out.println();
				}
			});

		mainMenu.addEntry(new Menu.Entry("Banks") {
			@Override
			public void run() {
				banksMenu.run();
			}
		});

		Menu usersMenu = new Menu("┌─┐ ┌─┬─────┬─────┬────┐┌─────┐\n│ │ │ │ ╶───┤ ╶───┤ ╶╴ └┤ ╶───┤\n│ └─┘ ├───╴ │ ╶───┤ ┌─┐ ├───╴ │\n└─────┴─────┴─────┴─┘ └─┴─────┘");
		usersMenu.addEntry(new Menu.Entry("Back") {
			@Override
			public void run() {
				usersMenu.close();
			}
		});
		ArrayList<User> users = userService.select(user -> true);
		for (User user : users)
			usersMenu.addEntry(new Menu.Entry(user.getFullName() + " info") {
				@Override
				public void run() {
					System.out.println("User:");
					printUser(user);
					System.out.println("CreditAccounts:");
					for (CreditAccount creditAccount : creditAccountService.select(item -> item.getUser() == user))
						printCreditAccount(creditAccount);
					System.out.println("PaymentAccounts:");
					for (PaymentAccount paymentAccount : paymentAccountService.select(item -> item.getUser() == user))
						printPaymentAccount(paymentAccount);
					System.out.println();
				}
			});

		mainMenu.addEntry(new Menu.Entry("Users") {
			@Override
			public void run() {
				usersMenu.run();
			}
		});
		mainMenu.run();
	}
}
