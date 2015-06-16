package negocio;

import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.Namespace;

public class CargosMes {
	private Concepto[] conceptos;
	private String ieps3;
	private String iva16;
	private String total;

	public CargosMes(Element conceptos, Element impuestos, Namespace name) {
		int i = 0;
		List<Element> concepto = conceptos.getChildren();
		this.conceptos = new Concepto[concepto.size()];
		for (Iterator iterator = concepto.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			this.conceptos[i] = new Concepto(element);
			i++;
		}
		
		Element traslados = impuestos.getChild("Traslados", name);
		List<Element> traslado = traslados.getChildren();
		ieps3 = traslado.get(0).getAttributeValue("importe");
		iva16 = traslado.get(3).getAttributeValue("importe");
	}

	public Concepto[] getConceptos() {
		return conceptos;
	}

	public void setConceptos(Concepto[] conceptos) {
		this.conceptos = conceptos;
	}

	public String getIeps3() {
		return ieps3;
	}

	public void setIeps3(String ieps3) {
		this.ieps3 = ieps3;
	}

	public String getIva16() {
		return iva16;
	}

	public void setIva16(String iva16) {
		this.iva16 = iva16;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
}
