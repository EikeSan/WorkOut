<html
    xmlns:h="http://xmlns.jcp.org/jsf/html"
    >
<body>
    <form action="gerenciarAluno.xhtml">
        <button type="submit">Cancelar</button>
    </form>
<div class="planner" id="planner"><%= getPlanner(request) %></div>
<%@ page import="com.dhtmlx.planner.*,com.dhtmlx.planner.data.*" %>
<%!
        String getPlanner (HttpServletRequest request) throws Exception {
        DHXPlanner s = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
        s.setWidth(900);
        s.setInitialDate(2016, 05, 30);
        s.load("events.jsp", DHXDataFormat.JSON);
        s.data.dataprocessor.setURL("events.jsp");
  return s.render();
      }
%>
</body>
</html>