(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'logicielPerepheriqueController',
			function($scope, $http, $state, $uibModal, $stateParams,
					PerepheriquesFactory, MachineFactory) {

				var vm = this;
				vm.postLogiciel = postLogiciel;

				
				vm.submissionSuccess=null;
				
				PerepheriquesFactory.getPerepheriques().then(function(data) {
					vm.classifieds = data.data;

				});

				MachineFactory.getMachines().then(function(data) {
					vm.machs = data.data;

				});

				function postLogiciel(logiciel) {
					if ($scope.myform.$valid) {

						var params = "obj1=" + logiciel.obj1 + "&obj2="
								+ logiciel.obj2;

						$http.put('/save_per-machine?' + params).success(
								function(data, status, headers) {
									// $scope.ServerResponse = data;
									console.log(params);
									
									$state.reload();
										
										vm.submissionSuccess="insertion faites avec succees";
										
								}).error(
								function(data, status, header, config) {
									$state.go("403");
									
								});

					}

				}
				;

			});

})();