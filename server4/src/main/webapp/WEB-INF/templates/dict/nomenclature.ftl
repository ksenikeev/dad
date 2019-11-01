<html>
<head><title> Central place</title>


<body>
<div id="header">
<H2>
	All nomenclatures after ${model["reqdate"]}
</H2>
</div>

<div id="content">
	<ul>
		<#list model["nomenclatures"] as nomenclature>
		<li>${nomenclature.name}</li>
		</#list>
	</ul>

</div>
</body>
</html>  