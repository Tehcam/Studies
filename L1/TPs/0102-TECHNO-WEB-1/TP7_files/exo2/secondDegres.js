var form = document.querySelector("#submit");
var result = document.querySelector("p");

form.addEventListener('click', function()
{
	var a = parseInt(document.querySelector("#A").value);
	var b = parseInt(document.querySelector("#B").value);
	var c = parseInt(document.querySelector("#C").value);

	var delta = (b*b)+(-4*a*c);

	if(delta >= 0)
	{
		if(delta == 0)
		{
			result.innerHTML = "<i>x</i> = " + ((-b)/(2*a));
		}
		else
		{
			result.innerHTML = "<i>x</i> = " + ((-b+Math.sqrt(delta))/(2*a)) + "<br>ou<br>" + "<i>x</i> = " + ((-b-Math.sqrt(delta))/(2*a));
		}
	}
	else
	{
		result.innerHTML = "Il n'existe aucune solution réel de cette équation.";
	}
});