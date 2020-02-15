package DAO;

import Beans.BeansAluno;
import controle.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDAO {

    public List<BeansAluno> readAll() {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<BeansAluno> alunos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT id_aluno,nome FROM alunos");
            rs = stmt.executeQuery();

            while (rs.next()) {

                BeansAluno aluno = new BeansAluno();

                aluno.setID(rs.getString("id_aluno"));
                aluno.setNome(rs.getString("nome"));

                alunos.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return alunos;

    }

    public BeansAluno readForId(String id_aluno) {

        Connection con = conexao.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT id_aluno,nome,img FROM alunos WHERE id_aluno LIKE ?");
            stmt.setString(1, "%" + id_aluno + "%");

            rs = stmt.executeQuery();

            while (rs.next()) {
                BeansAluno aluno = new BeansAluno();

                aluno.setID(rs.getString("id_aluno"));
                aluno.setNome(rs.getString("nome"));
                aluno.setPicture(rs.getBytes("img"));

                return aluno;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexao.closeConnection(con, stmt, rs);
        }

        return null;
    }

}
