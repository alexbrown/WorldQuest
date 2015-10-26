angular.module('WorldQuest.question.services', [])

.factory('Questions', function($http){
	var question = {}

	$http({
		method: 'GET',
		url:'/features/question/service/dummydata.json'
	}).then(function successCallback(response){
		question = response.data;
	});

	return{
		all:function(){
			return question;
		}
	}
})