angular.module('worldquest.services', [])

.factory('loginservice', function($http){
	verifiedTeam= {};
	var teamId = null;

	function sendForVerification(loginInfo){	
		console.log(loginInfo);
		$http({
			method: 'GET',
			url: 'http://127.0.0.1:8080/team/auth' + loginInfo,
		}).then(function successCallback(output){
			verifiedTeam = output.data;
			if(verifiedTeam.name != "Unauthorized"){
				teamId = verifiedTeam.teamId;
			} else{
				teamId = "Unauthorized"
			}
			
		})
	}

	function getVerified(){
		return teamId;
	}
		
	return {
		sendForVerification: sendForVerification,
		getVerified : getVerified
	};
});