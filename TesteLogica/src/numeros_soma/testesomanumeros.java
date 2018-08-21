package numeros_soma;

/*
 * Nessa solução, eu coloco dentro de um array os números desejados e após isso 
 * faço a validação da soma máxima.
 * 
 * Instruções: digite o numero e aperte "enter" para poder digitar o próximo número,
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
		
		System.out.println("Digite um número inteiro e digite '0' para parar: ");
		
		//Aqui é preenchido o conjunto de inteiros
		do
		{
			scanner = new Scanner(System.in);
			
			//Inclui o numero desejado na sequencia até o usuario digitar 0
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
				System.out.println("Digite apenas números Inteiros!!");
			}			
			
			//Validação de conjunto vazio
			if(numero == 0  && sequencia.isEmpty()) 
			{
				System.out.println("Não pode sair com o conjunto vazio!!");
				numero = 0;
			}
			
		}
		while(numero != 0);
				
		System.out.println(subconjuntoSomaMaxima(sequencia));

	}

	private static ArrayList<String> subconjuntoSomaMaxima(ArrayList<Integer> subsommax) 
	{
		/**Método que recebe o conjunto de números e retorna o subconjunto identificado por '**'
		 * param s - (Conjunto de inteiros)
		 * return sub - (Resultado com a identificação do subconjunto)
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
			
			//Se o resultado da soma for menor que a posição atual, atualiza o índice do subconjunto
			if(subsommax.get(i) > maxAtual) 
			{
				maxAtual = subsommax.get(i);
				indX = i;			
			}				
			
			//Atualiza a soma total e seus índices no array
			if(maxAtual > maxTotal) 
			{
				maxTotal = indX;
				indI = indX;
				indF = i;
			}
			
			sub.add(subsommax.get(i).toString());
		}		
		
		//Edita a posição inicial e final do subconjunto dentro do array
		sub.set(indI, "**" + subsommax.get(indI).toString());
		sub.set(indF, subsommax.get(indF).toString() + "**");
		
		return sub;
	}

}
