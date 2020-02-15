package DAO;

import Beans.BeansMatricula;
import controle.conexao;
import java.sql.Connection;
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

public class MatriculaDAO {

    public List<BeansMatricula> readAll() {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansMatricula> matricula = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM matriculas");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansMatricula matric = new BeansMatricula();
                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

                matric.setId(rs.getString("id"));
                matric.setId_aluno(rs.getString("id_aluno"));
                matric.setId_modalidade(rs.getString("id_modalidade"));
                matric.setModalidade(rs.getString("modalidade"));
                matric.setNome(rs.getString("nome"));
                matric.setValor(rs.getFloat("valor"));
                matric.setData(data.format(rs.getDate("data")));
                matric.setVencimento(rs.getString("vencimento"));


                matricula.add(matric);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }
        
        return matricula;
    }

    public List<BeansMatricula> readForDescId(String id) {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansMatricula> matriculas = new ArrayList<BeansMatricula>();

        try {
            stmt = con.prepareStatement("SELECT * FROM matriculas WHERE id_aluno LIKE ?");
            stmt.setString(1, "%" + id + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansMatricula matricula = new BeansMatricula();
                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
                
                matricula.setId(rs.getString("id"));
                matricula.setId_aluno(rs.getString("id_aluno"));
                matricula.setNome(rs.getString("nome"));
                matricula.setModalidade(rs.getString("modalidade"));
                matricula.setValor(rs.getFloat("valor"));
                matricula.setData(data.format(rs.getDate("data")));

                matriculas.add(matricula);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return matriculas;
    }

    public List<BeansMatricula> readForDescNome(String nome) {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansMatricula> matriculas = new ArrayList<BeansMatricula>();

        try {
            stmt = con.prepareStatement("SELECT * FROM matriculas WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansMatricula matricula = new BeansMatricula();
                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            
                matricula.setId(rs.getString("id"));
                matricula.setId_aluno(rs.getString("id_aluno"));
                matricula.setNome(rs.getString("nome"));
                matricula.setModalidade(rs.getString("modalidade"));
                matricula.setValor(rs.getFloat("valor"));
                matricula.setData(data.format(rs.getDate("data")));

                matriculas.add(matricula);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return matriculas;
    }

    public List<BeansMatricula> readForDescModalidade(String modalidade) {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansMatricula> matriculas = new ArrayList<BeansMatricula>();

        try {
            stmt = con.prepareStatement("SELECT * FROM matriculas WHERE modalidade LIKE ?");
            stmt.setString(1, "%" + modalidade + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansMatricula matricula = new BeansMatricula();
                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

                matricula.setId(rs.getString("id"));
                matricula.setId_aluno(rs.getString("id_aluno"));
                matricula.setNome(rs.getString("nome"));
                matricula.setModalidade(rs.getString("modalidade"));
                matricula.setValor(rs.getFloat("valor"));
                matricula.setData(data.format(rs.getDate("data")));

                matriculas.add(matricula);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return matriculas;
    }

    public List<BeansMatricula> readForDescCodigoAluno(String id) {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansMatricula> matriculas = new ArrayList<BeansMatricula>();

        try {
            stmt = con.prepareStatement("SELECT * FROM matriculas WHERE id_aluno LIKE ?");
            stmt.setString(1, "%" + id + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansMatricula matricula = new BeansMatricula();
                SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

                matricula.setId(rs.getString("id"));
                matricula.setId_aluno(rs.getString("id_aluno"));
                matricula.setNome(rs.getString("nome"));
                matricula.setModalidade(rs.getString("modalidade"));
                matricula.setValor(rs.getFloat("valor"));
                matricula.setData(data.format(rs.getDate("data")));

                matriculas.add(matricula);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return matriculas;
    }

    public void Cadastro_Matricula(BeansMatricula matricula) {

        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO matriculas(id,id_aluno,nome,id_modalidade,modalidade,valor,data , vencimento) VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, matricula.getId());
            stmt.setString(2, matricula.getId_aluno());
            stmt.setString(3, matricula.getNome());
            stmt.setString(4, matricula.getId_modalidade());
            stmt.setString(5, matricula.getModalidade());
            stmt.setFloat(6, matricula.getValor());
            stmt.setString(7, matricula.getData());
            stmt.setString(8, matricula.getVencimento());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Matricula salva com sucesso!!!!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!!!!" + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
    }
    
    public void update(BeansMatricula matri){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE matriculas SET id_aluno = ?, nome = ?, id_modalidade = ?, modalidade = ?, valor = ?, data = ?, vencimento = ? WHERE id = ?");
            stmt.setString(1,matri.getId_aluno());
            stmt.setString(2,matri.getNome());
            stmt.setString(3,matri.getId_modalidade());
            stmt.setString(4, matri.getModalidade());
            stmt.setFloat(5, matri.getValor());

            SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                stmt.setString(6,frmt.format(frmt.parse(matri.getData())));
            } catch (ParseException ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            stmt.setString(7, matri.getVencimento());
            
            stmt.setString(8, matri.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!!!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar!!!!"+ex);
        }finally{
            conexao.closeConnection(con,stmt);
        }
    }

    public void delete(BeansMatricula delete) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM matriculas WHERE id = ?");
            stmt.setString(1, delete.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }

    }

}
