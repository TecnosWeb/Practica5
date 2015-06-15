package negocio;

import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Parser {
	private CargosMes cargoMes;
	private DatosCliente cliente;
	private String fecha;
	private String noCertificado;

	public void LeerXml(String ruta) {
		SAXBuilder lector = new SAXBuilder();

		// Los siguientes datos no se encuentran en la factura utilizada:
		// String pago;
		// String cargoRedondeo;
		// String creditoRedondeo;
		// String Telefono;
		// String idFactura;
		// String saldoAnterior;
		// String fechaVen;
		// String mesFacturacion;
		// String saldoCorte;

		try {
			Document facturaXml = lector.build(ruta);
			Element raiz = facturaXml.getRootElement();

			fecha = raiz.getAttributeValue("fecha");
			noCertificado = raiz.getAttributeValue("noCertificado");

			cliente = new DatosCliente(raiz.getChild("cfdi:Receptor"));
			cargoMes = new CargosMes(raiz.getChild("cfdi:Conceptos"),
					raiz.getChild("cfdi:Impuestos"));
			cargoMes.setTotal(raiz.getAttributeValue("total"));

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public CargosMes getCargoMes() {
		return cargoMes;
	}

	public void setCargoMes(CargosMes cargoMes) {
		this.cargoMes = cargoMes;
	}

	public DatosCliente getCliente() {
		return cliente;
	}

	public void setCliente(DatosCliente cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNoCertificado() {
		return noCertificado;
	}

	public void setNoCertificado(String noCertificado) {
		this.noCertificado = noCertificado;
	}
}
