var jsonObj = {};
var isUpdate = false;
var targetId = null;

(function() {
	window.onload = function(){
		
		$.ajax({
			url : '/selectUser',
			type : 'GET',
			dataType : 'json',
			success : function(result){
				for (var i = 0; i < result.length; i++) {
					var obj = result[i];
					jsonObj[obj["ndis"]] = obj;
					$('#users').append('<option value="'+obj["ndis"]+'">'+obj["ndis"]+'</option>');
				}
			}
		});
		
		$('#btn_save').on('click',function(){
			if(validation()){
				if(isUpdate){
					$.ajax({
						url : '/updateUser',
						type : 'POST',
						dataType : 'json',
						data : {
							'targetId' : targetId,
							'ndis' : $('#ndis').val(),
							'name' : $('#name').val(),
							'address' : $('#address').val(),
							'phone' : $('#phone').val(),
							'nok' : $('#nok').val(),
							'dob' : $('#dob').val(),
							'device' : $('#device').val(),
							'notes' : $('#notes').val(),
							'profile' : $("#profilePicture").attr('src')
						},
						success : function(data){
							location.reload(true);
						}
					});
				}else{
					$.ajax({
						url : '/addUser',
						type : 'POST',
						dataType : 'json',
						data : {
							'ndis' : $('#ndis').val(),
							'name' : $('#name').val(),
							'address' : $('#address').val(),
							'phone' : $('#phone').val(),
							'nok' : $('#nok').val(),
							'dob' : $('#dob').val(),
							'device' : $('#device').val(),
							'notes' : $('#notes').val(),
							'profile' : $("#profilePicture").attr('src')
						},
						success : function(data){
							location.reload(true);
						}
					});	
				}
			}
		});
		
		$('#profile').on('change',function(){
			if ($(this)[0].files && $(this)[0].files[0]) {
				var FR= new FileReader();
				FR.onload = function(e) {
					$('#profilePicture').attr( "src", e.target.result );
				};
				FR.readAsDataURL($(this)[0].files[0]);
			}
		});
		
		$('#users').on('change',function(){
			if($(this).val() == 'create'){
				location.reload(true);
			}else{
				var user = jsonObj[$(this).val()];
				$('#ndis').val(user.ndis);
				$('#name').val(user.name);
				$('#address').val(user.address);
				$('#phone').val(user.phone);
				$('#nok').val(user.nok);
				$('#dob').val(user.dob);
				$('#device').val(user.device);
				$('#notes').val(user.notes);
				$('#profilePicture').attr('src', user.profile);
				isUpdate = true;
				targetId = $(this).val();
				
			}
		});
	};
})();



function validation(){
	if($.trim($('#ndis').val()) == ""){
		alert("Please enter your ID.");
		$('#ndis').focus();
		return false;
	}else if($.trim($('#name').val()) == ""){
		alert("Please enter your name.");
		$('#name').focus();
		return false;
	}else if($.trim($('#address').val()) == ""){
		alert("Please enter your address.");
		$('#address').focus();
		return false;
	}else if($.trim($('#phone').val()) == ""){
		alert("Please enter your phone number.");
		$('#phone').focus();
		return false;
	}else if($.trim($('#nok').val()) == ""){
		alert("Please enter your next of kin.");
		$('#nok').focus();
		return false;
	}else if($.trim($('#dob').val()) == ""){
		alert("Please enter your date of birth.");
		$('#dob').focus();
		return false;
	}
	return true;
}

