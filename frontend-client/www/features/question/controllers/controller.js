var app = angular.module('WorldQuest.question.controller', []);

app.controller('QuestionCtrl', function($scope, Questions){
	$scope.questions = Questions.all();
	$scope.questionId = Questions.all().id;
	$scope.teamId = 12;

	$scope.$watch(function(){return Questions.all();}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
        $scope.questions = newVal;
        $scope.questionId = newVal.id;
        console.log(newVal);
    }});

	$scope.selectAwnser = function(index){
		console.log($scope.questionId);
	}


})
