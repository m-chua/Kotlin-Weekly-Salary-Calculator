/**
 * Name: Micole Keesha Chua
 * Date Last Updated: Nov. 08, 2023
 * Purpose: MCO for CSADPRG
 * Description: program to calculate weekly salary
 */

import java.util.Scanner


fun displayWeek (event: MutableList<String>){
	for (i in 0..6){
		println("Day ${i+1}: ${event[i]}")
	}
}

fun main() {

    //to exit out of the program
    var exit = false

  //choice of user action
    val input = Scanner(System.`in`)
    var choice: Int
	var randInput: Int
	var randInput2: Int
	var strInput: String 
	
    var cur_person: Int
    var event =  mutableListOf("normal", "normal", "normal", "normal", "normal", "normal", "normal")
    var employee : MutableList<person> = mutableListOf()
	
	
	
	
    
    while(!exit){
        //display the current set up of the week
      
    	displayWeek(event)
        println("=====MENU=====\n1. Change Weekly Settings ")
		println("2. Employee Manager")
        println("3. Calculate Weekly Salary\n4. Exit Program")
        println("\nPlease input the number of your choice. ")
        
        choice = input.nextInt()

        when (choice){
            1 -> {
				println("Which day of the week would you like to change? (Input a number from 1-7)")
				randInput = input.nextInt()
				println("Day $randInput is a: \n1. Normal Day\n2. Special Non-working Day\n3. Regular Holiday")
				randInput2 = input.nextInt()
				when (randInput2){
					1 -> event[randInput-1] = "normal"
					2 -> event[randInput-1] = "specialNW"
					3 -> event[randInput-1] = "regularH"
					else -> println("Invalid Input. The changes will be discarded. Please input the number of your choice.")
				}
				
            }//weekly settings
            2 -> {
				if(employee.size == 0){
					println("You have no employees to edit.")
				}else {
					//display employee IDs
					println(" ===== EMPLOYEE IDs ===== ")
					for(e in employee){
						println(e.employeeID)
					}
					//get employee ID
					println("Kindly enter the employeeID to begin changing details.")
					strInput = input.nextLine()
					//look for where the employee ID is
					cur_person = -1
					for(p in 0..6){
						if(employee[p].employeeID == strInput){
							cur_person = p
							break;
						}
					}
					//go to change menu if employee ID exists
					if(cur_person==-1){
						println("Invalid employeeID. ")
					}else {
						employee[cur_person].employeeMenu()
					}
					
				}
			}// employee status
            3 -> {
				if(employee.size == 0){
					println("You have no employees to calculate salary for.")
				}else {
					//display employee IDs
					println(" ===== EMPLOYEE IDs ===== ")
					for(e in employee){
						println(e.employeeID)
					}
					//get employee ID
					println("Kindly enter the employeeID to begin salary calculation.")
					strInput = input.nextLine()
					//look for where the employee ID is
					cur_person = -1
					for(p in 0..6){
						if(employee[p].employeeID == strInput){
							cur_person = p
							break;
						}
					}
					//output salary calculation if employee ID exists
					if(cur_person==-1){
						println("Invalid employeeID. ")
					}else {
						employee[cur_person].salaryCalc(event)
					}
					
				}
			}// calculate salary
            4 -> exit = true

            else -> println("Invalid Input. Please input the number of your choice. ")
        }
    }
    println("Closing program...")
}