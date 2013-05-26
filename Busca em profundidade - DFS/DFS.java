/**
 * \file DFS.java
 *
 * \brief Definicao da classe da busca em profundidade.
 *
 * \author Petrucio Ricardo Tavares de Medeiros
 * Raul Lucena e Silva
 *
 * \version 1.0
 */
import representacoes.*; //MatrizAdjacencia.java e ListaAdjacencia.java
import java.util.LinkedList; //Listas ligadas para pilha
import java.util.List; //Lista
/**
 * \class DFS
 *
 * \brief A classe da busca em profundidade.
 */
public class DFS{
    //--------------------------------------------------------------------
    //                       Atributo Privado
    //--------------------------------------------------------------------
    private LinkedList<Integer> pilha = new LinkedList<Integer>();
    private int caminho[]; //Vetor armazenara o caminho
    private int analisado[]; //Vetor para armazenar nos percorridos
    private int tamMatriz; //Tamanho da matriz de adjacencia

    //--------------------------------------------------------------------
    //                       Metodos privados
    //--------------------------------------------------------------------
    /**
     * \fn private void verificarTamMatriz(MatrizAdjacencia M)
     *
     * \brief Metodo que guarda o tamanho da matriz.
     *
     * \param M - Matriz de adjacencia analisada
     */
    private void verificarTamMatriz(MatrizAdjacencia M){
	tamMatriz = M.getTamanhoDaMatriz();
    }

    /**
     * \fn private void iniciandoVetorAnalisado()
     *
     * \brief Inicia todo o vetor analisado com todas as posicoes iguais a -1.
     */
    // Iniciando todos os valores do vetor com -1
    // 0   1   2   3   4 
    //-1  -1  -1  -1  -1
    private void iniciandoVetorAnalisado(){
	analisado = new int[tamMatriz];
	for (int i = 0; i < tamMatriz; i++){
	    analisado[i] = -1;
	}
    }

    /**
     * \fn private void chaveInicial(int chave)
     *
     * \brief Atualiza a posicao inicial com o valor da chave inicial.
     *
     * \param chave - chave do vertice inicial
     */
    // Sendo a chave inicial 2
    // 0   1   2   3   4 
    //-1  -1   2  -1  -1
    private void chaveInicial(int chave){
	analisado[chave] = chave;
    }

    /**
     * \fn private boolean chaveFoiAnalisada(int chave)
     *
     * \brief Verifica se a chave foi ou nao analisada.
     *
     * \param chave - chave do vertice.
     *
     * \return Se a posicao da chave for preenchida com algum valor diferente de
     * -1, entao foi analisada a posicao, senao nao foi analisada ainda.
     */
    private boolean chaveFoiAnalisada(int chave){
        if (analisado[chave] != -1) return true;
	else return false;
    }
    
    /**
     * \fn private int quantVizinhos(int chave, MatrizAdjacencia M)
     *
     * \brief Metodo que verifica quantos vizinhos tem o vertice chave.
     *
     * \param chave - chave do vertice.
     * M - Matriz de adjacencia
     *
     * \return O valor de quantos vizinhos tem o vertice.
     */
    private int quantVizinhos(int chave, MatrizAdjacencia M){
	int cont = 0;
	for (int i = 0; i < tamMatriz; i++){
	    if (M.M[chave][i] == 1) cont++;
	}
	return cont;
    }
    
    /**
     * \fn private int[] vizinhos(int chave, MatrizAdjacencia M)
     *
     * \brief Armazena todos os vizinhos do vertice que nao foi analisado.
     *
     * \param chave - chave do vertice.
     * M - Matriz de adjacencia
     *
     * \return O vetor de vizinhos do vertice referenciado. Se nao tem vizinhos
     * o retorno e vazio.
     */
    private int[] vizinhos(int chave, MatrizAdjacencia M){
	int[] _vizinhos;
	int qVizinhos = quantVizinhos(chave, M);
	if (qVizinhos == 0) _vizinhos = new int[0];
	else{
	    _vizinhos = new int[qVizinhos];
	    int cont = 0;
	    for (int i = 0; i < tamMatriz; i++){
		if ((M.M[chave][i] == 1) && 
		    (!chaveFoiAnalisada(i))){
		    _vizinhos[cont] = i;
		    analisado[i] = chave;
		    cont++;
		}
	    }
	    if (qVizinhos != cont){
		int[] aux = new int[cont];
		for (int i = 0; i < cont; i++){
		    aux[i] = _vizinhos[i];
		}
		return aux;
	    }
	}
	return _vizinhos;
    }

