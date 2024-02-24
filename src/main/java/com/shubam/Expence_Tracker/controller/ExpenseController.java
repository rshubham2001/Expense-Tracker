package com.shubam.Expence_Tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shubam.Expence_Tracker.exception.UserException;
import com.shubam.Expence_Tracker.model.ExpenseInputModel;
import com.shubam.Expence_Tracker.model.ExpenseOutputModel;
import com.shubam.Expence_Tracker.serviceInterfaceImplementation.ExpenseServiceImplementation;

@RestController
public class ExpenseController {
	
	@Autowired
	ExpenseServiceImplementation expenseServiceImplementation;

	@PostMapping("/addexpense")
	public ResponseEntity<ExpenseOutputModel> addExpense(@RequestBody ExpenseInputModel expenseInputModel) throws UserException{
		ExpenseOutputModel expenseOutputModel = expenseServiceImplementation.addExpense(expenseInputModel);
		return new ResponseEntity<ExpenseOutputModel>(expenseOutputModel, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalexpensebyitem/{item}")
	public ResponseEntity<Double> getTotalExpenseByItem(@PathVariable String item){
		Double amount = expenseServiceImplementation.getTotalExpenseByItem(item);
		return new ResponseEntity<Double>(amount, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalexpensebycategory/{category}")
	public ResponseEntity<Double> getTotalExpenseByCategory(@PathVariable String category){
		Double amount = expenseServiceImplementation.getTotalExpenseByCategory(category);
		return new ResponseEntity<Double>(amount, HttpStatus.OK);
	}
	
	@GetMapping("/getremainingbalancetospend/{emailId}")
	public ResponseEntity<Double> getRemainingBalanceToSpend(@PathVariable String emailId) throws UserException{
		Double amount = expenseServiceImplementation.getRemainingBalanceToSpend(emailId);
		return new ResponseEntity<Double>(amount, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalexpenseformonth/{month}/{year}")
	public ResponseEntity<Double> getTotalExpenseForMonth(@PathVariable Integer month, @PathVariable Integer year){
		Double amount = expenseServiceImplementation.getTotalExpenseForMonth(month, year);
		return new ResponseEntity<Double>(amount, HttpStatus.OK);
	}
	
	@GetMapping("/gettotalexpenseforyear/{year}")
	public ResponseEntity<Double> getTotalExpenseForYear(@PathVariable Integer year){
		Double amount = expenseServiceImplementation.getTotalExpenseForYear( year);
		return new ResponseEntity<Double>(amount, HttpStatus.OK);
	}
	
	@GetMapping("/getallexpensebymonth/{month}/{year}")
	public ResponseEntity<List<ExpenseOutputModel>> getAllExpenseByMonth(@PathVariable Integer month, @PathVariable Integer year){
		List<ExpenseOutputModel> list = expenseServiceImplementation.getAllExpenseByMonth(month, year);
		return new ResponseEntity<List<ExpenseOutputModel>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getallexpensebyemailId/{emailId}")
	public ResponseEntity<List<ExpenseOutputModel>> getAllExpenseByEmailId(@PathVariable String emailId){
		List<ExpenseOutputModel> list = expenseServiceImplementation.getAllExpenseByEmailId(emailId);
		return new ResponseEntity<List<ExpenseOutputModel>>(list, HttpStatus.OK);
	}
}
