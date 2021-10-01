function Options()
{
	var select = document.querySelector('#an');
	for(var i=2000; i<=2050; i++)
	{
		var opt = document.createElement('option');
		opt.value = opt.innerHTML = i;
		select.appendChild(opt);
	}
}

function Calendrier()
{
	var date = new Date();

	// Dans le cas où l'utilisateur modifier le calendrier manuellement, on verifie et modifie la date
	// Sinon elle reste inchangée
	var tdYear = verifYear(date.getFullYear());
	var tdMonth = verifMonth(date.getMonth());
	var tdDay = verifDay(date.getDay(), tdMonth, tdYear, date);
	var tdDate = verifDate(date.getDate(), tdMonth, tdYear, date);

	// tableau semaine x jours
	var tab = [
			[0, 0, 0, 0, 0, 0, 0],
			[0, 0, 0, 0, 0, 0, 0],
			[0, 0, 0, 0, 0, 0, 0],
			[0, 0, 0, 0, 0, 0, 0],
			[0, 0, 0, 0, 0, 0, 0]
	];

	var k = tdDay;
	var i=0;

	for(var j=parseInt(tdDate/7)+1; j>=0; j--)
	{
		for(k; k>=0; k--)
		{
			if(tdDate-i>0)
				tab[j][k] = tdDate - i;
			i++;
		}
		k=6;
	}

	k = tdDay;
	i=0;

	for(var j=parseInt(tdDate/7)+1; j<5; j++)
	{
		for(k; k<7; k++)
		{
			if(tdDate+i <= nbDay(tdMonth, tdYear))
				tab[j][k] = tdDate + i;
			i++;
		}
		k=0;
	}

	afficheTab(tab);
}

Options();
Calendrier();

var opt = document.querySelectorAll('select');
for(var i=0; i<opt.length; i++)
{
	opt[i].addEventListener('change', Calendrier);
}

function afficheTab(arr)
{
	var tab = document.createElement('table');
	tab.border = '1px';

	var head = document.createElement('thead');
	for(var i=0; i<7; i++)
	{
		var th = document.createElement('th');
		switch(i)
		{
			case 0: th.innerHTML = "Dim";
			break;
			case 1: th.innerHTML = "Lun";
			break;
			case 2: th.innerHTML = "Mar";
			break;
			case 3: th.innerHTML = "Mer";
			break;
			case 4: th.innerHTML = "Jeu";
			break;
			case 5: th.innerHTML = "Ven";
			break;
			case 6: th.innerHTML = "Sam";
		}
		head.appendChild(th);
	}
	tab.appendChild(head);

	var body = document.createElement('tbody');
	for(var j=0; j<5; j++)
	{
		var tr = document.createElement('tr');
		for(var k=0; k<7; k++)
		{
			var td = document.createElement('td');
			td.innerHTML = arr[j][k];
			tr.appendChild(td);
		}
		body.appendChild(tr);
	}
	tab.appendChild(body);

	if(typeof document.querySelector('section').lastChild === 'object')
		document.querySelector('section').removeChild(document.querySelector('section').lastChild);
	document.querySelector('section').appendChild(tab);
}

function isBix(year)
{
	return year%400 == 0 || (year%4 == 0 && year%100 != 0);
}

function nbDay(month, year)
{
	month = parseInt(month) + 1;
	year = parseInt(year);
	var result;
	if(month == 2)
	{
		if(isBix(year))
		{
			result = 29;
		}
		else
		{
			result = 28;
		}
	}
	else if(month < 8)
	{
		if(month%2 == 0)
		{
			result = 30;
		}
		else
			result = 31;
	}
	else
	{
		if(month%2 != 0)
		{
			result = 30;
		}
		else
			result = 31;
	}
	return result;
}

function verifYear(year)
{
	var select = document.querySelector('#an').value;
	var result;
	if(select == "default")
		result = year;
	else
		result = parseInt(select);
	console.log(result);
	return result;
}

function verifMonth(month)
{
	var select = document.querySelector('#mois').value;
	var result;
	if(select == "default")
		result = month;
	else
		result = parseInt(select);
	console.log(result);
	return result;
}

function verifDate(date, month, year, today)
{
	var tdMonth = today.getMonth();
	var tdYear = today.getFullYear();
	if(tdMonth != month || tdYear != year)
		date = 1;
	return date;
}

function verifDay(day, month, year, today)
{
	var tdMonth = today.getMonth();
	if(month < tdMonth)
	{
		do
		{
			day = findFirstDay(day, today.getDate());
			day--;
			if(day<0)
				day = 6;
			tdMonth--;
		}while(tdMonth != month);
		day = toYear(day, year, today);
	}
	else if(month > tdMonth)
	{
		do
		{
			day = findFirstDay(day, today.getDate());
			day += nbDay(tdMonth, today.getFullYear())%7;
			if(day>6)
				day = day%7;
			tdMonth++;
		}while(tdMonth != month);
		day = toYear(day, year, today);
	}
	return day;
}

function findFirstDay(day, d)
{
	while(d != 1)
	{
		day--;
		if(day<0)
			day = 6;
		d--;
	}
	return day;
}

function toYear(day, year, today)
{
	var tdYear = today.getFullYear();
	if(year < tdYear)
	{
		do
		{
			if(isBix(tdYear) || isBix(tdYear-1))
			{
				day = findFirstDay(day, 366%7);
				day--;
				if(day<0)
					day = 6;
			}
			else
			{
				day = findFirstDay(day, 365%7);
				day--;
				if(day<0)
					day = 6;
			}
			tdYear--;
		}while(tdYear != year);
	}
	else if(year > tdYear)
	{
		do
		{
			if(isBix(tdYear) || isBix(tdYear+1))
			{
				day += 366%7;
				if(day>6)
					day = day%7;
			}
			else
			{
				day += 365%7;
				if(day>6)
					day = day%7;
			}
			tdYear++;
		}while(tdYear != year);
	}
	return day;
}