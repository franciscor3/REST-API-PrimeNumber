package com.assessment.rest.api.model;

import java.util.ArrayList;

public class PrimesResponse {
	//Model of the response to use the MVC approach
	
	//I add the Name of the algorithm to be more explicit in the algorithm selected
	private String algorithmName;
	private int initial;
	private ArrayList<Integer> primes;
	
	
	
	//constructor
	public PrimesResponse(int number) {
		this.initial = number;
		
	}
	
	//Get/Set methods of the variables in the model
	public String getAlgorithmName() {
		return algorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	public int getInitial() {
		return initial;
	}
	public void setInitial(int initial) {
		this.initial = initial;
	}
	public ArrayList<Integer> getPrimes() {
		return primes;
	}
	public void setPrimes(ArrayList<Integer> primes) {
		this.primes = primes;
	}
	
	
		

}
