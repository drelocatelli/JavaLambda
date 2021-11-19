import Entity.Pessoa;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {

		// pessoas
		Pessoa[] pessoas = {
			new Pessoa("João", 50, 1.60),
			new Pessoa("Maria", 100, 1.80),
			new Pessoa("Joana", 65, 1.70),
			new Pessoa("Sérgio", 180, 1.70),
			new Pessoa("Fernanda", 189, 1.50),
			new Pessoa("Andressa", 50, 1.65)
		};

		var pessoa = Arrays.asList(pessoas)
				.stream().map(Object::toString)
				.collect(Collectors.toList());

		System.out.println(pessoa + "\n");

		// calculo
		for(int i = 0; i < pessoas.length; i++) {
			System.out.printf("[%s] \n", pessoas[i].getNome());
			System.out.printf("Altura: %.2f \n", pessoas[i].getAltura());
			System.out.printf("Peso kg: %.2f \n", pessoas[i].getPeso());
			System.out.printf("IMC: %.2f \n", pessoas[i].imc());
			System.out.printf("Classificação: %s \n", pessoas[i].classificacao(pessoas[i].imc()));
			System.out.printf("Grau: %d \n\n", pessoas[i].getGrau());
		}

		System.out.println("Pessoas com obesidade grau 3 (mórbida): ");
		List<String> pessoasObesas = Arrays.asList(pessoas).stream()
				.filter(i -> i.getGrau() == 5)
				.map(Pessoa::getNome)
				.collect(Collectors.toList());
		System.out.println(pessoasObesas);

		System.out.println("Pessoas abaixo do peso:");
		List<String> pessoasAbaixoPeso = Arrays.asList(pessoas).stream()
				.filter(i -> i.getGrau() == 0)
				.map(Pessoa::getNome)
				.collect(Collectors.toList());
		System.out.println(pessoasAbaixoPeso);

		System.out.println("Pessoas com peso ideal:");
		List<String> pessoasPesoIdeal = Arrays.asList(pessoas).stream()
				.filter(i -> i.getGrau() == 1)
				.map(Pessoa::getNome)
				.collect(Collectors.toList());
		System.out.println(pessoasPesoIdeal);

	}

	public static String amount(double value) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return "R$ " +decimalFormat.format(value);
	}

}
