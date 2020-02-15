package DAO;

import Beans.BeansFinanceiro;
import controle.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FinanceiroDAO {

    public List<BeansFinanceiro> readAll() {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFinanceiro> financeiro = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM financeiro");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansFinanceiro financ = new BeansFinanceiro();
                SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");

                financ.setRecibo(rs.getInt("recibo"));
                financ.setDescricao(rs.getString("descricao"));
                financ.setValor(rs.getFloat("valor"));
                financ.setData(data.format((Date) (rs.getDate("data"))));
                financ.setHora(hora.format((Time) rs.getTime("hora")));
                financ.setData_venc(data.format((Date) rs.getDate("data_vencimento")));
                financ.setData_pag(data.format((Date) rs.getTime("data_pagamento")));

                financeiro.add(financ);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return financeiro;

    }

    public List<BeansFinanceiro> readForDia(String desc) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFinanceiro> financeiro = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM financeiro WHERE data LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansFinanceiro financ = new BeansFinanceiro();
                SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat hora = new SimpleDateFormat("HH-mm-ss");

                financ.setRecibo(rs.getInt("recibo"));
                financ.setDescricao(rs.getString("descricao"));
                financ.setValor(rs.getFloat("valor"));
                financ.setData(data.format((Date) (rs.getDate("data"))));
                financ.setHora(hora.format((Time) rs.getTime("hora")));
                financ.setData_venc(data.format((Date) rs.getDate("data_vencimento")));
                financ.setData_pag(data.format((Date) rs.getTime("data_pagamento")));

                financeiro.add(financ);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FinanceiroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return financeiro;

    }

    public void delete(BeansFinanceiro financ) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM financeiro WHERE recibo = ?");
            stmt.setInt(1, financ.getRecibo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }

    }

    public void insert(BeansFinanceiro financ) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO financeiro(descricao, valor, data, hora, data_vencimento, data_pagamento) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, financ.getDescricao());
            stmt.setFloat(2, (float) financ.getValor());
            stmt.setString(3, financ.getData());
            stmt.setString(4, financ.getHora());
            stmt.setString(5, financ.getData_venc());
            stmt.setString(6, financ.getData_pag());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar! " + ex);
            System.out.println(ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
    }

    public void update(BeansFinanceiro financ) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE financeiro SET descricao = ?, valor = ?, data = ?, hora = ?, data_vencimento = ?, data_pagamento = ? WHERE recibo = ?");
            stmt.setString(1, financ.getDescricao());
            stmt.setFloat(2, (float) financ.getValor());
            stmt.setString(3, financ.getData());
            stmt.setString(4, financ.getHora());
            stmt.setString(5, financ.getData_venc());
            stmt.setString(5, financ.getData_pag());

            SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                stmt.setString(6, frmt.format(frmt.parse(financ.getData())));
            } catch (ParseException ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            stmt.setInt(7, financ.getRecibo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!!!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!!!" + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
    }
}
