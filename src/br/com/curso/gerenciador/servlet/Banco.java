package br.com.curso.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
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

}
