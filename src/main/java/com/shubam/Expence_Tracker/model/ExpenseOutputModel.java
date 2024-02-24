package com.shubam.Expence_Tracker.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseOutputModel {

	private Integer id;
	private String item;
	private String category;
	private Double amount;
	private String user;
	private LocalDate date;
}
