// lien vers la page de commentaire (bouton en fin du footer)

document.querySelector('.comment-container').addEventListener('click', function(){
	window.location.href = "commentaire.html";
});

// vérification puis envoi (si estValide renvoi true) du formulaire destiné au(x) commentaire(s)

document.querySelector('#submit').addEventListener('click', function(){
	if(estValide())
		this.type = "submit";
	else
		alert("Merci de remplir l'intégralité du formulaire.");
});

function estValide()
{
	var bool = true;
	var type = document.getElementsByName('type');
	var comment = document.getElementsByName('comment');
	if(type[0].value == "none")
		bool = false;
	if(comment[0].value == "")
		bool = false;
	return bool;
}