import representacoes.*; //MatrizAdjacencia.java e ListaAdjacencia.java
import conjuntosDisjuntos.*; //ConjuntosDisjuntos.java
public class TesteKruskal{
    public static void main(String[] args){
			ListaAdjacencia obj = new ListaAdjacencia();

			

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
