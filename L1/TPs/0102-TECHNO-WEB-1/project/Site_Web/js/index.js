// bouton du footer vers la page de commentaire

document.querySelector('.comment-container').addEventListener('click', function(){
	window.location.href = "html/commentaire.html";
});

// lien des boutons du corps de page vers la référence passé en attribut data-href des éléments de classe .main

var mains = $('.main');

for(var i=0; i<mains.length; i++)
{
	mains[i].addEventListener('click', function(){
		window.location.href = this.dataset.href;
	});
}