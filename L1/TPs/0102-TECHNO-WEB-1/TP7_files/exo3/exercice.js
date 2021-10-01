(function()
{
	document.querySelector("p").innerHTML = "Le protocol utilisé est " + window.location.protocol + "<br> Et son URL est " + window.location.href;
	window.defaultStatus = "Ceci est un test avec les objets du navigateur...";

	var span = document.querySelectorAll("span");

	for(var i=0; i<4; i++)
	{
		span[i].addEventListener('click', function()
		{
			switch(this.id)
			{
				case "red" :
					document.body.style = "background-color: red;";
					break;
				case "yell" :
					document.body.style = "background-color: yellow;";
					break;
				case "green" :
					document.body.style = "background-color: green;";
					break;
				case "blue" :
					document.body.style = "background-color: blue;";
			}
		})
	}

})();