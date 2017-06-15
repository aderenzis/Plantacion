package edu.uncoma.fai.vyv.plantacion.test;


import static org.junit.Assert.*;

import org.junit.Test;

import edu.uncoma.fai.vyv.plantacion.Plantacion;

public class CubrimientoEstados {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Plantacion p = new Plantacion();
		
		/*
		 * estado 1 : es Excedido
		 * 
		 * */
		System.out.println(p.getCultivos());
		System.out.println(p.getMetrosOcupados());
		System.out.println(p.getParcelas());
		System.out.println(p.getMetrosTotales());
		
		
		assertTrue("Debe ser Improductivo", p.getEstado() == Plantacion.ESTADO_IMPRODUCTIVO);
	
		p.addCultivos(3);
		// ACA NO PASO EL ASSERT. Por lo tanto, TIENE 
		assertTrue("Debe ser Improductivo"+"y somos: "+p.getEstado(), p.getEstado() == Plantacion.ESTADO_IMPRODUCTIVO);
		
		p.addCultivos(1);
		assertTrue("Debe ser Productivo", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.addParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser Productivo", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.addCultivos(2);
		assertTrue("Debe ser CON_RESERVA", p.getEstado() == Plantacion.ESTADO_CON_RESERVA);
		
		p.addCultivos(1);
		assertTrue("Debe ser EXCEDIDO", p.getEstado() == Plantacion.ESTADO_EXCEDIDO);
			
	}

}
