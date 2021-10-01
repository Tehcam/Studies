var button = document.querySelector(".button");

button.addEventListener('click', function()
{
	alert("Ceci est un message d'alerte !");
	if(confirm("Voulez vous continuer ?"))
	{
		var string = prompt("Entrer vos données : {nom}, {prénom}, {age}, {adresse}", "ERROR");
		const exp = new RegExp(/([A-Za-z\-]+), ([A-Za-z\-]+), ([0-9]{1,2} *[a-z]*), (\w+\ *)/);
		if(string.match(exp))
		{
			var result = string.split(', ');
			for(var elem of result)
			{
				console.log(elem);
			}
		}
	}
})