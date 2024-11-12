import java.util.ArrayList;
import java.util.Arrays;

public class Grafo {
	// Variáveis
	private int numVertices;
	private int numArestas;
	private ArrayList<int[]> arestas;
	private int[][] matrizAdjacencia;
	private int[][] matrizIncidencia;

	// Construtor
	public Grafo(int numVertices, int numArestas) {
		this.numVertices = numVertices;
		this.numArestas = numArestas;
		this.arestas = new ArrayList<>();
		this.matrizAdjacencia = new int[numVertices][numVertices];
		this.matrizIncidencia = new int[numArestas][numVertices];
	}

	// Getters e Setters
	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	public int getNumArestas() {
		return numArestas;
	}

	public void setNumArestas(int numArestas) {
		this.numArestas = numArestas;
	}

	public ArrayList<int[]> getArestas() {
		return arestas;
	}

	public void setArestas(ArrayList<int[]> arestas) {
		this.arestas = arestas;
	}

	public int[][] getMatrizAdjacencia() {
		return matrizAdjacencia;
	}

	public void setMatrizAdjacencia(int[][] matrizAdjacencia) {
		this.matrizAdjacencia = matrizAdjacencia;
	}

	public int[][] getMatrizIncidencia() {
		return matrizIncidencia;
	}

	public void setMatrizIncidencia(int[][] matrizIncidencia) {
		this.matrizIncidencia = matrizIncidencia;
	}

	public void adicionarAresta(int origem, int destino) {
		arestas.add(new int[] { origem - 1, destino - 1 });
	}

	// Métodos
	public void preencheMatriz() {
		for (int[] aresta : arestas) {
			int origem = aresta[0];
			int destino = aresta[1];
			matrizAdjacencia[origem][destino] = 1;
			matrizAdjacencia[destino][origem] = 1;
		}

		for (int i = 0; i < arestas.size(); i++) {
			int origem = arestas.get(i)[0];
			int destino = arestas.get(i)[1];
			matrizIncidencia[i][origem] = 1;
			matrizIncidencia[i][destino] = 1;
		}
	}

	public void imprimeMatriz() {
		System.out.println("\nMatriz de Adjacência: ");
		System.out.print("   ");
		for (int i = 1; i <= numVertices; i++) {
			System.out.printf("%3d ", i);
		}
		System.out.println();
		for (int i = 0; i < numVertices; i++) {
			System.out.printf("%2d ", (i + 1));
			for (int j = 0; j < numVertices; j++) {
				System.out.printf("%3d ", matrizAdjacencia[i][j]);
			}
			System.out.println();
		}

		System.out.println("\nMatriz de Incidência: ");
		System.out.print("    ");
		for (int i = 1; i <= numArestas; i++) {
			System.out.printf("A%-3d ", i);
		}
		System.out.println();
		for (int i = 0; i < numVertices; i++) {
			System.out.printf("V%-3d ", (i + 1));
			for (int j = 0; j < numArestas; j++) {
				System.out.printf("%-4d ", matrizIncidencia[j][i]);
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "Grafo [numVertices=" + numVertices + ", numArestas=" + numArestas + ", arestas=" + arestas
				+ ", matrizAdjacencia=" + Arrays.toString(matrizAdjacencia) + ", matrizIncidencia="
				+ Arrays.toString(matrizIncidencia) + "]";
	}
}