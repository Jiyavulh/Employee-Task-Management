package com.etm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.etm.entity.Employee;

public class EmployeeDao {

    EntityManager entityManager =
        Persistence.createEntityManagerFactory("vikas").createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();

    public Employee saveEmployee(Employee employee) {
        entityTransaction.begin();
        entityManager.persist(employee);
        entityTransaction.commit();
        return employee;
    }

    public Employee updateEmployee(Employee employee) {
        entityTransaction.begin();
        entityManager.merge(employee);
        entityTransaction.commit();
        return employee;
    }

    public Employee deleteEmployeee(Employee employee) {
        entityTransaction.begin();
        entityManager.remove(employee);
        entityTransaction.commit();
        return employee;
    }

    public Employee findEmployeeByIdEmployee(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    public List<Employee> findAllEmployee() {
        Query query = entityManager.createQuery("select e from Employee e");
        List<Employee> list = query.getResultList();
        return list;
    }

  
    public Employee findEmployeeByEmailAndPassword(String email, String password) {
        Query query = entityManager.createQuery( "select e from Employee e where e.email=?1 and e.password=?2");

        query.setParameter(1, email);
        query.setParameter(2, password);

        List<Employee> list = query.getResultList();

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
    public Employee findEmployeeByEmail(String email) {
        Query query =
            entityManager.createQuery("select e from Employee e where e.email=?1");
        query.setParameter(1, email);

        List<Employee> list = query.getResultList();
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
    public List<Employee> findAllDeveloper() {

        Query query = entityManager.createQuery(
            "select e from Employee e where e.role='developer'"
        );

        List<Employee> list = query.getResultList();

        if (list != null) {
            return list;
        } else {
            return null;
        }
    }
    public Employee findEmployeeById(int employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    public void deleteEmployee(Employee employee) {
        entityTransaction.begin();
        entityManager.remove(employee);
        entityTransaction.commit();
    }



}
