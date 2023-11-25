package cadastroee.dao;

import cadastroee.model.Produto;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://localhost:1433;database=Loja;user=Loja;password=Loja;encrypt=true;trustServerCertificate=true;loginTimeout=10;";

    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url);
            return con;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Produto> listar() {
        List<Produto> produtos = new ArrayList<>();
        String read = "select * from produtos";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(read);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                float precoVenda = rs.getFloat("precoVenda");
                produtos.add(new Produto(idProduto, nome, quantidade, precoVenda));
            }

            con.close();
            return produtos;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void incluir(Produto produto) {
        String insert = "insert into produtos (nome, quantidade, precoVenda) values (?,?,?)";
        try {
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(insert);

            pst.setString(1, produto.getNome());
            pst.setString(2, Integer.toString(produto.getQuantidade()));
            pst.setString(3, Float.toString(produto.getPrecoVenda()));

            pst.executeUpdate();
            con.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Produto findOne(int id) {
        String findOne = "select * from produtos where idProduto=?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(findOne);
            pst.setString(1, Integer.toString(id));

            ResultSet rs = pst.executeQuery();
            rs.next();

            int idProduto = rs.getInt("idProduto");
            String nome = rs.getString("nome");
            int quantidade = rs.getInt("quantidade");
            float precoVenda = rs.getFloat("precoVenda");

            Produto produto = new Produto(idProduto, nome, quantidade, precoVenda);
            con.close();
            return produto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Produto produto) {
        String update = "update produtos set nome = ?, quantidade = ?, precoVenda = ? where idProduto = ?";
        try {
            Connection con = conectar();
            PreparedStatement pst = con.prepareStatement(update);
            pst.setString(1, produto.getNome());
            pst.setString(2, Integer.toString(produto.getQuantidade()));
            pst.setString(3, Float.toString(produto.getPrecoVenda()));
            pst.setString(4, Integer.toString(produto.getIdProduto()));

            pst.executeUpdate();
            con.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(String idProduto) {
        String delete = "delete from produtos where idProduto=?";
        try {
            Connection con = conectar();

            PreparedStatement pst = con.prepareStatement(delete);
            pst.setString(1, idProduto);
            pst.executeUpdate();

            con.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
