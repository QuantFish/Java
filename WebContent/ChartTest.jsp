<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://cewolf.sourceforge.net/taglib/cewolf.tld" prefix="cewolf" %>
<%@page contentType="text/html"%>
<%@page import="java.awt.*" %>
<%@page import="java.util.*"%>
<%@page import="org.jfree.chart.*"%>
<%@page import="org.jfree.chart.event.ChartProgressEvent" %>
<%@page import="org.jfree.chart.event.ChartProgressListener" %>
<%@page import="org.jfree.chart.plot.*"%>
<%@page import="org.jfree.data.*"%>
<%@page import="org.jfree.data.category.*"%>
<%@page import="org.jfree.data.gantt.*"%>
<%@page import="org.jfree.data.general.*"%>
<%@page import="org.jfree.data.time.*"%>
<%@page import="org.jfree.data.xy.*"%>

<%
Dataset xyData = new DefaultCategoryDataset() {
    public Object defaultDataset(Map params) {
      XYSeries xys = new XYSeries("Example XY Dataset");
      double last = 0.0;
      for (int i = -50; i <= 50; i++) {
        double y = last + ((Math.random() * 100) - 50.0);
        xys.add((double) i, y);
        last = y;
      }
      return new XYSeriesCollection(xys);
    }
    public String getProducerId() {
      return "XYDataProducer";
    }
    public boolean hasExpired(Map params, Date since) {
      return false;
    }
  };
  pageContext.setAttribute("xyData", xyData);
%>
<html>
<head>
<link href="quantfish.css" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QuantFish test chart</title>
</head>
<h1>QuantFish test chart</h1>
<body>

</body>
</html>