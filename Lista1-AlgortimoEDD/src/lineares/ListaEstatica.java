package lineares;

public class ListaEstatica<F> implements Lista<F> {
	private F[] info;
	private int tamanho;

	public ListaEstatica() {
		info = (F[]) new Object[10];
		tamanho = 0;
	}

	@Override
	public void inserir(F valor) {
		if (tamanho == info.length) {
			this.redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}

	private void redimensionar() {
		F[] novo = (F[]) new Object[tamanho + 10];
		for (int i = 0; i < tamanho; i++) {
			novo[i] = info[i];
		}
		info = novo;
	}

	@Override
	public String exibir() {
		String resultado = "[";
		for (int i = 0; i < tamanho; i++) {
			resultado += info[i] + ", ";
		}
		return resultado + "]";
	}

	@Override
	public int buscar(F valor) {
		for (int i = 0; i < tamanho; i++) {
			if (info[i].equals(valor)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean estaVazia() {
		return (tamanho == 0);
	}

	@Override
	public void retirar(F valor) {
		int posicao = this.buscar(valor);

		if (posicao != -1) {
			for (int idx = posicao; idx < tamanho - 1; idx++) {
				info[idx] = info[idx + 1];
			}
			tamanho--;
		}
	}

	@Override
	public Lista<F> copiar() {
		Lista<F> novaLista = new ListaEstatica<>();

		for (int idx = 0; idx < tamanho; idx++)
			novaLista.inserir(info[idx]);

		return novaLista;
	}

	@Override
	public void concatenar(Lista<F> outraLista) {
		for (int idx = 0; idx < outraLista.getTamanho(); idx++)
			this.inserir(outraLista.pegar(idx)); 
	}

	@Override
	public int getTamanho() {
		return this.tamanho;
	}

	@Override
	public Lista<F> dividir() {
		Lista<F> novaLista = new ListaEstatica<>();

		int tamanhoOriginal = tamanho;
		int metadeLista = tamanho / 2;

		for (int idx = metadeLista; idx < tamanhoOriginal; idx++)
			novaLista.inserir(info[idx]);

		this.tamanho = metadeLista;

		return novaLista;
	}

	@Override
	public F pegar(int posicao) {
		return info[posicao];
	}

	@Override
	public void inserir(F valor, int pos) {
		// TODO Auto-generated method stub
		
	}
}