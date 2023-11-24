package entidades;

import java.util.Scanner;

import Interfaces.Froglet;
import Interfaces.Tradicional;


public class Partida {
	Scanner entrada = new Scanner(System.in);
	private int jogador1 =0;
	private int jogador2 =0;
	private Tabuleiro tabuleiro;
	
	public  void mostrarPlacar() {
		System.out.println("____________________________");
		System.out.println();
		System.out.println("Pontuação jogador 1: " + jogador1 +"                   Pontuação jogador 2: " + jogador2);
		System.out.println();
		System.out.println("____________________________");
	}
	public Boolean definirRegra() {
		
		System.out.println("Dois modos de jogo estão disponiveis o tradicional, "
				+ "\nonde todas as peças valem 1 e o modo Froglet, onde a pontuação é variada.");
			System.out.println("Digite 1 para jogar na versão Froglet");
			System.out.println("Digite 2 para jogar na versão tradicional");
			System.out.println("Qualquer outra tecla será interpretada como a vontade de não jogar o jogo");
			System.out.print("insira o modo de jogo: ");
			System.out.println();
			String resultado = entrada.next();
			if(resultado.equals("1")) { 
				this.tabuleiro = new Tabuleiro(new Froglet());
				return true;
			}
			if(resultado.equals("2")) { 
				this.tabuleiro = new Tabuleiro(new Tradicional());
				return true;
			}
			return false;
	}
	public  void zerarJogo() {
		jogador1 =0;
		jogador2 =0;
		tabuleiro = null;
		definirRegra();
	}
	public void introducao() {
		System.out.println("Você está jogando tananan, uma pequena explicação de como jogar, primeiro você "
				+ "seleciona a peça que deseja mover, primeiro digitando a linha e depois a coluna, em seguida digite a "
				+ "direção que deseja mover a peça, caso tente  mover para uma posição ocupada ou para fora do tabuleiro a jogada será perdida."
				+ "para ganhar, quando a soma dos pontos adquiridos atingir 70%, quem tiver mais pontos ganha, em caso de empate,quem conseguir o proximo ponto ganha");
		System.out.println();
		System.out.println("Botões de movimento:");
		System.out.println("W: Cima");
		System.out.println("S: Baixo");
		System.out.println("A: Esquerda");
		System.out.println("D: Direita");
		System.out.println();
	}
	
	public Boolean jogoEmSi() {
		introducao();
		if(definirRegra() == false) {
			System.out.println("Não foi possivel criar o tabuleiro");			
			return false;
			
		}
		tabuleiro.mostrarTabuleiro();
		mostrarPlacar(); 
		
		System.out.println();
		
		
		for(;;) {
			
			System.out.println("Jogador 1:");
			System.out.print("digite a posição y: ");
			int y = entrada.nextInt();
			entrada.nextLine();
			
			System.out.print("digite a posição x: ");
			int x = entrada.nextInt();
			entrada.nextLine();
			
			System.out.print("Digite a direção W,A,S,D: ");
			String direcao = entrada.next();
			
			jogador1 += tabuleiro.jogar(x, y, direcao);
			mostrarPlacar();
			
			System.out.println("Jogador 2:");
			System.out.print("digite a posição y: ");
			int y2 = entrada.nextInt();
			entrada.nextLine();
			
			System.out.print("digite a posição x: ");
			int x2 = entrada.nextInt();
			entrada.nextLine();
			
			System.out.print("Digite a direção W,A,S,D: ");
			String direcao2 = entrada.next();
			
			jogador2 += tabuleiro.jogar(x2, y2, direcao2);
			mostrarPlacar();
			
			if((2) <= (jogador1 + jogador2)) {
				
				if(jogador1 >jogador2) {
					System.out.println("Jogador 1 é o Vercedor, para o jogador 2 só sobra a vergonha!");
					System.out.println("deseja jogar novamente s/n");
					if("s".equalsIgnoreCase(entrada.next())) {
						zerarJogo();
					}
					else break;
				
				}
				if(jogador2 >jogador1) {
					System.out.println("Jogador 1 é o Vercedor, para o jogador 2 só sobra a vergonha!");
					System.out.println("deseja jogar novamente s/n");
					if("s".equalsIgnoreCase(entrada.next())) {
						zerarJogo();
					}
					else break;
				}
			}
			
		}
		return null;
	
	}
	public static void main(String[] args) {
		
		Partida partida = new Partida();
		partida.jogoEmSi();

	}

}
