package br.com.jogogourmet.entity;


public class Prato
{

    private int id;
    private String nome;
    private String tipo;
    private String categoria;

    public Prato()
    {
    }

    public Prato(int id, String nome, String tipo)
    {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }
    
    public Prato(int id, String nome, String tipo, String categoria)
    {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
    
}
