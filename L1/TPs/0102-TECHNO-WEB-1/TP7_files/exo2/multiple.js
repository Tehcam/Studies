(function(){
	var n = parseInt(prompt("Entrez un entier"));
	document.write(
		"<table border><tr><td>1x"+n+"</td><td>"+n+"</td></tr><tr><td>2x"+n+"</td><td>"+(n*2)+"</td></tr><tr><td>3x"+n+"</td><td>"+(3*n)+"</td></tr></table>"
	);
})();