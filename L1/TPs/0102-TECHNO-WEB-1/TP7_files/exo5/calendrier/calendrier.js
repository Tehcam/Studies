function printArr(arr, elem, cal)
{
	var tr = document.createElement('tr');
	tr.setAttribute('class', 'week');
	var td;
	for(var i=0; i<7; i++)
	{
		td = document.createElement('td');
		td.innerHTML = arr[i];
		tr.appendChild(td);
	}
	cal.replaceChild(tr, elem);
}

function toTime(date)
{
	return date.getTime();
}

function getToday()
{
	var date = new Date();
	return toTime(zero(date));
}

function addDay()
{
	var date = new Date(1970, 0, 2);
	return toTime(zero(date));
}

function getWeek(timeOf)
{
	var date = new Date();
	date = zero(date);
	var today = new Date();
	today.setTime(timeOf);
	today = zero(today);
	var week = new Array(7);
	var k=1, j=1;
	for(var i=today.getDay()-1; i>=0; i--)
	{
		date.setTime(today.getTime() - k*addDay());
		week[i] = date.getDate();
		k++;
	}
	for(var i=today.getDay(); i<7; i++)
	{
		date.setTime(today.getTime() + j*addDay());
		week[i] = date.getDate();
		j++;
	}
	return week;
}

function getWeekIndex(today)
{
	var date = new Date();
	date.setTime(toTime(zero(today)));
	var i=0;
	do
	{
		date.setTime(toTime(date) - 7*addDay());
		i++;
	}while(date.getMonth() == today.getMonth());
	return i;
}

function isWeek(week)
{
	var i=0;
	var bool = false;
	while(i<week.length && !bool)
	{
		if(week[i] == 1)
			bool = true;
		i++;
	}
	return bool;
}

function Calendrier(mois, an)
{
	var changingDate = new Date();
	changingDate = zero(changingDate);
	changingDate.setMonth(mois);
	changingDate.setFullYear(an);
	var cal = document.querySelector('.calendrier tbody');
	var weeks = document.querySelectorAll('.week');
	var index = getWeekIndex(changingDate)*7;
	var week;
	for(var i=0; i<5; i++)
	{
		week = getWeek(toTime(changingDate) - index*addDay());
		if(isWeek(week) && i==0)
		{
			printArr(week, weeks[i], cal);
		}
		else if(i==0)
		{
			i--;
		}
		else
		{
			printArr(week, weeks[i], cal);
		}
		index -= 7;
	}
}

function zero(date)
{
	date.setHours(0);
	date.setMinutes(0);
	date.setSeconds(0);
	date.setMilliseconds(0);
	return date;
}

/************** MAIN **************/

var an = document.getElementsByName('an');
an = an[0];
var val;
for(var i=2000; i<2051; i++)
{
	val = document.createElement('option');
	val.value = val.innerHTML = i;
	an.appendChild(val);
}
var firstDate = new Date();
firstDate = zero(firstDate);
Calendrier(firstDate.getMonth(), firstDate.getFullYear());

var select = document.querySelectorAll('select');
for(var i=0; i<select.length; i++)
{
	select[i].addEventListener('change', function(){
		var mois = document.getElementsByName('mois');
		mois = mois[0].value;
		if(mois == "def")
		{
			mois = firstDate.getMonth();
		}else{
			mois = parseInt(mois);
		}
		var an = document.getElementsByName('an');
		an = an[0].value;
		if(an == "def")
		{
			an = firstDate.getFullYear();
		}else{
			an = parseInt(an);
		}
		Calendrier(mois, an);
	});
}