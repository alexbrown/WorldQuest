angular.module('worldquest.controllers', [])

.controller('logincontroller', function($scope, loginservice){

		var team= {};
	 	
	 	$scope.sendForVerification= function(){
			team.name=$scope.name;
			team.password= $scope.password;
			console.log(team);
			loginservice.sendForVerification(team);
	}


})