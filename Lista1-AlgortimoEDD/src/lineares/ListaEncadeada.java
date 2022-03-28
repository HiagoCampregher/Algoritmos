package lineares;

public class ListaEncadeada<F> implements Lista<F>
{
	private NoLista primeiro;
	private NoLista ultimo;
	private int qtdElementos;
	
	public boolean estaVazia()
	{
		return primeiro == null;
	}
	
	public int buscar(F valor)
	{
		int posicao = -1;
		NoLista aux = primeiro;
		
		while(aux != null)
		{
			++posicao;
			
			if (aux.getInfo() == valor)
				return posicao;
			
			aux = aux.getProx();
		}
		
		return posicao;
	}
	
	public int getTamanho()
	{
		return qtdElementos;
	}
	
	public F pegar(int pos)
	{
		if (pos >= getTamanho() || pos < 0)
			throw new IndexOutOfBoundsException("Index: " + pos + " fora do intervalo!");
			
		NoLista aux = primeiro;
		
		int posicao = 0;
		
		while(aux != null)
		{
			if (posicao == pos)
				return (F) aux.getInfo();
			
			aux = aux.getProx();
			++posicao;
		}
		
		return null;
	}
	
	public Lista<F> copiar()
	{
		ListaEncadeada novaLista = new ListaEncadeada();

		NoLista p = primeiro;

		while(p != null)
		{
			novaLista.inserir(p.getInfo());

			p = p.getProx();
		}

		return novaLista;
	}
	
	
	public Lista<F> dividir()
	{
		int qtd = getTamanho() / 2;
		
		ListaEncadeada novaLista = new ListaEncadeada();

		NoLista p = primeiro;

		int contador = 0;
		
		while(p != null)
		{
			++contador;
			if (contador > qtd)
				novaLista.inserir(p.getInfo());

			if (contador == qtd)
				ultimo = p;

			p = p.getProx();
		}
		
		ultimo.setProx(null);
		qtdElementos -= qtd;
		
		return novaLista;
	}
	
	public String exibir()
	{
		NoLista aux = primeiro;
		
		String sRetorno = "";
		
		while (aux != null)
		{
			sRetorno += aux.getInfo() + ", "; 
			
			aux = aux.getProx();
		}
		
		return sRetorno;
	}
	
	public void concatenar(Lista<F> outro)
	{
		for (int idx = 0; idx < outro.getTamanho(); ++idx)
			this.inserir(outro.pegar(idx));
	}
	
	public void inserir(F valor)
	{
		NoLista novo = new NoLista();
		novo.setInfo(valor);
		
		if (estaVazia())
			primeiro = novo;
		else
			ultimo.setProx(novo);
		
		ultimo = novo;
		++qtdElementos;
	}
	
	public void inserir(F valor, int pos)
	{
		NoLista aux = primeiro;
		
		int posicao = 0;
		
		NoLista novo = new NoLista();
		novo.setInfo(valor);
		
		while(aux != null)
		{
			if (posicao == pos)
			{
				NoLista proxAntes = aux.getProx();
				novo.setProx(proxAntes);
				aux.setProx(novo);
				
				++qtdElementos;
				
				return;
			}
				
			aux = aux.getProx();
			++posicao;
		}
	}
	
	public void retirar(F valor)
	{
		NoLista aux = primeiro;
		NoLista anterior = null;
		
		while(aux != null && aux.getInfo() != valor)
		{
			anterior = aux;
			aux = aux.getProx();
		}
		
		if (aux != null)
		{
			if(anterior == null)
				primeiro.setProx(aux.getProx());
			else
				anterior.setProx(aux.getProx());

			if (ultimo == aux)
				ultimo = anterior;
			
			--qtdElementos;
		}
	}
}
