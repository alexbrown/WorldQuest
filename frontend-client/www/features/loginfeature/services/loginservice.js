angular.module('worldquest.services', [])

.factory('loginservice', function($http){
	verifiedTeam= {};
	url = 'http://127.0.0.1:8080/team/auth';


	function sendForVerification(loginInfo){
		console.log(loginInfo);
		
		$http({
			method: 'GET',
			url: url,
			data: loginInfo
		}).then(function successCallback(output){
			console.log(output);
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
});