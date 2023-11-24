package Interfaces;

public interface ModoJogo {
	
	public String[][] gerarTabuleiro(String[][] tabuleiro);
	
	public int adicionarPontos(String peca);
	
	public int retornarTotaldePontos();
}
