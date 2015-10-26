angular.module('worldquest.controllers', [])

.controller('logincontroller', function($scope, loginservice, $state){

		var team= {};
	 	$verifiedTeam={};

	 	$scope.sendForVerification= function(){
			team.name=$scope.name;
			team.password= $scope.password;
			team.url = "?name=" + $scope.name + "&password=" + $scope.password;
			loginservice.sendForVerification(team.url);
	}

		 $scope.$watch(function(){return loginservice.getVerified();}, function(newVal, oldVal) {
		     if (typeof newVal !== 'undefined') {
		        $scope.verifiedTeam = newVal;
		        if(newVal.teamId == 0){
		        	$state.go('question');
		        } else  {
		        	$state.go('notfound');
		        }
		        }
      });
})