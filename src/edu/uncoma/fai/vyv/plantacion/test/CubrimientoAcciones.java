package edu.uncoma.fai.vyv.plantacion.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.uncoma.fai.vyv.plantacion.Plantacion;

public class CubrimientoAcciones {

	@Test
	public void test() {
		
		Plantacion p = new Plantacion();
		
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
		
		p.addCultivos(3);
		assertTrue("Debe ser Improductivo", p.getEstado() == Plantacion.ESTADO_IMPRODUCTIVO);
		
		p.addCultivos(1);
		assertTrue("Debe ser ESTADO_PRODUCTIVO", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		assertTrue("Debe tener con 2 parcelas", p.getParcelas() == 2);
		assertTrue("Debe tener con 4 cultivos", p.getCultivos() == 4);
		assertTrue("Debe tener con 8000 metros totales", p.getMetrosTotales() == 8000);
		assertTrue("Debe tener con 8000 metros ocupados", p.getMetrosOcupados() == 8000);
		assertTrue("Debo tener estado 0", p.getEstado() == 0);
		
		p.addParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser ESTADO_PRODUCTIVO", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.addCultivos(1);
		assertTrue("Debe ser ESTADO_PRODUCTIVO", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.deleteCultivos(1);
		assertTrue("Debe ser ESTADO_PRODUCTIVO", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.deleteParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser ESTADO_PRODUCTIVO", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.addParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser ESTADO_PRODUCTIVO", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.addCultivos(2);
		assertTrue("Debe ser ESTADO_CON_RESERVA", p.getEstado() == Plantacion.ESTADO_CON_RESERVA);
		
		assertTrue("Debe tener con 3 parcelas", p.getParcelas() == 3);
		assertTrue("Debe tener con 6 cultivos", p.getCultivos() == 6);
		assertTrue("Debe tener con 10000 metros totales", p.getMetrosTotales() == 10000);
		assertTrue("Debe tener con 12000 metros ocupados", p.getMetrosOcupados() == 12000);
		assertTrue("Debo tener estado 2", p.getEstado() == 2);
		
		p.addCultivos(1);
		assertTrue("Debe ser ESTADO_EXCEDIDO", p.getEstado() == Plantacion.ESTADO_EXCEDIDO);
		
		p.deleteCultivos(1);
		assertTrue("Debe ser ESTADO_CON_RESERVA", p.getEstado() == Plantacion.ESTADO_CON_RESERVA);
		
		p.deleteCultivos(1);
		assertTrue("Debe ser ESTADO_PRODUCTIVO", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.addParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser ESTADO_PRODUCTIVO", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.addCultivos(2);
		assertTrue("Debe ser ESTADO_CON_RESERVA", p.getEstado() == Plantacion.ESTADO_CON_RESERVA);
		
		p.deleteParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser ESTADO_EXCEDIDO", p.getEstado() == Plantacion.ESTADO_EXCEDIDO);
		
		p.deleteCultivos(1);
		
		assertTrue("Debe ser ESTADO_CON_RESERVA", p.getEstado() == Plantacion.ESTADO_CON_RESERVA);
		
		p.addParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser ESTADO_PRODUCTIVO", p.getEstado() == Plantacion.ESTADO_PRODUCTIVO);
		
		p.addCultivos(1);
		assertTrue("Debe ser ESTADO_CON_RESERVA", p.getEstado() == Plantacion.ESTADO_CON_RESERVA);
		
		p.addCultivos(1);
		assertTrue("Debe ser ESTADO_EXCEDIDO", p.getEstado() == Plantacion.ESTADO_EXCEDIDO);
		
		assertTrue("Debe tener con 4 parcelas", p.getParcelas() == 4);
		assertTrue("Debe tener con 8 cultivos", p.getCultivos() == 8);
		assertTrue("Debe tener con 12000 metros totales", p.getMetrosTotales() == 12000);
		assertTrue("Debe tener con 16000 metros ocupados", p.getMetrosOcupados() == 16000);
		assertTrue("Debo tener estado 1", p.getEstado() == 1);
		
		p.deleteParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser ESTADO_EXCEDIDO", p.getEstado() == Plantacion.ESTADO_EXCEDIDO);
		
		p.addParcela(Plantacion.PARCELA_CHICA);
		assertTrue("Debe ser ESTADO_EXCEDIDO", p.getEstado() == Plantacion.ESTADO_EXCEDIDO);
		
	}

}
