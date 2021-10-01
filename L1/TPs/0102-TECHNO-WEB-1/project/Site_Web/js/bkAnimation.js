var root = document.documentElement;

// renvoi des var x et y dans la racine (utilisation des coordonnées de la souris dans la gestion du fond css)

root.addEventListener('mousemove', function(e){
	root.style.setProperty('--x', e.clientX + 'px');
	root.style.setProperty('--y', e.clientY + 'px');
});

// création et affectation dans le DOM d'un tooltip pour chaque élément d'attribut data-tooltip

var tools = $('*[data-tooltip]');

for(var i=0; i<tools.length; i++)
{
	var div = document.createElement('div');
	
	div.innerHTML = tools[i].getAttribute('data-tooltip');
	tools[i].setAttribute('data-index', i);
	div.setAttribute('class', 'tools');
	div.style.position = "fixed";
	div.style.display = "none";
	root.appendChild(div);

	tools[i].addEventListener('mouseenter', function(e){
		var tool = $('.tools');
		tool[e.target.getAttribute('data-index')].style.display = "block";
	});
	tools[i].addEventListener('mouseout', function(e){
		var tool = $('.tools');
		tool[e.target.getAttribute('data-index')].style.display = "none";
	});
	tools[i].addEventListener('mousemove', function(e){
		var tool = $('.tools');
		tool[e.target.getAttribute('data-index')].style.top = (e.clientY + -15) + "px";
		tool[e.target.getAttribute('data-index')].style.left = (e.clientX + 15) + "px";
	});
	
}

