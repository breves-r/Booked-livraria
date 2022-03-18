package edu.infnet.applivraria.testes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.infnet.applivraria.exceptions.ClassificacaoEtariaInvalidaException;
import edu.infnet.applivraria.exceptions.ClienteNuloException;
import edu.infnet.applivraria.exceptions.CpfInvalidoException;
import edu.infnet.applivraria.exceptions.EmailInvalidoException;
import edu.infnet.applivraria.exceptions.NomeInvalidoException;
import edu.infnet.applivraria.exceptions.SerieInvalidaException;
import edu.infnet.applivraria.exceptions.TelefoneInvalidoException;
import edu.infnet.applivraria.exceptions.ValorInvalidoException;
import edu.infnet.applivraria.exceptions.listaProdutosInvalidaException;
import edu.infnet.applivraria.model.domain.Cliente;
import edu.infnet.applivraria.model.domain.Compra;
import edu.infnet.applivraria.model.domain.Escolar;
import edu.infnet.applivraria.model.domain.Informatica;
import edu.infnet.applivraria.model.domain.Livro;
import edu.infnet.applivraria.model.domain.Produto;

public class ArquivoTeste {

	public static void main(String[] args) {
		try {

			List<String> inconsistencias = new ArrayList<String>();

			System.out.println("Início do processamento das compras!!!");
			try {

				String arquivo = "compra.txt";

				FileReader fileR = new FileReader(arquivo);
				BufferedReader leitura = new BufferedReader(fileR);

				FileWriter fileW = new FileWriter("out_" + arquivo);
				BufferedWriter escrita = new BufferedWriter(fileW);

				String linha = leitura.readLine();

				String[] campos = null;

				List<Produto> produtos = new ArrayList<Produto>();

				Compra compra = null;

				while (linha != null) {
					campos = linha.split(";");

					String tipo = campos[0];

					switch (tipo.toUpperCase()) {
					case "C":

						Cliente cliente = null;
						try {
							cliente = new Cliente(campos[2], campos[3], campos[4], campos[5]);
						} catch (NomeInvalidoException | TelefoneInvalidoException | EmailInvalidoException | CpfInvalidoException e) {
							System.out.println(e.getMessage());
						}

						try {
							compra = new Compra(cliente);
							compra.setformaPagamento(campos[1]);
							compra.setListaProdutos(produtos);

						} catch (ClienteNuloException e) {
							System.out.println(e.getMessage());
						}

						break;
					case "E":
						try {
							Escolar escolar = new Escolar(campos[1], campos[2], Integer.valueOf(campos[3]), Float.valueOf(campos[4]));
							escolar.setDisciplina(campos[5]);
							escolar.setSerie(Integer.valueOf(campos[6]));
							escolar.setTemRespostas(Boolean.valueOf(campos[7]));
							
							produtos.add(escolar);
						} catch (ValorInvalidoException | SerieInvalidaException e) {
							System.out.println(e.getMessage());
						}

						break;
					case "I":
						try {
							Informatica informatica = new Informatica(campos[1], campos[2], Integer.valueOf(campos[3]), Float.valueOf(campos[4]));
							
							informatica.setArea(campos[5]);
							informatica.setEhAvancado(Boolean.valueOf(campos[6]));
							informatica.setEhProgramacao(Boolean.valueOf(campos[7]));
							
							produtos.add(informatica);
							
						} catch (ValorInvalidoException e) {
							System.out.println(e.getMessage());
						}

						break;
					case "L":
						try {
							Livro livro = new Livro(campos[1], campos[2], Integer.valueOf(campos[3]), Float.valueOf(campos[4]));
							
							livro.setGenero(campos[5]);
							livro.setClassificacaoEtaria(Integer.valueOf(campos[6]));
							livro.setIlustrado(Boolean.valueOf(campos[7]));
							
							produtos.add(livro);
						} catch (ValorInvalidoException | ClassificacaoEtariaInvalidaException e) {
							System.out.println(e.getMessage());
						}

						break;

					default:
						inconsistencias.add(linha);
						break;
					}

					linha = leitura.readLine();
				}

				try {
					compra.impressao();

					escrita.write(compra.obterLinhaGravacaoArquivo());

					System.out.println("#Quantidade de erros no processamento: " + inconsistencias.size());
					for (String erro : inconsistencias) {
						System.out.println("- " + erro);
					}
				} catch (listaProdutosInvalidaException e) {
					System.out.println(e.getMessage());
				}

				leitura.close();
				escrita.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} finally {
			System.out.println("Processamento finalizado!!!");
		}

	}

}
