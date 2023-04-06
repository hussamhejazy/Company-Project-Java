package com.company;

public class Employees {

    private int[] ids;
    private String[] names;
    private int[] years;
    private double[] salaries;
    private String[] departments;
    private int nEmployees;

    public Employees() {
        ids = new int[50];
        names = new String[50];
        years = new int[50];
        salaries = new double[50];
        departments = new String[50];
        nEmployees = 0;
    }

    public int getNEmployees() {
        return this.nEmployees;
    }

    public int addEmployee(int id, String name, int year, double salary, String department) {
        int addedStatus = 0;
        if (getNEmployees() ==50){
            addedStatus = -2;
        }else  if (getNEmployees() <= 50) {
            if (findEmployee(id) != -1) {
                addedStatus = -1;
            } else {
                this.ids[this.nEmployees] = id;
                this.names[this.nEmployees] = name;
                this.years[this.nEmployees] = year;
                this.salaries[this.nEmployees] = salary;
                this.departments[this.nEmployees] = department;
                this.nEmployees++;
                addedStatus = 1;
            }
        }
        return addedStatus;
    }

    public int findEmployee(int id) {
        int index = -1;
        for (int i = 0; i < ids.length; i++) {
            if (this.ids[i] == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findHighestSalary(String department) {
        int index = -1;
        double maxSalary = 0.0;
        for (int i = 0; i < departments.length; i++) {
            if (department.equals(departments[i])) {
                if (salaries[i] > maxSalary) {
                    maxSalary = salaries[i];
                    index = i;
                }
            }
        }
        return index;
    }

    public void printEmployee(int index) {
        if (index < 0 && index >= nEmployees) {
            System.out.println("Error cannot print");
        } else {
            System.out.printf("Employee: ID: %d. Name: %s. Years: %d. Salary: %s. Department: %s\n", ids[index], names[index], years[index], salaries[index], departments[index]);
        }
    }

    public void printAll() {
        if (getNEmployees() == 0) {
            System.out.println("The list is empty!");
        } else {
            int i = 0;
            while (i < getNEmployees()) {
                System.out.printf("Employee: ID: %d. Name: %s. Years: %d. Salary: %s. Department: %s\n", ids[i], names[i], years[i], salaries[i], departments[i]);
                i++;
            }
        }
    }

    public double calculateBonus(int id) {
        double Bonus = 0.0;
        int index = findEmployee(id);
        System.out.printf("Employee: ID: %d. Name: %s. Years: %d. Salary: %s. Department: %s\n", ids[index], names[index], years[index], salaries[index], departments[index]);
        if (years[index] < 5) {
            Bonus = salaries[index] * 2;
            return Bonus;
        } else if (years[index] >= 5 && years[index] <= 10) {
            Bonus = salaries[index] * 3;
            return Bonus;
        } else if (years[index] > 10) {
            Bonus = salaries[index] * 4;
            return Bonus;
        }
        return Bonus;
    }
}
