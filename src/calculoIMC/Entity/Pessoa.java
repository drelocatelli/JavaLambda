package Entity;

public class Pessoa extends CalculaIMC {

	private String nome;
	private double peso;
	private double altura;

	public Pessoa(String nome, double peso, double altura) {
		super(peso, altura);
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

	@Override
	public String toString() {
		return "Pessoa{" +
				"nome='" + nome + '\'' +
				", peso=" + peso +
				", altura=" + altura +
				", IMC=" + String.format("%.2f", imc()) +
				", classificação=" + classificacao() +
				'}';
	}
}
