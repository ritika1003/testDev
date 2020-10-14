package actions;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmpDao {
	private SessionFactory sessionfactory;
	private Session session;

	public EmpDao() {
		if (sessionfactory == null)
			sessionfactory = new Configuration().configure()
					.buildSessionFactory();
		session=sessionfactory.openSession();
	}
	public String addEmp(Employee emp)
	{
		session.beginTransaction().begin();
		session.save(emp);
		session.beginTransaction().commit();
		return "Employee record Inserted";
	}
	public String updateEmp(Employee emp)
	{
		String status="Not updated";
		session.beginTransaction().begin();
		Employee emp1=(Employee)session.get(Employee.class, emp.getEid());
		if(emp1!=null)
		{
			emp1.setName(emp.getName());
			emp1.setCity(emp.getCity());
			emp1.setSalary(emp.getSalary());
			session.update(emp1);
			status="Employe updated";
		}
		session.beginTransaction().commit();
		return status;
	}
	public String deleteEmp(Employee emp)
	{
		String status="Not deleted";
		session.beginTransaction().begin();
		Employee emp1=(Employee)session.get(Employee.class, emp.getEid());
		if(emp1!=null)
		{
			session.delete(emp1);
			status="Employe Deleted";
		}
		session.beginTransaction().commit();
		return status;
	}
	public Employee queryEmp(Employee emp)
	{
		Employee emp1=(Employee)session.get(Employee.class, emp.getEid());
		return emp1;
	}
	public List<Employee> showallEmp()
	{
		Query qr = session.createQuery("from Employee");
		List<Employee> emps=qr.list();
		return emps;
	}
}
