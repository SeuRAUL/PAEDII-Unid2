/**
 * \file Prim.java
 *
 * \brief Definicao da classe de arvore geradora minima utilizando prim.
 *
 * \author Petrucio Ricardo Tavares de Medeiros
 *
 * \version 1.0
 */
import representacoes.*; //MatrizAdjacencia.java e ListaAdjacencia.java
/**
 * \class Prim
 *
 * \brief A classe do algoritmo prim.
 */
public class Prim{

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
    public VerticesECusto caminho[]; //Vetor correspondente ao caminho
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
	if (caminho[0].verticeInicial != caminho[0].verticeFinal){
	    for (int i = 0; i < caminho.length; i++){
		if ((caminho[i].verticeFinal == verticeInicial) &&
		    (caminho[i].verticeInicial == verticeFinal)){
		    return true;
		}
	    }
	    return false;
	}
	else return false;
    }

    /**
     * \fn private void iniciandoCaminho()
     *
     * \brief Inicia o vetor do caminho com zeros em todos os campos.
     */
    private void iniciandoCaminho(){
	VerticesECusto aresta = new VerticesECusto(0,0,0);
	for (int i = 0; i < caminho.length; i++){
	    caminho[i] = aresta;
	}
    }

    /**
     * \fn private int menorDaLista(int indiceVetor, ListaAdjacencia L)
     *
     * \brief Encontra o menor elemento da lista.
     *
     * \param indiceVetor - indice do vetor de L
     * L - lista de adjacencia
     *
     * \return O indice da lista de adjacencia que é referente ao menor elemento
     */
    private int menorDaLista(int indiceVetor, ListaAdjacencia L){
	int indice = -1;
	indice = 0;
	int menor = L.L[indiceVetor].get(0).getCust();
	for (int i = 0; i < L.L[indiceVetor].getTam(); i++){
	    if ((menor > (L.L[indiceVetor]).get(i).getCust()) &&
		(!buscaArestas(indiceVetor,
			      L.L[indiceVetor].get(i).getInfo()))){
		menor = L.L[indiceVetor].get(i).getCust();
		indice = i;
	    }
	}
	System.out.printf("O menor do indice %d, eh %d", indice, menor);
	System.out.println();
	return indice;
    }

    /**
     * \fn private void atualizandoCaminho(ListaAdjacencia L)
     *
     * \brief Atualiza o vetor do caminho.
     *
     * \param L - Lista de adjacencia
     */
    private void atualizandoCaminho(ListaAdjacencia L){
	caminho = new VerticesECusto[L.verificarTamLista() - 1];
	iniciandoCaminho();
	//Varrendo todo o vetor
	int cont = 0;
	for (int i = 0; i < L.verificarTamLista() - 1; i++){ //Varrendo listas
	    int j = menorDaLista(i, L);
	    if (j != -1){
		VerticesECusto aresta = 
		    new VerticesECusto(i,
				       L.L[i].get(j).getInfo(),
				       L.L[i].get(j).getCust());
		caminho[cont] = aresta;
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
	for (int i = 0; i < caminho.length; i++){
	    System.out.printf("vInicial: %d, vFinal: %d e o custo: %d, interacao: %d",
			      caminho[i].getVerticeInicial(),
			      caminho[i].getVerticeFinal(),
			      caminho[i].getCusto(), i);
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
    public void prim(ListaAdjacencia L){
	//Atualizando o vetor de arestas
	atualizandoCaminho(L);
	imprimirCaminho();
    }
    
}
