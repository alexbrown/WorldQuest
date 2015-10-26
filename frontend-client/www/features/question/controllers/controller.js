var app = angular.module('WorldQuest.question.controller', []);

app.controller('QuestionCtrl', function($scope, Questions){
	$scope.questions = Questions.all();
<<<<<<< HEAD
	$scope.questionId = Questions.all().id;
	$scope.teamId = 12;
=======
	$scope.questionID= Questions.all().id;
	$scope.teamID = 12;
>>>>>>> bb0cf4de6cb1177d53cd1c1aa9bd2623b42b7cb1

	$scope.$watch(function(){return Questions.all();}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
        $scope.questions = newVal;
<<<<<<< HEAD
        $scope.questionId = newVal.id;
        console.log(newVal);
    }});

	$scope.selectAwnser = function(index){
		console.log($scope.questionId);
	}

=======
        $scope.questionID = newVal.id;
        console.log(newVal);
    }});


	$scope.selectedAnswer = function(index){
		var answer = {
			questionID: $scope.questionID,
			teamID: $scope.teamID,
			answerIndex: index
		}
		Questions.sendAnswer(answer);
	}
>>>>>>> bb0cf4de6cb1177d53cd1c1aa9bd2623b42b7cb1

})
