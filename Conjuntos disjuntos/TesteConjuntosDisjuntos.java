import representacoes.*; //MatrizAdjacencia.java e ListaAdjacencia.java
public class TesteConjuntosDisjuntos{
    public static void main(String[] args){
			ListaAdjacencia obj = new ListaAdjacencia();
			ConjuntosDisjuntos obj1 = new ConjuntosDisjuntos(obj);

			try {
        	// Entrada
			    FileReader arqIn = new FileReader("testes/conjuntos1.in");
			    BufferedReader lerArq = new BufferedReader(arqIn);
			    
			    // Saída
			    FileWriter arqOut = new FileWriter("testes/saida1.txt");
			    PrintWriter gravarArq = new PrintWriter(arqOut);
  
        	String linha = lerArq.readLine(); // lê a primeira linha
			  
        	obj.iniciaListaDeAdjacencia(Integer.parseInt(linha));
          
        	while (linha != null) { // a variável "linha" recebe o valor "null" quando o processo de repetição atingir o final do arquivo texto
	    
	        	  linha = lerArq.readLine(); // lê da segunda até a última linha
	        	  String params[] = linha.split(" ");
	        	  
	        	  if (params[0].contains("union")){
	        	  	obj1.union( Integer.parseInt(params[1]) ,Integer.parseInt(params[2]), obj);
	        	  	gravarArq.println("-");
	        	  }
	        	  else if (params[0].contains("compare")){
	        	  	if (obj1.compare(Integer.parseInt(params[1]) ,Integer.parseInt(params[2]))){
	        	  		gravarArq.println("true");
	        	  	} else {
	        	  		gravarArq.println("false");
	        	  	}
	        	  }
        	}
          
        	lerArq.close();
          gravarArq.close();
          
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }
			
			/*obj.iniciaListaDeAdjacencia(5);
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
			System.out.println("-----------");*/
    }
}
