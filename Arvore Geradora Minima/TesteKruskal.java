import representacoes.*; //MatrizAdjacencia.java e ListaAdjacencia.java
import conjuntosDisjuntos.*; //ConjuntosDisjuntos.java
public class TesteKruskal{

	ListaAdjacencia obj = new ListaAdjacencia();

	// Entrada
	static FileReader arqIn;
	static BufferedReader lerArq;
	
	// Saída
	static FileWriter arqOut;
	static PrintWriter gravarArq;

    public static void main(String[] args){

    	try{

    		// Entrada
	    	arqIn = new FileReader("agm2.in");
	    	lerArq = new BufferedReader(arqIn);
	    	
	    	// Saída
	    	arqOut = new FileWriter("saida.txt");
	    	gravarArq = new PrintWriter(arqOut);
    		
				String linha = lerArq.readLine();

				obj.iniciaListaDeAdjacencia(Integer.parseInt(linha));
				ConjuntosDisjuntos obj1 = new ConjuntosDisjuntos(obj);

				while (linha != null) {
					linha = lerArq.readLine(); // lê da segunda até a última linha
      	  String params[] = linha.split(" ");

      	  if (params[o].contains("edge")) {
      	  	obj.iniciaArestasDaListaComPeso(Integer.parseInt(params[1]), Integer.parseInt(params[2]), Integer.parseInt(params[3]));
      	  	gravarArq.println("-");
      	  }
      	  else if (params[0].contains("kruskal")) {
      	  	Kruskal obj2 = new Kruskal();
						obj2.kruskal(obj, obj1);
      	  }
      	  else if (params[0].contains("prim")) {
      	  	Prim obj2 = new Prim();
						obj2.prim(obj);
      	  }
				}


    	
    	} catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
	    }

			

			obj.iniciaListaDeAdjacencia(5);
			//Adicionando arestas com custo e com orientacao na lista
			obj.iniciaArestasDaListaComPeso(0, 2, 4);
			obj.iniciaArestasDaListaComPeso(2, 0, 4);
			obj.iniciaArestasDaListaComPeso(1, 4, 10);
			obj.iniciaArestasDaListaComPeso(4, 1, 10);
			obj.iniciaArestasDaListaComPeso(4, 3, 3);
			obj.iniciaArestasDaListaComPeso(3, 4, 3);
			obj.iniciaArestasDaListaComPeso(4, 2, 6);
			obj.iniciaArestasDaListaComPeso(2, 4, 6);
			obj.iniciaArestasDaListaComPeso(3, 2, 5);
			obj.iniciaArestasDaListaComPeso(2, 3, 5);
			
			
			// obj.iniciaListaDeAdjacencia(4);
			// obj.iniciaArestasDaListaComPeso(0, 1, 5);
			// obj.iniciaArestasDaListaComPeso(1, 0, 5);
			// obj.iniciaArestasDaListaComPeso(1, 2, 2);
			// obj.iniciaArestasDaListaComPeso(2, 1, 2);
			// obj.iniciaArestasDaListaComPeso(0, 2, 1);
			// obj.iniciaArestasDaListaComPeso(2, 0, 1);
			// obj.iniciaArestasDaListaComPeso(1, 3, 3);
			// obj.iniciaArestasDaListaComPeso(3, 1, 3);
			// obj.iniciaArestasDaListaComPeso(3, 2, 1);
			// obj.iniciaArestasDaListaComPeso(2, 3, 1);
			obj.imprimirListaDeAdjacencia();
			ConjuntosDisjuntos obj1 = new ConjuntosDisjuntos(obj);
			Kruskal obj2 = new Kruskal();
			obj2.kruskal(obj, obj1);
    }
}
