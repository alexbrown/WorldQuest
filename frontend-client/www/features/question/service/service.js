angular.module('WorldQuest.question.services', [])

.factory('Questions', function($http){
	var question = {}
	var lastQuestion = {}

	$http({
		method: 'GET',
		url:'http://localhost:8080/question'
	}).then(function successCallback(response){
		question = response.data;
	});

	function sendAnswer(answer){
		$http({
			method: 'GET',
			url: 'http://localhost:8080/answer?questionID='+ answer.questionID + '&teamID='+12+'&answerIndex='+ answer.answerIndex 
		}).then(function successCallback(output){
			lastQuestion = output
		})
	}

	return{
		all:function(){
			return question;
		},
		getLastQuestion: function(){
			return lastQuestion
		},
		sendAnswer: sendAnswer
	}
})