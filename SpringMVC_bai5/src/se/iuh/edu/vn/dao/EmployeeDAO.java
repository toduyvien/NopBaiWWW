package se.iuh.edu.vn.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import se.iuh.edu.vn.beans.Employee;

@Repository
public class EmployeeDAO {
	@Autowired
	JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Employee e) {
		String sql = "insert into Employee(name,salary,designation) values('"+e.getName()+"',"
	+e.getSalary()+",'"+e.getDesignation()+"')";
		
		return template.update(sql);
	}
	public int update(Employee e) {
		String sql = "update  Employee set name= '"+e.getName()+"',salary="
				+e.getSalary()+", designation='"+ e.getDesignation()+"' where id="+e.getId();
		
		return template.update(sql);
	}
	public int delete(int  id) {
		String sql = "delete from Employee where id="+id+"";
		
		return template.update(sql);
	}
	public Employee getEmployeeByID(int id) {
		String sql="select * from Employee where id=?";
		return template.queryForObject(sql,new Object[] {id},
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	public List<Employee> getAll(){
		return template.query("select * from Employee", new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e =new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}
}
