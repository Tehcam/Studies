//conversion du binaire vers decimale

//variables :
var bin = document.querySelector('#binaire'),
	result = document.querySelector('strong'),
	dec = 0,
	conv = document.querySelector('span'),
	error = document.querySelector('#error'),
	reset = document.querySelector('#reset');

//fonction de conversion :
function conversion(){
	var binContent = [];
		binContent = bin.value.split('');

		for(var i=0; i<binContent.length; i++){
			if(binContent[i] != '0' && binContent[i] != '1'){
				error.innerHTML = 'Error: unexpected (int) ' + binContent[i];
			}
		}

		for(var i=0; i<binContent.length; i++){
			dec += binContent[i]*(2**(binContent.length-1-i));
		}

		result.innerHTML = '';
		result.innerHTML = dec;
}

//fonction reset :
function functionReset(){
	result.innerHTML = '';
	error.innerHTML = '';
	dec = 0;
}

//appel des fonctions :
(function(){
	conv.addEventListener('click', conversion);
	document.addEventListener('keydown', function(e){
		const enter = e.key;
		if(enter === 'Enter'){
			conversion();
		}
	});
	reset.addEventListener('click', functionReset);
	document.querySelector('label').addEventListener('click', function(){
		bin.value = '';
	});
})();
