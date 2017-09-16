(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'newEcranController',
			function($scope, $http, $state, $stateParams, $uibModalInstance,
					FournisseurFactory, MArqsFactory, GarentieFactory) {
				// MyFunctions:bestpractices
				var vm = this;
				vm.postLogiciel = postLogiciel;
				vm.cancelform = cancelform;

				FournisseurFactory.getFournisseurs().then(function(data) {
					vm.four = data.data;

				});

				GarentieFactory.getGAR().then(function(data) {
					vm.gar = data.data;

				});

				MArqsFactory.getMArqs().then(function(data) {
					vm.marqs = data.data;

				});

				function postLogiciel(logiciel) {

					if ($scope.myform.$valid) {

						var res = $http.post('/save_ECC', logiciel);
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