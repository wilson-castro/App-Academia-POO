package DAO;

import Beans.BeansModalidades;
import controle.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModalidadesDAO {

    public List<BeansModalidades> readA() {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansModalidades> modalidades = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM modalidade");
            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansModalidades modal = new BeansModalidades();

                modal.setId_modalidade(rs.getString("id_modalidade"));
                modal.setModalidades(rs.getString("modalidade"));
                modal.setPreço(Float.parseFloat(rs.getString("preco")));

                modalidades.add(modal);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModalidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return modalidades;

    }

    public void Cadastro_Modalidades(BeansModalidades usu) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO modalidade(id_modalidade,modalidade,preco)VALUES(?,?,?)");
            stmt.setString(1, usu.getId_modalidade());
            stmt.setString(2, usu.getModalidades());
            stmt.setFloat(3, usu.getPreço());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Modalidade salva com sucesso!!!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!!!" + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
    }

    public void UpdateModalidades(BeansModalidades modalidade) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE modalidade SET modalidade = ?, preco = ? WHERE id_modalidade = ?");
            stmt.setString(1, modalidade.getModalidades());
            stmt.setFloat(2, modalidade.getPreço());
            stmt.setString(3, modalidade.getId_modalidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Modalidade atualizada com sucesso!!!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!!!!" + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
    }

    public void delete(BeansModalidades m) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM modalidade WHERE id_modalidade = ?");
            stmt.setString(1, m.getId_modalidade());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }

    }

    public BeansModalidades readForId(String id) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT id_modalidade,modalidade,preco FROM modalidade WHERE id_modalidade LIKE ?");
            stmt.setString(1, "%" + id + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansModalidades mod = new BeansModalidades();

                mod.setId_modalidade(rs.getString("id_modalidade"));
                mod.setModalidades(rs.getString("modalidade"));
                mod.setPreço(Float.parseFloat(rs.getString("preco")));

                return mod;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModalidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return null;
    }

    public List<BeansModalidades> readAll() {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansModalidades> modalidade = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT id_modalidade,modalidade,preco FROM modalidade");
            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansModalidades modalidades = new BeansModalidades();

                modalidades.setId_modalidade(rs.getString("id_modalidade"));
                modalidades.setModalidades(rs.getString("modalidade"));
                modalidades.setPreço(Float.parseFloat(rs.getString("preco")));

                modalidade.add(modalidades);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModalidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return modalidade;

    }

    public List<BeansModalidades> readForDescModalidade(String desc) {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansModalidades> buscar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM modalidade WHERE modalidade LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansModalidades busca = new BeansModalidades();

                busca.setId_modalidade(rs.getString("Id_modalidade"));
                busca.setModalidades(rs.getString("modalidade"));
                busca.setPreço(Float.parseFloat(rs.getString("preco")));

                buscar.add(busca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModalidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar;

    }

    public List<BeansModalidades> readForDescPreco(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansModalidades> buscar_modalidade = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM modalidade WHERE preco LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansModalidades buscar = new BeansModalidades();

                buscar.setId_modalidade(rs.getString("Id_modalidade"));
                buscar.setModalidades(rs.getString("modalidade"));
                buscar.setPreço(Float.parseFloat(rs.getString("preco")));

                buscar_modalidade.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModalidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar_modalidade;

    }

    public List<BeansModalidades> readForDescId_modalidade(String desc) {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansModalidades> buscar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM modalidade WHERE id_modalidade LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansModalidades busca = new BeansModalidades();

                busca.setId_modalidade(rs.getString("Id_modalidade"));
                busca.setModalidades(rs.getString("modalidade"));
                busca.setPreço(Float.parseFloat(rs.getString("preco")));

                buscar.add(busca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModalidadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar;

    }
}
