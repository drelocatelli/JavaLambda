package Entity;

public class Pessoa extends CalculaIMC {

	private int id;
	private String nome;
	private double peso;
	private double altura;

	public Pessoa(int id, String nome, double peso, double altura) {
		super(id, peso, altura);
		this.nome = nome;
		this.peso = peso;
		this.altura = altura;
	}

	public String getNome() {
		return nome;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}

}
