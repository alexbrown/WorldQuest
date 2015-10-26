angular.module('worldquest.services', [])

.factory('loginservice', function($http){
	verifiedTeam= {};
	url = 'http://127.0.0.1:8080/team/auth';


	function sendForVerification(loginInfo){
		$http({
			method: 'POST',
			url: url,
			data: loginInfo
		}).then(function successCallback(output){
			verifiedTeam = output.data;
			return verifiedTeam;
		})
	}

	function getResponse(){
		return response;
	}
		
	return {
		sendForVerification: sendForVerification,
		getResponse: getResponse
	};
	


	return {
		verify : verify
	}
});