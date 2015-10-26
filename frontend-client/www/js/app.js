// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'

angular.module('worldquest', ['ionic','worldquest.controllers', 'worldquest.services', 'WorldQuest.question.controller', 'WorldQuest.question.services', 'timer.controllers'])

angular.module('starter', ['ionic','worldquest.controllers', 'worldquest.services', 'WorldQuest.question.controller', 'WorldQuest.question.services', 'timer.controllers'])


.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if(window.cordova && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
})

.config(function($stateProvider, $urlRouterProvider) {

  $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: '/features/loginfeature/views/login.html',
                controller: "logincontroller"
            })
            .state('question', {
                url: '/question',
                templateUrl: '/features/question/question.html',
                controller: 'QuestionCtrl'
            })
                .state('timer', {
                url: '/timer',
                templateUrl: '/features/timer/timer.html',
                controller: 'TimerCtrl'
            })
                .state('submission', {
                  url: '/submission',
                  templateUrl: '/features/question/redirectSubmitted.html',
                  controller: 'QuestionCtrl'
              })

                .state('noSubmission', {
                  url: '/noSubmission',
                  templateUrl: '/features/question/redirectTimeout.html',
                  controller: 'QuestionCtrl'
              })

            
        $urlRouterProvider.otherwise('/login');
      });