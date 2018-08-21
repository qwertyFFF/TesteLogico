package sequencia_letras;

/*
 * Aqui, na main da aplicação, entro com a palavra desejada e utilizo um metodo
 * para mostrar as letras repetidas da palavra.
 * 
 * Intruções: digite a palavra desejada com varias letras repetidas em sequencia,
 * após isso tecle "enter" para mostrar o resultado.
 */

import java.util.Scanner;

public class TesteSequencia 
{
	private static Scanner scanner;

	public static void main(String[] args) 
	{
		String palavra;
		
		//Usuario digita a palavra desejada
		System.out.println("Entre com a palavra desejada: ");
		scanner = new Scanner(System.in);
		palavra = scanner.nextLine(); 
		
		//Cria uma nova palavra no objeto
		ContaLetras p = new ContaLetras(palavra);
		
		//Chama o método sequenciaCaracteres e imprime o resultado retornado
		System.out.println(sequenciaCaracteres(p));		
	}
	
	public static String sequenciaCaracteres(ContaLetras pa) 
	{
	/* Método que retorna a sequência de caracteres que mais aparecem.
	 * param pa - Objeto do tipo Palavra
	 * return sequencia - String de caracteres. 
	 */
		
		String aux, sequencia = "";
		
		//Percorre toda a palavra para mostrar as letras repetidas
		for(int j = 0; j < pa.tamanhoPalavra(); j++) 
		{
			//Recebe o primeiro caractér
			aux = Character.toString(pa.letraPalavra(j));
			
			//Alimenta a sequência de caracteres repetidos
			while(pa.letraPalavra(j) == pa.letraPalavra(j+1)) 
			{				
				aux += pa.letraPalavra(j+1);
				j++;				
			}
			
			//Substitue a sequência menor pela maior
			if(aux.length() > sequencia.length()) 
			{
				sequencia = aux;
			}			
		}		
		
		return sequencia;
	}

}
