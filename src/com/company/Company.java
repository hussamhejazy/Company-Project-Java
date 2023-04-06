package com.company;

import java.util.Scanner;

public class Company {

    public static void main(String[] args) {
        // write your code here
        Employees employees = new Employees();
        Scanner input = new Scanner(System.in);
        boolean RunApp = true;
        while (RunApp) {
            System.out.println("*************************");
            System.out.println("1-Add employee\n2-Print employee\n3-Print all employees\n4-calculate the bonus\n5-Find highest salary\n6-Exit");
            System.out.println("*************************");
            System.out.print("Enter your choice:");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter ID, Name, Years, Salary, Department:");
                    int result = employees.addEmployee(input.nextInt(), input.next(), input.nextInt(), input.nextDouble(), input.next());
                    if (result == 1) {
                        System.out.println("Added");
                    } else if (result == -1) {
                        System.out.println("Cannot add! ID is already used!");
                    } else if (result == -2) {
                        System.out.println("Cannot add! array is full!");
                    }
                    break;
                case 2:
                    System.out.print("Enter the ID of the employee you want to print:");
                    int id = input.nextInt();
                    int result1 = employees.findEmployee(id);
                    if (result1 != -1) {
                        employees.printEmployee(result1);
                    } else {
                        System.out.println("Error cannot print");
                    }
                    break;
                case 3:
                    employees.printAll();
                    break;
                case 4:
                    System.out.print("Enter the ID of the employee:");
                    int ID = input.nextInt();
                    int itFound = employees.findEmployee(ID);
                    if (itFound != -1) {
                        double bonus = employees.calculateBonus(ID);
                        System.out.println("Bonus: " + bonus);
                    } else {
                        System.out.println("ID is not correct!");
                    }
                    break;
                case 5:
                    System.out.print("Enter the department: ");
                    String department = input.next();
                    int result2 = employees.findHighestSalary(department);
                    if (result2 != -1) {
                        System.out.print("The employee with highest salary in the " + department + " department is: ");
                        employees.printEmployee(result2);
                    } else {
                        System.out.println("The department is not found!");
                    }
                    break;
                case 6:
                    RunApp = false;
                    System.out.println("Thanks goodbye!");
                    break;
                default:
                    System.out.println("incorrect input please try again!");
            }
        }

    }
}
