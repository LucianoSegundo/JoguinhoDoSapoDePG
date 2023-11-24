package entidades;

import Interfaces.ModoJogo;

public class Tabuleiro {
	private ModoJogo versao;
	private String tabuleiro[][];
	
	public Tabuleiro(ModoJogo novaRegra) {
		this.versao = novaRegra;
		this.tabuleiro = new String[6][6];
		gerarTabuleiro();
	}
	public void gerarTabuleiro() {
		this.tabuleiro = versao.gerarTabuleiro(tabuleiro);
	}
	private int retornarPontos(String peca) {
		return versao.adicionarPontos(peca);
	}
	
	private Boolean validarjogada(int x, int y, String tecla) {
	
		if(tabuleiro[y][x]== null) return false;
		if(tecla.equalsIgnoreCase("w")) {
			if(y== 0 || y ==1) return false;	
			if((y-2<0)) return false;
			if(tabuleiro[y-2][x] != null) return false;
		}
		if(tecla.equalsIgnoreCase("s")) {
			if(y== tabuleiro.length-1 || y == tabuleiro.length -2) return false;
			if((y+2>tabuleiro.length-1)) return false;
			if(tabuleiro[y+2][x] != null) return false;
		}
		if(tecla.equalsIgnoreCase("a")) {
			if(x== 0 || x ==1) return false;	
			if((x-2<0)) return false;
			if(tabuleiro[y][x-2] != null) return false;
		}
		if(tecla.equalsIgnoreCase("d")) {
			if(x== tabuleiro[y].length-1 || x == tabuleiro[y].length-2) return false;	
			if((x+2> tabuleiro[y].length-1)) return false;
			if(tabuleiro[y][x+2] != null) return false;
		
		}
		if(false == (tecla.equalsIgnoreCase("w") || tecla.equalsIgnoreCase("s") || tecla.equalsIgnoreCase("a") || tecla.equalsIgnoreCase("d"))) {
		return false;	
		}
		
		return true;
	}
	
	public int jogar(int x, int y, String tecla) {
		int ponto =0;
		if(validarjogada(x, y, tecla) ==false) {
			System.out.println(" foi realizada uma Jogada irregular, então nenhum movimento foi realizado");
			tecla ="jogada cancelada";
			mostrarTabuleiro();
			return 0;
		}
		else {
			if(tecla.equalsIgnoreCase("w")) {
				tabuleiro[y-2][x] = tabuleiro[y][x];
				tabuleiro[y][x] = null;
				 ponto = retornarPontos(tabuleiro[y-1][x]);
				tabuleiro[y-1][x]= null;
			
			}
			if(tecla.equalsIgnoreCase("s")) {
				tabuleiro[y+2][x] = tabuleiro[y][x];
				tabuleiro[y][x] = null;
				 ponto = retornarPontos(tabuleiro[y+1][x]);
				tabuleiro[y+1][x]= null;
				
			}
			if(tecla.equalsIgnoreCase("a")) {
				tabuleiro[y][x-2] = tabuleiro[y][x];
				tabuleiro[y][x] = null;
				 ponto = retornarPontos(tabuleiro[y][x-1]);
				tabuleiro[y][x-1]= null;
				
			}
			if(tecla.equalsIgnoreCase("d")) {
				tabuleiro[y][x+2] = tabuleiro[y][x];
				tabuleiro[y][x] = null;
				 ponto = retornarPontos(tabuleiro[y][x+1]);
				tabuleiro[y][x+1]= null;
				
			}
		}
		mostrarTabuleiro();
		return ponto;
		
		
	}

	public void mostrarTabuleiro(){
		System.out.print("y");
		for(int j=0; j< tabuleiro[0].length; j++){
			System.out.print(" | __"+j+"__");
		}
		System.out.print("| x");
		System.out.println();
		for(int i=0; i< tabuleiro.length; i++) {
			System.out.print(""+i);
			for(int j=0; j< tabuleiro[i].length; j++) {
				if(tabuleiro[i][j] == null)System.out.print(" | _____");
				else System.out.print(" | "+ tabuleiro[i][j]);
			}
			System.out.println();
		}
	}

	public void mudarRegraJogo(ModoJogo novaRegra) {
		this.versao = novaRegra;
		gerarTabuleiro();
	}
	
	public int retornarTotalPontos() {
		return versao.retornarTotaldePontos();
	}
}