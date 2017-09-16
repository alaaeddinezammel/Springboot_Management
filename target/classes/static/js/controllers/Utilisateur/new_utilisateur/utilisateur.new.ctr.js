(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'newUserController',
			function($scope, $http, $state, $stateParams, $uibModalInstance,
					UsersFactory) {
				// MyFunctions:bestpractices
				var vm = this;
				vm.postLogiciel = postLogiciel;
				vm.cancelform = cancelform;

				vm.droitU = [

				"ADMIN", "DIRECTION" ];

				// POST Form

				function postLogiciel(logiciel) {

					if ($scope.myform.$valid) {

						var res = $http.post('/save_uSER', logiciel);
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