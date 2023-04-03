package co.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
//	resultSet rs;
	
	public void connect() {
		try {
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Map<String, Object> getEmpInfo(int empId){
		// Map 타입 : {키:값},{키:값},{키:값},{키:값} => result.get('키값')넣으면 값을 반환
		connect(); // conn객체
		String sql = "select * from employees where employee_id = ?";
		
		Map<String, Object> result = new HashMap<>();
		
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				result.put("id", rs.getInt("employee_id"));
				result.put("firstName", rs.getString("first_name"));
				result.put("lastName", rs.getString("last_name"));
				result.put("salary", rs.getInt("salary"));
				result.put("departmentId", rs.getInt("department_ID"));
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return result;
	}
	
	//	사원 번호 : <input type="text" name="emplId"><br>
	//	firstName : <input type="text" name="first"><br>
	//	lastName : <input type="text" name="last"><br>
	//	입사일자 : <input type="date" name="hire"><br>
	//	직무 : <input type="text" name="job"><br>
	//	이메일 : <input type="text" name="email"><br>
	
	public int InsertEmpInfo(Map<String, Object> insert){
		
		int result = 0;
		connect();
		String sql = "insert into employees(employee_id,first_name,last_name,hire_date,job_id,email) values(?,?,?,?,?,?)";
		try {
		psmt = conn.prepareStatement(sql);
		psmt.setString(1, (String) insert.get("eid"));
		psmt.setString(2, (String) insert.get("first"));
		psmt.setString(3, (String) insert.get("last"));
		psmt.setString(4, (String) insert.get("hire"));
		psmt.setString(5, (String) insert.get("job"));
		psmt.setString(6, (String) insert.get("email"));
	
		result = psmt.executeUpdate();
	}catch(SQLException e) {
		e.printStackTrace();
	}
		return result;
}
	
	
	
	
	
	
	
	
	
	
	
}
