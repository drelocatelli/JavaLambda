package Entity;

public class CalculaIMC {

	private int id;
	private double peso;
	private double altura;

	public CalculaIMC(int id, double peso, double altura) {
		this.id = id;
		this.peso = peso;
		this.altura = altura;
	}

	public int getId() {
		return id;
	}

	public double imc() {
		return peso / (altura * altura);
	}

	public String classificacao(double calculo) {
		if(calculo < 18.5) {
			return "Abaixo do peso";
		}else if(calculo >= 18.6 && calculo <= 24.5) {
			return "Peso ideal";
		}else if(calculo >= 25 && calculo <= 29.9) {
			return "Levemente acima do peso";
		}else if(calculo >= 30 && calculo <= 34.8) {
			return "Obesidade grau 1";
		}else if(calculo >= 35 && calculo <= 39) {
			return "Obesidade grau 2 (severa)";
		}else if(calculo > 40) {
			return "Obesidade grau 3 (mórbida)";
		}else {
			return "Não foi possível classificar";
		}
	}

}
