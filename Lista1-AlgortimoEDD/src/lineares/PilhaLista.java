package lineares;

public class PilhaLista<F> implements Pilha<F>
{
	private ListaEncadeada lista;

	PilhaLista()
	{
		lista = new ListaEncadeada(); 
	}
	
	@Override
	public void push(F info) 
	{
		lista.inserir(info);
	}

	@Override
	public F pop()
	{
		F valor = (F) lista.pegar(lista.getTamanho() - 1);
		lista.retirar(valor);
		
		return valor;
	}

	@Override
	public F peek()
	{
		return (F) lista.pegar(lista.getTamanho() - 1);
	}

	@Override
	public boolean estaVazia()
	{
		return lista.getTamanho() == 0;
	}

	@Override
	public void liberar()
	{
		
	}
}
