var position = document.documentElement;

position.addEventListener('mousemove', function(e){
	position.style.setProperty('--x', e.clientX + 'px');
	position.style.setProperty('--y', e.clientY + 'px');
});