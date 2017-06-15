package edu.uncoma.fai.vyv.plantacion.test;


import static org.junit.Assert.*;

import org.junit.Test;

import edu.uncoma.fai.vyv.plantacion.Plantacion;

public class CubrimientoEventos {

	@Test
	public void test() {
		Plantacion p = new Plantacion();
		
		/*
		 * estado 1 : es Excedido
		 * 
		 * */
		
		assertTrue("Debe empezar con 2 parcelas", p.getParcelas() == 2);
		assertTrue("Debe empezar con 0 cultivos", p.getCultivos() == 0);
		assertTrue("Debe empezar con 8000 metros totales", p.getMetrosTotales() == 8000);
		assertTrue("Debe empezar con 0 metros ocupados", p.getMetrosOcupados() == 0);
		assertTrue("Debo tener estado 3", p.getEstado() == 3);
		
		p.addCultivos(1);
		assertTrue("Debe ser Improductivo", p.getEstado() == Plantacion.ESTADO_IMPRODUCTIVO);
		
		p.deleteCultivos(1);
		assertTrue("Debe ser Improductivo", p.getEstado() == Plantacion.ESTADO_IMPRODUCTIVO);
		
		p.addParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser Improductivo", p.getEstado() == Plantacion.ESTADO_IMPRODUCTIVO);
		
		p.deleteParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser ESTADO_IMPRODUCTIVO", p.getEstado() == Plantacion.ESTADO_IMPRODUCTIVO);
		
	}

}
