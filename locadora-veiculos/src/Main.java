import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	// Funções 
	public static String RetornaCarroClienteNormal(Integer NumPessoas,String Datas){			
		 String[] RegistroData;
	      String DiaSemana;
	      float TotalCarroCompacto = 0.00f;
	      float TotalCarroSport    = 0.00f;
	      float TotalCarroSUV      = 0.00f;
	      String DetalhesTotais    = "";
	      String TextoMelhorCarro  = "";
	      
	      RegistroData = Datas.split(","); //Pegando os dias informados  sepradados por ','      
		  for(int i = 0;i<RegistroData.length;i++){			
			DiaSemana = RegistroData[i];	
			DiaSemana = DiaSemana.substring(11, 14);

			if (DiaSemana.toUpperCase().equals("SAB") || DiaSemana.toUpperCase().equals("DOM")) {
				
				TotalCarroCompacto = (TotalCarroCompacto+200f);
				TotalCarroSport    = (TotalCarroSport+200f);
				TotalCarroSUV      = (TotalCarroSUV+600f);
			}
			else {
				if  (DiaSemana.toUpperCase().equals("SEG") || DiaSemana.toUpperCase().equals("TER") ||
	  				 DiaSemana.toUpperCase().equals("QUA") || DiaSemana.toUpperCase().equals("QUI")	||
	  				 DiaSemana.toUpperCase().equals("SEX") ) {
					TotalCarroCompacto = (TotalCarroCompacto+150f);
					TotalCarroSport    = (TotalCarroSport+150f);
					TotalCarroSUV      = (TotalCarroSUV+580f);
				}
				else {
					TextoMelhorCarro = "Erro ao ler entrada de datas para locação!";
				}
			}
		 }
		  if (NumPessoas<3) {
			if (TotalCarroCompacto>0 ||TotalCarroSport>0 || TotalCarroSUV>0 ) {  
		        DetalhesTotais = (
		        		"Total Carro Compcto: "+TotalCarroCompacto+
		        		"\nTotal Carro Sport: "+TotalCarroSport+
		        		" \nTotal Carro SUV: "+TotalCarroSUV+"\n");
			}
	        if (TextoMelhorCarro == "") {
	          TextoMelhorCarro = "\nCarro sugerido: Carro Sport da loja WestCar\n"; 
	        }
	      }
		  else {
			  if (TotalCarroCompacto>0 ||TotalCarroSport>0 || TotalCarroSUV>0 ) {  
				  DetalhesTotais = (
			        		"Total Carro Compcto: "+TotalCarroCompacto+
			        		" \nTotal Carro SUV: "+TotalCarroSUV+"\n");
			  }
			  if (TextoMelhorCarro == "") {
			    TextoMelhorCarro = "\nCarro sugerido: Carro Compacto da loja SouthCar\n"; 
			  }
		  }
		  
		  return (DetalhesTotais+TextoMelhorCarro);
	}
	
	public static String RetornaCarroClientePremium(Integer NumPessoas,String Datas){   
      
      String[] RegistroData;
      String DiaSemana;
      float TotalCarroCompacto = 0.00f;
      float TotalCarroSport    = 0.00f;
      float TotalCarroSUV      = 0.00f;
      String DetalhesTotais    = "";
      String TextoMelhorCarro  = "";
      
      RegistroData = Datas.split(","); //Pegando os dias informados  sepradados por ','      
	  for(int i = 0;i<RegistroData.length;i++){			
		DiaSemana = RegistroData[i];	
		DiaSemana = DiaSemana.substring(11, 14);

		if (DiaSemana.toUpperCase().equals("SAB") || DiaSemana.toUpperCase().equals("DOM")) {
			
			TotalCarroCompacto = (TotalCarroCompacto+90f);
			TotalCarroSport    = (TotalCarroSport+90f);
			TotalCarroSUV      = (TotalCarroSUV+590f);
		}
		else {
			if  (DiaSemana.toUpperCase().equals("SEG") || DiaSemana.toUpperCase().equals("TER") ||
  				 DiaSemana.toUpperCase().equals("QUA") || DiaSemana.toUpperCase().equals("QUI")	||
  				 DiaSemana.toUpperCase().equals("SEX") ) {
				TotalCarroCompacto = (TotalCarroCompacto+150f);
				TotalCarroSport    = (TotalCarroSport+150f);
				TotalCarroSUV      = (TotalCarroSUV+580f);
			}
			else {
				TextoMelhorCarro = "Erro ao ler entrada de datas para locação!";
			}
		}
	 }
	  if (NumPessoas<3) {
       	if (TotalCarroCompacto>0 ||TotalCarroSport>0 || TotalCarroSUV>0 ) {    
	        DetalhesTotais = (
	        		"Total Carro Compcto: "+TotalCarroCompacto+
	        		"\nTotal Carro Sport: "+TotalCarroSport+
	        		" \nTotal Carro SUV: "+TotalCarroSUV+"\n");
        }
        if (TextoMelhorCarro == "") {
          TextoMelhorCarro = "\nCarro sugerido: Carro Sport da loja WestCar\n"; 
        }
      }
	  else {
		  if (TotalCarroCompacto>0 ||TotalCarroSport>0 || TotalCarroSUV>0 ) {  
			  DetalhesTotais = (
		        		"Total Carro Compcto: "+TotalCarroCompacto+
		        		" \nTotal Carro SUV: "+TotalCarroSUV+"\n");
		  }
		  if (TextoMelhorCarro == "") {
		    TextoMelhorCarro = "\nCarro sugerido: Carro Compacto da loja SouthCar\n"; 
		  }
	  }
	  
	  return (DetalhesTotais+TextoMelhorCarro);
	}
	
    public static String RetornaMelhorCarro(String TipoCliente,String NumPessoas,String Datas){
      String Retorno;	// Variável de retorno da função      
	  int pessoas;
	  
	  try {
		  pessoas = Integer.parseInt(NumPessoas); // Converto o parametro de tring para inteiro
	  } catch (NumberFormatException e) {	  
		  pessoas = 0;
  	  }      
      
      // Validando os tipos possíveis de cliente
      if (TipoCliente.toUpperCase().equals("NORMAL") || TipoCliente.toUpperCase().equals("PREMIUM") ) {    	 
	    if (pessoas <= 0 || pessoas > 7) { // Confiro se está entre o numero máximo de passageiros permitido  			
	      Retorno = "Erro ao ler entrada de passageiros! (Número máximo de passageiros deve ser 7)";  
	    }
        else {
          if (pessoas > 4) {
        	  Retorno = "SUV's da loja NorthCar (Apenas essa categoria disponível para mais de 4 pessoas pessoas) "; 
          }
          else {
		      if (TipoCliente.toUpperCase().equals("NORMAL")) {		    	  
		        Retorno = RetornaCarroClienteNormal(pessoas,Datas);
		      }
		      else {		    	  
		        Retorno = RetornaCarroClientePremium(pessoas,Datas);
		      }
	      }
	    }    	         	    
      }
      else {
        Retorno = "Tipo de cliente inválido! Tipo encontrado no arquivo: "+TipoCliente.toUpperCase();
      } 
            
      return Retorno;	
    }
    
    // Método principal
	public static void main(String[] args) {
			
		   //Declarações de variaveis
		    Scanner path = new Scanner(System.in);		 
		    String    tpCliente; // Criando variável do tipo de cliente
		    String    nPessoas;  // Criando variável do número de pessoas
		    String    Data;		 // Criando variável para receber as datas da locação 	
		 
		    System.out.printf("Digite o caminho do arquivo (.txt) de entrada:\n");
		    String nome = path.nextLine();
		    
	        try {
		      FileReader arq = new FileReader(nome); // Passando o conteúdo do arquivo para variavel arq
		      BufferedReader lerArq = new BufferedReader(arq); // Carregando o conteúdo da arq 
		      
		      
		      // a variável "linha" recebe o valor "null" quando o processo
		      // de repetição atingir o final do arquivo texto		      
		      String linha = lerArq.readLine(); // lendo a primeira linha		    
		      Integer Contador;
		      Contador = 0;
		      System.out.printf("\nCada linha do arquivo corresponde a 1 Registro.  \n\n");
		      while (linha != null) {
		        try {		          	
		    	  String[] Partes    = linha.split(":"); //Separando a linha onde tiver : 
		    	  tpCliente = Partes[0]; // Tipo Cliente recebe a primeira parte
			      nPessoas  = Partes[1]; // Numero Pessoas recebe a segunda parte
			      Data      = Partes[2]; // Data recebe a terceira parte			      
			      
			      Contador  = Contador+1;
			      System.out.printf("Registro nº: "+Contador);
			      
			      //Mostra o resultado da função para cada linha do arquivo
			      System.out.printf("\n"+RetornaMelhorCarro(tpCliente,nPessoas,Data)+"\n");
			      
				  /*System.out.printf("Cliente:"+tpCliente+"\n");
				  System.out.printf("Pessoas:"+nPessoas+"\n");
				  System.out.printf("Data"+Data+"\n");*/
			        
			     } catch (Exception f) {
			    	 System.err.printf("\n",f.getMessage()); 
			      }			      
		        
		        linha = lerArq.readLine(); // lendo da segunda até a última linha
		      }		      
		      arq.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
		 
		    System.out.println();
	}
	
}
