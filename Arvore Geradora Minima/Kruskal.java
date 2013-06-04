/**
 * \file Kruskal.java
 *
 * \brief Definicao da classe de arvore geradora minima utilizando kruskal.
 *
 * \author Petrucio Ricardo Tavares de Medeiros
 *
 * \version 1.0
 */
import representacoes.*; //MatrizAdjacencia.java e ListaAdjacencia.java
import conjuntosDisjuntos.*; //ConjuntosDisjuntos.java
/**
 * \class Kruskal
 *
 * \brief A classe do algoritmo kruskal.
 */
public class Kruskal{

    /**
     * \class VerticesECusto
     *
     * \brief Classe que tem os campos vertice inicial, vertice atingido
     * e custo da aresta.
     */
    public class VerticesECusto{
	//---------------------------------------------------------
	//                       Atributo publico
	//---------------------------------------------------------
	public int verticeInicial; //vertice inicial
	public int verticeFinal; //vertice vizinho
	public int custo; //custo da aresta
	
	//---------------------------------------------------------
	//                       Metodos publicos
	//---------------------------------------------------------
	/**
	 * \fn public VerticesECusto(int _verticeInicial, int _verticeFinal,
	 * int _custo)
	 *
	 * \brief Metodo construtor da classe Vizinho.
	 *
	 * \param _verticeInicial - Vertice inicial do percorrimento
	 * _verticeFinal - Vertice final da aresta
	 * _custo - Custo associado a aresta que liga os dois vertices
	 */
	public VerticesECusto(int _verticeInicial,
			      int _verticeFinal, 
			      int _custo){
	    verticeInicial = _verticeInicial;
	    verticeFinal = _verticeFinal;
	    custo = _custo;
	}

	/**
	 * \fn public int getVerticeInicial()
	 *
	 * \brief Metodo para pegar o vertice inicial.
	 *
	 * \return O valor do vertice inicial.
	 */
	public int getVerticeInicial(){
	    return verticeInicial;
	}

	
	/**
	 * \fn public int getVerticeFinal()
	 *
	 * \brief Metodo para pegar o vertice final.
	 *
	 * \return O valor do vertice final.
	 */
	public int getVerticeFinal(){
	    return verticeFinal;
	}

	/**
	 * \fn public int getCusto()
	 *
	 * \brief Metodo para pegar o custo.
	 *
	 * \return O valor do custo.
	 */
	public int getCusto(){
	    return custo;
	}
    } //Fim da classe VerticesECusto

    //--------------------------------------------------------------------
    //                       Atributo Privado
    //--------------------------------------------------------------------
    public VerticesECusto vetorArestas[]; //Vetor de arestas
    public VerticesECusto vetorCaminho[]; //Vetor correspondente ao caminho
    //--------------------------------------------------------------------
    //                       Metodos privados
    //--------------------------------------------------------------------    
    /**
     * \fn private boolean buscaArestas(int verticeInicial, int verticeFinal)
     *
     * \brief Busca se ja foi atualizado no vetor de arestas.
     *
     * \param verticeInicial - Vertice inicial que analisaremos.
     * verticeFinal - Vertice final que analisaremos.
     *
     * \return True se ja foi colocado no vetor de arestas e false caso
     * contrario.
     */
    private boolean buscaArestas(int verticeInicial, int verticeFinal){
	if (vetorArestas[0].verticeInicial != vetorArestas[0].verticeFinal){
	    for (int i = 0; i < vetorArestas.length; i++){
		if ((vetorArestas[i].verticeFinal == verticeInicial) &&
		    (vetorArestas[i].verticeInicial == verticeFinal)){
		    return true;
		}
	    }
	    return false;
	}
	else return false;
    }

    /**
     * \fn private int quantArestas(ListaAdjacencia L)
     *
     * \brief Encontra a quantidade de arestas que existe no grafo.
     *
     * \param L - Lista de adjacencia.
     *
     * \return O valor da quantidade de arestas.
     */
    private int quantArestas(ListaAdjacencia L){
	int cont = 0;
	for (int i = 0; i < L.verificarTamLista(); i++){
	    cont = cont + L.L[i].getTam();
	}
	return (cont/2);
    }

