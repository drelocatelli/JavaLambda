import Entity.Pessoa;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {

		// pessoas
		Pessoa[] pessoa = new Pessoa[6];
		pessoa[0] = new Pessoa("João", 50, 1.60);
		pessoa[1] = new Pessoa("Maria", 100, 1.80);
		pessoa[2] = new Pessoa("Joana", 65, 1.70);
		pessoa[3] = new Pessoa("Sérgio", 180, 1.70);
		pessoa[4] = new Pessoa("Fernanda", 189, 1.50);
		pessoa[5] = new Pessoa("Andressa", 50, 1.65);

		// calculo
		for(int i = 0; i < pessoa.length; i++) {
			System.out.printf("[%s] \n", pessoa[i].getNome());
			System.out.printf("Altura: %.2f \n", pessoa[i].getAltura());
			System.out.printf("Peso kg: %.2f \n", pessoa[i].getPeso());
			System.out.printf("IMC: %.2f \n", pessoa[i].imc());
			System.out.printf("Classificação: %s \n", pessoa[i].classificacao(pessoa[i].imc()));
			System.out.printf("Grau: %d \n\n", pessoa[i].getGrau());
		}

		System.out.println("Pessoas com obesidade grau 3 (mórbida): ");
		List<String> pessoasObesas = Arrays.asList(pessoa).stream()
				.filter(i -> i.getGrau() == 5)
				.map(Pessoa::getNome)
				.collect(Collectors.toList());
		System.out.println(pessoasObesas);

		System.out.println("Pessoas abaixo do peso:");
		List<String> pessoasAbaixoPeso = Arrays.asList(pessoa).stream()
				.filter(i -> i.getGrau() == 0)
				.map(Pessoa::getNome)
				.collect(Collectors.toList());
		System.out.println(pessoasAbaixoPeso);

		System.out.println("Pessoas com peso ideal:");
		List<String> pessoasPesoIdeal = Arrays.asList(pessoa).stream()
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
