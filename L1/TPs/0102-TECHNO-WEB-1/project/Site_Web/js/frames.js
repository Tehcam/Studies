// gestion du fond (coleur et effet)

$(document).ready(toggleMenu);

function toggleMenu()
{
	var root = document.documentElement;
	var sombre = localStorage.getItem('sombre');
	if(sombre == "true")
	{
		root.style.setProperty('--bkcolor', 'rgb(30, 30, 45)');
		root.style.setProperty('--title-color', 'white');
		root.style.setProperty('--shadow-color', 'black');
		root.style.setProperty('--before-display', 'initial');
	}else{
		root.style.setProperty('--bkcolor', 'white');
		root.style.setProperty('--title-color', 'black');
		root.style.setProperty('--shadow-color', 'white');
		root.style.setProperty('--before-display', 'none');
	}
}