var app = angular.module('WorldQuest.question.controller', []);

app.controller('QuestionCtrl', function($scope, Questions){
	$scope.questions = Questions.all();
	$scope.questionID= Questions.all().id;
	$scope.teamID = 12;

	$scope.$watch(function(){return Questions.all();}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
        $scope.questions = newVal;
        $scope.questionID = newVal.id;
        console.log(newVal);
    }});


	$scope.selectedAnswer = function(index){
		var answer = {
			questionID: 1,
			teamID: $scope.teamID,
			answerIndex: index
		}
		Questions.sendAnswer(answer);
		console.log(answer);
	}

})