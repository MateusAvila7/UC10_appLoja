package dao;

import com.sun.org.apache.regexp.internal.recompile;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Categoria;

public class CategoriaDao {

    public static void inserir(Categoria categoria) {
        String sql = "INSERT INTO categorias (nome)"
                + " VALUES ( '" + categoria.getNome() + "' )";
        boolean retorno = Conexao.excutar(sql);
        if (!retorno) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir a categoria");
        }
    }

    public static void editar(Categoria categoria) {
        String sql = "UPDATE categoria SET"
                + "nome = '" + categoria.getNome() + "' , "
                + " WHERE codigo = " + categoria.getCodigo();
        boolean retorno = Conexao.excutar(sql);
        if (!retorno) {
            JOptionPane.showMessageDialog(null, "Erro ao editar a cidade");
        }
    }

    public static void excluir(Categoria categoria) {
        String sql = "DELETE FROM categoria"
                + " WHERE codigo = " + categoria.getCodigo();
        boolean retorno = Conexao.excutar(sql);
        if (!retorno) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir a cidade");
        }
    }

    public static List<Categoria> getCategorias() {
        String sql = " SELECT c.codigo, c.nome"
                + "FROM categoria c"
                + " ORDER BY c.nome";
        List<Categoria> lista = new ArrayList<>();
        ResultSet rs = Conexao.consultar(sql);
        if( rs != null ){
        try {
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setCodigo(rs.getInt(1));
                cat.setNome(rs.getString(2));
                lista.add(cat);
            }
        } catch (Exception e) {
        }
      }
      return lista;
    }
    public static List<Categoria> getCategorias(int codProdutos) {
        String sql = " SELECT c.codigo, c.nome"
                + "FROM categoria c"
                + " ORDER BY c.nome";
        List<Categoria> lista = new ArrayList<>();
        ResultSet rs = Conexao.consultar(sql);
        if( rs != null ){
        try {
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setCodigo(rs.getInt(1));
                cat.setNome(rs.getString(2));
                lista.add(cat);
            }
        } catch (Exception e) {
        }
      }
      return lista;
    }
    public static Categoria getCategoriaByCodigo(int codigo) {
         String sql = " SELECT c.codigo, c.nome"
                + " FROM categoria c"
                + " WHERE c.codigo = " + codigo;
          ResultSet rs = Conexao.consultar(sql);
        if( rs != null ){
            try {
                rs.next();
                System.out.println("1-");
                Categoria cat = new Categoria();
                cat.setCodigo( rs.getInt(1));
                cat.setNome( rs.getString(2));
                System.out.println("2-");
                return cat;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
       return null;  
    }
     
}
