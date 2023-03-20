package com.assessment.rest.api.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.rest.api.model.PrimesResponse;

@RestController
@RequestMapping("/primes")
public class PrimeNumberController {
	//This is the GET request with a specific number
	//It returns the same contentType that the request was made or accept representation
	@GetMapping(value="/{number}")
	public PrimesResponse getPrimeNumbers(@PathVariable int number, @RequestParam("algorithm")Optional<String> algorithmName){
		ArrayList<Integer> result = new ArrayList<>();
		
		//Model of the response
		PrimesResponse response = new PrimesResponse(number);
		
		//simple case
		if (number >=2) {
			result.add(2);
		}
		
		//Square Root algorithm is the default one in case no parameter. 
		//The optional parameter are numbers, for simplicity of the user, in an user interface could be used a DropdownList
		if(algorithmName.isPresent()) {
			switch(algorithmName.get()) {
				case "1":
					response.setAlgorithmName("Brute Force");
					for(int i = 3; i <= number; i++) {
						if(bruteForceIsPrime(i)) {
							result.add(i);
						}	
					}
					break;
				case "2":
					response.setAlgorithmName("Sieve of Erastosthene");
					boolean[] resultArr = sieveOfEratosthenes(number);
					for(int i = 3; i <= number; i++) {
						if(resultArr[i]==true) {
							result.add(i);
						}	
					}
					break;
					
				default:
					response.setAlgorithmName("Square Root");
					
					for(int i = 3; i <= number; i++) {
						if(isPrime(i)) {
							result.add(i);
						}	
					}
			}
		}else {
			response.setAlgorithmName("Square Root");
			
			for(int i = 3; i <= number; i++) {
				if(isPrime(i)) {
					result.add(i);
				}	
			}
			
		}
			
		response.setPrimes(result);
			
		return response;
		
	}


	//Square Root algorithm
	//I got this algorithm from https://www.geeksforgeeks.org/prime-numbers/
	private boolean isPrime(int n) {
		if (n%2 == 0){
			return false;
		}
		
		for(int i=3; i<=Math.sqrt(n); i+= 2) {
			if(n%i== 0) {
				return false;
			}
		}
		return true;
		
	}

	//Brute force; Less efficient algorithm to find Prime Numbers
	private boolean bruteForceIsPrime(int n) {
		for(int i=3; i<=n; i++) {
			if(n%i== 0) {
				return false;
			}
		}
		return true;
	}
	
	//Sieve of Eratosthenes it is a very efficient algorithm in terms of time processing but it requires more memory
	//I got this algorithm from  https://www.geeksforgeeks.org/sieve-of-eratosthenes/
	private boolean[] sieveOfEratosthenes(int n) {
		boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
 
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
		return prime;
		
	}
	


}
