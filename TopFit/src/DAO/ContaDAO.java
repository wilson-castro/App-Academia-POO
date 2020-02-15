package DAO;

import Beans.BeansConta;
import Beans.BeansMatricula;
import controle.conexao;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ContaDAO {

    private Connection con = null;

    public void Conta_DAO(BeansConta conta) {

        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pagamentos(id_aluno,descricao,valor,data,hora,data_venc,situacao)VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, conta.getId_aluno());
            stmt.setString(2, conta.getDescricao());
            stmt.setFloat(3, conta.getValor());
            stmt.setDate(4, (java.sql.Date) conta.getData());
            stmt.setString(5, conta.getHora());
            stmt.setDate(6, (java.sql.Date) conta.getData_venc());
            stmt.setBoolean(7, false);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Conta lançanda com sucesso!!!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao lançar!!!!" + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
    }

    public List<BeansConta> readAll() {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansConta> buscar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM pagamentos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansConta busca = new BeansConta();

                busca.setRecibo(rs.getInt("recibo"));
                busca.setDescricao(rs.getString("descricao"));
                busca.setData(rs.getDate("data"));
                busca.setHora(rs.getString("hora"));
                busca.setData_venc(rs.getDate("data_vencimento"));

                buscar.add(busca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar;

    }

    public List<BeansConta> readForDescSituacao() {

        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansConta> buscar = new ArrayList<>();

        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat data1 = new SimpleDateFormat("yyyy-MM-");

        try {
            String dataHoje = data.format(new Date());

            stmt = con.prepareStatement("SELECT * FROM pagamentos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                try {
                    JOptionPane.showMessageDialog(null, data.parse(data1.format(new Date()) + rs.getString("dia_pagamento")).compareTo(data.parse(dataHoje)));
                } catch (ParseException ex) {
                    Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
                }

                BeansConta busca = new BeansConta();

                busca.setRecibo(rs.getInt("recibo"));
                busca.setDescricao(rs.getString("descricao"));
                busca.setData(rs.getDate("data"));
                busca.setHora(rs.getString("hora"));
                busca.setData_venc(rs.getDate("data_vencimento"));

                buscar.add(busca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar;

    }

    public void update(BeansConta Conta) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE pagamento SET id_aluno = ?, decricao = ?, valor = ?, data = ?, hora = ?, data_vencimento = ? WHERE recibo = ?");
            stmt.setString(1, Conta.getId_aluno());
            stmt.setString(2, Conta.getDescricao());
            stmt.setFloat(3, Conta.getValor());

            SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                stmt.setString(4, frmt.format(frmt.parse(String.valueOf(Conta.getData()))));
            } catch (ParseException ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            stmt.setString(5, Conta.getHora());

            SimpleDateFormat frmta = new SimpleDateFormat("yyyy-MM-dd");
            try {
                stmt.setString(6, frmta.format(frmt.parse(String.valueOf(Conta.getData_venc()))));
            } catch (ParseException ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            stmt.setInt(7, Conta.getRecibo());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!!!" + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
    }

}
