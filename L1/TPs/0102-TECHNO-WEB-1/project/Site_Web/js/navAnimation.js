// gestion de l'affichage du menu de navigatoire au clique sur l'icone menu

document.getElementById('menu').addEventListener('click', showNav);
document.getElementById('nav-bkg').addEventListener('click', showNav);

function showNav()
{
	$('.nav').toggle();	
}

// gestion du changement de couleur de fond

// appel de la fonction dès le chargement de la page
$(document).ready(toggleMenu);

// puis ecoute d'un event
document.getElementById('toggleTheme').addEventListener('click', function(){
	var sombre = localStorage.getItem('sombre');
	if(sombre == "true")
		toggleTheme(true);
	else
		toggleTheme(false);
});

// fonctions utilisées lors du changement de thème :
function toggleMenu()
{
	var root = document.documentElement;
	var sombre = localStorage.getItem('sombre');
	if(sombre == "true")
	{
		$('#toggleTheme .non').css({
			textDecoration: 'none',
			color: 'currentColor'
		});
		$('#toggleTheme .oui').css({
			textDecoration: 'underline',
			color: 'black'
		});
		root.style.setProperty('--bkcolor', 'rgb(30, 30, 45)');
		root.style.setProperty('--title-color', 'white');
		root.style.setProperty('--shadow-color', 'black');
		root.style.setProperty('--content-color', 'rgba(90, 90, 90, .7)');
		root.style.setProperty('--before-display', 'initial');
		root.style.setProperty('--foot-color', 'rgba(255, 255, 255, .6)');
		$('#logo').css({background: 'transparent'});
	}else{
		$('#toggleTheme .oui').css({
			textDecoration: 'none',
			color: 'currentColor'
		});
		$('#toggleTheme .non').css({
			textDecoration: 'underline',
			color: 'black'
		});
		root.style.setProperty('--bkcolor', 'white');
		root.style.setProperty('--title-color', 'black');
		root.style.setProperty('--shadow-color', 'white');
		root.style.setProperty('--content-color', 'rgba(90, 90, 90, .2)');
		root.style.setProperty('--before-display', 'none');
		root.style.setProperty('--foot-color', 'rgba(0, 0, 0, .5)');
		$('#logo').css({background: 'gray'});
	}
}

function toggleTheme(isSombre)
{
	isSombre = !isSombre;
	localStorage.setItem('sombre', isSombre);
	toggleMenu();
}