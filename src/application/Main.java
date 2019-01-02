package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.entities.enums.WorkLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();

        System.out.println("Enter work data: ");
        System.out.print("Name: ");
        String workName = sc.nextLine();
        System.out.print("Level: ");
        String workLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workName, WorkLevel.valueOf(workLevel), baseSalary, new Department(departmentName));
        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();
        for (int i = 1; i <=n ; i++) {
            System.out.println("Enter contract #"+i+" data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate,valuePerHour,hours);
            worker.addContract(contract);
            System.out.println();
        }
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month =  Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: "+worker.getName());
        System.out.println("Department: "+worker.getDepartment().getName());
        System.out.println("Income for "+monthAndYear+": "+ String.format("%.2f",worker.income(year,month) ));



        sc.close();
    }
}
