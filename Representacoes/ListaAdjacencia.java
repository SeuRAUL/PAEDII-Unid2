package representacoes;
/**
 * \file ListaAdjacencia.java
 *
 * \brief Definicao da classe de lista de adjacencia.
 *
 * \author Petrucio Ricardo Tavares de Medeiros
 *
 * \version 1.0
 */
import java.util.LinkedList; //Listas ligadas
import java.util.List; //Lista
/**
 * \class ListaAdjacencia
 *
 * \brief A classe de lista de adjacencia.
 */
public class ListaAdjacencia{
    
    /**
     * \class Node
     *
     * \brief Classe que tem um campo informacao e custo.
     */
    public class Node{
	//---------------------------------------------------------
	//                       Atributo publico
	//---------------------------------------------------------
	private int info;
	private int cust;
	//---------------------------------------------------------
	//                       Metodos publicos
	//---------------------------------------------------------
	public Node(int _info, int _cust){
	    info = _info;
	    cust = _cust;
	}
	public int getInfo(){
	    return info;
	}
	public int getCust(){
	    return cust;
	}
    }

    /**
     * \class Lista
     *
     * \brief A classe de lista.
     */
    public class Lista{
	//---------------------------------------------------------
	//                       Atributo publico
	//---------------------------------------------------------
	public LinkedList<Node> list = new LinkedList<Node>();

	//---------------------------------------------------------
	//                       Metodos privados
	//---------------------------------------------------------
	/**
	 * \fn public Node get(int indice)
	 *
	 * \brief Metodo para pegar os no referente ao indice.
	 *
	 * \param indice - Lugar onde esta o no que estou buscando.
	 *
	 * \return retorna o no associado ao indice.
	 */
	public Node get(int indice){
	    Node no = list.get(indice);
	    return no;
	}
	//---------------------------------------------------------
	//                       Metodos publicos
	//---------------------------------------------------------
	/**
	 * \fn public void adicionarLista(int chave)
	 *
	 * \brief Adiciona uma chave na lista e um custo.
	 *
	 * \param chave - Informacao que sera adicionada na lista.
	 */
	public void adicionarLista(int chave, int custo){
	    Node no = new Node(chave, custo);
	    list.addFirst(no);
	}
	
	/**
	 * \fn public void imprimirLista()
	 *
	 * \brief Imprime a lista com o no e seu custo
	 */
	public void imprimirLista(){
	    for (int i = 0; i < list.size(); i++){
		System.out.printf("%d,%d ",(list.get(i)).getInfo(),
				 (list.get(i)).getCust());
	    }
	}
    }

    //--------------------------------------------------------------------
    //                       Atributo Privado
    //--------------------------------------------------------------------
    public Lista L[]; ///< Lista de Adjacencia representacao

    //--------------------------------------------------------------------
    //                       Metodos Publicos
    //--------------------------------------------------------------------
    /**
     * \fn public int verificarTamLista()
     *
     * \brief Identifica o tamanho da lista de adjacencia.
     *
     * \return O valor do tamanho da lista de adjacencia.
     */
    public int verificarTamLista(){
	return L.length;
    }

    /**
     * \fn public void iniciaListaDeAdjacencia(int tam)
     *
     * \brief Responsavel pela inicializacao da lista de adjacencia.
     *
     * \param tam - O tamanho que utilizaremos na lista.
     */
    public void iniciaListaDeAdjacencia(int tam){
	L = new Lista[tam];
	for (int i = 0; i < tam; i++){
	    L[i] = new Lista();
	}
    }
    
    /**
     * \fn public void iniciaArestasDaLista(int i, int j)
     *
     * \brief Inicia as arestas da lista de adjacencia.
     *
     * \param i e j - Informa que entre elas havera uma aresta.
     */
    public void iniciaArestasDaLista(int i, int j){
	//Adiciona uma aresta de i para j
	L[i].adicionarLista(j,1);
	//Adiciona uma aresta de j para i
	L[j].adicionarLista(i,1);
    }

    /**
     * \fn public void iniciaArestasDaListaComPeso(int i, int j, int k)
     *
     * \brief Inicia as arestas da lista de adjacencia com peso.
     *
     * \param i e j - Informa que entre elas havera uma aresta.
     * k - Informa que peso tem esta aresta.
     */
    public void iniciaArestasDaListaComPeso(int i, int j, int k){
	//Adiciona uma aresta de i para j com um custo k
	L[i].adicionarLista(j, k);
    }
    
    /**
     * \fn public void imprimirListaDeAdjacencia()
     *
     * \brief Imprime a lista de adjacencia.
     */
    public void imprimirListaDeAdjacencia(){
	for (int i = 0; i < L.length; i++){
	    System.out.printf("%d :", i);
	    L[i].imprimirLista();
	    System.out.println();
	}
    }
    
}
