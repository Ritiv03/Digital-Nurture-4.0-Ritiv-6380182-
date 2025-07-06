package EmployeeManagement;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}
class EmployeeManager {
    private Employee[] employees;
    private int count;

    public EmployeeManager(int size) {
        employees = new Employee[size];
        count = 0;
    }

    // Add employee
    public void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count++] = e;
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Search employee by ID
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse (print all employees)
    public void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees in the system.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete employee by ID
    public void deleteEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                // Shift remaining employees left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null; // Clear last spot
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}
public class Main {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        manager.addEmployee(new Employee(1, "Alice", "Manager", 70000));
        manager.addEmployee(new Employee(2, "Bob", "Developer", 50000));
        manager.addEmployee(new Employee(3, "Charlie", "Designer", 45000));

        System.out.println("\nAll Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for employee with ID 2:");
        Employee found = manager.searchEmployee(2);
        System.out.println(found != null ? found : "Employee not found.");

        System.out.println("\nDeleting employee with ID 2...");
        manager.deleteEmployee(2);

        System.out.println("\nAll Employees after deletion:");
        manager.traverseEmployees();
    }
}

