angular.module('worldquest.controllers', [])

.controller('logincontroller', function($scope, loginservice, $state){

		var team= {};
	 	$verifiedTeam={};
	 	$scope.alertMessage;

	 	$scope.sendForVerification= function(){
			team.name=$scope.name;
			team.password= $scope.password;
			team.url = "?name=" + $scope.name + "&password=" + $scope.password;
			loginservice.sendForVerification(team.url);
		}

		 $scope.$watch(function(){return loginservice.getVerified();}, function(newVal, oldVal) {
		     if (newVal !== null && newVal != "Unauthorized") {
		     	$scope.verifiedTeam = newVal;
		     	$state.go('question');
		     } else if(newVal == "Unauthorized"){
		     	$scope.alertMessage = "Please try again"

		     }
		     console.log($scope.alertMessage)
      });
		     

		
})