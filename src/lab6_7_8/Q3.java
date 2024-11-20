package lab6_7_8;

//) Create a class called employee that include three instance variable a)name(type string) b) last name
//        (type string) and c) monthly salary(double). Provide a constructor that initialize the three instance
//variable. Provide a set and a get method of instance variable. if the monthly salary is not positive do not set
//its value. Write a test aplication named employeetest that demonstrate class employee capabilities.create
//two employee object and display each object yearly salary. Then give each employee a 10% hike and
//display each employee yearly salary again.
class Employee{
    private String name;
    private String last_name;
    private double salary;

    public Employee(String name, String last_name, double salary) {
        this.name = name;
        this.last_name = last_name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setSalary(double salary) {
        if(salary<0){
            this.salary=0;
        }
        else{
            this.salary = salary;
        }

    }
    public void employeetest(Employee emp1){
        System.out.println(name +"'s Yearly salary:"+salary*12);
        System.out.println(emp1.name+"'s Yearly salary:"+emp1.salary*12);

        System.out.println(name +"'s Yearly salary:"+((salary*12)+(salary*12)*.1));
        System.out.println(emp1.name +"'s Yearly salary:"+((emp1.salary*12)+(emp1.salary*12)*.1));
        return ;
    }

}

public class Q3 {
    public static void main(String[] args) {
        Employee emp1=new Employee("Sahil","Nagwani",7000);
        Employee emp2=new Employee("Aman","Shakya",8000);

        emp1.employeetest(emp2);
    }
}