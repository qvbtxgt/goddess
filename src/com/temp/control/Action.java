package com.temp.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.temp.model.Goddess;
import com.temp.model.JDBC;

import sun.print.resources.serviceui_pt_BR;

public class Action {
	
	//增加女神，包括编号，姓名，年龄，生日，电话和邮箱。
	public void addGoddess(Goddess goddess) throws Exception {
		Connection connection=JDBC.Getconnection();
		String sql="insert into mysql(id,name,age,birthday,tele,email) "
				+ "values(?,?,?,?,?,?)";
		PreparedStatement pStatement=connection.prepareStatement(sql);//预编译
		pStatement.setInt(1, goddess.getId());
		pStatement.setString(2, goddess.getName());
		pStatement.setInt(3, goddess.getAge());
		pStatement.setDate(4, new Date(goddess.getBirthday().getTime()));
		pStatement.setString(5, goddess.getTele());
		pStatement.setString(6, goddess.getEmail());
		pStatement.execute();
	}
	
	//删除特定编号女神信息
	public void delGoddess(Integer id) throws SQLException {
		Connection connection=JDBC.Getconnection();
		String sql="delete from mysql where id=?";
		PreparedStatement pStatement=connection.prepareStatement(sql);//预编译
		pStatement.setInt(1, id);
		pStatement.execute();
	}
	
	//更新禁区的女神信息
	public void updateGoddess(Goddess goddess) throws SQLException {
		Connection connection=JDBC.Getconnection();
		String sql=" update mysql set name=?,age=?,birthday=?,tele=?,email=?  "
				+" where id=? ";
		PreparedStatement pStatement=connection.prepareStatement(sql);//预编译
		pStatement.setString(1, goddess.getName());
		pStatement.setInt(2, goddess.getAge());
		pStatement.setDate(3, new Date(goddess.getBirthday().getTime()));
		pStatement.setString(4, goddess.getTele());
		pStatement.setString(5, goddess.getEmail());
		pStatement.setInt(6, goddess.getId());
		pStatement.execute();
	}
	
	//查询所有女神的基本信息（即编号和姓名）
	public List<Goddess> queryGoddess() throws Exception  {
		Connection connection=JDBC.Getconnection();
		String sql="select id,name from mysql";
		PreparedStatement pstatement=connection.prepareStatement(sql);
		ResultSet rSet=pstatement.executeQuery();
		List<Goddess> goddesses=new ArrayList<>();
		Goddess gods=null;
		while(rSet.next()){
			//别忘了对gods进行初始化；
			gods=new Goddess();
			gods.setId(rSet.getInt("id"));
			gods.setName(rSet.getString("name"));
			goddesses.add(gods);
		}
		return goddesses;
	}
	
	//根据名字的一部分信息查询女神的详细信息(查询信息固定)
	public List<Goddess> queryGoddess(String name) throws Exception  {
		Connection connection=JDBC.Getconnection();
		String sql="select * from mysql where name like ?";
		PreparedStatement pstatement=connection.prepareStatement(sql);
		pstatement.setString(1, "%"+name+"%");
		ResultSet rSet=pstatement.executeQuery();
		List<Goddess> goddesses=new ArrayList<>();
		Goddess gods=null;
		while(rSet.next()){
			//别忘了对gods进行初始化；
			gods=new Goddess();
			gods.setId(rSet.getInt("id"));
			gods.setName(rSet.getString("name"));
			gods.setAge(rSet.getInt("age"));
			gods.setBirthday(rSet.getDate("birthday"));
			gods.setTele(rSet.getString("tele"));
			gods.setEmail(rSet.getString("email"));
			goddesses.add(gods);
		}
		return goddesses;
	}
	
	//改进根据名字的一部分信息查询女神的详细信息(查询信息不固定)
	public List<Goddess> query(List<Map<String, Object>> para) throws Exception  {
		Connection connection=JDBC.Getconnection();
		StringBuilder sql=new StringBuilder();//这里使用StringBuilder类型可以不断的增加命令
		sql.append(" select * from mysql where 1=0 ");
		if (para!=null&&para.size()>0) {
			for (Map<String, Object> map : para) {
				sql.append(" or "+map.get("name")+" "+map.get("relation")+" "+map.get("value"));
			}
		}
		PreparedStatement pstatement=connection.prepareStatement(sql.toString());
		ResultSet rSet=pstatement.executeQuery();
		List<Goddess> goddesses=new ArrayList<>();
		Goddess gods=null;
		while(rSet.next()){
			//别忘了对gods进行初始化；
			gods=new Goddess();
			gods.setId(rSet.getInt("id"));
			gods.setName(rSet.getString("name"));
			gods.setAge(rSet.getInt("age"));
			gods.setBirthday(rSet.getDate("birthday"));
			gods.setTele(rSet.getString("tele"));
			gods.setEmail(rSet.getString("email"));
			goddesses.add(gods);
		}
		System.out.println(sql);
		return goddesses;
	}
	

	//查询特定编号女神详细信息
	public Goddess queryDetail(Integer id) throws SQLException {
		Goddess goddess=null;
		Connection connection=JDBC.Getconnection();
		String sql="select * from mysql where id=?";
		PreparedStatement pStatement=connection.prepareStatement(sql);//预编译
		pStatement.setInt(1,id);
		ResultSet resultSet=pStatement.executeQuery();
		while (resultSet.next()) {
			goddess=new Goddess();
			goddess.setId(resultSet.getInt("id"));
			goddess.setName(resultSet.getString("name"));
			goddess.setAge(resultSet.getInt("age"));
			goddess.setBirthday(resultSet.getDate("birthday"));
			goddess.setTele(resultSet.getString("tele"));
			goddess.setEmail(resultSet.getString("email"));
		}
		return goddess;
	}
}
