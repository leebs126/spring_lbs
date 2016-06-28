<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
	<TITLE> <tiles:insertAttribute name="title" /></TITLE>
</head>
</head>
<BODY>

	<DIV id="outer_wrap">
		<DIV id="wrap">
			<HEADER>
				   <tiles:insertAttribute name="header" />
			</HEADER>
			<DIV class="clear"></DIV>
			<ASIDE>
				 <tiles:insertAttribute name="side" />
			</ASIDE>
			<ARTICLE>
			 	<tiles:insertAttribute name="body" />
			 
			</ARTICLE>
			<DIV class="clear"></DIV>
			<FOOTER>
        		<tiles:insertAttribute name="footer" />
        	</FOOTER>
		</DIV>
		 <tiles:insertAttribute name="sticky_menu" />
    </DIV>        	
</BODY>      
        
        