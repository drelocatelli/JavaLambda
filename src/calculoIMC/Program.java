import Entity.CalculaIMC;
import Entity.Pessoa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {

		// pessoas

		Pessoa[] pessoa = new Pessoa[5];
		pessoa[0] = new Pessoa("João", 50, 1.60);
		pessoa[1] = new Pessoa("Maria", 100, 1.80);
		pessoa[2] = new Pessoa("Joana", 65, 1.70);
		pessoa[3] = new Pessoa("Sérgio", 180, 1.70);
		pessoa[4] = new Pessoa("Fernanda", 189, 1.50);

		// calculo
		CalculaIMC[] calculos = new CalculaIMC[pessoa.length];
		for(int i = 0; i < pessoa.length; i++) {
			calculos[i] = new CalculaIMC(i, pessoa[i].getPeso(), pessoa[i].getAltura());

			System.out.printf("[%s] \n", pessoa[i].getNome());
			System.out.printf("Altura: %.2f \n", pessoa[i].getAltura());
			System.out.printf("Peso kg: %.2f \n", pessoa[i].getPeso());
			System.out.printf("IMC: %.2f \n", calculos[i].imc());
			System.out.printf("Classificação: %s \n\n", calculos[i].classificacao(calculos[i].imc()));
		}

		System.out.println("Pessoas com obesidade grau 3 (mórbida): ");
		List<Integer> pessoasObesas = Arrays.asList(calculos).stream()
				.filter(i -> i.classificacao(i.imc()).equals("Obesidade grau 3 (mórbida)"))
				.map(i -> i.getId())
				.collect(Collectors.toList());

		for(int indice: pessoasObesas) {
			System.out.printf("%s \n", pessoa[indice].getNome());
		}

	}

}
