var app = angular.module('WorldQuest.question.controller', []);

app.controller('QuestionCtrl', function($scope, Questions){
	$scope.questions = Questions.all();

	$scope.$watch(function(){return Questions.all();}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
        $scope.questions = newVal;
        console.log(newVal);
    }});
})
