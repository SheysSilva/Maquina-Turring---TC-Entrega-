package maquinaTuring;

public class Maquina {

	private String[] alfabeto;
	private String[] conjuntoEstados;
	private  String[][] funcaoTransicao;
	private  String estadoInicial;
	private  String[] conjuntoEstadosFinais;
	private  String[] alfabetoAuxiliar;
	private  String branco;
	private  String inicioFila;
	
	/**	String[] alfabeto, String[] conjuntoEstados, String[] funcaoTransicao,  String estadoInicial,  String[] conjuntoEstadosFinais, String[] alfabetoAuxiliar, String branco, String inicioFila
	 **/
	
	 public Maquina(String[] alfabeto, String[] conjuntoEstados, String[][] funcaoTransicao,  String estadoInicial, 
			 String[] conjuntoEstadosFinais, String[] alfabetoAuxiliar, String branco, String inicioFila){
	
		this.alfabeto = alfabeto;
		this.conjuntoEstados = conjuntoEstados;
		this.funcaoTransicao = funcaoTransicao;
		this.estadoInicial = estadoInicial;
		this.conjuntoEstadosFinais = conjuntoEstadosFinais;
		this.alfabetoAuxiliar = alfabetoAuxiliar;
		this.branco = branco;
		this.inicioFila = inicioFila;
		
	}

	public String[] getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String[] alfabeto) {
		this.alfabeto = alfabeto;
	}

	public String[] getConjuntoEstados() {
		return conjuntoEstados;
	}

	public void setConjuntoEstados(String[] conjuntoEstados) {
		this.conjuntoEstados = conjuntoEstados;
	}

	public String[][] getFuncaoTransicao() {
		return funcaoTransicao;
	}

	public void setFuncaoTransicao(String[][] funcaoTransicao) {
		this.funcaoTransicao = funcaoTransicao;
	}

	public String getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(String estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public String[] getConjuntoEstadosFinais() {
		return conjuntoEstadosFinais;
	}

	public void setConjuntoEstadosFinais(String[] conjuntoEstadosFinais) {
		this.conjuntoEstadosFinais = conjuntoEstadosFinais;
	}

	public String[] getAlfabetoAuxiliar() {
		return alfabetoAuxiliar;
	}

	public void setAlfabetoAuxiliar(String[] alfabetoAuxiliar) {
		this.alfabetoAuxiliar = alfabetoAuxiliar;
	}

	public String getBranco() {
		return branco;
	}

	public void setBranco(String branco) {
		this.branco = branco;
	}

	public String getInicioFila() {
		return inicioFila;
	}

	public void setInicioFila(String inicioFila) {
		this.inicioFila = inicioFila;
	}
	 
	public void maquina() {
		int indexEstado = 0;
		String funcaoTransicao = this.funcaoTransicao[indexEstado][0];
		
		if(!funcaoTransicao.equals(estadoInicial)){
			funcaoTransicao = this.estadoInicial;
			indexEstado = -1;
		}
		for(int i = 0; i < this.alfabeto.length; i++){
			
			while(alfabeto[i].equals(funcaoTransicao)){
				indexEstado += 1;
				funcaoTransicao = this.conjuntoEstados[indexEstado];
			}
		}
	}
			
	
}
