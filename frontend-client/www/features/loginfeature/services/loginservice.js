angular.module('worldquest.services', [])

.factory('loginservice', function($http){
	verifiedTeam= {};

	function sendForVerification(loginInfo){	
		console.log(loginInfo);
		$http({
			method: 'GET',
			url: 'http://127.0.0.1:8080/team/auth' + loginInfo,
		}).then(function successCallback(output){
			verifiedTeam = output.data;
			return verifiedTeam;
		})
	}

	function getVerified(){
		return verifiedTeam;
	}
		
	return {
		sendForVerification: sendForVerification,
		getVerified : getVerified
	};
});