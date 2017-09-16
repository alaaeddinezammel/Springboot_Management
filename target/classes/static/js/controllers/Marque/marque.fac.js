
"use strict";

angular.module('ngClassifieds').factory('MArqsFactory', function($http) {

	function getMArqs() {
		return $http.get('/MArqs');
	}

	return {
		getMArqs : getMArqs
	}

});
