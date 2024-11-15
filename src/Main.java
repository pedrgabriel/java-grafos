import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int numVertices;
		int numArestas;
		String aresta;
		String[] vertices;
		int origem;
		int destino;

		System.out.println("----- GRAFOS -----");

		while (true) {
			System.out.println("Informe a quantidade de vértices: ");
			try {
				numVertices = Integer.parseInt(s.next());
				if (numVertices > 0) {
					break;
				} else {
					System.out.println("Erro! Por favor, informe um número inteiro positivo.");
				}
			} catch (NumberFormatException ex) {
				System.out.println("Erro! Por favor, informe um número inteiro.");
			}
		}

		while (true) {
			System.out.println("Informe a quantidade de arestas: ");
			try {
				numArestas = Integer.parseInt(s.next());
				if (numArestas > 0) {
					break;
				} else {
					System.out.println("Erro! Por favor, informe um número inteiro positivo.");
				}
			} catch (NumberFormatException ex) {
				System.out.println("Erro! Por favor, informe um número inteiro.");
			}
		}

		Grafo grafo = new Grafo(numVertices, numArestas);

		System.out.println("Informe as arestas no formato {origem,destino} (sem espaços e com vírgula): ");
		for (int i = 0; i < numArestas; i++) {
			while (true) {
				aresta = s.next();
				aresta = aresta.replace("{", "").replace("}", "");
				vertices = aresta.split(",");
				if (vertices.length != 2) {
					System.out.println("Erro! O formato informado é inválido.");
					continue;
				}
				try {
					origem = Integer.parseInt(vertices[0]);
					destino = Integer.parseInt(vertices[1]);
					/*
					 * Validação considerando que qualquer aresta informada tenha como menor valor o
					 * 1 ou tenha o valor menor/igual ao número de vértices
					 */
					if (origem < 1 || origem > numVertices || destino < 1 || destino > numVertices) {
						System.out.println("Erro! Por favor, informe vértices que estejam dentro do escopo 1 a "
								+ numVertices + ".");
					} else {
						grafo.adicionarAresta(origem, destino);
						break;
					}
				} catch (NumberFormatException ex) {
					System.out.println("Erro! Por favor, informe um número inteiro.");
				}
			}
		}
		grafo.preencheMatriz();
		grafo.imprimeMatriz();
		grafo.calculaGrauVertice();
		s.close();
	}
}