    /**
     * \fn private void iniciandoVetorArestas()
     *
     * \brief Inicia o vetor de arestas com zeros em todos os campos.
     */
    private void iniciandoVetorArestas(){
	VerticesECusto vAresta = new VerticesECusto(0,0,0);
	for (int i = 0; i < vetorArestas.length; i++){
	    vetorArestas[i] = vAresta;
	}
    }

    /**
     * \fn private void atualizandoVetorArestas(ListaAdjacencia L)
     *
     * \brief Atualiza o vetor de arestas.
     *
     * \param L - Lista de adjacencia
     */
    private void atualizandoVetorArestas(ListaAdjacencia L){
	//Pegar a quantidade de arestas
	int quantidadeArestas = quantArestas(L);
	//Inicializando o vetor de arestas
	vetorArestas = new VerticesECusto[quantidadeArestas];
	iniciandoVetorArestas();
	//Varrendo todo o vetor
	int cont = 0;
	for (int i = 0; i < L.verificarTamLista(); i++){ //Varrendo listas
	    for (int j = 0; j < L.L[i].getTam(); j++){ //Varrer conteudo lista
		//Se nao esta no vetor de arestas entao temos que colocar
		if (buscaArestas(i, (L.L[i].get(j)).getInfo()) == false){
		    VerticesECusto aresta = 
			new VerticesECusto(i,
					   L.L[i].get(j).getInfo(),
					   L.L[i].get(j).getCust());
		    vetorArestas[cont] = aresta;
		    cont++;
		}
	    }
	}
    }

    /**
     * \fn private void ordenandoVetorArestas()
     *
     * \brief Ordenando o vetor de arestas.
     */
    private void ordenandoVetorArestas(){
	for (int i = 0; i < vetorArestas.length; i++){
	    for (int j = 0; j < vetorArestas.length - 1; j++){
		if (vetorArestas[j].getCusto() > vetorArestas[j+1].getCusto()){
		    VerticesECusto aux = vetorArestas[j+1];
		    vetorArestas[j+1] = vetorArestas[j];
		    vetorArestas[j] = aux;
		}
	    }
	}
    }
   
    /**
     * \fn private void percorrerVetorArestas(ConjuntosDisjuntos Cj)
     *
     * \brief Percorrendo o vetor de arestas.
     *
     * \param Cj - Conjunto disjunto
     */
    private void percorrerVetorArestas(ListaAdjacencia L, 
				       ConjuntosDisjuntos Cj){
	vetorCaminho = new VerticesECusto[L.verificarTamLista() - 1];
	int cont = 0;
	for (int i = 0; i < vetorArestas.length; i++){
	    //Verifica se os vertices inicial e final estao no mesmo conjunto
	    if (Cj.compare(vetorArestas[i].verticeInicial,
			   vetorArestas[i].verticeFinal) == false){
		//Os vertices nao pertencem ao mesmo conjunto
		vetorCaminho[cont] = vetorArestas[i];
		Cj.union(vetorArestas[i].verticeInicial, 
			 vetorArestas[i].verticeFinal, L);
		cont++;
	    }
	}
    }

    
    /**
     * \fn public void imprimirCaminho()
     *
     * \brief Imprime o caminho
     */
    public void imprimirCaminho(){
	for (int i = 0; i < vetorCaminho.length; i++){
	    System.out.printf("vInicial: %d, vFinal: %d e o custo: %d, interacao: %d",
			      vetorCaminho[i].getVerticeInicial(),
			      vetorCaminho[i].getVerticeFinal(),
			      vetorCaminho[i].getCusto(), i);
	    System.out.println();
	}
    }

    
    /**
     * \fn public void kruskal(ListaAdjacencia L, ConjuntosDisjuntos Cj)
     *
     * \brief Metodo de kruskal.
     *
     * \param L - Lista de adjacencia
     * Cj - Conjunto disjunto
     */
    public void kruskal(ListaAdjacencia L, ConjuntosDisjuntos Cj){
	//Atualizando o vetor de arestas
	atualizandoVetorArestas(L);
	ordenandoVetorArestas();
        //Percorrendo vetor de arestas e estabelecendo o menor caminho
	percorrerVetorArestas(L, Cj);
	imprimirCaminho();
    }
    
}
