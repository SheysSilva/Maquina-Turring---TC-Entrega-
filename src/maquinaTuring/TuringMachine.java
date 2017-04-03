package maquinaTuring;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class TuringMachine {

	private Set<String> conjuntoDeEstados;
	private Set<Transition> conjuntoDeFuncoesDeTransicao;
	private String estadoInicial;
	private String conjuntoDeEstadosDeAceitacao;
	private String conjuntoDeEstadosDeRejeicao;
	
	private String fita;
	private String estadoAtual;
	private int simboloAtual;
		
	
	
	public TuringMachine(){
		conjuntoDeEstados = new HashSet<String>();
		conjuntoDeFuncoesDeTransicao = new HashSet<Transition>();
		estadoInicial = new String("");
		conjuntoDeEstadosDeAceitacao = new String("");
		conjuntoDeEstadosDeRejeicao = new String("");
		fita = new String("");
		estadoAtual = new String("");
		simboloAtual = 0;
		
	}
	
	public boolean Run(String entrada, boolean modoSilencioso){
		estadoAtual = estadoInicial;
		fita = entrada;
		
		while(!estadoAtual.equals(conjuntoDeEstadosDeAceitacao) && !estadoAtual.equals(conjuntoDeEstadosDeRejeicao)){
			boolean foundTransition = false;
			Transition CurrentTransition = null;
			
			if (modoSilencioso == false){
				if (simboloAtual>0){
					System.out.println(fita.substring(0, simboloAtual) + " " + estadoAtual + " " + fita.substring(simboloAtual));
				}
				else{
					System.out.println(" " + estadoAtual + " " + fita.substring(simboloAtual));
				}
			}
			
			
			Iterator<Transition> iteradorDeTransicao = conjuntoDeFuncoesDeTransicao.iterator();
			while ( iteradorDeTransicao.hasNext() && foundTransition == false){
				
				Transition nextTransition = iteradorDeTransicao.next();
				if (nextTransition.getLerEstado().equals(estadoAtual) && nextTransition.getLerSimbolo() == fita.charAt(simboloAtual)){
					foundTransition = true;
					CurrentTransition = nextTransition;
				}						
		    }	
			
			if (foundTransition == false){
				System.err.println ("There is no valid transition for this phase! (state=" + estadoAtual + ", symbol=" + fita.charAt(simboloAtual) + ")");
				return false;
			}
			else
			{
				estadoAtual = CurrentTransition.getEscreverEstado();
				char[] tempTape = fita.toCharArray(); 				
				tempTape[simboloAtual] = CurrentTransition.getEscreverSimbolo();
				fita =  new String(tempTape);
				if(CurrentTransition.isDirecao() == true){
					simboloAtual++;
				}
				else{
					simboloAtual--;
				}
				
				if (simboloAtual < 0)
					simboloAtual = 0;
				
				while (fita.length() <= simboloAtual){
					fita = fita.concat("_");
				}
					
			}				
			
		}
		
		if (estadoAtual.equals(conjuntoDeEstadosDeAceitacao)){
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	public boolean addState(String newState){
		if (conjuntoDeEstados.contains(newState)){
			return false;
		}
		else{
			conjuntoDeEstados.add(newState);
			return true;
		}
	}
	
	public boolean setStartState(String newStartState){
		if (conjuntoDeEstados.contains(newStartState)){
			estadoInicial = newStartState;
			return true;
		}
		else{
			return false;
		}		
	}
	
	public boolean setAcceptState(String newAcceptState){
		if (conjuntoDeEstados.contains(newAcceptState) && !conjuntoDeEstadosDeRejeicao.equals(newAcceptState)){
			conjuntoDeEstadosDeAceitacao = newAcceptState;
			return true;
		}
		else{
			return false;
		}
		
	}
	
	public boolean setRejectState(String newRejectState){
		if (conjuntoDeEstados.contains(newRejectState) && !conjuntoDeEstadosDeAceitacao.equals(newRejectState)){
			conjuntoDeEstadosDeRejeicao = newRejectState;
			return true;
		}
		else{
			return false;
		}		
	}

	public boolean addTransition(String rState, char rSymbol, String wState, char wSymbol, boolean mDirection)
	{
		if(!conjuntoDeEstados.contains(rState) || !conjuntoDeEstados.contains(wState))
		{
			return false;
		}
			
		boolean conflict = false;
		Iterator<Transition> TransitionsIterator = conjuntoDeFuncoesDeTransicao.iterator();
		while ( TransitionsIterator.hasNext() && conflict == false)
	    {
			Transition nextTransition = TransitionsIterator.next();
			if (nextTransition.isConflicting(rState, rSymbol))
			{
				conflict = true;
			}
					
	    }
		if (conflict == true){
			return false;
		}
		else{
			Transition newTransition = new Transition();
			newTransition.setLerEstado(rState);
			newTransition.setLerSimbolo(rSymbol);
			newTransition.setEscreverEstado(wState);
			newTransition.setEscreverSimbolo(wSymbol);
			newTransition.setDirecao(mDirection);
			conjuntoDeFuncoesDeTransicao.add(newTransition);
			return true;
		}
	}
}
 