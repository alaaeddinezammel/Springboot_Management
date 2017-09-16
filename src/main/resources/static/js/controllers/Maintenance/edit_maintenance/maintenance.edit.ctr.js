(function() {

	"use strict";

	angular.module('ngClassifieds')
			.controller(
					'editMaintController',
					function($scope, $http, $state, $stateParams, classified,
							$uibModalInstance) {
						// MyFunctions:bestpractices
						var vm = this;

						vm.cancelform = cancelform;
						vm.PUTLogiciel = PUTLogiciel;

						vm.logiciel = classified;

						// vm.logiciel = $state.params.classified;
						// console.log(vm.logiciel);

						// POST Form
						console.log("||||||||||||||||||||:" + vm.logiciel
								+ "--------");

						vm.logiciel.dateFinMaint = new Date(
								vm.logiciel.dateFinMaint);
						vm.logiciel.dateDebutMaint = new Date(
								vm.logiciel.dateDebutMaint);

						vm.dateV = {
							currentDate : new Date()
						};

						function PUTLogiciel(logiciel) {
							console.log("the one :" + logiciel);

							if ($scope.myform.$valid) {

								var res = $http.put('/updateMaint', logiciel);
								res.success(function(data, status, headers,
										config) {
									// $state.go('Listlogiciel');

									$uibModalInstance.close();
									$state.reload();
								});
								res.error(function(data, status, headers,
										config) {
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