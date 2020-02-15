package DAO;

import Beans.BeansBuscarAluno;
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

public class PesquisarAlunosDAO {

    public List<BeansBuscarAluno> readForDescId(String desc) {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansBuscarAluno> buscar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM alunos WHERE id_aluno LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansBuscarAluno busca = new BeansBuscarAluno();

                busca.setId_aluno(rs.getString("Id_aluno"));
                busca.setNome(rs.getString("nome"));
                busca.setSexo(rs.getString("sexo"));
                busca.setIdade(rs.getInt("idade"));

                buscar.add(busca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisarAlunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar;

    }

    public List<BeansBuscarAluno> readForDescNome(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansBuscarAluno> buscar_aluno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM alunos WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansBuscarAluno buscar = new BeansBuscarAluno();

                buscar.setId_aluno(rs.getString("Id_aluno"));
                buscar.setNome(rs.getString("nome"));
                buscar.setSexo(rs.getString("sexo"));
                buscar.setIdade(rs.getInt("idade"));

                buscar_aluno.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisarAlunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar_aluno;

    }

    public List<BeansBuscarAluno> readForDescIdade(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansBuscarAluno> buscar_aluno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM alunos WHERE idade LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansBuscarAluno buscar = new BeansBuscarAluno();

                buscar.setId_aluno(rs.getString("Id_aluno"));
                buscar.setNome(rs.getString("nome"));
                buscar.setSexo(rs.getString("sexo"));
                buscar.setIdade(rs.getInt("idade"));

                buscar_aluno.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisarAlunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar_aluno;

    }

    public List<BeansBuscarAluno> readForDescSexo(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansBuscarAluno> buscar_aluno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM alunos WHERE sexo LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansBuscarAluno buscar = new BeansBuscarAluno();

                buscar.setId_aluno(rs.getString("Id_aluno"));
                buscar.setNome(rs.getString("nome"));
                buscar.setSexo(rs.getString("sexo"));
                buscar.setIdade(rs.getInt("idade"));

                buscar_aluno.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisarAlunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar_aluno;

    }

    public List<BeansBuscarAluno> readA() {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansBuscarAluno> buscar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM alunos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansBuscarAluno busca = new BeansBuscarAluno();

                busca.setId_aluno(rs.getString("Id_aluno"));
                busca.setNome(rs.getString("nome"));
                busca.setSexo(rs.getString("sexo"));
                busca.setIdade(rs.getInt("idade"));
                busca.setImagem(rs.getBytes("img"));

                buscar.add(busca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisarAlunosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar;

    }

    public void delete(BeansBuscarAluno p) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM alunos WHERE id_aluno = ?");
            stmt.setString(1, p.getId_aluno());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }

    }
}
