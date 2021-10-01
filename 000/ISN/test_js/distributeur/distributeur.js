// Corentin.M
// 2019-2020
// Distributeur, convertisseur d'une somme en combinaison de billet (50, 20, 10)

var enter = document.querySelector('#entrer');
var a, b, c;
var A, B, C;
var Awn = [];
var bin = 0;

function combin(x){
	A = x;
	if((A/50)>=1){
		a = A%50; // on affecte à a le plus grand nombre de 50 possible
		bin = A-a;
		a = bin/50;
		bin = 0;
		for(a; a>=0; a--){
			B = A-(a*50);
			if((B/20)>=1){
				b = B%20; // on affecte à b le plus grand nombre de 20 possible
				bin = B-b;
				b = bin/20;
				bin = 0;
				for(b; b>=0; b--){
					C = B-(b*20);
					if((C/10)>=1){
						c = C/10; // on affecte à c le plus grand nombre de 10 possible
						C -= c*10;//
						if(C===0){
							Awn.push("50x" + a + ", 20x" + b + ", 10x" + c + " | ");
						}else{Awn.push("error");}
					}else if(C===0){
							Awn.push("50x" + a + ", 20x" + b + " | ");
						}else{Awn.push("error");}
					C = B;
				}
			}else if(B===0){
					Awn.push("50x" + a + " | ");
				}else{Awn.push("error");}
			B = A;
		}
	}else if((A/20)>=1){
		a = A%20;
		bin = A-a;
		a = bin/20;
		bin = 0;
		for(a; a>=0; a--){
			B = A-(a*20);
			if((B/10)>=1){
				b = B/10;
				B -= b*10;
				if(B===0){
					Awn.push("20x" + a + ", 10x" + b + " | ");
				}else{Awn.push("error");}
			}else if(B===0){
					Awn.push("20x" + a + " | ");
				}else{Awn.push("error");}
			B = A;
		}
	}else if((x%10)!=0){
		Awn.push("entrez un multiple de 10 svp");
	}else{Awn.push("il suffit d'un billet de 10");}

	return Awn;
}

enter.addEventListener('click', function(){
	var somme = document.querySelector('#variable').value;
	// console.log(somme);
	combin(somme);
	var L = Awn.length;
	var textarea = document.querySelector('div');
	var distContent = Awn.join('');
	var dist = document.createElement('p');
	dist.innerHTML = distContent;
	textarea.appendChild(dist);
});