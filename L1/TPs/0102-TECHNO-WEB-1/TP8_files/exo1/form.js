document.querySelector('#submit').addEventListener('click', function(){
	var lastname = document.getElementsByName('lastname');
	var firstname = document.getElementsByName('firstname');
	var birth = document.getElementsByName('birth');
	var birthplace = document.getElementsByName('birthplace');
	var location_name = document.getElementsByName('location_name');
	var code = document.getElementsByName('code');
	var city = document.getElementsByName('city');
	var mail = document.getElementsByName('mail');

	document.querySelector('#submit').type = 'button';
	up([lastname[0], firstname[0], birthplace[0], location_name[0], city[0]]);
	verifMail(mail[0]);
	verifAge(birth[0]);
	verifCode(code[0]);
	if(confirm(formulaire()))
	{
		document.querySelector('#submit').type = 'submit';
	}
});

function up(arr)
{
	for(var i=0; i<arr.length; i++)
	{
		arr[i].value = arr[i].value.toUpperCase();
	}
}

function verifMail(mail)
{
	mail.value = mail.value.toLowerCase();
	while(!mail.value.match(new RegExp('([a-z0-9]+)@([a-z\-\.]+)\.([a-z]+)')))
		mail.value = prompt("Mail incorrect ! Réessayez ici :").toLowerCase();
}

function verifAge(age)
{
	var regex = new RegExp('([0-9]{2})/([0-9]{2})/([0-9]{4})')
	while(!age.value.match(regex))
		age.value = prompt("Date incorrecte ! Réessayez ici :");
	var an = parseInt(age.value.replace(regex, '$3'));
	// console.log(an);
	var now = new Date();
	if(now.getFullYear()-an < 0 || now.getFullYear()-an > 130)
	{
		alert("Votre age n'est pas correct !");
	}
}

function verifCode(code)
{
	while(code.value < 1000 || code.value > 99999)
	{
		code.value = prompt("Code postal incorrect.");
	}
}

function formulaire()
{
	var input = document.querySelectorAll('input[data-input]');
	var select = document.getElementsByName('location_type');
	select = select[0].value;
	var gender = document.querySelector('input[type="radio"]:checked').value;
	var comment = document.getElementsByName('comment');
	comment = comment[0].value;
	var str = "";
	var i=0;
	for(i; i<4; i++)
	{
		str += input[i].name + " => " + input[i].value + "\n";
	}
	str += "gender => " + gender + "\n";
	str += "location => " + input[i].value + " " + select + " " + input[i+1].value + "\n";
	for(i = i+2; i<input.length; i++)
	{
		str += input[i].name + " => " + input[i].value + "\n";
	}
	str += "comment => " + comment;
	return str;
}