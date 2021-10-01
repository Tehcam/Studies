/*

EXERCICE 1

console.log("du texte dans la console");
var text1 = "du text";
console.log(text1);
// console.log(text2); ici une erreur
console.log("un exemple de concaténation : " + text1 + " " + (4+5));

EXERCICE 2

console.log(document.getElementById('footer').innerHTML);
var td = document.querySelectorAll('td');
console.log(td);
console.log(td[0]);
console.log(td[2]);

*/

// EXERCICE 3

function maFonction()
{
	var mesCards = document.querySelectorAll('.card');
	console.log(mesCards.length);
	for(var i=0; i<mesCards.length; i++)
	{
		console.log(mesCards[i].firstChild.getAttribute('src'));
	}
}

function maFonction2()
{
	console.log("ma fonction 2 !");
}

function start()
{
	document.querySelector('h1').setAttribute('onclick', 'maFonction2();');
	document.querySelector('h1').addEventListener('click', maFonction);
	document.querySelector('h1').addEventListener('click', maFonction2);
	document.querySelector('#theme').addEventListener('click', theme); // exo4
}

window.addEventListener('DOMContentLoaded', start);

// EXERCICE 4

var root = document.documentElement;
var blue = "#6990CC";
var grey = "#666666";

var sombre;
var tmp = localStorage.getItem("sombre");
if(tmp == "true")
{
	sombre = true;
}
else
{
	sombre = false;
}

function theme()
{
	if(sombre)
	{
		root.style.setProperty('--colorBoite', blue);
		root.style.setProperty('--colorFond', grey);
	}
	else
	{
		root.style.setProperty('--colorBoite', grey);
		root.style.setProperty('--colorFond', "white");
	}
	localStorage.setItem("sombre", sombre);
	sombre = !sombre;
}

window.addEventListener('DOMContentLoaded', theme);

// EXERCICE 5

function initTooltip()
{
	var mesTooltips = document.querySelectorAll('*[data-tooltip]');
	for(var i=0; i<mesTooltips.length; i++)
	{
		let tooltip = document.createElement('div');
		tooltip.innerHTML = mesTooltips[i].getAttribute('data-tooltip');
		tooltip.style.display = "none";
		root.appendChild(tooltip);
		mesTooltips[i].addEventListener('mousemove', function(e){
			tooltip.style.position = "fixed";
			tooltip.style.top = (e.clientY-5) + "px";
			tooltip.style.left = (e.clientX+5) + "px";
		});
		mesTooltips[i].addEventListener('mouseout', function(){
			tooltip.style.display = "none";
		});
		mesTooltips[i].addEventListener('mouseenter', function(){
			tooltip.style.display = "block";
		});
	}
}

window.addEventListener('DOMContentLoaded', initTooltip);