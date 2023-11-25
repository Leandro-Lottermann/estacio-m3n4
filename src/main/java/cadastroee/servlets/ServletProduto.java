package cadastroee.servlets;

import cadastroee.dao.ProdutoDAO;
import cadastroee.model.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

@WebServlet(name = "servletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    public ServletProduto() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if(acao.equals("listar")) {
            listar(request, response);
        } else if (acao.equals("formIncluir")) {
            Produto produto = null;
            request.setAttribute("produto", produto);
            RequestDispatcher rd = request.getRequestDispatcher("ProdutoDados.jsp");
            rd.forward(request, response);
        } else if (acao.equals("formAlterar")) {
            formAlterar(request, response);
        } else if (acao.equals("incluir")) {
            incluir(request, response);
        } else if (acao.equals("alterar")) {
            alterar(request, response);
        } else if (acao.equals("excluir")) {
            excluir(request, response);
        }

    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produto> produtos = produtoDAO.listar();

        request.setAttribute("produtos", produtos);
        RequestDispatcher rd = request.getRequestDispatcher("ProdutoLista.jsp");
        rd.forward(request, response);
    }

    protected void incluir (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produto produto = new Produto(
                1,
                request.getParameter("nome"),
                Integer.parseInt(request.getParameter("quantidade")),
                Float.parseFloat(request.getParameter("precoVenda"))
        );

        produtoDAO.incluir(produto);
       response.sendRedirect("ServletProduto?acao=listar");
    }

    protected void formAlterar (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = produtoDAO.findOne(Integer.parseInt(request.getParameter("idProduto")));
        request.setAttribute("produto", produto);
        RequestDispatcher rd = request.getRequestDispatcher("ProdutoDados.jsp");
        rd.forward(request, response);
    }

    protected void alterar (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produto produto = new Produto(
                Integer.parseInt(request.getParameter("idProduto")),
                request.getParameter("nome"),
                Integer.parseInt(request.getParameter("quantidade")),
                Float.parseFloat(request.getParameter("precoVenda"))
        );
        produtoDAO.update(produto);
        response.sendRedirect("ServletProduto?acao=listar");
    }

    protected void excluir (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProduto = request.getParameter("idProduto");
        produtoDAO.excluir(idProduto);
        response.sendRedirect("ServletProduto?acao=listar");
    }


}
