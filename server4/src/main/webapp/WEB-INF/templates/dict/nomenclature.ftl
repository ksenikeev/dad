<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
		"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="utf-8"/>
	<title> Central place</title>
</head>


<body>
<div id="header">
<H2>
	All nomenclatures after ${model["reqdate"]}
</H2>
</div>

<div id="content">
	<ul>
		<#list model["nomenclatures"] as nomenclature>
		<li>${nomenclature.id} ${nomenclature.name}</li>
		</#list>
	</ul>

</div>
</body>
</html>  