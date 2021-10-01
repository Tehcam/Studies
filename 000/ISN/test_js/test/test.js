function square_nb(arg) {
	var x = arg+1;
	for(var n = 2, a = 2; a < x; a++){
		n+=1;
	}
	return n;
}

function square_area(arg) {
	var x = arg+1;
	for(var A = 4, c = 2, a = 2; a < x; a++){
		c/=2;
		A=c**2;
	}
	return A;
}

function totale() {
	var x = parseInt(prompt('Quelle étape ?'));
	for(var u = 24, a = 2; a < x; a++){
		u+= square_nb(a)*square_area(a);
	}
	alert(u);
}

totale();