package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entities.Distributions;
import Helper.ConnectionProvider;

public class DistributionsDao {
	
	public List<Distributions> getCategories(){
		List<Distributions> list=new ArrayList<Distributions>();
		try {
			Connection con=new ConnectionProvider().getConnection();
			
			String query="select * from Distributions";
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(query);
			
			while(rs.next()) {
				Distributions d=new Distributions(rs.getInt("Id"), rs.getString("Category"),rs.getInt("Weight"));
				list.add(d);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Map<String , Integer> getAllDistributions(){
		Map<String , Integer> distributions=new HashMap<String, Integer>();
		
		try {
			Connection con=new ConnectionProvider().getConnection();
			
			String query="select * from Distributions";
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(query);
			
			while(rs.next()) {
				Distributions d=new Distributions();
				d.setAssignmentCategory(rs.getString("Category"));
				d.setWeight(rs.getInt("weight"));
				distributions.put(d.getAssignmentCategory(), d.getWeight());
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return distributions;
	}
	
	public boolean addDistributions(Distributions d) {
		boolean b=false;
		
		if(!getAllCategories().contains(d.getAssignmentCategory())) {
			try {
				Connection con=new ConnectionProvider().getConnection();
				
				String query="insert into Distributions(Category,Weight) values(?,?)";
				PreparedStatement p=con.prepareStatement(query);
				p.setString(1, d.getAssignmentCategory());
				p.setInt(2, d.getWeight());
				p.executeUpdate();
				b=true;
				
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return b;
		}else {
			return false;
		}
	}
	
	public List<String> getAllCategories(){
		List<String> list=new ArrayList<String>();
		try {
			Connection con=new ConnectionProvider().getConnection();
			
			String query="select Category from Distributions";
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(query);
			
			while(rs.next()) {
				list.add(rs.getString("Category"));
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean removeCategory(String c) {
		boolean b=false;
		
		if(getAllCategories().contains(c)) {
			try {
				Connection con=new ConnectionProvider().getConnection();
				
				String query="delete from Distributions where Category=?";
				PreparedStatement p=con.prepareStatement(query);
				p.setString(1, c);
				p.executeUpdate();
				b=true;
				
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return b;
		}else {
			return false;
		}

	}
	
}
