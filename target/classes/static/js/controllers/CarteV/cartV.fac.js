
"use strict";

angular.module('ngClassifieds').factory('cartVFactory', function($http) {

	function getcartV() {
		return $http.get('/getCV');
	}

	return {
		getcartV : getcartV
	}

});
