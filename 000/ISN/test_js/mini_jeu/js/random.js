function getRandomInt(max) { //nb aléatoire
  return Math.floor(Math.random() * Math.floor(max));
};

(function(){ //calcul aléatoire
	var firstNb = getRandomInt(10),
		secondNb = getRandomInt(10),
		calcul = firstNb + ' x ' + secondNb + ' = ',
		result = firstNb*secondNb,
		nb1 = result + 2,
		nb2 = nb1 +2,
		nb3 = nb2 +2;
	return {
		calcul,
		nb1, nb2, nb3,
		result
	}

})();

