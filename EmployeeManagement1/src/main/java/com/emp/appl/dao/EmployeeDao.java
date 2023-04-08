package com.emp.appl.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.emp.appl.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory sf;

	public List<Employee> getallEmp() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		List<Employee> lt = cr.list();

		session.close();
		return lt;

	}

	public String insEmp(Employee ee) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();

		session.save(ee);

		tr.commit();
		session.close();
		return "1 Record Inserted";

	}

	public String deleteEmp(int empid) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Employee emp = session.get(Employee.class, empid);
		session.delete(emp);

		tr.commit();
		session.close();

		return "1 Record Deleted";

	}

	public boolean updtEmp(Employee emp) {

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(emp);

		tr.commit();
		session.close();
		return true;

	}

	public Object getSingleEmp(int empid) {
		Session session = sf.openSession();
		Employee emp = session.get(Employee.class, empid);
		session.close();
		if (emp == null) {
			return "Not Found with empid: " + empid;
		} else {
			return emp;
		}

	}

	public List<Employee> greaterThan25000() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.gt("salary", 25000));
		List<Employee> lt = cr.list();

		session.close();
		return lt;
	}

	public List<Employee> experienceBetn() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.between("experience", 4, 10));
		List<Employee> lt = cr.list();

		session.close();
		return lt;

	}

	public List<Employee> empProfileDeveloper() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.like("position", "software developer"));
		List<Employee> lt = cr.list();

		session.close();
		return lt;

	}

	public List<Employee> profileNotDeveloper() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.add(Restrictions.ne("position", "software developer"));
		List<Employee> lt = cr.list();

		session.close();
		return lt;

	}

	public List<Employee> maxSalary() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);

		cr.addOrder(Order.desc("salary"));
		cr.setMaxResults(1);
		List<Employee> lt = cr.list();
		session.close();

		return lt;

	}

	public String minExpEmp() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.setMaxResults(1);
		List<Employee> lt = cr.list();
		String s1 = null;
		int s2 = 0;
		for (Employee emp : lt) {
			s1 = emp.getEmpname();
			s2 = emp.getExperience();
		}
		session.close();
		return s1 + " [experience : " + s2 + ")";

	}

	public List sumOfSalarys() {
		Session session = sf.openSession();
		Criteria cr = session.createCriteria(Employee.class);
		cr.setProjection(Projections.sum("salary"));
		List sum = cr.list();

		session.close();
		return sum;

	}

}
