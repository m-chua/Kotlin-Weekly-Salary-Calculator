import java.util.Scanner

class person (){
	//configurations
  var employeeID : String = ""
  var clockIn =  mutableListOf(900, 900, 900, 900, 900, 900, 900)
  var clockOut =  mutableListOf(900, 900, 900, 900, 900, 900, 900)
  var salary_rate = 500
  var daysWorked : Int = 0
	
	//used for display
  var cHr: String = ""
  var cMin: String = ""
  
  fun display(){
    for (i in 0..6){
      
      cHr = (clockIn[i]/100).toString().padStart(2, '0')
      cMin = (clockIn[i]-(clockIn[i]/100)).toString().padStart(2, '0')
      
      println("Day ${i+1}: \n clock in time: $cHr:$cMin ")
		
      cHr = (clockOut[i]/100).toString().padStart(2, '0')
      cMin = (clockOut[i]-(clockOut[i]/100)).toString().padStart(2, '0')
		
      println("clock out time: $cHr:$cMin \n Salary rate: $salary_rate\n")
		
    }
  }
	
  fun salaryCalc(event: MutableList<String>){
	  println("salary calculation function in progress")
  }//calculate and display daily and weekly salary 
  
  fun employeeMenu(){
	  val input = Scanner(System.`in`)
	  var choice: Int = -1
	  
	  while(choice!=4){
		display()
		println(" ===== EMPLOYEE MENU ===== ")
		println("1. Change Clock-in time\n2. Change Clock-out time\n3. Change Salary Rate\n4. Exit")
		choice = input.nextInt()
	  
		when(choice){
			 1 -> {
				println("Which day of the week would you like to change? (Input a number from 1-7)")
				choice = input.nextInt()
				println("Please input the new clock-in time of day $choice:")
				clockIn[choice] = input.nextInt() 
				}
			 2 -> {
				println("Which day of the week would you like to change? (Input a number from 1-7)")
				choice = input.nextInt()
				println("Please input the new clock-out time of day $choice:")
				clockIn[choice] = input.nextInt() 
				}
			 3 ->  {
				 println("Please input employee $employeeID's new salary rate: ")
				 salary_rate = input.nextInt()
				}//salary rate
			else -> println("Invalid input. Please try again. ")
		 } 
	 }
	  
  }//change clock in, clock out, salary rate
}