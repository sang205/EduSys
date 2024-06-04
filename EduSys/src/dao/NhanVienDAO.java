/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.*;
import utils.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author sangh
 */
public class NhanVienDAO {
    public void insert(NhanVien model){
        String sql = "INSERT INTO NhanVien (MaNV, MatKhau, HoTen, VaiTro) VALUES (?, ?, ?, ?)";
        ConnectDB.executeUpdate(sql, 
                model.getMaNv(),
                model.getMatKhau(), 
                model.getHoTen(), 
                model.getVaiTro());
    }
    
    public void update(NhanVien model) {
        String sql = "UPDATE NhanVien SET MatKhau=?, HoTen=?, VaiTro=? WHERE MaNV=?";
        ConnectDB.executeUpdate(sql, 
                model.getMatKhau(),
                model.getHoTen(), 
                model.getVaiTro(), 
                model.getMaNv());
    }
    
    public void delete(String MaNV) {
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        ConnectDB.executeUpdate(sql, MaNV);
    }
    
    public List<NhanVien> select(){
        String sql = "SELECT * FROM NhanVien";
        return select(sql);
    }
    
    public List<NhanVien> select(String sql, Object...args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectDB.executeQuery(sql, args);
                while(rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally{
                 rs.getStatement().getConnection().close();
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNv(rs.getString("MaNV"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setHoTen(rs.getString("HoTen"));
        model.setVaiTro(rs.getBoolean("VaiTro"));
        return model;
    }
    
    public NhanVien findByID(String manv) {
        String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
        List<NhanVien> list = select(sql, manv);
        return list.isEmpty() ? null: list.get(0);
    }
}
