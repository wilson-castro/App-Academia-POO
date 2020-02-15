package DAO;

import Beans.BeansPesquisar;
import controle.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import paineis.PesquisarAluno;
import controle.conexao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PesquisarDAO {

    private static controle.Conexion con = new Conexion();
    private static Connection conexion = con.getConexion();
    private static PreparedStatement ps = null;

    public static boolean isRegister(BeansPesquisar p) {
        String sql = BeansPesquisar.REGISTRAR;

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, p.getId_aluno());
            ps.setString(2, p.getData_cadastro());
            ps.setString(3, p.getNome());
            ps.setString(4, p.getData_nascimento());
            ps.setString(5, p.getSexo());
            ps.setString(6, p.getCpf());
            ps.setString(7, p.getRua());
            ps.setString(8, p.getNºDaCasa());
            ps.setString(8, p.getBairro());
            ps.setString(9, p.getCidade());
            ps.setString(10, p.getCep());
            ps.setString(11, p.getUf());
            ps.setString(12, p.getTelefone());
            ps.setString(13, p.getCelular());
            ps.setString(14, p.getObservacao());
            ps.setString(15, p.getEmail());
            ps.setBytes(16, p.getImagem());
            ps.setString(18, p.getIdade());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(PesquisarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean isUpdate(BeansPesquisar p) {
        String sql = BeansPesquisar.ATUALIZAR;

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, p.getId_aluno());
            ps.setString(2, p.getData_cadastro());
            ps.setString(3, p.getNome());
            ps.setString(4, p.getData_nascimento());
            ps.setString(5, p.getSexo());
            ps.setString(6, p.getCpf());
            ps.setString(7, p.getRua());
            ps.setString(8, p.getNºDaCasa());
            ps.setString(8, p.getBairro());
            ps.setString(9, p.getCidade());
            ps.setString(10, p.getCep());
            ps.setString(11, p.getUf());
            ps.setString(12, p.getTelefone());
            ps.setString(13, p.getCelular());
            ps.setString(14, p.getObservacao());
            ps.setString(15, p.getEmail());
            ps.setBytes(16, p.getImagem());
            ps.setString(18, p.getIdade());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(PesquisarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean isDelete(BeansPesquisar p) {
        String sql = BeansPesquisar.DELETAR;

        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, p.getId_aluno());
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(PesquisarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static boolean isTruncate(BeansPesquisar p) {
        String sql = BeansPesquisar.DELETAR_TUDO;

        try {
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            return true;

        } catch (SQLException ex) {
            return false;
            //Logger.getLogger(PesquisarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setListar(String buscar) {
        DefaultTableModel modelo = (DefaultTableModel) PesquisarAluno.TableMetroBuscarAlunos.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        String sql = "";

        if (buscar.equals("")) {
            sql = BeansPesquisar.LISTAR;
        } else {
            sql = "SELECT * FROM alunos WHERE ("
                    + "id_aluno LIKE '" + buscar + "%' OR "
                    + "nome LIKE '" + buscar + "%' OR "
                    + "sexo LIKE '" + buscar + "%' OR "
                    + "idade LIKE '" + buscar + "%'"
                    + ")";
        }

        String dados[] = new String[17];
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                dados[0] = rs.getString("id_aluno");
                dados[1] = rs.getString("data_cadastro");
                dados[2] = rs.getString("nome");
                dados[3] = rs.getString("data_nascimento");
                dados[4] = rs.getString("sexo");
                dados[5] = rs.getString("cpf");
                dados[6] = rs.getString("rua");
                dados[7] = rs.getString("num_casa");
                dados[8] = rs.getString("bairro");
                dados[9] = rs.getString("cidade");
                dados[10] = rs.getString("cep");
                dados[11] = rs.getString("uf");
                dados[12] = rs.getString("telefone");
                dados[13] = rs.getString("celular");
                dados[14] = rs.getString("observacao");
                dados[15] = rs.getString("email");
                dados[16] = rs.getString("img");
                dados[17] = rs.getString("idade");
                modelo.addRow(dados);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisarDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String extraerIDMax() {
        String sql = "SELECT MAX(id_aluno) FROM dados_alunos";
        int id_alunos = 0;

        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                id_alunos = rs.getInt(1);

            }

            if (id_alunos == 0) {
                id_alunos = 1;
            } else {
                id_alunos = id_alunos + 1;
            }

            return String.valueOf(id_alunos);
        } catch (SQLException ex) {
            return null;
        }

    }

    public void readForId() {

    }

    public List<BeansPesquisar> readAll() {
        Connection con = conexao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansPesquisar> pesquisa = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM alunos");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansPesquisar pesq = new BeansPesquisar();

                SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat data_nascimento = new SimpleDateFormat("yyyy-MM-dd");

                pesq.setId_aluno(rs.getString("id_aluno"));
                pesq.setNome(rs.getString("nome"));
                pesq.setCelular(rs.getString("celular"));
                pesq.setSexo(rs.getString("sexo"));
                pesq.setUf(rs.getString("uf"));
                pesq.setCpf(rs.getString("cpf"));
                pesq.setIdade(rs.getString("idade"));
                pesq.setBairro(rs.getString("bairro"));
                pesq.setCidade(rs.getString("cidade"));
                pesq.setEmail(rs.getString("email"));
                pesq.setNºDaCasa(rs.getString("num_casa"));
                pesq.setRua(rs.getString("rua"));
                pesq.setObservacao(rs.getString("observacao"));
                pesq.setTelefone(rs.getString("telefone"));
                pesq.setCep(rs.getString("cep"));
                pesq.setData_cadastro(rs.getString("data_cadastro"));
                pesq.setData_nascimento(rs.getString("data_nascimento"));
                pesq.setImagem(rs.getBytes("img"));

                pesquisa.add(pesq);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PesquisarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return pesquisa;
    }
}
