"use strict";

angular.module('ngClassifieds').factory('EcransFactory', function($http) {

	function getEC() {
		return $http.get('/getECC');
	}

	return {
		getEC : getEC
	}

});
