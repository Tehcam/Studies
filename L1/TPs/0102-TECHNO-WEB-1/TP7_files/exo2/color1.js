function toHexa(x)
{
	switch(x)
	{
		case 10:
			x = 'a';
			break;
		case 11:
			x = 'b';
			break;
		case 12:
			x = 'c';
			break;
		case 13:
			x = 'd';
			break;
		case 14:
			x = 'e';
			break;
		case 15: x ='f';
	}

	return x;
}

function createColor(r, g, b)
{
	r = toHexa(r);
	g = toHexa(g);
	b = toHexa(b);
	return "#"+r+g+b;
}

(function()
{
	document.write("<table cellpadding=\"10px\">");
	for(var r=0; r<16; r++)
	{
		for(var g=0; g<16; g++)
		{
			document.write("<tr>");
			for(var b=0; b<16; b++)
			{
				document.write("<td style=\"background-color:" + createColor(r, g, b) + ";\"> </td>");
			}
			document.write("</tr>");
		}
	}
	document.write("</table>");
})();