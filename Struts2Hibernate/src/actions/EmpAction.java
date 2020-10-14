package actions;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmpAction extends ActionSupport implements ModelDriven<Employee>,
		Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Employee emp;
	private String message;
	List<Employee> emps;

	@Override
	public Employee getModel() {
		return emp;
	}

	public String getMessage() {
		return message;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	@Override
	public void prepare() throws Exception {
		emp = new Employee();
		message = "";
		emps = new ArrayList<Employee>();
	}

	// save method
	public String save() {
		// message = "Add method executed";
		message = new EmpDao().addEmp(emp);
		System.out.println("save" + message);
		return SUCCESS;
	}

	// delete method
	public String delete() {
		// message = "delete method executed";
		message = new EmpDao().deleteEmp(emp);
		System.out.println(message);
		return SUCCESS;
	}

	// update method
	public String update() {
		// message = "update method executed";
		message = new EmpDao().updateEmp(emp);
		return SUCCESS;
	}

	// query method
	public String query() {
		message = "query method executed";
		Employee emp2 = new EmpDao().queryEmp(emp);
		emps.add(emp2);
		return SUCCESS;
	}

	// showall method
	public String showall() {
		message = "All Employees";
		emps = new EmpDao().showallEmp();
		return SUCCESS;
	}

}
