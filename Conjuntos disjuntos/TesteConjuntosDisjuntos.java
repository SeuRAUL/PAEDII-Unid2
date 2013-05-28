import representacoes.*; //MatrizAdjacencia.java e ListaAdjacencia.java
public class TesteConjuntosDisjuntos{
    public static void main(String[] args){
	ListaAdjacencia obj = new ListaAdjacencia();
	obj.iniciaListaDeAdjacencia(5);
	ConjuntosDisjuntos obj1 = new ConjuntosDisjuntos(obj);
	obj1.imprimirRepresentantes();
	obj1.imprimirOrdens();
	System.out.println("-----------");
	obj1.union(0,1,obj);
	obj1.imprimirRepresentantes();
	obj1.imprimirOrdens();
	System.out.println("-----------");
	obj1.union(0,2,obj);
	obj1.imprimirRepresentantes();
	obj1.imprimirOrdens();
	System.out.println("-----------");
	obj1.union(3,4,obj);
	obj1.imprimirRepresentantes();
	obj1.imprimirOrdens();
	System.out.println("-----------");
	if (obj1.compare(0,2) == true){
	    System.out.println("Estao no mesmo conjunto");
	}
	else System.out.println("Nao estao no mesmo conjunto");
	obj1.imprimirRepresentantes();
	obj1.imprimirOrdens();
	System.out.println("-----------");
    }
}
