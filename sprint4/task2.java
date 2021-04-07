Employee emp1=new Employee();
Employee emp2=new Employee();
emp1.fullName="John Doe";
emp2.fullName="Peter Peterson";
emp1.salary=20000f;
emp2.salary=25000f;
Employee[] employees={emp1,emp2};
StringBuilder employeesAsJSON=new StringBuilder("[");
for(Employee emp:employees){
    employeesAsJSON.append("{fullName: ");
    employeesAsJSON.append("\"");
    employeesAsJSON.append(emp.fullName);
    employeesAsJSON.append("\", ");
    employeesAsJSON.append("salary: ");
    employeesAsJSON.append(emp.salary);
    employeesAsJSON.append("}, ");
}
employeesAsJSON.delete(employeesAsJSON.length()-2,employeesAsJSON.length());
employeesAsJSON.append("]");
String employeesInfo=employeesAsJSON.toString();