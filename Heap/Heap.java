/**
 * \file Heap.java
 *
 * \brief Definicao da classe da lista de prioridade.
 *
 * \author Petrucio Ricardo Tavares de Medeiros
 * Raul Lucena e Silva
 *
 * \version 1.0
 */

import java.util.Vector; // Vector para a heap

/**
 * \class Heap
 *
 * \brief A classe da lista de prioridade.
 */
public class Heap {
    
    public static void main(String[] args){
        min_max = 1;
        
        Heap heap = new Heap();
        
        heap.heap.add(null); // 1ª posição nula
        
        heap.insert(3, 5);
        heap.insert(5, 8);
        heap.insert(8, 2);
        heap.insert(7, 9);
        heap.extract();
        heap.increase(8, 6);
        heap.extract();
        heap.extract();
    }
    
    //--------------------------------------------------------------------
    //                       Atributos Privado
    //--------------------------------------------------------------------
    static byte min_max = 0; // 0 = ainda não definido, 1 p/ max e -1 para min;
    private Vector<No> heap = new Vector<No>();
    /**
     * \class No
     *
     * \brief A classe do tipo do Array.
     */
    
    
    private class No{
        //--------------------------------------------------------------------
        //                       Atributos Privado
        //--------------------------------------------------------------------
        private int id, chave;
        //--------------------------------------------------------------------
        //                       Metodos privados
        //--------------------------------------------------------------------
        /**
         * \fn private No(int id, int chave)
         *
         * \brief Metodo construtor da classe No.
         *
         * \param id - atribui id ao objeto
         * chave - atribui chave ao objeto
         */
        private No(int id, int chave){
            this.id = id;
            this.chave = chave;
        }
        /**
         * \fn private int getId()
         *
         * \brief Metodo que retorna o valor da ID.
         */
        private int getId(){return this.id;}
        /**
         * \fn private int getChave()
         *
         * \brief Metodo que retorna o valor da Chave.
         */
        private int getChave(){return this.chave;}
    }
    
    //--------------------------------------------------------------------
    //                       Metodos privados
    //--------------------------------------------------------------------
    /**
     * \fn public void insert(int id, int chave)
     *
     * \brief Metodo que insere elemento da heap.
     *
     * \param id - posição a inserir Array
     * chave - valor guardado na posição
     */
    public void insert(int id, int chave){

        No no = new No(id, chave);
        heap.add(no);
        int ultimaPosicao = heap.size() - 1;
        heapify(ultimaPosicao);
        System.out.println("Add "+ id + " " + chave);
    }
    
    /**
     * \fn private void heapify(int posicao)
     *
     * \brief Metodo que ordena as prioridades da heap.
     *
     * \param posicao - posição a ordenar
     */
    private void heapify(int posicao){
            
        int pai = posicao/2;
        if (pai > 0){ // Pai existe
            if (min_max == 1){ // maxHeapify
                No posicao_ = heap.get(posicao);
                if (heap.get(pai).getChave() < posicao_.getChave()){
                    trocarNo(posicao, pai);
                    
                    heapify(pai);
                }
            }
            else if(min_max == -1){ // minHeapify
                if (heap.get(pai).getChave() > heap.get(posicao).getChave()){
                    trocarNo(posicao, pai);
                    
                    heapify(pai);
                }
            }
        }
    } 

    /**
     * \fn public void extract()
     *
     * \brief Metodo que extrai a prioridade.
     */
    public void extract(){

        
        System.out.println("Extraiu: " + heap.get(1).chave);
        int ultimaPosicao = heap.size() - 1;
       
        No aux = heap.get(ultimaPosicao);
        
        heap.remove(ultimaPosicao);
        heap.set(1, aux);
        
        descer(1);
        
    }
    
    /**
     * \fn private void descer(int posicao)
     *
     * \brief Metodo que desce o no da raiz para reaustá-lo à prioridade.
     * 
     * \param posicao - informa a posição do no a descer. Função recursiva.
     */
    private void descer(int posicao){
        int filhoE = -1;
        if ((posicao * 2) < heap.size()) {
        	filhoE = posicao * 2;
        }
        int filhoD = -1;
        if ((posicao * 2)+1 < heap.size()) {
        	filhoD = (posicao * 2) + 1;
        }
        
        if ( (filhoE > 0) && (filhoD > 0) ){
            if (min_max == 1){ // maxHeapify
                if (heap.get(filhoE).getChave() > heap.get(filhoD).getChave()){
                    trocarNo(posicao, filhoE);
                    descer(filhoE);
                }
                else{
                    trocarNo(posicao, filhoD);
                    descer(filhoD);
                }
            }
            else if (min_max == -1){ // minHeapify
                if (heap.get(filhoE).getChave() < heap.get(filhoD).getChave()){
                    trocarNo(posicao, filhoE);
                    descer(filhoE);
                }
                else{
                    trocarNo(posicao, filhoD);
                    descer(filhoD);
                }
            }
        }
        else if (filhoE > 0){
        	trocarNo(posicao, filhoE);
            descer(filhoE);
        }
    }
    
    /**
     * \fn private void trocarNo(int no1, int no2)
     *
     * \brief Metodo que troca a posição de dois nós no Array.
     * 
     * \param no1 - index do 1º nó a ser trocado.
     * no2 - index do 2º nó a ser trocado.
     */
    private void trocarNo(int no1, int no2){
        No aux = heap.get(no1);
        heap.set(no1, heap.get(no2));
        heap.set(no2, aux);
    }
    
    /**
     * \fn private boolean verificarId(int id)
     *
     * \brief Metodo que verifica se algum nó da heap possui o id passado e retorna a posição.
     * 
     * \param id - id a verificar.
     */
    private int verificarId(int id){
        for(int i = 1 ; i < heap.size() ; i++ ){
            if( heap.get(i).getId() == id ) {
                return i;
            }
        }
        return 0;
    }

    /**
     * \fn public decrease(int id, int chave)
     *
     * \brief Metodo que altera elemento da heap mínima.
     *
     * \param id - posição a mudar na heap
     * chave - novo valor a inserir na posição do id
     */
    public void decrease(int id, int chave){

        if(min_max != -1){ // para decrease() a heap tem que ser mínima 
            System.out.println("notupdated");
            return;
        }

        int posicao = verificarId(id);

        if (posicao > 0){
            if(heap.get(posicao).getChave() > chave){
                No no = new No(id, chave);

                heap.set(posicao, no);
                heapify(posicao);
            }
            else{
                System.out.println("notupdated");
            }
        }
    }

    /**
     * \fn public increase(int id, int chave)
     *
     * \brief Metodo que altera elemento da heap máxima.
     *
     * \param id - posição a mudar na heap
     * chave - novo valor a inserir na posição do id
     */
    public void increase(int id, int chave){

        if(min_max != 1){ // para increase() a heap tem que ser máxima 
            System.out.println("notupdated");
            return;
        }

        int posicao = verificarId(id);

        if (posicao > 0){
            if(heap.get(posicao).getChave() < chave){
                No no = new No(id, chave);

                heap.set(posicao, no);
                
                System.out.println("Increased " + id + " para: " + chave);
                heapify(posicao);
            }
            else{
                System.out.println("notupdated");
            }
        }
    }
}