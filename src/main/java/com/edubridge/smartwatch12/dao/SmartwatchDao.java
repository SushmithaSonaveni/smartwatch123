package com.edubridge.smartwatch12.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.contactapp.util.DBUtils;
import com.edubridge.smartwatch12.model.Smartwatch;
/*
DAO-Data Access Object
To maintain only data persistence logic (Jdbc Code)
 */
public class SmartwatchDao implements SmartwatchDaoI {
    private static Connection con = null;
    
    static{
        con=DBUtils.getConnection();    
    }
    @Override
    public int addSmartwatch(Smartwatch s) {
        String insert="insert into smartwatch_details(id,name,brand,colour,price) values(?,?,?,?,?)";
        int status=0;
        
        try {
            PreparedStatement ps=con.prepareStatement(insert);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getBrand());
            ps.setString(4, s.getColour());
            ps.setFloat(5, s.getPrice());
            status=ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    @Override
   
    public List<Smartwatch> getAllSmartwatches() {
        List<Smartwatch> smartwatches=new ArrayList<Smartwatch>();
        String select="select * from smartwatch_details";
        try {
            PreparedStatement ps=con.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	Smartwatch smartwatch=new Smartwatch();
            	smartwatch.setId(rs.getInt("id"));
            	smartwatch.setName(rs.getString("name"));
            	smartwatch.setBrand(rs.getString("brand"));
            	smartwatch.setColour(rs.getString("colour"));
            	smartwatch.setPrice(rs.getFloat("price"));
            	smartwatches.add(smartwatch);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
        return smartwatches;
    }
   
    @Override
    public Smartwatch getSmartwatchByName(String name) {
        Smartwatch smartwatch = null;
        String select = "SELECT * FROM smartwatch_details WHERE name = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(select);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                smartwatch = new Smartwatch();
                smartwatch.setId(rs.getInt("id"));
                smartwatch.setName(rs.getString("name"));
                smartwatch.setBrand(rs.getString("brand"));
                smartwatch.setColour(rs.getString("colour"));
                smartwatch.setPrice(rs.getFloat("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return smartwatch;
    }

    @Override
    public int updateSmartwatch(Smartwatch s) {
        String update = "UPDATE smartwatch_details SET name = ?, brand = ?, colour = ?, price = ? WHERE id = ?";
        int status = 0;

        try {
            PreparedStatement ps = con.prepareStatement(update);
            ps.setString(1, s.getName());
            ps.setString(2, s.getBrand());
            ps.setString(3, s.getColour());
            ps.setFloat(4, s.getPrice());
            ps.setInt(5, s.getId());
            status = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    @Override
    public void deleteSmartwatch(String name) {
        String delete = "DELETE FROM smartwatch_details WHERE name = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(delete);
            ps.setString(1, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllSmartwatches() {
        String deleteAll = "DELETE FROM smartwatch_details";
        
        try {
            PreparedStatement ps = con.prepareStatement(deleteAll);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchSmartwatch(String name) {
        List<Smartwatch> smartwatches = new ArrayList<>();
        String search = "SELECT * FROM smartwatch_details WHERE name LIKE ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(search);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Smartwatch smartwatch = new Smartwatch();
                smartwatch.setId(rs.getInt("id"));
                smartwatch.setName(rs.getString("name"));
                smartwatch.setBrand(rs.getString("brand"));
                smartwatch.setColour(rs.getString("colour"));
                smartwatch.setPrice(rs.getFloat("price"));
                smartwatches.add(smartwatch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return;
    }
}
        
    
   