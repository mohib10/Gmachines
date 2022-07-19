package service;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Machine;
import connexion.Connexion;
import dao.IDao;

public class MachineService implements IDao<Machine> {

    @Override
    public boolean create(Machine o) {
        String sql = "insert into machine values (null, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
            ps.setDate(2, new Date(o.getDateAchat().getTime()));
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getMarqueId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("create : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean delete(Machine o) {
        String sql = "delete from machine where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("delete : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public boolean update(Machine o) {

        String sql = "update machine set reference  = ? ,dateAchat = ? , prix = ?, marque_id= ? where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, o.getReference());
            ps.setDate(2, new Date(o.getDateAchat().getTime()));
            ps.setDouble(3, o.getPrix());
            ps.setInt(4, o.getMarqueId());
            ps.setInt(5, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("update : erreur sql : " + e.getMessage());

        }
        return false;
    }

    @Override
    public Machine findById(int id) {
        Machine m = null;
        String sql = "select * from machine where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	Date date = rs.getDate("dateAchat"); 
                return new Machine(rs.getInt("id"), rs.getString("reference"), date,
                        rs.getDouble("prix"), rs.getInt("marque_id"));
            }

        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Machine> findAll() {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"), rs.getInt("marque_id")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<Machine> findMachineByDateDebut_dateFin(java.util.Date dateDebut, java.util.Date dateFin) {
        List<Machine> machines = new ArrayList<Machine>();
        String sql = "select * from machine where (dateAchat BETWEEN ? AND ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setDate(1, new Date(dateDebut.getTime()));
            ps.setDate(2, new Date(dateFin.getTime()));
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"), rs.getInt("marque_id")));
                
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<Machine> findMachineByMarqueId(int marqueId) {
        List<Machine> machines = new ArrayList<Machine>();

        String sql = "select * from machine where marque_id =  ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setInt(1, marqueId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                machines.add(new Machine(rs.getInt("id"), rs.getString("reference"), rs.getDate("dateAchat"),
                        rs.getDouble("prix"), rs.getInt("marque_id")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return machines;
    }
    
    public List<String> findReference() {
        List<String> references = new ArrayList<String>();
        String sql = "select distinct(reference) as ref from machine";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                references.add(rs.getString("ref"));
            }
        } catch (SQLException e) {
            System.out.println("findReference " + e.getMessage());
        }
        return references;
    }

}
