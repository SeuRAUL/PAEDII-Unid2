
//package floyd;
/**
 * \file Floyd.java
 *
 * \brief Definicao da classe do algoritmo de menor caminho Floyd.
 * 
 * \author Petrucio Ricardo Tavares de Medeiros
 * Raul Lucena e Silva
 *
 * \version 1.0
 */

import java.util.*; // pilha para imprimmir caminho
import java.io.*; // leitura de arquivo

/**
 * \class Floyd
 *
 * \brief A classe do algoritmo de menor caminho Floyd.
 */
public class Floyd {

	// Entrada
	static FileReader arqIn;
	static BufferedReader lerArq;
	
	// Saída
	static FileWriter arqOut;
	static PrintWriter gravarArq;

	public static void main(String[] args) {

		/*try{

			// Entrada
    	arqIn = new FileReader("floyd1.in");
    	lerArq = new BufferedReader(arqIn);
    	
    	// Saída
    	arqOut = new FileWriter("saida.txt");
    	gravarArq = new PrintWriter(arqOut);
    	String path = new String();
        
    	String linha = lerArq.readLine(); // lê a primeira linha
	  	
	  	//instancia obj floyd
	  	int tam = Integer.parseInt(linha) + 1;
	  	Floyd floyd = new Floyd(tam);
	  	gravarArq.println("-");

	  	while ( linha != null ) {

	  		linha = lerArq.readLine();
	  		String params[] = linha.split(" ");

	  		if (params[0].contains("edge")) {
	  			floyd.adicionarAresta(Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
	  			gravarArq.println("-");
	  			floyd.floydAr();
	  		}
	  		else if (params[0].contains("shortest")) {
	  			
  				System.out.println(linha);
  				//System.out.println( floyd.shortest( Integer.parseInt(params[1]) , Integer.parseInt(params[2]) ) );
  				//String params[] = linha.split(" ");
  				
  				//gravarArq.println(floyd.shortest( Integer.parseInt(params[1]) , Integer.parseInt(params[2]) ) );
	  			path = floyd.shortest(Integer.parseInt(params[1]), Integer.parseInt(params[2]));
	  			//System.out.println(path);
	  			gravarArq.println(path);

  				//linha = lerArq.readLine();
  			}
	  	}

		} catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
    }*/



		Floyd floyd = new Floyd(6);

		System.out.println("\nInicializada:");
		floyd.printMatriz(floyd.matrizArestas);
		System.out.println();
		floyd.printMatriz(floyd.matrizPredecessor);
		
		//grafo do slide
		floyd.adicionarAresta(0,1,8);
		floyd.adicionarAresta(0,3,3);
		floyd.adicionarAresta(0,4,3);

		floyd.adicionarAresta(1,0,8);
		floyd.adicionarAresta(1,2,5);
		floyd.adicionarAresta(1,4,2);

		floyd.adicionarAresta(2,1,5);
		floyd.adicionarAresta(2,4,5);
		floyd.adicionarAresta(2,5,3);

		floyd.adicionarAresta(3,0,3);
		floyd.adicionarAresta(3,4,2);

		floyd.adicionarAresta(4,0,3);
		floyd.adicionarAresta(4,1,2);
		floyd.adicionarAresta(4,2,5);
		floyd.adicionarAresta(4,3,2);
		floyd.adicionarAresta(4,5,4);

		floyd.adicionarAresta(5,2,3);
		floyd.adicionarAresta(5,4,4);
		//\grafo do slide

		System.out.println("\nAresteada:");
		floyd.printMatriz(floyd.matrizArestas);
		System.out.println();
		floyd.printMatriz(floyd.matrizPredecessor);

		System.out.println("\nfloydAdo:");
		floyd.floydAr();
		floyd.printMatriz(floyd.matrizArestas);
		System.out.println();
		floyd.printMatriz(floyd.matrizPredecessor);
		System.out.println();
		System.out.println("Caminho de 0 a 5:");
		System.out.println(floyd.shortest(0, 5));
		
	}
	
