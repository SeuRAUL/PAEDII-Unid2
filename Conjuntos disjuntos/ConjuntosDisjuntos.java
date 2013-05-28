/**
 * \file ConjuntosDisjuntos.java
 *
 * \brief Definicao da classe de conjuntos disjuntos.
 *
 * \author Petrucio Ricardo Tavares de Medeiros
 *
 * \version 1.0
 */
import representacoes.*; //MatrizAdjacencia.java e ListaAdjacencia.java
/**
 * \class ConjuntosDisjuntos
 *
 * \brief A classe conjuntos disjuntos.
 */
public class ConjuntosDisjuntos{
    //--------------------------------------------------------------------
    //                       Atributo Privado
    //--------------------------------------------------------------------
    int[] rep; //Vetor de representantes
    int tamLista; //Tamanho da lista de adjacencia
    int[] ordem; //Vetor de ordem
    //--------------------------------------------------------------------
    //                       Metodos privados
    //--------------------------------------------------------------------
    /**
     * \fn private void atualizarTamLista(ListaAdjacencia L)
     *
     * \brief Atualiza o tamanho da lista de adjacencia.
     *
     * \param L - Lista de adjacencia.
     */
    private void atualizarTamLista(ListaAdjacencia L){
	tamLista = L.verificarTamLista();
    }

    /**
     * \fn private void iniciaRepresentantes()
     *
     * \brief Iniciando todos os vertice da lista de adjacencia como proprio
     * vertice representante.
     */
    private void iniciaRepresentantes(){
	rep = new int[tamLista];
	for (int i = 0; i < tamLista; i++){
	    rep[i] = i;
	}
    }
    
    /**
     * \fn private void iniciarOrdens()
     *
     * \brief Inicia as ordens dos vertices como 1.
     */
    private void iniciarOrdens(){
	ordem = new int[tamLista];
	for (int i = 0; i < tamLista; i++){
	    ordem[i] = 1;
	}
    }

    /**
     * \fn private void atualizaRepresentanteVertice(int vertice, int repAtual)
     *
     * \brief Atualiza o representante do vertice.
     *
     * \param vertice - Vertice que sera atualizado.
     * repAtual - Representante atual.
     */
    private void atualizaRepresentanteVertice(int vertice, int repAtual){
	rep[vertice] = repAtual;
    }

    /**
     * \fn private int findset(int vertice)
     *
     * \brief Encontra o representante do vertice.
     *
     * \param vertice - Vertice que sera atualizado.
     *
     * \return O valor do representante do vertice.
     */
    private int findset(int vertice){
	//Heuristica da Compressao de Caminho
	//Atribuir o representante pai como representante direto de todos os
	//vertices utilizados por este metodo
	if (rep[vertice] != rep[rep[vertice]]){
	    //Atualizando a ordem
	    ordem[vertice] = ordem[rep[vertice]];
	    return rep[vertice] = findset(rep[rep[vertice]]);
	}
	else return rep[vertice];
    }
    
    /**
     * \fn private void atualizarOrdem(int vertice)
     *
     * \brief Metodo que atualiza a ordem de um determinado vertice
     */
    private void atualizarOrdem(int vertice){
	ordem[vertice] = ordem[vertice] + 1;
    }
    
    //--------------------------------------------------------------------
    //                       Metodos publicos
    //--------------------------------------------------------------------
    /**
     * \fn public ConjuntosDisjuntos()
     *
     * \brief Construtor da classe conjuntos disjuntos.
     */
    public ConjuntosDisjuntos(ListaAdjacencia l){
	atualizarTamLista(l);
	iniciaRepresentantes();
	iniciarOrdens();
    }

    /**
     * \fn public void imprimirRepresentantes()
     *
     * \brief Metodo imprime os representantes dos conjuntos.
     */
    public void imprimirRepresentantes(){
	System.out.println("Representantes");
	for (int i = 0; i < tamLista; i++){
	    System.out.printf("%d ", rep[i]);
	}
	System.out.println();
    }

    /**
     * \fn public void imprimirOrdens()
     *
     * \brief Metodo imprime as ordens dos conjuntos.
     */
    public void imprimirOrdens(){
	System.out.println("Ordem");
	for (int i = 0; i < tamLista; i++){
	    System.out.printf("%d ", ordem[i]);
	}
	System.out.println();	
    }

    /**
     * \fn public boolean compare(int i, int j)
     *
     * \brief Metodo que avalia se os representantes dos vertices i e j sao
     * iguais ou nao
     *
     * \param i e j - vertices que serao comparados.
     *
     * \return Verdadeiro se os vertices tem o mesmo representante e falso caso
     * contrario.
     */
    public boolean compare(int i, int j){
	if (findset(i) == findset(j)) return true;
	else return false;
    }

    /**
     * \fn public boolean union(int i, int j)
     *
     * \brief Metodo que une dois vertices.
     *
     * \param i e j - vertices que serao unidos.
     *
     * \return Verdadeiro se consegue realizar a uniao e falso caso contrario.
     */
    public boolean union(int i, int j, ListaAdjacencia l){
	if (!compare(i, j)){ //Se os representantes sao distintos
	    if (ordem[i] == ordem[j]){ //Ordens iguais
	        atualizaRepresentanteVertice(i, j);
		//Heuristica de União por Ordenacao
		//A ordem so e alterada quando as ordens sao iguais
		ordem[i]++;
		ordem[j]++;
	    }
	    else{ //Ordens distintas
	        //Heuristica de Uniao por Ordenacao
		//Aponta a arvore de menor ordem para a arvore de maior ordem.
		if (ordem[i] > ordem[j]){ //Ordem de i maior que ordem de j
		    //j devera se unir a i
		    atualizaRepresentanteVertice(j, i);
		}
		else{ //Ordem de j maior que ordem de i
		    //i devera se unir a j
		    atualizaRepresentanteVertice(i, j);
		}
	    }
	    return true;
	}
	else return false; //Se os representantes sao iguais
    }
}
