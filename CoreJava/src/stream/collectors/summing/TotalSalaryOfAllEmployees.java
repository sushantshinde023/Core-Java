package stream.collectors.summing;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TotalSalaryOfAllEmployees {
	
	public static void main(String [] args) {
		 List<Employee> employees=List.of(
				 new Employee(1,"Suhant","Marketing",18000,List.of("Digital Marketing","Social Media")),
				 new Employee(2,"ABC","HR",90000,List.of("Leadership","Time Management")),
				 new Employee(3,"PQR","IT",150000,List.of("Java","React")),
				 new Employee(4,"XYZ","IT",60000,List.of("Java","Spring")),
				 new Employee(5,"MNO","Marketing",10000,List.of("Copywriting","Social Media")),
				 new Employee(6,"Apparaj","IT",125000,List.of("Java","Spring","React")),
				 new Employee(7,"User7","HR",50000,List.of("Lead","Social Media")),
				 new Employee(8,"User8","IT",80000,List.of("Java","Spring","React"))
				 
				 );
		 
		 //Collectors.summingDouble
		 
		 //1. Total Salary of all Employees
		  double sum=employees.stream().mapToDouble(Employee::getSalary).sum();
		  System.out.println(sum);
		  //with summingDouble way -> This is more useful with groupingBy, partitioningBy, collectingAndThen,mapping
		 double sumOfSalary= employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		 System.out.println(sumOfSalary);
		 
		 //2. Total salary of IT department
		 
		 double totalSalOfITEmployees=employees.stream().filter(emp->emp.getDepartment().equals("IT")).collect(Collectors.summingDouble(Employee::getSalary));
		  System.out.println(totalSalOfITEmployees);
		  
		  //3. Total  salary of employees earning more than 80k
		  double  totalOfEmpSalGreaterThan=employees.stream().filter(emp->emp.getSalary() > 80000).collect(Collectors.summingDouble(Employee::getSalary));
		 System.out.println(totalOfEmpSalGreaterThan);
		 
		 //4. Total number of skills across all employees
		 int totalSkills=employees.stream().collect(Collectors.summingInt(emp->emp.getSkills().size()));
		 System.out.println(totalSkills);
		 
		 //5. Total number of skills across IT employees
		 int totalSkillsOfIt=employees.stream().filter(emp->emp.getDepartment().equals("IT")).collect(Collectors.summingInt(emp->emp.getSkills().size()));
		 System.out.println(totalSkillsOfIt);
		 
		 //6.each skill count
		 Map<String,Long> count=employees.stream().flatMap(emp->emp.getSkills().stream()).collect(Collectors.groupingBy(s->s,Collectors.counting()));
		 System.out.println(count);
		//7.unique skills list
		 Set<String> uniqueSkill=employees.stream().flatMap(e->e.getSkills().stream()).collect(Collectors.toSet());
		 
		 System.out.println(uniqueSkill);
		//8. unique skills across IT employees
		 Set<String> uniqueSkillsOfIt=employees.stream().filter(emp->emp.getDepartment().equals("IT")).flatMap(e->e.getSkills().stream()).collect(Collectors.toSet());
		 System.out.println(uniqueSkillsOfIt);
		 //9. Find the most common skill among employees.
		 Map.Entry<String, Long> employeesWithMaxSkill= employees.stream().flatMap(e->e.getSkills().stream()).collect(Collectors.groupingBy(s->s,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
		 System.out.println(employeesWithMaxSkill);
		 
		 //10. Find the employee who has the maximum number of skills.
		 
		 Employee employeeWithMaxSkill=employees.stream().max(Comparator.comparingInt(e->e.getSkills().size())).orElse(null);
		 System.out.println(employeeWithMaxSkill);
		 
		 //11. Find the department that has the highest total salary.
		 
		Map.Entry<String,Double> department= employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.summingDouble(Employee::getSalary))).entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
		 System.out.println(department);
	}

}
