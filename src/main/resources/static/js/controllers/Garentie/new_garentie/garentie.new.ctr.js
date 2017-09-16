(function() {

	"use strict";

	angular.module('ngClassifieds').controller('newGarentieController',
			function($scope, $http, $state, $stateParams, $uibModalInstance) {
				// MyFunctions:bestpractices
				var vm = this;
				vm.postLogiciel = postLogiciel;
				vm.cancelform = cancelform;

			
				 vm.dateV = {
				         currentDate: new Date()
				       };
			
				// POST Form

				function postLogiciel(logiciel) {

					if ($scope.myform.$valid) {

						var res = $http.post('/save_GAR', logiciel);
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