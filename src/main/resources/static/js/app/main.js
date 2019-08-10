var main = {
	init : function(){
		var _this = this;
		$('#btn-save').on('click', function(){
			_this.save();
		});
	},
	save : function(){
		var data = {
			title: $('#title').val(),
			author: $('#author').val(),
			content: $('#content').val()
		};
		
		$.ajax({
			type: 'post',
			url: '/posts',
			dataType: 'json',
			contentType: 'application/json; charset=urf-8',
			data: JSON.stringify(data)
		}).done(function(){
			alert('글이 등록되었습니다.');
			location.reload();
		}).fail(function(error){
			alert(error);
		});
	}
}

main.init();

/*
만약 main.js의 각 function을 각 변수에 따로 선언하게 되면
나중에 불러온 js의 init이나 save 함수가 있을 때 이 js의 function을 덮어쓰는 문제가 생긴다.
(브라우저의 scope는 공용으로 쓰기 때문) 
그렇기 때문에 main 객체 안에 function을 선언한다. (main 객체 안에서만 이름이 유요하기 때문에 다른 js와 겹칠 위험이 사라짐)

프론트엔드의 이런 의존성 관리나 scope 관리 등의 문제로 Angular, React등은 이미 이런 기능을 프레임워크 레벨에서 지원하고 있다.
*/