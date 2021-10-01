//FEUILLE DE SCRIPT
//script pour les boutons de la page 005_MachetCorentin.html


//déclaration de la fonction 'query':
function query(identity, style){
	var id = identity,
		st = style,
		idElement = document.querySelector(id);

	idElement.addEventListener('click',function(){
		var styleElement = document.querySelector(st).getAttribute('style');
		switch(true){
			case styleElement === 'display: block;': 
				document.querySelector(st).setAttribute('style', 'display: none;');
			break;
			case styleElement === 'display: none;': 
				document.querySelector(st).setAttribute('style', 'display: block;');
			break;
			default: console.log(styleElement);
		}
	});
}




//declaration de la fonction 'articleLighter' :
var article = document.querySelectorAll(".cv_article_content");
var cv = document.querySelectorAll(".cv_article_menu");
var cvArr = {};

function opacity(){
	for(var k=0; k<article.length; k++){
		article[k].setAttribute('style', 'opacity: .2;');
	}
}
function lighter(x){
	article[x].setAttribute('style', 'opacity: 1;');
}

function articleLighter(){
	for(var i=0; i<cv.length; i++){
		var cvi = cv[i].textContent;
		cvArr[cvi] = i;

		cv[i].addEventListener('click', function(e){
			var etar = e.target.textContent;
			var y = cvArr[etar];

			opacity();
			lighter(y);
		});
	}
}




//déclaration de la fonction 'option' :
var mode = document.querySelectorAll('.changingMode_option');

function option(butt, nav, mod){
	var butt = butt,
		nav = nav,
		mod = mod;

	for(var n=0; n<mode.length; n++){
		mode[n].addEventListener('click', function(e){
			switch(true){
				case e.target.textContent === butt :
					linkQuery('#nav_default').setAttribute('href', nav);
					if(mod){
						linkQuery('#style_mode_default').setAttribute('href', mod);
					}
					break;
				default: break;
			}

			switch(true){
				case linkQuery('#style_mode_default').href === "../css_005/005_MachetCorentin/005_MachetCorentin_1.css" 
				&& linkQuery('#nav_default').href === "../css_005/005_MachetCorentin/005_MachetCorentin_nav_default_1.css" :
					linkQuery('#lower_side_default').href = "../css_005/005_MachetCorentin/005_MachetCorentin_lowerside_1.css";
					linkQuery('#nav_lowerside').href = "../css_005/005_MachetCorentin/005_MachetCorentin_nav_lowerside_1-1.css";
					break;
				case linkQuery('#style_mode_default').href === "../css_005/005_MachetCorentin/005_MachetCorentin_2.css" 
				&& linkQuery('#nav_default').href === "../css_005/005_MachetCorentin/005_MachetCorentin_nav_default_1.css" :
					linkQuery('#lower_side_default').href = "../css_005/005_MachetCorentin/005_MachetCorentin_lowerside_2.css";
					linkQuery('#nav_lowerside').href = "../css_005/005_MachetCorentin/005_MachetCorentin_nav_lowerside_2-1.css";
					break;
				case linkQuery('#style_mode_default').href === "../css_005/005_MachetCorentin/005_MachetCorentin_1.css" 
				&& linkQuery('#nav_default').href === "../css_005/005_MachetCorentin/005_MachetCorentin_nav_default_2.css" :
					linkQuery('#lower_side_default').href = "../css_005/005_MachetCorentin/005_MachetCorentin_lowerside_1.css";
					linkQuery('#nav_lowerside').href = "../css_005/005_MachetCorentin/005_MachetCorentin_nav_lowerside_1-2.css";
					break;
				case linkQuery('#style_mode_default').href === "../css_005/005_MachetCorentin/005_MachetCorentin_2.css" 
				&& linkQuery('#nav_default').href === "../css_005/005_MachetCorentin/005_MachetCorentin_nav_default_2.css" :
					linkQuery('#lower_side_default').href = "../css_005/005_MachetCorentin/005_MachetCorentin_lowerside_2.css";
					linkQuery('#nav_lowerside').href = "../css_005/005_MachetCorentin/005_MachetCorentin_nav_lowerside_2-2.css";
					break;
				default: break;
			}

		});
	}
}
function linkQuery(link){
	var lq = document.querySelector(link);
	return lq;
}




//fonction relative au lien 'accueil' disponible sur le header commun :
document.querySelector("#title_presentation").addEventListener('click', function(){
	window.location.href = "../index_005.html";
});

//fonction relative au nav en lowerside
var width = window.innerWidth;
var height = window.innerHeight;
var menuDuSite_1 = document.querySelector('#menu_du_site_content');
var menuDuSite_2 = document.querySelector('#menu_du_site_items');
var errorMsg = document.querySelector('#lowerside_message');

if(width<964 || height<600){
	alert('Vous utilisez la version "lowerside" de ce site : il se peut que certains modes du menu "option" soient alors inadaptés. Dans ce cas, augmenter la taille de la page pour remédier au problème.');
	errorMsg.style = "display: block;" ;
	menuDuSite_1.style = "display: none;" ;
	menuDuSite_2.style = "display: none;" ;
	document.querySelector('#menu_du_site_005').addEventListener('click', function(){
		menuDuSite_1.style = "display: block;" ;
		menuDuSite_2.style = "display: block;" ;
	
		document.querySelector('#menu_du_site_content').addEventListener('click', function(){
			window.location.reload();
		});

	});
}

window.addEventListener('resize', function(){
	window.location.reload();
});