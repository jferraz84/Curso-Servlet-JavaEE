package br.com.curso.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/ola")
public class OlaMundo extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Parabéns,  pelo seu primeiro 'Olá Mundo' no mundo Servlets!");
		out.println("</body>");
		out.println("</html>");
		System.out.println("O servlet foi chamado.");

		
		
	}

}
