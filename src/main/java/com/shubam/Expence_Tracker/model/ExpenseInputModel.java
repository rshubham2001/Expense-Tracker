package com.shubam.Expence_Tracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseInputModel {

	private String item;
	private String category;
	private Double amount;
	private String emailId;
}
