package com.shubam.Expence_Tracker.serviceInterface;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shubam.Expence_Tracker.exception.UserException;
import com.shubam.Expence_Tracker.model.ExpenseInputModel;
import com.shubam.Expence_Tracker.model.ExpenseOutputModel;

@Service
public interface ExpenseService {

	public ExpenseOutputModel addExpense(ExpenseInputModel expenseInputModel) throws UserException;
	
	public Double getTotalExpenseByItem(String item);
	
	public Double getTotalExpenseByCategory(String category);
	
    public Double getRemainingBalanceToSpend(String emailId) throws UserException;
	
	public Double getTotalExpenseForMonth(Integer month, Integer year);
	
	public List<ExpenseOutputModel> getAllExpenseByMonth(Integer month, Integer year);
	
	public List<ExpenseOutputModel> getAllExpenseByEmailId(String emailId);
	
	public Double getTotalExpenseForYear(Integer year);
}
