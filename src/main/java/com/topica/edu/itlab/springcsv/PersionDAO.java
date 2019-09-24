package com.topica.edu.itlab.springcsv;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.PreparedStatement;

public class PersionDAO {
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public void save(Persion persion) {
		String query = "insert into Persion (id, name, birthOfDate, gender) values (?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = (PreparedStatement) con.prepareStatement(query);
			ps.setInt(1, persion.getId());
			ps.setString(2, persion.getName());
			ps.setString(3, persion.getBirthOfDate());
			ps.setString(4, persion.getGender());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Persion saved with id="+persion.getId());
			}else System.out.println("Persion save failed with id="+persion.getId());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
