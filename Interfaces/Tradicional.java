package Interfaces;

import java.util.Random;

public class Tradicional implements ModoJogo {
int numeropeças;
	@Override
	public String[][] gerarTabuleiro(String[][] tabuleiro) {
		// preenchendo tabuleiro.
		Random random = new Random();
		int altura = tabuleiro.length;
		int largura = tabuleiro[0].length;
		numeropeças = largura *altura;
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				tabuleiro[i][j] = "PEÇAA";
			}
		}
		
		//adicionando espaço vazio
		int yf = random.nextInt(altura);
		int xf = random.nextInt(largura);
			tabuleiro[yf][xf] = null;

		return tabuleiro;
	}

	@Override
	public int adicionarPontos(String peca) {
		if(peca.equals("PEÇAA")) return 1;
		if(peca ==null) return 0;
		return 0;
	}
	@Override
	public int retornarTotaldePontos() {
		// TODO Auto-generated method stub
		return numeropeças;
	}

}