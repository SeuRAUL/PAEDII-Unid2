import representacoes.*; //MatrizAdjacencia.java e ListaAdjacencia.java
public class TesteBFS{
    public static void main(String[] args){
	MatrizAdjacencia obj = new MatrizAdjacencia();
	BFS obj1 = new BFS();
	obj.iniciaMatrizDeAdjacencia(5);
	// obj.iniciaArestasDaMatriz(0, 1);
	// obj.iniciaArestasDaMatriz(1, 2);
	// obj.iniciaArestasDaMatriz(2, 3);
	// obj.iniciaArestasDaMatriz(3, 4);
	// obj.iniciaArestasDaMatriz(4, 3);
	// obj.iniciaArestasDaMatriz(3, 2);
	// obj.iniciaArestasDaMatriz(2, 1);
	// obj.iniciaArestasDaMatriz(1, 0);
	
	// obj.iniciaArestasDaMatriz(0, 1);
	// obj.iniciaArestasDaMatriz(1, 0);
	// obj.iniciaArestasDaMatriz(2, 1);
	// obj.iniciaArestasDaMatriz(1, 2);
	// obj.iniciaArestasDaMatriz(2, 3);
	// obj.iniciaArestasDaMatriz(3, 2);
	// obj.iniciaArestasDaMatriz(3, 4);
	// obj.iniciaArestasDaMatriz(4, 3);

	obj.iniciaArestasDaMatriz(0, 2);
	obj.iniciaArestasDaMatriz(2, 4);
	obj.iniciaArestasDaMatriz(4, 3);
	obj.iniciaArestasDaMatriz(3, 1);
	obj.iniciaArestasDaMatriz(2, 0);
	obj.iniciaArestasDaMatriz(4, 2);
	obj.iniciaArestasDaMatriz(3, 4);
	obj.iniciaArestasDaMatriz(1, 3);

	obj.imprimirMatrizDeAdjacencia();
	obj1.Bfs(0,1,obj);
    }
}
