package studentmanage.model.dao;

import studentmanage.common.SearchInterface;
import studentmanage.model.vo.Employee;
import studentmanage.model.vo.Job;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements DaoInterface {
    private List<Employee> employeeList = new ArrayList<>();
    private static EmployeeDao dao;

    private EmployeeDao() {

    }

    public static EmployeeDao employeeDao() {
        if (dao == null) {
            dao = new EmployeeDao();
        }
        return dao;
    }


    @Override
    public boolean save(Job employee) {
        Employee employeeInfo = (Employee) employee;
        if (findEqualJob(employeeInfo)) {
            System.out.println("== 중복 사원 ==");
            return false;
        }
        employeeList.add(employeeInfo);
        return true;
    }

    @Override
    public List<Employee> search(SearchInterface search) {
        List<Employee> employees = new ArrayList<>();

        for (Employee employee : employeeList) {
            if (search.find(employee)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Override
    public boolean update(Job existEmployeeInfo, Job updateEmployeeInfo) {
        Employee exsistEmployee = (Employee) existEmployeeInfo;
        Employee updateEmployee = (Employee) updateEmployeeInfo;
        if (!findEqualJob(exsistEmployee)) {
            return false;
        }

        exsistEmployee.setDepartment(updateEmployee.getDepartment());
        exsistEmployee.setRank(updateEmployee.getRank());
        exsistEmployee.setYear(updateEmployee.getYear());
        exsistEmployee.setContact(updateEmployee.getContact());
        exsistEmployee.setAddress(updateEmployee.getAddress());

        return true;
    }

    @Override
    public boolean delete(int id) {
        List<Employee> employees = search(
                job -> {
                    Employee employee = (Employee) job;
                    return employee.getId() == id;
                }
        );

        Employee employee = null;
        if (employees.size() == 1) {
            employee = employees.get(0);
        }

        if (employee == null) {
            return false;
        }
        employeeList.remove(employee);
        return true;
    }

    @Override
    public boolean findEqualJob(Job employee) {
        return employeeList.contains((Employee) employee);
    }
}