
"use strict";

angular.module('ngClassifieds').factory('MachineFactory', function($http) {

	function getMachines() {
		return $http.get('/get_machines');
	}

	return {
		getMachines : getMachines
	}

});
