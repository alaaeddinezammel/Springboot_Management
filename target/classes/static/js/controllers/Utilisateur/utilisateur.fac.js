
"use strict";

angular.module('ngClassifieds').factory('UsersFactory', function($http) {

	function getUsers() {
		return $http.get('/Users');
	}

	return {
		getUsers : getUsers
	}

});
