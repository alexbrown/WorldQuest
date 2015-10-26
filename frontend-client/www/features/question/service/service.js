angular.module('WorldQuest.question.services', [])

.factory('Questions', function($http){
	var question = {}

	$http({
		method: 'GET',
		url:'/features/question/service/dummydata.json'
	}).then(function successCallback(response){
		question = response.data;
	});

	function sendAnswer(awnser){
		$http({
			method: 'POST',
			url: 'http://localhost:8080/answer',
			data: awnser
		}).then(function successCallback(output){
			return output
		})
	}

	return{
		all:function(){
			return question;
		}
	}
})