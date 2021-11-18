import Entity.Pessoa;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {

		// pessoas
		Pessoa[] pessoa = new Pessoa[6];
		pessoa[0] = new Pessoa(1,"João", 50, 1.60);
		pessoa[1] = new Pessoa(2,"Maria", 100, 1.80);
		pessoa[2] = new Pessoa(3,"Joana", 65, 1.70);
		pessoa[3] = new Pessoa(4,"Sérgio", 180, 1.70);
		pessoa[4] = new Pessoa(5,"Fernanda", 189, 1.50);
		pessoa[5] = new Pessoa(6,"Andressa", 50, 1.65);

		// calculo
		for(int i = 0; i < pessoa.length; i++) {
			System.out.printf("[%s] \n", pessoa[i].getNome());
			System.out.printf("Altura: %.2f \n", pessoa[i].getAltura());
			System.out.printf("Peso kg: %.2f \n", pessoa[i].getPeso());
			System.out.printf("IMC: %.2f \n", pessoa[i].imc());
			System.out.printf("Classificação: %s \n\n", pessoa[i].classificacao(pessoa[i].imc()));
		}

		System.out.println("Pessoas com obesidade grau 3 (mórbida): ");
		List<String> pessoasObesas = Arrays.asList(pessoa).stream()
				.filter(i -> i.classificacao(i.imc()).equals("Obesidade grau 3 (mórbida)"))
				.map(Pessoa::getNome)
				.collect(Collectors.toList());
		System.out.println(pessoasObesas);

	}

	public static String amount(double value) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return "R$ " +decimalFormat.format(value);
	}

}
