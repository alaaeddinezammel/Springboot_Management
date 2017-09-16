
"use strict";

angular.module('ngClassifieds').factory('GarentieFactory', function($http) {

	function getGAR() {
		return $http.get('/Garentie');
	}

	return {
		getGAR : getGAR
	}

});
