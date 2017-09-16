(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'newLogicielController',
			function($scope, $http, $state, $stateParams, $uibModalInstance,
					classifiedsFactory) {
				// MyFunctions:bestpractices
				var vm = this;
				vm.postLogiciel = postLogiciel;
				vm.cancelform = cancelform;

				vm.type = [

				"OS", "LINUX", "Windows" ];
				
				
				  vm.dateV = {
					         currentDate: new Date()
					       };
				
				
				// POST Form
				
				
				function postLogiciel(logiciel) {
					
					if ($scope.myform.$valid) {

						var res = $http.post('/save_log', logiciel);
						res.success(function(data, status, headers, config) {
							// $state.go('Listlogiciel');
							$uibModalInstance.close();
							$state.reload();
						});
						res.error(function(data, status, headers, config) {
							$state.go("403");
							$uibModalInstance.dismiss();
						});

					}

				};

				// cancel Form
				function cancelform() {
					$uibModalInstance.dismiss();
					$state.reload();
				}

			});

})();