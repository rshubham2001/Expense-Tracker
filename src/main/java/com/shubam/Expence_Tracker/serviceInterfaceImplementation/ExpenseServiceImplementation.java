package com.shubam.Expence_Tracker.serviceInterfaceImplementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shubam.Expence_Tracker.entity.Expense;
import com.shubam.Expence_Tracker.exception.UserException;
import com.shubam.Expence_Tracker.model.ExpenseInputModel;
import com.shubam.Expence_Tracker.model.ExpenseOutputModel;
import com.shubam.Expence_Tracker.repository.ExpenseRepository;
import com.shubam.Expence_Tracker.serviceInterface.ExpenseService;
import com.shubam.Expence_Tracker.util.MapExpense;

import jakarta.transaction.Transactional;

@Service
public class ExpenseServiceImplementation implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepository;

	@Autowired
	UserServiceImplementation userServiceImplementation;

	@Override
	@Transactional
	public ExpenseOutputModel addExpense(ExpenseInputModel expenseInputModel) throws UserException {

		Expense expense = new Expense();

		expense.setAmount(expenseInputModel.getAmount());
		expense.setCategory(expenseInputModel.getCategory());
		expense.setDate(LocalDate.now());
		expense.setItem(expenseInputModel.getItem());
		expense.setUser(userServiceImplementation.getUserByEmailId(expenseInputModel.getEmailId()));

		expenseRepository.save(expense);
		ExpenseOutputModel expenseOutputModel = MapExpense.mapToExpenseOutputModel(expense);
		return expenseOutputModel;
	}

	@Override
	@Transactional
	public Double getTotalExpenseByItem(String item) {
		return expenseRepository.getTotalExpenseByItem(item);
	}

	@Override
	@Transactional
	public Double getTotalExpenseByCategory(String category) {
		return expenseRepository.getTotalExpenseByCategory(category);
	}

	@Override
	@Transactional
	public Double getRemainingBalanceToSpend(String emailId) throws UserException {
		Double expenseLimit = userServiceImplementation.getUserExpenseLimitByEmailId(emailId);
		Integer month = LocalDate.now().getMonthValue();
		Integer year = LocalDate.now().getYear();
		Double expenseForMonth = getTotalExpenseForMonth(month, year);
		return (expenseLimit-expenseForMonth);
	}

	@Override
	@Transactional
	public Double getTotalExpenseForMonth(Integer month, Integer year) {
		return expenseRepository.getTotalExpenseForMonth(month, year);
	}

	@Override
	@Transactional
	public List<ExpenseOutputModel> getAllExpenseByMonth(Integer month, Integer year) {
		List<Expense> expenseList = expenseRepository.getAllExpenseByMonth(month, year);
		List<ExpenseOutputModel> list = MapExpense.mapToExpenseOutputModelList(expenseList);
		return list;
	}

	@Override
	@Transactional
	public List<ExpenseOutputModel> getAllExpenseByEmailId(String emailId) {
		List<Expense> expenseList = expenseRepository.getAllExpenseByEmailId(emailId);
		List<ExpenseOutputModel> list = MapExpense.mapToExpenseOutputModelList(expenseList);
		return list;
	}

	@Override
	@Transactional
	public Double getTotalExpenseForYear(Integer year) {
		return expenseRepository.getTotalExpenseForYear(year);
	}

}
