// affichage ou non de l'info au chargement de la page

if(localStorage.getItem("understood") == "true")
{
	$('.pre').hide();
}

// en cas d'affichage, prévoir un mouseevent au click sur le bouton du popup

document.querySelector('#ok').addEventListener('click', function(){
	var check = document.querySelector('#understood');
	if(check.checked)
		localStorage.setItem("understood", "true");
	else
		localStorage.setItem("understood", "false");
	$('.pre').hide();
});

// bouton du footer vers la page de commentaire

document.querySelector('.comment-container').addEventListener('click', function(){
	window.location.href = "commentaire.html";
});

// animation du corps de page en fonction des titres

var titres = $('.article-title');

for(x of titres)
{
	x.addEventListener('click', function(){
		var attr = this.getAttribute('data-main');
		var elem = $('.article-content[data-main=' + attr + ']');
		if(elem.css("display") == "none")
			this.lastElementChild.style = "transform: rotateZ(90deg);";
		else
			this.lastElementChild.style = "transform: rotateZ(0deg);";
		elem.toggle(350);
	});
}

// mini jeu : principe du drag et drop

var DRAGCONTENT;
var gameBox = document.querySelectorAll('.game-box');

for(var i=0; i<gameBox.length; i++)
{
	gameBox[i].addEventListener('drag', function(e){
		DRAGCONTENT = this.innerHTML;
	});
}

var inputs = document.querySelectorAll('.game-awnser input');

for(var i=0; i<inputs.length; i++)
{
	inputs[i].addEventListener('drop', function(e){
		this.value = DRAGCONTENT;
	});
}

function allow(e)
{
	e.preventDefault();
}

document.querySelector('#verif-game').addEventListener('click', function(){
	var q = document.querySelectorAll('.game-awnser input');
	if(q[0].value == "Le script")
		green(q[0]);
	else
		red(q[0]);
	if(q[1].value == "Le dead cat")
		green(q[1]);
	else
		red(q[1]);
	if(q[2].value == "View")
		green(q[2]);
	else
		red(q[2]);
	
});

function green(elem)
{
	elem.style.background = "rgb(0, 250, 150)";
}

function red(elem)
{
	elem.style.background = "rgb(250, 50, 50)";
}