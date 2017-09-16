(function() {

	"use strict";

	angular.module('ngClassifieds').controller('newEmplacementController',
			function($scope, $http, $state, $stateParams, $uibModalInstance) {
				// MyFunctions:bestpractices
				var vm = this;
				vm.postLogiciel = postLogiciel;
				vm.cancelform = cancelform;

			

				// POST Form

				function postLogiciel(logiciel) {

					if ($scope.myform.$valid) {

						var res = $http.post('/save_EMP', logiciel);
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

				}
				;

				// cancel Form
				function cancelform() {
					$uibModalInstance.dismiss();
					$state.reload();
				}

			});

})();