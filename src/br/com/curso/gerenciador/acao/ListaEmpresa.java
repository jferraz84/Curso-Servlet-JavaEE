package br.com.curso.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.curso.gerenciador.modelo.Banco;
import br.com.curso.gerenciador.modelo.Empresa;
import br.com.curso.gerenciador.modelo.Usuario;

public class ListaEmpresa implements Acao{
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("usuarioLogado") == null) {
			return "redirect:entrada?acao=LoginForm";
		}
		
		System.out.println("Listando empresa !");
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		request.setAttribute("empresas", listaEmpresas);
		
		return "forward:listaEmpresas.jsp";
		
	}

}
