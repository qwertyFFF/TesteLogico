package sequencia_letras;

/*
 * Aqui, resolvi utilizar a classe palavra para percorrer a palavra digitada pelo
 * usu�rio e verificar desde o indice 0 at� o final da palavra quantas letras 
 * repetidas possui a palavra em si 
 */

public class ContaLetras 
{
	
	private String palavra;

	public ContaLetras(String palavra) 
	{
		this.palavra = palavra;
	}

	public String getPalavra() 
	{ 
		return palavra; 
	}

	public void setPalavra(String palavra) 
	{ 
		this.palavra = palavra; 
	}
	
	public int tamanhoPalavra() 
	{ 
		return this.palavra.length()-1;	
	}
	
	public char letraPalavra(int i) 
	{
	/*M�todo que retorna o car�cter que se encontra no �ndice desejado.
	 * param i - inteiro referente ao index.
	 * return c - char da posi��o requerida.  
	 */
		
		if(i == tamanhoPalavra()) 
		{
			if(this.palavra.charAt(i) == '*') 
			{
				return '#';
			}
			else 
			{
				return '*';		
			}
		}
		
		char c = this.palavra.charAt(i);
		return c;
	}
}
