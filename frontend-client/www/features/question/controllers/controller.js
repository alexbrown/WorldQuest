var app = angular.module('WorldQuest.question.controller', []);

app.controller('QuestionCtrl', function($scope, $timeout, $state, Questions){
	/*
	Required references to the Question object
	*/
	$scope.questions = Questions.all();
	$scope.questionID= Questions.all().id;
	$scope.teamID = 12;

	/*
	Timer functionality variables
	*/
	$scope.counter = 45;
    var mytimeout = null;

    /*
    Checks for new entries from user
    */
	$scope.$watch(function(){return Questions.all();}, function(newVal, oldVal) {
		if (typeof newVal !== 'undefined') {
        $scope.questions = newVal;
        $scope.questionID = newVal.id;
        
        console.log(newVal);
    }});

    /*
    Sends selected answer to backend
    */
	$scope.selectedAnswer = function(index){
		var answer = {
			questionID: 1,
			teamID: $scope.teamID,
			answerIndex: index,
			timeAnswered: $scope.counter
		}
		Questions.sendAnswer(answer);
		console.log(answer);
        $state.go('submission');
	}

 // the current timeoutID
    // actual timer method, counts down every second, stops on zero
    $scope.onTimeout = function() {
        if($scope.counter ===  0) {
            $scope.$broadcast('timer-stopped', 0);
            $timeout.cancel(mytimeout);
            return;
        }
        $scope.counter--;
        mytimeout = $timeout($scope.onTimeout, 1000);
    };
    $scope.startTimer = function() {
        mytimeout = $timeout($scope.onTimeout, 1000);
    };
    // stops and resets the current timer
    $scope.stopTimer = function() {
        $scope.$broadcast('timer-stopped', $scope.counter);
        $scope.counter = 45;
        $timeout.cancel(mytimeout);
    };
    // triggered, when the timer stops, you can do something here, maybe show a visual indicator or vibrate the device
    $scope.$on('timer-stopped', function(event, remaining) {
        var noAnswer = {
            questionID: 1,
            teamID: $scope.teamID,
            answerIndex: -9001,
            timeAnswered: $scope.counter
        };
        if(remaining === 0) {
            $state.go('noSubmission');

            Questions.sendAnswer(noAnswer);
              }
    });
	$scope.$on('$ionicView.enter', $scope.startTimer())
})




