/*JS*/

var latitude, longitude;

function activeLocation()
{
	if(navigator.geolocation)
		navigator.geolocation.getCurrentPosition(showLocation);
	else
		document.querySelector('#x').innerHTML = "Votre navigateur ne supporte pas la géolocalisation.";
}

function showLocation(position)
{
	latitude = position.coords.latitude;
	longitude = position.coords.longitude;
	// console.log(latitude + " x " + longitude);
	ajaxOpenSM(latitude, longitude);
}

function ajaxOpenSM(latitude, longitude)
{
	var req = new XMLHttpRequest();
	req.open('GET', 'https://nominatim.openstreetmap.org/reverse?format=json&lat=' + latitude + '&lon=' + longitude, true);
	req.onreadystatechange = callback;
	req.send();
}

function callback(e)
{
	// console.log(e.currentTarget);
	if(e.currentTarget.readyState === XMLHttpRequest.DONE)
	{
		if(e.currentTarget.status === 200)
		{
			console.log(e.currentTarget.responseText);
			var codeP = getCP(e.currentTarget.responseText);
			colorDPT(codeP);
		}
		else
		{
			alert(e.currentTarget.status);
		}
	}
}

function getCP(reponse)
{
	var json = JSON.parse(reponse);
	var cp = json.address.postcode[0] + json.address.postcode[1];
	return parseInt(cp);
}

function colorDPT(dpt)
{
	document.querySelector('path[data-num="' + dpt + '"]').style.fill = "red";
}

activeLocation();