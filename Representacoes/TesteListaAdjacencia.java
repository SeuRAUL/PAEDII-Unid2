public class TesteListaAdjacencia{
    public static void main(String[] args){
			ListaAdjacencia obj = new ListaAdjacencia();
			obj.iniciaListaDeAdjacencia(5);
			//Adicionando arestas sem custo na lista e sem orientacao
			obj.iniciaArestasDaLista(2, 3);
			//Adicionando arestas com custo e com orientacao na lista
			obj.iniciaArestasDaListaComPeso(2, 4, 20);
			obj.imprimirListaDeAdjacencia();
    }
}
