
"use strict";

angular.module('ngClassifieds').factory('MAINTSFactory', function($http) {

	function getMAINTS() {
		return $http.get('/MAINTS');
	}

	return {
		getMAINTS : getMAINTS
	}

});
