// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
<<<<<<< HEAD
angular.module('worldquest', ['ionic', 'worldquest.controllers', 'worldquest.services'])
=======
angular.module('starter', ['ionic', 'WorldQuest.question.controller', 'WorldQuest.question.services'])
>>>>>>> master

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

<<<<<<< HEAD

=======
>>>>>>> master
.config(function($stateProvider, $urlRouterProvider) {

  $stateProvider
            .state('login', {
                url: '/login',
<<<<<<< HEAD
                templateUrl: '/features/loginfeature/views/login.html',
                controller: "logincontroller"
            })
            /*.state('question', {
                url: '/question',
                templateUrl: '/features/question/question.html',
                controller: 'QuestionCtrl'
            })*/
            
        $urlRouterProvider.otherwise('/login');
=======
                templateUrl: '/features/loginfeature/login.html',
            })
            .state('question', {
                url: '/question',
                templateUrl: '/features/question/question.html',
                controller: 'QuestionCtrl'
            })
            
        $urlRouterProvider.otherwise('/');
>>>>>>> master
      });