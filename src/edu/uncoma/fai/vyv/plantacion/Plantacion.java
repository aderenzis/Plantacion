package edu.uncoma.fai.vyv.plantacion;

public class Plantacion {
	
	
	private double metrosTotales;
	private double metrosOcupados;
	private int estado;
	
	private int parcelas;
	private int cultivos;
	
	public static int ESTADO_PRODUCTIVO=0;
	public static int ESTADO_EXCEDIDO=1;
	public static int ESTADO_CON_RESERVA=2;
	public static int ESTADO_IMPRODUCTIVO=3;
	
	public static int PARCELA_CHICA=0;
	public static int PARCELA_MEDIANA=1;
	public static int PARCELA_GRANDE=2;
	
	
	private static final double METROS_CULTIVO = 2000;
	private static double METROS_CHICA=2000;
	private static double METROS_MEDIANA=4000;
	private static double METROS_GRANDE=5000;

	
	
	
	public Plantacion() {
		this.cultivos=0;
		this.parcelas=2;
		this.metrosTotales=8000;
		this.metrosOcupados=0;
		this.estado=ESTADO_IMPRODUCTIVO;
	}
	/*
	 *  metros ocupados <= metros totales *  1.2
	 *  
	 *  todos los atributos numericos son positivos.
	 *  
	 *  ((100-(metrosOcupados*100/metrosTotales)>20) && estado=IMPRODUCTIVO) ||
	 *  (0<=(100-(metrosOcupados*100/metrosTotales)<=20) && estado=Productivo) ||
	 *  (-20<=(100-(metrosOcupados*100/metrosTotales)<0) && estado=CON_RESERVA) ||
	 *  ((100-(metrosOcupados*100/metrosTotales)<-20) && estado=EXCEDIDO) 
	 *  
		
	 *  
	 *  
	 *  double porcentajeConsumo = this.metrosOcupados*100/this.metrosTotales;
		double diferenciaPorcentual= 100-porcentajeConsumo;
		if(diferenciaPorcentual>20){
			this.estado=IMPRODUCTIVO;
		}
		else if(diferenciaPorcentual<=20 && diferenciaPorcentual>=0){
			this.estado=PRODUCTIVO;
		}
		else if(diferenciaPorcentual<0 && diferenciaPorcentual>=-20){
			this.estado=CON_RESERVA;
		}
		else if(diferenciaPorcentual<-20){
			this.estado=EXCEDIDO;		
		}
	 */
		
	public double getMetrosTotales() {
		return metrosTotales;
	}
	
	public double getMetrosOcupados() {
		return metrosOcupados;
	}
	

	public String getEstadoStr() {
		if(this.estado==ESTADO_EXCEDIDO)
			return "Excedido";
		if(this.estado==ESTADO_CON_RESERVA)
			return "Con Reserva";
		if(this.estado==ESTADO_PRODUCTIVO)
			return "Productivo";
		if(this.estado==ESTADO_IMPRODUCTIVO)
			return "Improductivo";
		else
			return "Sin estado";
	}

	public void addParcela(int tipoParcela){
		if(tipoParcela==PARCELA_CHICA){
			this.metrosTotales=metrosTotales+METROS_CHICA;
		}
		else if(tipoParcela==PARCELA_MEDIANA){
			this.metrosTotales=metrosTotales+METROS_MEDIANA;
		}else if(tipoParcela==PARCELA_GRANDE){
			this.metrosTotales=metrosTotales+METROS_GRANDE;
		}
		this.parcelas++;
		calcularEstado();
	}
	
	public void deleteParcela(int tipoParcela){
		if(parcelas>0){
			if(tipoParcela==PARCELA_CHICA){
				this.metrosTotales=metrosTotales-METROS_CHICA;
			}
			else if(tipoParcela==PARCELA_MEDIANA){
				this.metrosTotales=metrosTotales-METROS_MEDIANA;
			}else if(tipoParcela==PARCELA_GRANDE){
				this.metrosTotales=metrosTotales-METROS_GRANDE;
			}
			this.parcelas--;
			calcularEstado();
		}
		else{
			System.out.println("No hay parcelas para eliminar.");
		}
	}
	
	public void addCultivos(int cantidad){
		if(cantidad>0){
			if(this.estado!=ESTADO_EXCEDIDO){
				if(cantidad<=3){
					this.metrosOcupados=this.metrosOcupados+cantidad*METROS_CULTIVO;
					this.cultivos=this.cultivos+cantidad;
					calcularEstado();
				}
				else{
					System.out.println("La cantidad debe ser <= a 3");
				}
			}
			else{
				System.out.println("Imposible agregar cultivo: estado excedido");
			}
		}
		else{
			System.out.println("La cantidad debe ser mayor a 0");
		}
	}
		
	public void deleteCultivos(int cantidad){
		if(cantidad>0){
			if(cantidad<=3){
				if(this.cultivos>=cantidad){
					this.metrosOcupados=this.metrosOcupados-cantidad*METROS_CULTIVO;
					this.cultivos=this.cultivos-cantidad;
					calcularEstado();
				}
				else{
					System.out.println("La cantidad ingresada es mayor a la cantidad de cultivos.");
				}
			}
			else{
				System.out.println("La cultivos debe ser <= a 3");
			}
		}
		else{
			System.out.println("La cantidad debe ser mayor a 0");
		}
	}


	
	private void calcularEstado() {
		double porcentajeConsumo = this.metrosOcupados*100/this.metrosTotales;
		double diferenciaPorcentual= 100-porcentajeConsumo;
		if(diferenciaPorcentual>20){
			this.estado=ESTADO_IMPRODUCTIVO;
		}
		else if(diferenciaPorcentual<=20 && diferenciaPorcentual>=0){
			this.estado=ESTADO_PRODUCTIVO;
		}
		else if(diferenciaPorcentual<0 && diferenciaPorcentual>=-20){
			this.estado=ESTADO_CON_RESERVA;
		}
		else if(diferenciaPorcentual<-20){
			this.estado=ESTADO_EXCEDIDO;		
		}
	}

	public int getParcelas() {
		return parcelas;
	}


	public int getCultivos() {
		return cultivos;
	}

	public int getEstado() {
		return estado;
	}
	
}
