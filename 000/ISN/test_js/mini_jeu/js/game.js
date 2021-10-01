(function(){
	var movingSpan = {},
		span = document.querySelectorAll('.span'),
		eachSpan = span.length;

	for (var i = 0; i < eachSpan; i++) {
		span[i].addEventListener('mousedown', function(e){
			var m = movingSpan;
			e.target.style.position = 'absolute';
			e.target.style.top = null; 
			e.target.style.left = null;
			e.target.style.float = 'left';
			m.target = e.target;
			m.offSetX = e.clienX - m.target.offSetLeft;
			m.offSetY = e.clientY - m.target.offSetTop;
		});

		span[i].addEventListener('mouseup', function(e){
			movingSpan = {};
			e.target.style.position = 'relative';
			e.target.style.top = '30%';
			e.target.style.float = 'none';
			switch(true){
				case e.target.id = 'a0' : e.target.style.left = '7%';
				break;
				case e.target.id = 'a1' : e.target.style.left = '12%';
				break;
				case e.target.id = 'a2' : e.target.style.left = '17%';
				break;
				case e.target.id = 'a3' : e.target.style.left = '22%';
				break; 
			}
		});
	}

	document.addEventListener('mousemove', function(e){
		var target = movingSpan.target;
		if (target) {
			target.style.top = e.clientY - movingSpan.offSetTop + 'px';
			target.style.left = e.clienX - movingSpan.offSetLeft + 'px';
		}
	});

})();



