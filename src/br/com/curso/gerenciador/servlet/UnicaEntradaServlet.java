package br.com.curso.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.curso.gerenciador.acao.Acao;
import br.com.curso.gerenciador.acao.AlteraEmpresa;
import br.com.curso.gerenciador.acao.ListaEmpresa;
import br.com.curso.gerenciador.acao.MostraEmpresa;
import br.com.curso.gerenciador.acao.NovaEmpresa;
import br.com.curso.gerenciador.acao.NovoFormEmpresa;
import br.com.curso.gerenciador.acao.RemoveEmpresa;

//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
//		HttpSession sessao = request.getSession();	
//		boolean usuarioNaoLogado = (sessao.getAttribute("usuarioLogado") == null);
//		boolean ehAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		
//		if (ehAcaoProtegida && usuarioNaoLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}

		// acao = CONTROLLER

		String nomeDaClasse = "br.com.curso.gerenciador.acao." + paramAcao;

		// carrega a classe com nome

		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
			throw new ServletException(e);
		}

		String[] tipoEndereco = nome.split(":");

		if (tipoEndereco[0].equals("forward")) {

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);

		} else {
			response.sendRedirect(tipoEndereco[1]);

		}

//		String nome = null;
//		if (paramAcao.equals("listaEmpresa")) {
//
//			ListaEmpresa acao = new ListaEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("removeEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("mostraEmpresa")) {
//
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("alteraEmpresa")) {
//
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("novaEmpresa")) {
//
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//
//		} else if (paramAcao.equals("ovoFormEmpresa")) {
//
//			NovoFormEmpresa acao = new NovoFormEmpresa();
//			nome = acao.executa(request, response);
//		}

	}

}
