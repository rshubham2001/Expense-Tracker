package com.shubam.Expence_Tracker.util;

import java.util.ArrayList;
import java.util.List;

import com.shubam.Expence_Tracker.entity.Expense;
import com.shubam.Expence_Tracker.model.ExpenseOutputModel;

public class MapExpense {
	
	public static ExpenseOutputModel mapToExpenseOutputModel(Expense expense) {
		ExpenseOutputModel expenseOutputModel = new ExpenseOutputModel();
		expenseOutputModel.setId(expense.getId());
		expenseOutputModel.setAmount(expense.getAmount());
		expenseOutputModel.setCategory(expense.getCategory());
		expenseOutputModel.setDate(expense.getDate());
		expenseOutputModel.setItem(expense.getItem());
		expenseOutputModel.setUser(expense.getUser().getName());
		return expenseOutputModel;
	}
	
	public static List<ExpenseOutputModel> mapToExpenseOutputModelList(List<Expense> expenseList){
		List<ExpenseOutputModel> list = new ArrayList<>();
		for(Expense expense: expenseList) {
			ExpenseOutputModel expenseOutputModel = new ExpenseOutputModel();
			expenseOutputModel.setId(expense.getId());
			expenseOutputModel.setAmount(expense.getAmount());
			expenseOutputModel.setCategory(expense.getCategory());
			expenseOutputModel.setDate(expense.getDate());
			expenseOutputModel.setItem(expense.getItem());
			expenseOutputModel.setUser(expense.getUser().getName());
			
			list.add(expenseOutputModel);
		}
		return list;
	}
}
