<%@page import="java.io.Writer"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = 'negocio.Parser,
    negocio.DatosCliente,
    negocio.Concepto,
    negocio.CargosMes'
%>
<%!
	Parser parser = new Parser();
	DatosCliente cliente;
	CargosMes cargos;
	Concepto[] conceptos;
%>
<%
	parser.LeerXml(request.getParameter("factura"));
	cliente = parser.getCliente();
	cargos = parser.getCargoMes();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Telmex</h1>
<h2>Datos del cliente</h2>
<p>Dirección: <%= cliente.getCalle()%> <%= cliente.getNoExterior()%> <%= cliente.getNoInterior()%> <%= cliente.getColonia()%> </p>
<p>CP: <%= cliente.getCodigoPostal() %> <%= cliente.getEstado() %></p>
<p>RFC: <%= cliente.getRfc() %></p>
<p>Fecha: <%= parser.getFecha() %>
<h2><%= cliente.getNombre() %></h2>

<p>Total a pagar: <%= cargos.getTotal() %></p>
<p>Factura No. : <%= parser.getNoCertificado() %></p>
<h1>Cargos del mes</h1>
<p>
	<%
		conceptos = cargos.getConceptos();
		for(int i = 0; i < conceptos.length; i++){
			out.println(conceptos[i].getDescripcion());
			out.println("\t" + conceptos[i].getImporte());
			out.println("\n");
		}
	%>
</p>
<p>IEPS 3%: <%= cargos.getIeps3() %> </p>
<p>IVA 16%: <%= cargos.getIva16() %></p>
<p>Total: <%= cargos.getTotal() %></p>
</body>
</html>

