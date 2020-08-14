package br.com.curso.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();

	private static Integer chavaSequencial = 1;
	
	

	static {
		Empresa empresa1 = new Empresa();
		empresa1.setId(chavaSequencial++);
		empresa1.setNome("Jferraz Service");
		listaEmpresas.add(empresa1);

		Empresa empresa2 = new Empresa();
		empresa2.setId(chavaSequencial++);
		empresa2.setNome("Santos & CIA");
		listaEmpresas.add(empresa2);

		Empresa empresa3 = new Empresa();
		empresa3.setId(chavaSequencial++);
		empresa3.setNome("Ferraz LTDA");
		listaEmpresas.add(empresa3);
		
		Usuario u1 = new Usuario();
		u1.setLogin("jferraz");
		u1.setSenha("1234");
		
		Usuario u2 = new Usuario();
		u2.setLogin("aline");
		u2.setSenha("5678");
		
		Usuario u3 = new Usuario();
		u3.setLogin("helo");
		u3.setSenha("1357");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
		listaUsuarios.add(u3);
		
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chavaSequencial++);
		Banco.listaEmpresas.add(empresa);

	}

	public List<Empresa> getEmpresas() {
		return Banco.listaEmpresas;
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = listaEmpresas.iterator();
		
		while (it.hasNext()) {
			Empresa emp = it.next();
			
			if (emp.getId() == id) {
				it.remove();
			}
			
		}

	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		
		for (Empresa empresa : listaEmpresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
		
	}

	public Usuario existeUsuario(String login, String senha) {
		
		for (Usuario usuario : listaUsuarios) {
			if (usuario.ehIgual(senha, senha)) {
				return usuario;
			}
		}
		 return null;
	}

}
