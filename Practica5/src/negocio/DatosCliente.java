package negocio;

import org.jdom2.Element;

public class DatosCliente {
	private String calle;
	private String colonia;
	private String noExterior;
	private String noInterior;
	private String municipio;
	private String estado;
	private String pais;
	private String codigoPostal;
	private String rfc;
	private String nombre;

	public DatosCliente(Element receptor) {
		Element domicilio;
		rfc = receptor.getAttributeValue("rfc");
		nombre = receptor.getAttributeValue("nombre");
		domicilio = receptor.getChild("cfdi:Domicilio");
		calle = domicilio.getAttributeValue("calle");
		colonia = domicilio.getAttributeValue("colonia");
		noExterior = domicilio.getAttributeValue("noExterior");
		noInterior = domicilio.getAttributeValue("noInterior");
		municipio = domicilio.getAttributeValue("municipio");
		estado = domicilio.getAttributeValue("estado");
		pais = domicilio.getAttributeValue("pais");
		codigoPostal = domicilio.getAttributeValue("codigoPostal");

	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	public String getNoExterior() {
		return noExterior;
	}

	public void setNoExterior(String noExterior) {
		this.noExterior = noExterior;
	}

	public String getNoInterior() {
		return noInterior;
	}

	public void setNoInterior(String noInterior) {
		this.noInterior = noInterior;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
