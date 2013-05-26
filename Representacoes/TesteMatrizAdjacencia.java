public class TesteMatrizAdjacencia{
    public static void main(String[] args){
	MatrizAdjacencia obj = new MatrizAdjacencia();
	obj.iniciaMatrizDeAdjacencia(5);
	obj.iniciaArestasDaMatriz(1, 2);
	obj.iniciaArestasDaMatriz(4, 3);
	obj.iniciaArestasDaMatrizComPeso(2, 3, 5);
	obj.imprimirMatrizDeAdjacencia();
    }
}
