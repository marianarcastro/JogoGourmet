package br.com.jogogourmet.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import br.com.jogogourmet.entity.Prato;

public class PratoController
{

    public List<Prato> listaDePratos;
    private List<Prato> listaNovosPratos;
    private List<Prato> listaPorTipoPrato;
    public static final Prato lasanha = new Prato(1, "Lasanha", "massa");
    private static final Prato boloDeChocolate = new Prato(2, "Bolo de Chocolate", "doce");

    public PratoController()
    {
        listaDePratos = new ArrayList<>();
        listaNovosPratos = new ArrayList<>();
        listaPorTipoPrato = new ArrayList<>();
    }

    public void adicionandoPratosIniciais()
    {
        listaDePratos.add(lasanha);
        listaDePratos.add(boloDeChocolate);
    }

    public void descobrirPrato(int opcaoSelecionada)
    {
        if(opcaoSelecionada == 0)
        {
            int dialogResult3 = JOptionPane.showConfirmDialog(null,"O prato que você pensou é " + lasanha.getNome() + "?", "Confirme", 0, 3);
            if(dialogResult3 == 0)
            {
                JOptionPane.showConfirmDialog(null, "Acertei de novo!!", "Jogo Gourmet", -1, 1);
            } else
            {
                String nomePrato = JOptionPane.showInputDialog(null, "Qual prato vvocê pensou?", "Desisto", 3);
                if(nomePrato != null)
                {
                    JOptionPane.showInputDialog(null, nomePrato + "é ________ mas "+ lasanha.getNome() + " não.", "Desisto", 3);
                }
            }
        } else
        {
            int dialogResult2 = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + boloDeChocolate.getNome() + "?", "Confirme", 0, 3);
            if(dialogResult2 == 0)
            {
                JOptionPane.showConfirmDialog(null, "Acertei de novo!!", "Jogo Gourmet", -1, 1);
            } else
            {
                String nomePrato = JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", 3);
                if(nomePrato != null)
                {
                    String tipoPrato = JOptionPane.showInputDialog(null, nomePrato + " é ________ mas "+ boloDeChocolate.getNome() + "?", "Desisto", 3);
                    if(tipoPrato != null)
                    {
                        adicionarNovoPrato(nomePrato, tipoPrato, tipoPrato);
                    }
                }
            }
        }
    }

    public void descobrirPratoDepoisDoPrimeiro(int opcaoSelecionada)
    {
        if(opcaoSelecionada == 0)
        {
        	int dialogResult3 = JOptionPane.showConfirmDialog(null,"O prato que você pensou é " + lasanha.getNome() + "?", "Confirme", 0, 3);
            if(dialogResult3 == 0)
            {
                JOptionPane.showConfirmDialog(null, "Acertei de novo!!", "Jogo Gourmet", -1, 1);
            } else
            {
                int dialogResult2 = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + boloDeChocolate.getNome(), "Confirme", 0, 3);
                if(dialogResult2 == 0)
                {
                    JOptionPane.showConfirmDialog(null, "Acertei de novo!!", "Jogo Gourmet", -1, 1);
                } else
                {
                    String nomePrato = JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", 3);
                    if(nomePrato != null)
                    {
                        String tipoPrato = JOptionPane.showInputDialog(null, nomePrato + " é ________ mas " + boloDeChocolate.getNome() + " não.", "Desisto", 3);
                        if(tipoPrato != null)
                        {
                            adicionarNovoPrato(nomePrato, tipoPrato, tipoPrato);
                        }
                    }
                }
            }
        } else {
            int sizeListaNovosPratos = listaNovosPratos.size();
            boolean acertou = false;
            for(int i = 0; i < sizeListaNovosPratos; i++) {
                int dialogResult2 = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + this.listaNovosPratos.get(i).getTipo() + "?", "Confirme", 0, 3);
                if(dialogResult2 == 0) {
                	int dialogResult6 = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + this.listaNovosPratos.get(i).getNome() + "?", "Confirme", 0, 3);
	                if(dialogResult6 == 0) {
	                	sizeListaNovosPratos = 0;
	                    JOptionPane.showConfirmDialog(null, "Acertei de novo!!", "Jogo Gourmet", -1, 1);
	                    acertou = true;
	                } else {
	                	int dialogResult7 = 10;
	                	if(!listaPorTipoPrato.isEmpty()) {
		                	for(Prato p : listaPorTipoPrato) {
		                		if(p.getCategoria() == this.listaNovosPratos.get(i).getTipo()) {
				                	dialogResult7 = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + p.getNome() + "?", "Confirme", 0, 3);
					                if(dialogResult7 == 0) {
					                	sizeListaNovosPratos = 0;
					                    JOptionPane.showConfirmDialog(null, "Acertei de novo!!", "Jogo Gourmet", -1, 1);
					                    acertou = true;
					                }
		                		}
		                	}
	                	} 
	                	if(dialogResult7 != 0) {
		                    String nomePrato = JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", 3);
		                    if(nomePrato != null) {
		                    	String tipoPrato = JOptionPane.showInputDialog(null, nomePrato + " é ________ mas " + this.listaNovosPratos.get(i).getNome() + " não.", "Desisto", 3);
		                        sizeListaNovosPratos = 0;
		                        if(tipoPrato != null) {
		                        	Prato p = new Prato(listaPorTipoPrato.size() + 1, nomePrato, tipoPrato, this.listaNovosPratos.get(i).getTipo());
		                        	listaPorTipoPrato.add(p);
		                        	acertou = true;
		                        }
		                    }
		                }
	                } 
                }
            }
            if(!acertou) {
                int dialogResult4 = JOptionPane.showConfirmDialog(null, "O prato que você pensou é " + boloDeChocolate.getNome(), "Confirme", 0, 3);
                if(dialogResult4 == 0)
                {
                    sizeListaNovosPratos = 0;
                    JOptionPane.showConfirmDialog(null, "Acertei de novo!!", "Jogo Gourmet", -1, 1);
                } else
                {
                    String nomePrato = JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", 3);
                    if(nomePrato != null)
                    {
                    	String tipoPrato = JOptionPane.showInputDialog(null, nomePrato + " é ________ mas " + boloDeChocolate.getNome() + " não.", "Desisto", 3);
                        if(tipoPrato != null)
                        {
                            sizeListaNovosPratos = 0;
                            adicionarNovoPrato(nomePrato, tipoPrato, tipoPrato);
                        }
                    }
                }
            }
        }
    }

    public void adicionarNovoPrato(String nome, String tipo, String categoria)
    {
        int id = listaDePratos.size() + 1;
        Prato novoPrato = new Prato(id, nome, tipo, categoria);
        listaNovosPratos.add(novoPrato);
        listaDePratos.add(novoPrato);
        
    }

}