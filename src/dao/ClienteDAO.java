
package dao;

import java.util.Calendar;
import model.Cliente;


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
                + " filho          =  " +cliente.isTemFilhos() +" , "
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
 
    
}
