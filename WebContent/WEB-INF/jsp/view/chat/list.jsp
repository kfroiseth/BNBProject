<%--@elvariable id="sessions" type="java.util.List<com.wrox.chat.ChatSession>"--%>
<%@ include file="/WEB-INF/jsp/base.jspf" %>
<%
	
	String Role = (String)session.getAttribute("role");
 	
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Sleeping Inn B &amp; B - Reservation System</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resource/stylesheet/chat.css">
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
        
	</head>
	<header>
    	 	<img src="<%=request.getContextPath()%>/images/logo.png" />
    	 	
    	 	
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.0.0/moment.min.js"></script>
        <script type="text/javascript" lang="javascript">
            var postInvisibleForm = function(url, fields) {
                var form = $('<form id="mapForm" method="post"></form>')
                        .attr({ action: url, style: 'display: none;' });
                for(var key in fields) {
                    if(fields.hasOwnProperty(key))
                        form.append($('<input type="hidden">').attr({
                            name: key, value: fields[key]
                        }));
                }
                $('body').append(form);
                form.submit();
            };
            var newChat = function() {
                postInvisibleForm('<c:url value="/chat" />', { action: 'new' });
            };
        </script>
            
        <script src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.1/js/bootstrap.min.js"></script>
    	 	
    </header>
   
   
   
    <c:choose>
        <c:when test="${fn:length(sessions) == 0}">
            <i>There are no pending support chat requests.</i>
        </c:when>
        <c:otherwise>
            Click on a chat request to accept it:<br /><br />
            <c:forEach items="${sessions}" var="s">
                <a href="javascript:void 0;"
                   onclick="join(${s.sessionId});">${s.customerUsername}</a><br />
            </c:forEach>
        </c:otherwise>
    </c:choose>
    <script type="text/javascript" language="javascript">
        var join = function(id) {
            postInvisibleForm('<c:url value="/chat" />', {
                action: 'join', chatSessionId: id
            });
        };
        
    </script>
    
     <br />
        <br />
            <a href="<c:url value="/reservations" />">Return to reservations</a>
        	<a href="<c:url value="/login?logout" />">Logout</a>
</html>
