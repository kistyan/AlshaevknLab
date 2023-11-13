package tech.reliab.course.toropchinda.bank;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.entity.User;

import java.util.Date;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank(0, "VTB");
		System.out.printf("{\n    \"id\": %d,\n    \"name\": \"%s\",\n    \"officeCount\": %d,\n    \"atmCount\": %d,\n    \"employeeCount\": %d,\n    \"clientCount\": %d,\n    \"rating\": %.2f,\n    \"totalMoney\": %.2f,\n    \"interestRate\": %.2f\n}\n", bank.getId(), bank.getName(), bank.getOfficeCount(), bank.getAtmCount(), bank.getEmployeeCount(), bank.getClientCount(), bank.getRating(), bank.getTotalMoney(), bank.getInterestRate());

		BankAtm bankAtm = new BankAtm(0, "VTB_ATM", bank);
		System.out.printf("{\n    \"id\": %d,\n    \"name\": \"%s\",\n    \"moneyAmount\": %.2f,\n    \"servicePrice\": %.2f,\n    \"address\": \"%s\",\n    \"status\": \"%s\",\n    \"bank\": \"%s\",\n    \"location\": \"%s\",\n    \"serviceEmployee\": \"%s\",\n    \"isReceivingMoney\": %b,\n    \"isGivingMoney\": %b\n}\n", bankAtm.getId(), bankAtm.getName(), bankAtm.getMoneyAmount(), bankAtm.getServicePrice(), bankAtm.getAddress(), bankAtm.getStatus(), bankAtm.getBank(), bankAtm.getLocation(), bankAtm.getServiceEmployee(), bankAtm.isReceivingMoney(), bankAtm.isGivingMoney());

		BankOffice bankOffice = new BankOffice(0, "VTB_BGD");
		System.out.printf("{\n    \"id\": %d,\n    \"name\": \"%s\",\n    \"atmCount\": %d,\n    \"amountMoney\": %.2f,\n    \"rentPrice\": %.2f,\n    \"address\": \"%s\",\n    \"status\": \"%s\",\n    \"isPossibleToPlaceAtm\": %b,\n    \"isGivingLoan\": %b,\n    \"isReceivingMoney\": %b,\n    \"isGivingMoney\": %b\n}\n", bankOffice.getId(), bankOffice.getName(), bankOffice.getAtmCount(), bankOffice.getAmountMoney(), bankOffice.getRentPrice(), bankOffice.getAddress(), bankOffice.getStatus(), bankOffice.isPossibleToPlaceAtm(), bankOffice.isGivingLoan(), bankOffice.isReceivingMoney(), bankOffice.isGivingMoney());

		CreditAccount creditAccount = new CreditAccount(0);
		System.out.printf("{\n    \"id\": %d,\n    \"monthNumber\": %d,\n    \"creditAmount\": %.2f,\n    \"monthlyPayment\": %.2f,\n    \"interestRate\": %.2f,\n    \"user\": \"%s\",\n    \"bankName\": \"%s\",\n    \"startDate\": \"%s\",\n    \"endDate\": \"%s\",\n    \"employee\": \"%s\",\n    \"paymentAccount\": \"%s\"\n}\n", creditAccount.getId(), creditAccount.getMonthNumber(), creditAccount.getCreditAmount(), creditAccount.getMonthlyPayment(), creditAccount.getInterestRate(), creditAccount.getUser(), creditAccount.getBankName(), creditAccount.getStartDate(), creditAccount.getEndDate(), creditAccount.getEmployee(), creditAccount.getPaymentAccount());

		Employee employee = new Employee(0, "Ivanov Ivan Ivanovich", new Date());
		System.out.printf("{\n    \"id\": %d,\n    \"fullName\": \"%s\",\n    \"jobTitle\": \"%s\",\n    \"birthDate\": \"%s\",\n    \"bank\": %s,\n    \"office\": %s,\n    \"isWorksRemotely\": %b,\n    \"isGivingLoan\": %b,\n    \"salary\": %.2f\n}\n", employee.getId(), employee.getFullName(), employee.getJobTitle(), employee.getBirthDate(), employee.getBank(), employee.getOffice(), employee.isWorksRemotely(), employee.isGivingLoan(), employee.getSalary());

		PaymentAccount paymentAccount = new PaymentAccount(0, null, "VTB");
		System.out.printf("{\n    \"id\": %d,\n    \"user\": %s,\n    \"bankName\": \"%s\",\n    \"moneyAmount\": %.2f\n}\n", paymentAccount.getId(), paymentAccount.getUser(), paymentAccount.getBankName(), paymentAccount.getMoneyAmount());

		User user = new User(0, "Ivanov Ivan Ivanovich", new Date());
		System.out.printf("{\n    \"id\": %d,\n    \"fullName\": \"%s\",\n    \"workPlace\": \"%s\",\n    \"birthDate\": \"%s\",\n    \"monthlyIncome\": %.2f,\n    \"creditRating\": %.2f,\n    \"banks\": %s,\n    \"creditAccounts\": %s,\n    \"paymentAccounts\": %s\n}\n", user.getId(), user.getFullName(), user.getWorkPlace(), user.getBirthDate(), user.getMonthlyIncome(), user.getCreditRating(), user.getBanks(), user.getCreditAccounts(), user.getPaymentAccounts());
	}
}
