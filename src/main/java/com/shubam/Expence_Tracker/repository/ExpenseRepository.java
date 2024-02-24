package com.shubam.Expence_Tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shubam.Expence_Tracker.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{
	
	@Query(value="select SUM(e.amount) from Expense e where e.item=?1")
	public Double getTotalExpenseByItem(String item);
	
	@Query(value="select SUM(e.amount) from Expense e where e.category=?1")
	public Double getTotalExpenseByCategory(String category);
	
	@Query(value="select SUM(e.amount) from Expense e where YEAR(e.date)=?2 and MONTH(e.date) =?1")
	public Double getTotalExpenseForMonth(Integer month, Integer year);
	
	@Query(value="select e from Expense e where YEAR(e.date)=?2 and MONTH(e.date) =?1")
	public List<Expense> getAllExpenseByMonth(Integer month, Integer year);
	
	@Query(value="select e from Expense e where e.user.emailId=?1")
	public List<Expense> getAllExpenseByEmailId(String emailId);
	
	@Query(value="select SUM(e.amount) from Expense e where YEAR(e.date)=?1")
	public Double getTotalExpenseForYear(Integer year);
	
	
}
