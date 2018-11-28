
package dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cidade;
import model.Cliente;
import model.Estado;


public class ClienteDAO {
   
    public static void inserir(Cliente cliente){
        String data = "" + cliente.getNasimento().get(Calendar.YEAR)
                + "-" + (cliente.getNasimento().get(Calendar.MONTH)+1)
                + "-" +  cliente.getNasimento().get(Calendar.DAY_OF_MONTH);
        String sql = "INSERT INTO clientes "
                + "(nome, telefone, cpf, salario, filhos, casado,"
                + " sexo, DataNascimento, codCidade) VALUES("
                + " '" +cliente.getNome()    +"' , "
                + " '" +cliente.getTelefone() +"' , "
                + " '" +cliente.getCpf()      +"' , "
                + "  " +cliente.getSalario()  +" , "
                + "  " +cliente.isTemFilhos() +" , "
                + "  " +cliente.isCasado()    +" , "
                + "  " +cliente.getSexo()     +"' , "
                + "  " +data                  +"' , "
                + "  " +cliente.getCidade().getCodigo()
                + ")" ;
        
        Conexao.excutar(sql);
    }
    
     public static void editar(Cliente cliente){
        String data = "" + cliente.getNasimento().get(Calendar.YEAR)
                + "-" + (cliente.getNasimento().get(Calendar.MONTH)+1)
                + "-" +  cliente.getNasimento().get(Calendar.DAY_OF_MONTH);
        String sql = "UPDATE clientes "
                + " nome           = '" +cliente.getNome()    +"' , "
                + " telefone       = '" +cliente.getTelefone() +"' , "
                + " cpf            = '" +cliente.getCpf()      +"' , "
                + " salario        =  " +cliente.getSalario()  +" , "
                + " filho          =  " +cliente.isTemFilhos()+" , "
                + " casado         =  " +cliente.isCasado()    +" , "
                + " sexo           =  " +cliente.getSexo()     +"' , "
                + " dataNascimento = '" +data                  +"' , "
                + " codCidade      =  " +cliente.getCidade().getCodigo()
                + " WHERE codigo   =  " +cliente.getCodigo();
        
        Conexao.excutar(sql);
    }
     public static void excluir(Cliente cliente){
        
        String sql = "DELETE FROM clientes "
               + " WHERE codigo   =  " +cliente.getCodigo();
        
        Conexao.excutar(sql);
    }
     
     
     public static List<Cliente> getCliente() {
         List<Cliente> lista = new  ArrayList<>();
         
         String sql = "SELECT c.codigo, c.nome, c.telefone, c.cpf"
                 + "c.salario, c.filhos, c.casado,c.sexo, m.codigo,"
                 + " m.nome, e.codigo, e.nome,"
                 + " DATE_FORMAT( c.dataNasimento , '%d') , "
                 + " DATE_FORMAT( c.dataNasimento , '%m') , "
                 + " DATE_FORMAT( c.dataNasimento , '%Y')  "
                 + "FROM cliente c "
                 + "INNER JOIN cidade m ON m.codigo =c.codCidade "
                 + "INNER JOIN estado m ON e.codigo =m.codCidade "
                 + "ORDER BY c.nome ";
         ResultSet rs = Conexao.consultar(sql);
         if ( rs != null){
             try {
                 
                 while ( rs.next() ){
                     Estado estado = new Estado();
                     estado.setCodigo(rs.getInt(11));
                     estado.setNome(rs.getString(12));
                     
                     
                     Cidade cidade = new Cidade();
                     cidade.setCodigo(rs.getInt(9));
                     cidade.setNome(rs.getString(10));
                     cidade.setEstado(estado);
                     
                     Cliente cliente = new Cliente();
                     cliente.setCodigo( rs.getInt(1) );
                     cliente.setNome( rs.getString(2) );
                     cliente.setTelefone( rs.getString(3) );
                     cliente.setCpf(rs.getString(4));
                     cliente.setSalario(rs.getDouble(5));
                     cliente.setTemFilhos(rs.getBoolean(5));
                     cliente.setCasado(rs.getBoolean(7));
                     cliente.setSexo(rs.getString(8));
                     
                     Calendar nascimento = Calendar.getInstance();
                     nascimento.set(rs.getInt(15),rs.getInt(14),rs.getInt(13));
                     cliente.setNasimento(nascimento);
                     cliente.setCidade(cidade);
                     
                     lista.add(cliente);
                     
                 }
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, e.toString());
             }
         }
         
         
         
        return lista;
    }
 
    
}