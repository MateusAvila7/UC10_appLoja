package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produto;

public class ProdutoDao {

    public static void inserir(Produto produto) {

        String sql = "INSERT INTO produtos"
                + "(nome, prco, quantidade, codCategoria) VALUES ("
                + " '" + produto.getNome() + "' , "
                + " " + produto.getPreco() + " , "
                + " " + produto.getQuantidade() + " , "
                + " " + produto.getCategoria().getCodigo()
                + " )";

        Conexao.excutar(sql);
    }

    public static void editar(Produto produto) {

        String sql = "UPDATE produtos "
                + " nome          = '" + produto.getNome() + "' , "
                + " preco         = " + produto.getPreco() + "  , "
                + " quantidade    = " + produto.getQuantidade() + "  , "
                + " codCategoria  = " + produto.getCategoria().getCodigo()
                + " WHERE codigo = " + produto.getCodigo();

        Conexao.excutar(sql);
    }

    public static void excluir(Produto produto) {

        String sql = "DELETE FROM produto"
                + "WHERE codigo  =  " + produto.getCodigo();

        Conexao.excutar(sql);
    }

    public static List<Produto> getProdutos() {

        List<Produto> lista = new ArrayList<>();

        String sql = "SELET p.codigo, p.nome, p.preco, p.quantidade, "
                + " c.codigo, c.nome "
                + " FROM produtos p "
                + " INNER JOIN categorias c ON c.codigo = p.codCategoria "
                + " ORDER BY p.nome ";
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {

                while (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setCodigo(rs.getInt(5));
                    categoria.setNome(rs.getString(6));

                    Produto produto = new Produto();
                    produto.setCodigo(rs.getInt(1));
                    produto.setNome(rs.getString(2));
                    produto.setPreco(rs.getDouble(3));
                    produto.setQuantidade(rs.getDouble(4));
                    produto.setCategoria(categoria);

                    lista.add(produto);
                }
                return lista;

            } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.toString());
                 return null; 

            }
        } else {

            return null;
        }
    }
     public static List<Produto> getProdutos( int codCategoria) {
         String sql = "SELET p.codigo, p.nome, p.preco, p.quantidade, "
                + " c.codigo, c.nome "
                + " FROM produtos p "
                + " INNER JOIN categorias c "
                + " ON c.codigo = p.codCategoria "
                + " WHERE p.codCategoria = " + codCategoria
                + " ORDER BY p.nome ";
        List<Produto> lista = new ArrayList<>();
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {
                while (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setCodigo(rs.getInt(5));
                    categoria.setNome(rs.getString(6));

                    Produto produto = new Produto();
                    produto.setCodigo(rs.getInt(1));
                    produto.setNome(rs.getString(2));
                    produto.setPreco(rs.getDouble(3));
                    produto.setQuantidade(rs.getDouble(4));
                    produto.setCategoria(categoria);
                    
                     lista.add(produto);
                   }
                } catch (Exception e) {
                }
        } 
        return null;
    }
      public static Produto getProdutoByCodigo(int codigo) {

       String sql = "SELET p.codigo, p.nome, p.preco, p.quantidade, "
                + " c.codigo, c.nome "
                + " FROM produtos p "
                + " INNER JOIN categorias c ON c.codigo = p.codCategoria "
                + " WHERE p.codigo = " + codigo;
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null) {
            try {

                    rs.next();
                    Categoria categoria = new Categoria();
                    categoria.setCodigo(rs.getInt(5));
                    categoria.setNome(rs.getString(6));

                    Produto produto = new Produto();
                    produto.setCodigo(rs.getInt(1));
                    produto.setNome(rs.getString(2));
                    produto.setPreco(rs.getDouble(3));
                    produto.setQuantidade(rs.getDouble(4));
                    produto.setCategoria(categoria);

                    return produto;
            } catch (Exception e) {
               JOptionPane.showMessageDialog(null, e.toString());
                 return null; 

            }
        } else {

            return null;
        }
    }
    
    
    
}
