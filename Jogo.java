import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class Jogo {
	public static void main(String[] args) throws IOException {
		int nivel = 1;
		int vidas = 5;
		int pontos = 0;
		int acertos = 0;
		Scanner sc = new Scanner(System.in);
		int opcao = 0;
		
		while ( opcao != 3 ){
			System.out.println("-----------------------");
			System.out.println("| 1 - Novo jogo       |");
			if ( nivel > 1 || vidas < 5 || pontos > 0 )
				System.out.println("| 2 - Continuar jogo  |");
			System.out.println("| 3 - Sair            |");
			System.out.println("-----------------------");
			System.out.print("Digite a opção: ");
			opcao = sc.nextInt();
			
			System.out.println("");
			
			switch(opcao){
			case 1:
				nivel = 1;
				vidas = 5;
				pontos = 0;
				acertos = 0;
			case 2:
				int op = 0;
				while ( op != 2 ){
					System.out.println("-------------------------------------------------------------");
					System.out.println("| Vidas              | Pontos           | Nível             |");
					System.out.print  ("| ");
					for ( int i=0;i<5;i++ ){
						if ( i < vidas )
							System.out.print("X ");
						else
							System.out.print(". ");
					}
					System.out.print  ("         | "+pontos);
					for ( int i=0;i<(17-(""+pontos).length());i++ ){
						System.out.print(" ");
					}
					System.out.println("| "+nivel+"                 |");
					System.out.println("-------------------------------------------------------------");
					System.out.println("| 1 - Próxima questão                                       |");
					System.out.println("| 2 - Voltar ao menu                                        |");
					System.out.println("-------------------------------------------------------------");
					System.out.print("Digite a opção: ");
					op = sc.nextInt();
					
					switch(op){
					case 1:
						char[] operacoes = {'+','-','*','/'};
						Random rand = new Random();
						int num1, num2;
						int result = 0;
						System.out.println("");
						System.out.println("Quanto é? (Em caso de número com vírgula, coloque apenas o inteiro)");
						switch(nivel){
						case 1:
							num1 = rand.nextInt(10);
							num2 = rand.nextInt(10);
							result = (int)num1 + num2;
							System.out.print(num1+" + "+num2+" = ");
							break;
						case 2:
							num1 = rand.nextInt(50);
							num2 = rand.nextInt(50);
							result = (int)num1 - num2;
							System.out.print(num1+" - "+num2+" = ");
							break;
						case 3:
							num1 = rand.nextInt(10);
							num2 = rand.nextInt(10);
							result = (int)num1 * num2;
							System.out.print(num1+" * "+num2+" = ");
							break;
						case 4:
							num1 = rand.nextInt(10);
							num2 = rand.nextInt(10);
							while(num2==0){
								num2 = rand.nextInt(10);
							}
							result = (int)num1 / num2;
							System.out.print(num1+" / "+num2+" = ");
							break;
						case 5:
							num1 = rand.nextInt(50);
							num2 = rand.nextInt(50);
							int opr = rand.nextInt(4);
							switch(opr){
							case 1:
								result = (int)num1 + num2;
								System.out.print(num1+" + "+num2+" = ");
								break;
							case 2:
								result = (int)num1 - num2;
								System.out.print(num1+" - "+num2+" = ");
								break;
							case 3:
								result = (int)num1 * num2;
								System.out.print(num1+" * "+num2+" = ");
								break;
							case 4:
								while(num2==0){
									num2 = rand.nextInt(10);
								}
								result = (int)num1 / num2;
								System.out.print(num1+" / "+num2+" = ");
								break;
							}
							break;
						}
						int r = sc.nextInt();
						if ( r == result ){
							System.out.println("");
							System.out.println("Parabéns, resposta correta!");
							System.out.println("");
							pontos++;
							acertos++;
							if ( acertos == 5 ){
								nivel++;
								System.out.println("Parabéns, Você subiu para o nível "+nivel+"!");
								System.out.println("");
								acertos = 0;
							}
						} else {
							System.out.println("");
							System.out.println("Que pena, você errou!");
							System.out.println("");
							vidas--;
							if ( vidas == 0 ){
								System.out.println("Infelizmente você perddeu o jogo, tente novamente!");
								System.out.println("");
								vidas = 5;
								pontos = 0;
								nivel = 1;
								acertos = 0;
								op = 2;
							}
						}
						break;
					default:
						System.out.println("");
						System.out.println("Opção inválida.");
						System.out.println("");
						break;
					}
				}
				break;
			case 3:
				System.out.println("");
				System.out.println("Muito obrigado por jogar! Tchau!");
				System.out.println("");
				break;
			default:
				System.out.println("");
				System.out.println("Opção inválida.");
				System.out.println("");
				break;
			}
		}
		
	}
}
