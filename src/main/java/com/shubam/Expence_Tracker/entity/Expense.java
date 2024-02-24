package com.shubam.Expence_Tracker.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String item;
	
	@Column(nullable = false)
	private String category;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false)
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name="email_id",nullable=false)
	private User user;
}
