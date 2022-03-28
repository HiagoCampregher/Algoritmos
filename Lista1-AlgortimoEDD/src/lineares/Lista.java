package lineares;

public interface Lista<T>
{
	boolean estaVazia();
	int buscar(T valor);
	int getTamanho();
	T pegar(int pos);
	Lista<T> copiar();
	Lista<T> dividir();
	String exibir();	
	void concatenar(Lista<T> outro);	
	void inserir(T valor);	
	void inserir(T valor, int pos);
	void retirar(T valor);
}
