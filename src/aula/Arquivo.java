package aula;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	
	public void inserir(String texto) throws IOException {
		//Gravação
		 FileWriter arq = new FileWriter("d:\\teste.txt",true);
		 PrintWriter gravarArq = new PrintWriter(arq);
		 
		 gravarArq.println(texto); 

		 arq.close();
	}
	
	public void leitura(String texto) throws IOException {
		//Leitura
		 FileReader arqleitura = new FileReader("d:\\teste.txt");
		 BufferedReader lerArq = new BufferedReader(arqleitura);
	 
	     String linha = lerArq.readLine(); 
	     int i = 0;
	     
	     while (linha != null) {
	    	 i++;
	    	 if(linha.contains(texto)) {
	    		 System.out.println("linha: " + i + " conteúdo: " + linha); 
	    	 } 
	    	 linha = lerArq.readLine();
	     }
	     
	     arqleitura.close();
	}
	
	public void atualizar(String texto, String textNew) throws IOException {
		//Leitura
		//instancia os dois arquivos
		 File arq1 = new File("d:\\teste.txt");
		 File arq2 = new File("d:\\teste1.txt");
		 // metodo para ler os arquivos
		 FileReader arqleitura = new FileReader(arq1);
		 BufferedReader lerArq = new BufferedReader(arqleitura);
		 //metodo para gravar os arquivos
		 FileWriter arq = new FileWriter(arq2,true);
		 PrintWriter gravarArq = new PrintWriter(arq);
		 //quebra de linha
		 String qbtxt = System.getProperty("line.separator");
	     
		 String linha = lerArq.readLine();
	     
		 int i = 0;
	     String textOld = "";
		//lê o arquivo teste(arq1), altera o que foi pedido e imprime o arquivo teste1(arquivo 2) 
	     while (linha != null) {
	    	 i++;
	    	
	    	 if(linha.contains(texto)) {
	    		 textOld += textNew + qbtxt;
	    	 }else {
	    		 textOld += linha + qbtxt;
	    	 }
	    	 linha = lerArq.readLine();
	     }
	     gravarArq.println(textOld); 
	     System.out.println(textOld);
		 arqleitura.close();
		 arq.close();
		 //deleta o arq 1 (teste originalmente criado), e renomeia o arq2 para teste
		 arq1.delete();
		 arq2.renameTo(arq1);
	}
	
	//faz a mesma coisa que o atualizar, porém não adiciona a linha pesquisa no novo arquivo
	public void deletar(String texto) throws IOException {
		 File arq1 = new File("d:\\teste.txt");
		 File arq2 = new File("d:\\teste1.txt");
		 FileReader arqleitura = new FileReader(arq1);
		 BufferedReader lerArq = new BufferedReader(arqleitura);
		 FileWriter arq = new FileWriter(arq2,true);
		 PrintWriter gravarArq = new PrintWriter(arq);
		 String qbtxt = System.getProperty("line.separator");
	     String linha = lerArq.readLine();
	     int i = 0;
	     String textOld = "";
		
	     while (linha != null) {
	    	 i++;
	    	
	    	 if(linha.contains(texto)) {
	    	 }else {
	    		 textOld += linha + qbtxt;
	    	 }
	    	 linha = lerArq.readLine();
	     }
	     gravarArq.println(textOld); 
	     System.out.println(textOld);
		 arqleitura.close();
		 arq.close();
		 arq1.delete();
		 arq2.renameTo(arq1);
	}
	
	public static void main(String args[]) throws Exception {
		Arquivo arq = new Arquivo();
		//arq.inserir("Amanda");
		arq.leitura("João");
		//arq.atualizar("Amanda","Amarelo");
		//arq.deletar("Amarelo");
	}
}