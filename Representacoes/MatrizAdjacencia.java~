package representacoes;
/**
 * \file MatrizAdjacencia.java
 *
 * \brief Definicao da classe de matriz de adjacencia.
 *
 * \author Petrucio Ricardo Tavares de Medeiros
 *
 * \version 1.0
 */

/**
 * \class MatrizAdjacencia
 *
 * \brief A classe da matriz de adjacencia.
 */
public class MatrizAdjacencia{
    
    //--------------------------------------------------------------------
    //                       Atributo Privado
    //--------------------------------------------------------------------
    public int M[][]; ///< Matriz da representação
    
    //--------------------------------------------------------------------
    //                       Metodos Publicos
    //--------------------------------------------------------------------
    /**
     * \fn public void iniciaMatrizDeAdjacencia(int tam)
     *
     * \brief Responsavel pela inicializacao da matriz de adjacencia.
     *
     * \param tam - O tamanho que utilizaremos na matriz.
     */
    public void iniciaMatrizDeAdjacencia(int tam){
	M = new int[tam][tam];
    }

    /**
     * \fn public int getTamanhoDaMatriz()
     *
     * \brief Enviar o tamanho da matriz de adjacencia.
     *
     * \return O valor do tamanho da matriz de adjacencia.
     */
    public int getTamanhoDaMatriz(){
	return M.length;
    }

    /**
     * \fn public void iniciaArestasDaMatriz(int i, int j)
     *
     * \brief Inicia as arestas da matriz de adjacencia.
     *
     * \param i e j - Informa que entre elas havera uma aresta.
     */
    public void iniciaArestasDaMatriz(int i, int j){
	M[i][j] = 1;
    }

    /**
     * \fn public void iniciaArestasDaMatrizComPeso(int i, int j, int k)
     *
     * \brief Inicia as arestas da matriz de adjacencia com peso.
     *
     * \param i e j - Informa que entre elas havera uma aresta.
     * k - Informa que peso tem esta aresta.
     */
    public void iniciaArestasDaMatrizComPeso(int i, int j, int k){
	M[i][j] = k;
    }

    /**
     * \fn public void imprimirMatrizDeAdjacencia()
     *
     * \brief Imprime a matriz de adjacencia.
     */
    public void imprimirMatrizDeAdjacencia(){
	for (int i = 0; i < M.length; i++){ //Linhas
	    for (int j = 0; j < M[i].length; j++){ //Colunas
		System.out.printf("%d  ",M[i][j]);
	    }
	    System.out.println();
	}
    }
}