	//--------------------------------------------------------------------
	//                       Atributos Privado
	//--------------------------------------------------------------------
	int quantidadeDeVertices;
	private int[][] matrizArestas;
	private int[][] matrizPredecessor;

	//--------------------------------------------------------------------
	//                       Metodos publicos
	//--------------------------------------------------------------------
	/**
	 * \fn public Floyd(int vertices)
	 *
	 * \brief Metodo construtor da classe FLoyd.
	 *
	 * \param vertices - Quantidades de vertices do grafo.
	 */
	public Floyd(int vertices){
		quantidadeDeVertices = vertices;
		matrizArestas = new int[vertices][vertices];
		matrizPredecessor = new int[vertices][vertices];

		for (int i = 0; i < quantidadeDeVertices ; i++ ) {
			for (int j = 0; j < quantidadeDeVertices ; j++ ) {
				if (i != j) matrizArestas[i][j] = 1000;
				else matrizArestas[i][j] = 0;
				matrizPredecessor[i][j] = i;
			}
		}
	}

	/**
	 * \fn public void adicionarAresta(int vertice1, int vertice2, int peso)
	 *
	 * \brief Metodo que adiciona aresta ao grafo
	 *
	 * \param vertice1, vertice2 - vertices ligados pela nova aresta.
	 * peso - custo da aresta.
	 */
	public void adicionarAresta(int vertice1, int vertice2, int peso){
		matrizArestas[vertice1][vertice2] = peso;
	}

	/**
	 * \fn public void adicionarPredecessor(int vertice1, int vertice2, int predecessor)
	 *
	 * \brief Metodo que adiciona predecessor de um vertice no caminho.
	 *
	 * \param vertice1, vertice2 - vertices ligados pela nova aresta.
	 * predecessor - predecessor do vertice2 vindo de vertice1.
	 */
	public void adicionarPredecessor(int vertice1, int vertice2, int predecessor){
		matrizPredecessor[vertice1][vertice2] = predecessor;
	}

	/**
	 * \fn public void floydAr()
	 *
	 * \brief Metodo que salva os caminhos mais curtos para os vertices.
	 */
	public void floydAr(){
		for (int k = 0; k < quantidadeDeVertices ; k++ ) {
			for (int i = 0; i < quantidadeDeVertices ; i++ ) {
				for (int j = 0; j < quantidadeDeVertices ; j++ ) {
					if (matrizArestas[i][j] > matrizArestas[k][j] + matrizArestas[i][k]) {
						adicionarAresta(i, j, (matrizArestas[k][j] + matrizArestas[i][k]));
						adicionarAresta(j, i, (matrizArestas[k][j] + matrizArestas[i][k]));
						adicionarPredecessor(i,j,k);
						adicionarPredecessor(j,i,k);
					}
				}
			}
		}
	}

	/**
	 * \fn public String shortest(int aresta1, int aresta2)
	 *
	 * \brief Metodo que aretorna o menor caminho de uma aresta a outra e seu custo.
	 *
	 * \param aresta1, aresta2 - vertices inicial e final.
	 */
	public String shortest(int aresta1, int aresta2) {
		Deque<Integer> path = new ArrayDeque<Integer>();
		//aresta1 -= 1; aresta2 -= 1; // localizar no array
		if (matrizArestas[aresta1][aresta2] < 1000){
			
			path.push(matrizArestas[aresta1][aresta2]);
			while (aresta2 != aresta1){
				path.push(matrizPredecessor[aresta1][aresta2]);
				aresta2 = matrizPredecessor[aresta1][aresta2];
			}
			String predecessores = new String("");
			while (!path.isEmpty()){
				predecessores = predecessores.concat(path.pop().toString() + " ");
			}
			return predecessores;
		} else
			return "No path";
	}

	public void printMatriz(int M[][]){
		for (int i = 0; i < quantidadeDeVertices ; i++ ) {
			for (int j = 0; j < quantidadeDeVertices ; j++ ) {
				System.out.print( M[i][j] + " ");
			}
			System.out.println();
		}
	}

}

