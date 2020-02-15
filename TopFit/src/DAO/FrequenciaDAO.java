package DAO;

import Beans.BeansFrequencia;
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

public class FrequenciaDAO {

    public List<BeansFrequencia> readForDescA(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFrequencia> frequencia = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM frequencia WHERE data LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFrequencia freq = new BeansFrequencia();

                freq.setId_aluno(rs.getString("Id_aluno"));
                freq.setNome(rs.getString("nome"));
                freq.setData(String.valueOf(rs.getDate("data")));
                freq.setHora(String.valueOf(rs.getTime("hora")));

                frequencia.add(freq);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return frequencia;

    }

    public List<BeansFrequencia> readForDescYear(int desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFrequencia> frequencia = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM frequencia WHERE data LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFrequencia freq = new BeansFrequencia();

                freq.setId_aluno(rs.getString("Id_aluno"));
                freq.setNome(rs.getString("nome"));
                freq.setData(String.valueOf(rs.getDate("data")));
                freq.setHora(String.valueOf(rs.getTime("hora")));

                frequencia.add(freq);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return frequencia;

    }

    public List<BeansFrequencia> readForDescMonth(int desc) {
        desc++;
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFrequencia> frequencia = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM frequencia WHERE data LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFrequencia freq = new BeansFrequencia();

                freq.setId_aluno(rs.getString("Id_aluno"));
                freq.setNome(rs.getString("nome"));
                freq.setData(String.valueOf(rs.getDate("data")));
                freq.setHora(String.valueOf(rs.getTime("hora")));

                frequencia.add(freq);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return frequencia;

    }

    public static void registrar(BeansFrequencia freq) {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO frequencia(id_aluno, nome, data, hora) VALUES(?,?,?,?)");
            stmt.setString(1, freq.getId_aluno());
            stmt.setString(2, freq.getNome());
            stmt.setString(3, freq.getData());
            stmt.setString(4, freq.getHora());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar! " + ex);
            System.out.println(ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }
    }

    public List<BeansFrequencia> readA() {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFrequencia> frequencia = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM frequencia");
            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFrequencia freq = new BeansFrequencia();

                freq.setId_aluno(rs.getString("id_aluno"));
                freq.setNome(rs.getString("nome"));
                freq.setData(String.valueOf(rs.getDate("data")));
                freq.setHora(String.valueOf(rs.getTime("hora")));

                frequencia.add(freq);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return frequencia;

    }

    public List<BeansFrequencia> readForDescId(String desc) {
        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFrequencia> buscar = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM frequencia WHERE id_aluno LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFrequencia busca = new BeansFrequencia();

                busca.setId_aluno(rs.getString("Id_aluno"));
                busca.setNome(rs.getString("nome"));
                busca.setData(String.valueOf(rs.getDate("data")));
                busca.setHora(String.valueOf(rs.getTime("hora")));

                buscar.add(busca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscar;

    }

    public List<BeansFrequencia> readForDescNome(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFrequencia> buscarFrequencia = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM frequencia WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFrequencia buscar = new BeansFrequencia();

                buscar.setId_aluno(rs.getString("Id_aluno"));
                buscar.setNome(rs.getString("nome"));
                buscar.setData(String.valueOf(rs.getDate("data")));
                buscar.setHora(String.valueOf(rs.getTime("hora")));

                buscarFrequencia.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscarFrequencia;

    }

    public List<BeansFrequencia> readForDescData(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFrequencia> buscarFrequencia = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM frequencia WHERE data LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFrequencia buscar = new BeansFrequencia();

                buscar.setId_aluno(rs.getString("Id_aluno"));
                buscar.setNome(rs.getString("nome"));
                buscar.setData(String.valueOf(rs.getDate("data")));
                buscar.setHora(String.valueOf(rs.getTime("hora")));

                buscarFrequencia.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscarFrequencia;

    }

    
    public List<BeansFrequencia> readForDescHora(String desc) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansFrequencia> buscarFrequencia = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM frequencia WHERE hora LIKE ?");
            stmt.setString(1, "%" + desc + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansFrequencia buscar = new BeansFrequencia();

                buscar.setId_aluno(rs.getString("Id_aluno"));
                buscar.setNome(rs.getString("nome"));
                buscar.setData(String.valueOf(rs.getDate("data")));
                buscar.setHora(String.valueOf(rs.getTime("hora")));

                buscarFrequencia.add(buscar);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return buscarFrequencia;

    }
    
        public void delete(BeansFrequencia f) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM frequencia WHERE id_aluno = ?");
            stmt.setString(1, f.getId_aluno());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            conexao.closeConnection(con, stmt);
        }

    }
        
            public void update(BeansFrequencia Frequencia){
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE frequencia SET id_aluno = ?, nome = ?, data = ?, hora = ?");
            stmt.setString(1,Frequencia.getId_aluno());
            stmt.setString(2,Frequencia.getNome());

            SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
            try {
                stmt.setString(3,frmt.format(frmt.parse(Frequencia.getData())));
            } catch (ParseException ex) {
                Logger.getLogger(MatriculaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            stmt.setString(4, Frequencia.getHora());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso!!!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar!!!!"+ex);
        }finally{
            conexao.closeConnection(con,stmt);
        }
    }

}
