package numeros_soma;

/*
 * Nessa solu��o, eu coloco dentro de um array os n�meros desejados e ap�s isso 
 * fa�o a valida��o da soma m�xima.
 * 
 * Instru��es: digite o numero e aperte "enter" para poder digitar o pr�ximo n�mero,
 * no final digite 0 para finalizar o programa e mostrar o resultado.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class testesomanumeros 
{

private static Scanner scanner;
	
	public static void main(String[] args) 
	{
		Integer numero = 0;
		ArrayList<Integer> sequencia = new ArrayList<>();
		
		System.out.println("Digite um n�mero inteiro e digite '0' para parar: ");
		
		//Aqui � preenchido o conjunto de inteiros
		do
		{
			scanner = new Scanner(System.in);
			
			//Inclui o numero desejado na sequencia at� o usuario digitar 0
			try 
			{
				numero = scanner.nextInt();
				
				if(numero != 0)
					sequencia.add(numero);
			} 
			//Mensagem caso o usuario digite outro caracter
			catch (InputMismatchException e) 
			{
				scanner.nextLine();
				System.out.println("Digite apenas n�meros Inteiros!!");
			}			
			
			//Valida��o de conjunto vazio
			if(numero == 0  && sequencia.isEmpty()) 
			{
				System.out.println("N�o pode sair com o conjunto vazio!!");
				numero = 0;
			}
			
		}
		while(numero != 0);
				
		System.out.println(subconjuntoSomaMaxima(sequencia));

	}

	private static ArrayList<String> subconjuntoSomaMaxima(ArrayList<Integer> subsommax) 
	{
		/**M�todo que recebe o conjunto de n�meros e retorna o subconjunto identificado por '**'
		 * param s - (Conjunto de inteiros)
		 * return sub - (Resultado com a identifica��o do subconjunto)
		 */
		
		ArrayList<String> sub = new ArrayList<>();
		int maxTotal, maxAtual, indX, indI, indF;
		maxAtual = 0;
		maxTotal = 0;
		indX = 0; 
		indI = 0;
		indF = 0;	
		
		for(int i = 0; i < subsommax.size(); i++) 
		{
			maxAtual = maxAtual + subsommax.get(i);
			
			//Se o resultado da soma for menor que a posi��o atual, atualiza o �ndice do subconjunto
			if(subsommax.get(i) > maxAtual) 
			{
				maxAtual = subsommax.get(i);
				indX = i;			
			}				
			
			//Atualiza a soma total e seus �ndices no array
			if(maxAtual > maxTotal) 
			{
				maxTotal = indX;
				indI = indX;
				indF = i;
			}
			
			sub.add(subsommax.get(i).toString());
		}		
		
		//Edita a posi��o inicial e final do subconjunto dentro do array
		sub.set(indI, "**" + subsommax.get(indI).toString());
		sub.set(indF, subsommax.get(indF).toString() + "**");
		
		return sub;
	}

}
