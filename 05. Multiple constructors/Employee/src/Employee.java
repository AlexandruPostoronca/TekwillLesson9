class Employee {

    String name;
    int salary;
    String address;

    //write your code here


    public Employee() {
        name = "unknown";
        salary = 0;
        address="unknown";
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
        address = "unknown";
    }

    public Employee(String name, int salary, String address) {
        this.name = name;
        this.salary = salary;
        this.address = address;
    }
}