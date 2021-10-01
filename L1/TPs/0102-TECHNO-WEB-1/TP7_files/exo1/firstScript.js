var hello = "Bonjour ",
	world = "tout le monde !";

function sayHello()
{
	var elem = document.createElement("p");
	elem.innerHTML = hello + world + "<br>Comment allez-vous ?";
	elem.style = "text-align:center;";
	document.body.appendChild(elem);
}

function putTable()
{
	var table = document.createElement("table");
	table.border = "1px";
	table.cellpadding = "1em";
	table.style = "margin:2em;";

	var row = document.createElement("tr");
	var d1, d2;
	d1 = document.createElement("td");
	d2 = document.createElement("td");

	row.appendChild(d1);
	row.appendChild(d2);
	table.appendChild(row);
	document.body.appendChild(table);
}

function putImg(source)
{
	var img = document.createElement("img");
	img.src = source;
	return img;
}

function putList()
{
	var list = document.createElement("ul");
	var li1, li2, li3;
	li1 = document.createElement("li");
	li2 = document.createElement("li");
	li3 = document.createElement("li");
	li1.innerHTML = li2.innerHTML = li3.innerHTML = "Blabla";
	list.appendChild(li1);
	list.appendChild(li2);
	list.appendChild(li3);
	return list;
}

function main()
{
	sayHello();
	putTable();

	var data = document.querySelectorAll("td");
	data[0].appendChild(putImg("image.jpg"));
	data[1].appendChild(putList());
}

main();