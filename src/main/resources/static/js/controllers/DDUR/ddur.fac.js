
"use strict";

angular.module('ngClassifieds').factory('DDURFactory', function($http) {

	function getDD() {
		return $http.get('/getDD');
	}

	return {
		getDD : getDD
	}

});