    /**
     * \fn private boolean atingido(int j, int[] vetorVizinhos)
     *
     * \brief Verifica se o vertice final ja foi atingido, ou melhor, se o
     * vertice esta no vetor de vizinhos.
     *
     * \param j - Chave do vertice final.
     * vetorVizinhos - Vetor com todos os vizinhos.
     *
     * \return Verdade se tem o vertice final no vetor de vizinhos e falso caso
     * contrario.
     */
    private boolean atingido(int j, int[] vetorVizinhos){
	for (int i = 0; i < vetorVizinhos.length; i++){
	    System.out.printf("%d", vetorVizinhos[i]);
	    System.out.println();
	    if (vetorVizinhos[i] == j) return true;
	}
	return false;
    }

    /**
     * \fn private void empilhandoVizinhos(int[] vetorVizinhos, int chave)
     *
     * \brief Metodo que empilha os vizinhos.
     *
     * \param chave - chave da vertices dos vizinhos.
     * vetorVizinhos - Vetor com todos os vizinhos.
     */
    private void empilhandoVizinhos(int[] vetorVizinhos){
	for (int i = 0; i < vetorVizinhos.length; i++){
	    if (chaveFoiAnalisada(vetorVizinhos[i])){
		pilha.add(vetorVizinhos[i]);
	    }
	}
    }

    /**
     * \fn private void imprimirVetorAnalisado()
     *
     * \brief Metodo que imprime o vetor analisado.
     */
    private void imprimirVetorAnalisado(){
	for (int i = 0; i < tamMatriz; i++){
	    System.out.printf("%d ", analisado[i]);
	}
    }
    
    /**
     * \fn private int quantElementosCaminho(int i, int j)
     *
     * \brief Metodo que verifica a quantidade de elementos do caminho.
     *
     * \param i - chave do vertice inicial
     * j - chave do vertice final
     *
     * \return Retorna o valor da quantidade de elementos que tem no caminho.
     */
    private int quantElementosCaminho(int i, int j){
	int inicio = j;
	int cont = 0;
	while(inicio != i){
	    cont++;
	    inicio = analisado[inicio];
	}
	return cont;
    }
    
    /**
     * \fn private void armazenandoCaminho(int i, int j)
     *
     * \brief Armazena o caminho entre os vertices iniciais e finais.
     *
     * \param i - chave do vertice inicial
     * j - chave do vertice final
     */
    private void armazenandoCaminho(int i, int j){
	int qtdCaminho = quantElementosCaminho(i, j);
	caminho = new int[qtdCaminho+1];
	caminho[0] = j;
	int inicio = j;
	int cont = 1;
	while(inicio != i){
	    caminho[cont] = analisado[inicio];
	    inicio = analisado[inicio];
	    cont++;
	}
    }

    /**
     * \fn private void imprimirCaminho()
     *
     * \brief Imprime todo o caminho.
     */
    private void imprimirCaminho(){
	System.out.println();
        for (int i = caminho.length - 1; i > -1; i--){
	    System.out.printf("%d ", caminho[i]);
	}
	System.out.println();
    }

    //--------------------------------------------------------------------
    //                       Metodo publico
    //--------------------------------------------------------------------
    /**
     * \fn public void Dfs(int i, int j, MatrizAdjacencia M)
     *
     * \brief Metodo de busca em profundidade.
     *
     * \param i - chave do vertice inicial
     * j - chave do vertice final
     * M - Matriz de adjacencia
     */
    public void Dfs(int i, int j, MatrizAdjacencia M){
	int valor_invertido = 0;
	verificarTamMatriz(M);  //modificar nome pq nao retorna o inteiro...
	iniciandoVetorAnalisado();
	chaveInicial(i);
	pilha.add(i);
	while(pilha.size() != 0){
	    int v = pilha.pop();
	    int[] viz = vizinhos(v, M);
	    //Verifica se já foi atingido
	    System.out.printf("Impressao do vetor analisado de %d!\n", v);
	    imprimirVetorAnalisado();
	    System.out.println();
	    if (atingido(j, viz)){
		System.out.println("Axei!");
		imprimirVetorAnalisado();
		armazenandoCaminho(i, j);
	        imprimirCaminho();
		return;
	    }
	    else{
		//Tenho que empilhar todos os vizinhos
		empilhandoVizinhos(viz);
	    }
	}
    }

}
