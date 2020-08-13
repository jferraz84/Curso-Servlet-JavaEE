package br.com.curso.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.curso.gerenciador.acao.AlteraEmpresa;
import br.com.curso.gerenciador.acao.ListaEmpresa;
import br.com.curso.gerenciador.acao.MostraEmpresa;
import br.com.curso.gerenciador.acao.NovaEmpresa;
import br.com.curso.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = null;

		String paramAcao = request.getParameter("acao");

		if (paramAcao.equals("listaEmpresa")) {

			ListaEmpresa acao = new ListaEmpresa();
			nome = acao.executa(request, response);

		} else if (paramAcao.equals("removeEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);

		} else if (paramAcao.equals("mostraEmpresa")) {

			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(request, response);

		} else if (paramAcao.equals("alteraEmpresa")) {

			AlteraEmpresa acao = new AlteraEmpresa();
			acao.executa(request, response);

		} else if (paramAcao.equals("novaEmpresa")) {

			NovaEmpresa acao = new NovaEmpresa();
			acao.executa(request, response);
		}

		String[] tipoEndereco = nome.split(":");

		if (tipoEndereco[0].equals("forward")) {
			
			RequestDispatcher rd = request.getRequestDispatcher(tipoEndereco[1]);
			rd.forward(request, response);

		} else {
			response.sendRedirect(tipoEndereco[1]);

		}
	}

}
