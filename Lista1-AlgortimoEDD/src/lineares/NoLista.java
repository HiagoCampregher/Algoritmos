package lineares;

public class NoLista<F> {
	private F info;
	private NoLista prox;
	
	public F getInfo()
	{
		return info;
	}
	
	public void setInfo(F info)
	{
		this.info = info;
	}
	
	public NoLista getProx()
	{
		return prox;
	}
	
	public void setProx(NoLista prox)
	{
		this.prox = prox;
	}
}
