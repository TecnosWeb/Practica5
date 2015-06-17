package negocio;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;

public class Parser {
	private CargosMes cargoMes;
	private DatosCliente cliente;
	private String fecha;
	private String noCertificado;

	public void LeerXml(String facturaXML) {
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
			
			InputStream stream = new ByteArrayInputStream(facturaXML.getBytes("UTF-8"));
			Document facturaXml = lector.build(stream);
			Element raiz = facturaXml.getRootElement();
			Namespace name = raiz.getNamespace();
			fecha = raiz.getAttributeValue("fecha");
			noCertificado = raiz.getAttributeValue("noCertificado");
			cliente = new DatosCliente(raiz.getChild("Receptor", name), name);
			cargoMes = new CargosMes(raiz.getChild("Conceptos", name),
					raiz.getChild("Impuestos", name), name);
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
