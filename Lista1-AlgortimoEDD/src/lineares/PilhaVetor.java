	package lineares;
	
	public class PilhaVetor<T> implements Pilha<T>
	{
		public T info[];
		public int limite = 0;
		public int tamanhoAtual = 0;
		
		PilhaVetor(int limiteFornecido)
		{
			info = (T[]) new Object[limiteFornecido];
			limite = limiteFornecido;
		}
		
		@Override
		public void push(T info)
		{
			if (tamanhoAtual == limite)
				throw new IllegalArgumentException("Limite atingido!");
			
			this.info[tamanhoAtual] = info;
			++tamanhoAtual;
		}
		
		@Override
		public T pop()
		{
			T valor = peek();
			--tamanhoAtual;
			info[tamanhoAtual] = null;
			return valor;
		}
		
		@Override
		public T peek()
		{
			if (estaVazia())
				throw new IllegalArgumentException("Esta Vazia!");
			
			return info[tamanhoAtual - 1];
		}
		
		@Override
		public boolean estaVazia()
		{
			return tamanhoAtual == 0;
		}
		
		@Override
		public void liberar()
		{
			info = (T[]) new Object[this.limite];
			tamanhoAtual = 0;
		}
	}
