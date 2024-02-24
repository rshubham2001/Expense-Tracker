package com.shubam.Expence_Tracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInputModel {

	private String name;
	private String emailId;
	private String phoneNumber;
	private Double expenseLimit;
	private String password;
}
