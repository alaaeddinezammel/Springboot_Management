
"use strict";

angular.module('ngClassifieds').factory('EmplacementFactory', function($http) {

	function getEmpl() {
		return $http.get('/Emplacmenet');
	}

	return {
		getEmpl : getEmpl
	}

});
