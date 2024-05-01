package model;


public enum Cidade {

	SAOPAULO("saoPaulo"),
	BELOHORIZONTE("BH"),
	PORTOALEGRE("PortoAlegre"),
	CURITIBA("Curitiba");
	
	
	private String estado;

	Cidade(String estado){
		this.estado = estado;
	}
	
	public String getCidadeSelecionada() {
		return estado;
	}
	
	
	
}
