var app = angular.module('timer.controllers', []);

app.controller('TimerCtrl', function($scope, $timeout) {
    $scope.counter = 45;
    var mytimeout = null; // the current timeoutID
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
        if(remaining === 0) {
            console.log('You did not answer the question in time.');
        }
    });
})
