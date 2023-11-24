package Interfaces;

import java.util.Random;

public class Froglet implements ModoJogo {
	int Nazuis = 0;
	int Nvermelhos = 0;
	int Nverdes = 0;
	int Nlaranja = 0;
	@Override
	public String[][] gerarTabuleiro(String[][] tabuleiro) {
		Random random = new Random();
		//coletando dados do tabuleiro e certificando que ele está repleto de null
		int altura = tabuleiro.length;
		int largura = tabuleiro[0].length;
		int total = altura * largura;
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				tabuleiro[i][j] = null;
			}
		}

		//determinando quantidade de peças de cada cor
		 Nazuis = (int) (total * 0.4);
		 Nvermelhos = (int) (total * 0.3);
		 Nverdes = (int) (total * 0.2);
		 Nlaranja = (int) (total * 0.1);

		//preenchendo tabuleiro
		for (int i = 0; i < Nazuis; i++) {
			int y = random.nextInt(altura);
			int x = random.nextInt(largura);
			if (tabuleiro[y][x] != null)
				i--;
			else
				tabuleiro[y][x] = "PAZUI";

		}

		for (int i = 0; i < Nvermelhos; i++) {
			int y = random.nextInt(altura);
			int x = random.nextInt(largura);
			if (tabuleiro[y][x] != null)
				i--;
			else
				tabuleiro[y][x] = "PVERM";

		}
		for (int i = 0; i < Nverdes; i++) {
			int y = random.nextInt(altura);
			int x = random.nextInt(largura);
			if (tabuleiro[y][x] != null)
				i--;
			else
				tabuleiro[y][x] = "PVERD";

		}
		for (int i = 0; i < Nlaranja; i++) {
			int y = random.nextInt(altura);
			int x = random.nextInt(largura);
			if (tabuleiro[y][x] != null)
				i--;
			else
				tabuleiro[y][x] = "PLARA";

		}
		
		// adicionando espaço vazio
		int yf = random.nextInt(altura) - 1;
		int xf = random.nextInt(largura) - 1;
			tabuleiro[yf][xf] = null;

		return tabuleiro;
	}

	@Override
	public int adicionarPontos(String peca) {
		//retornando pontuação adiquirida
		if(peca == null) return 0;
		if(peca.equals("PLARA")) return 4;
		if(peca.equals("PVERD")) return 3;
		if(peca.equals("PVERM")) return 2;
		if(peca.equals("PAZUI")) return 1;
		return 0;
	}
	
	@Override
	public int retornarTotaldePontos() {
		int total = (Nazuis*1)+(2* Nvermelhos)+ (Nverdes*3)+(Nlaranja*4);
		return total;
	}

}

