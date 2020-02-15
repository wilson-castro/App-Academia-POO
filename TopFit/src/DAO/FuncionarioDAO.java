package DAO;

import Beans.BeansBuscarFuncionario;
import Beans.BeansFrequencia;
import Beans.BeansFuncionarios;
import controle.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FuncionarioDAO {

    public List<BeansFuncionarios> readA() {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFuncionarios> buscar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios");
            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFuncionarios busca = new BeansFuncionarios();

                busca.setID(rs.getString("id_func"));
                busca.setNome(rs.getString("nome"));
                busca.setSexo(rs.getString("sexo"));
                busca.setIdade(rs.getString("idade"));
                busca.setImagem(rs.getBytes("img"));

                buscar.add(busca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar;

    }

    public void delete(BeansBuscarFuncionario f) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM funcionarios WHERE id_func = ?");
            stmt.setString(1, f.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }

    }

 public List<BeansFuncionarios> readAll() {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFuncionarios> pesquisa = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansFuncionarios pesq = new BeansFuncionarios();

                SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat data_nascimento = new SimpleDateFormat("yyyy-MM-dd");

                pesq.setID(rs.getString("id_func"));
                pesq.setNome(rs.getString("nome"));
                pesq.setCelular(rs.getString("celular"));
                pesq.setSexo(rs.getString("sexo"));
                pesq.setUf(rs.getString("uf"));
                pesq.setCpf(rs.getString("cpf"));
                pesq.setIdade(rs.getString("idade"));
                pesq.setBairro(rs.getString("bairro"));
                pesq.setCidade(rs.getString("cidade"));
                pesq.setEmail(rs.getString("email"));
                pesq.setNumDaCasa(rs.getString("num_casa"));
                pesq.setRua(rs.getString("rua"));
                pesq.setObservacao(rs.getString("observacao"));
                pesq.setTelefone(rs.getString("telefone"));
                pesq.setCep(rs.getString("cep"));
                pesq.setData_cadastro(rs.getString("data_cadastro"));
                pesq.setData_nascimento(rs.getString("data_nascimento"));
                pesq.setImagem(rs.getBytes("img"));
                pesq.setApelido(rs.getString("apelido"));
                pesq.setEstado_civil(rs.getString("estado_civil"));
                pesq.setFuncao(rs.getString("funcao"));
                pesq.setSalario(rs.getString("salario"));
                pesq.setSenha(rs.getString("senha"));
                pesq.setUsuario(rs.getString("usuario"));

                pesquisa.add(pesq);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return pesquisa;
    }
 
    public List<BeansFuncionarios> readForDescId(String desc) {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFuncionarios> buscar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios WHERE id_func LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFuncionarios busca = new BeansFuncionarios();

                busca.setID(rs.getString("Id_func"));
                busca.setNome(rs.getString("nome"));
                busca.setSexo(rs.getString("sexo"));
                busca.setIdade(rs.getString("idade"));

                buscar.add(busca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar;

    }

    public List<BeansFuncionarios> readForDescNome(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFuncionarios> buscar_aluno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFuncionarios buscar = new BeansFuncionarios();

                buscar.setID(rs.getString("Id_func"));
                buscar.setNome(rs.getString("nome"));
                buscar.setSexo(rs.getString("sexo"));
                buscar.setIdade(rs.getString("idade"));

                buscar_aluno.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar_aluno;

    }

    public List<BeansFuncionarios> readForDescIdade(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFuncionarios> buscar_aluno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios WHERE idade LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFuncionarios buscar = new BeansFuncionarios();

                buscar.setID(rs.getString("Id_func"));
                buscar.setNome(rs.getString("nome"));
                buscar.setSexo(rs.getString("sexo"));
                buscar.setIdade(rs.getString("idade"));

                buscar_aluno.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar_aluno;

    }

    public List<BeansFuncionarios> readForDescSexo(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFuncionarios> buscar_aluno = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM funcionarios WHERE sexo LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFuncionarios buscar = new BeansFuncionarios();

                buscar.setID(rs.getString("Id_func"));
                buscar.setNome(rs.getString("nome"));
                buscar.setSexo(rs.getString("sexo"));
                buscar.setIdade(rs.getString("idade"));

                buscar_aluno.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar_aluno;

    }

    public void delete(BeansFrequencia f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
