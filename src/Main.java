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
		System.out.println("Informe a quantidade de vértices: ");
		numVertices = s.nextInt();
		System.out.println("Informe a quantidade de arestas: ");
		numArestas = s.nextInt();

		Grafo grafo = new Grafo(numVertices, numArestas);

		System.out.println("Informe as arestas no formato {origem,destino} (sem espaços e com vírgula): ");
		for (int i = 0; i < numArestas; i++) {
			aresta = s.next();
			aresta = aresta.replace("{", "").replace("}", "");
			vertices = aresta.split(",");
			origem = Integer.parseInt(vertices[0]);
			destino = Integer.parseInt(vertices[1]);
			grafo.adicionarAresta(origem, destino);
		}
		grafo.preencheMatriz();
		grafo.imprimeMatriz();
		s.close();
	}
}