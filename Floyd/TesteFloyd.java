//import floyd.*;
public class TesteFloyd {
	public static void main(String[] args) {
		Floyd floyd = new Floyd(6);

		//grafo do slide
		floyd.adicionarAresta(0,1,8);
		floyd.adicionarAresta(0,3,3);
		floyd.adicionarAresta(0,4,3);

		floyd.adicionarAresta(1,0,8);
		floyd.adicionarAresta(1,2,5);
		floyd.adicionarAresta(1,4,2);

		floyd.adicionarAresta(2,1,5);
		floyd.adicionarAresta(2,4,5);
		floyd.adicionarAresta(2,5,3);

		floyd.adicionarAresta(3,0,3);
		floyd.adicionarAresta(3,4,2);

		floyd.adicionarAresta(4,0,3);
		floyd.adicionarAresta(4,1,2);
		floyd.adicionarAresta(4,2,5);
		floyd.adicionarAresta(4,3,2);
		floyd.adicionarAresta(4,5,4);
		//\grafo do slide

		floyd.printMatriz();
	}
}