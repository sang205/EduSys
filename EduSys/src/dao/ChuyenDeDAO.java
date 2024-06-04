/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.ChuyenDe;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.ConnectDB;

/**
 *
 * @author sangh
 */
public class ChuyenDeDAO {

    public void insert(ChuyenDe model) {
        String sql = "INSERT INTO ChuyenDe(MaCD, TenCD, HocPhi, ThoiLuong, Hinh, MoTa) VALUES (?, ?, ?, ?, ?, ?)";
        ConnectDB.executeUpdate(sql,
                model.getMaCD(),
                model.getTenCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getHinh(),
                model.getMoTa());
    }

    public void update(ChuyenDe model) {
        String sql = "UPDATE ChuyenDe SET TenCD = ?, HocPhi = ?, ThoiLuong =?, Hinh = ?, MoTa = ? WHERE MaCD = ?";
        ConnectDB.executeUpdate(sql,
                model.getTenCD(),
                model.getHocPhi(),
                model.getThoiLuong(),
                model.getHinh(),
                model.getMoTa(),
                model.getMaCD());
    }

    public void delete(String MaCD) {
        String sql = "DELETE FROM ChuyenDe WHERE MaCD = ?";
        ConnectDB.executeUpdate(sql, MaCD);
    }

    public List<ChuyenDe> select() {
        String sql = "SELECT * FROM ChuyenDe";
        return select(sql);
    }

    public ChuyenDe finfById(String macd) {
        String sql = "SELECT * FROM ChuyenDe WHERE MaCD = ?";
        List<ChuyenDe> list = select(sql, macd);
        return list.isEmpty() ? null : list.get(0);
    }
    
    private List<ChuyenDe> select(String sql, Object...args) {
        List<ChuyenDe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = ConnectDB.executeQuery(sql, args);
                while(rs.next()) {
                    ChuyenDe model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    
    private ChuyenDe readFromResultSet(ResultSet rs) throws SQLException {
        ChuyenDe model = new ChuyenDe();
        model.setMaCD(rs.getString("MaCD"));
        model.setHinh(rs.getString("Hinh"));
        model.setHocPhi(rs.getDouble("HocPhi"));
        model.setMoTa(rs.getString("MoTa"));
        model.setTenCD(rs.getString("TenCD"));
        model.setThoiLuong(rs.getInt("ThoiLuong"));
        return model;
    }
}
