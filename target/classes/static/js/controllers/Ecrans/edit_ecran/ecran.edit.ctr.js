(function() {

	"use strict";

	angular.module('ngClassifieds')
			.controller(
					'editEcranController',
					function($scope, $http, $state, $stateParams, classified,
							FournisseurFactory, MArqsFactory, GarentieFactory,
							$uibModalInstance) {
						// MyFunctions:bestpractices
						var vm = this;

						vm.cancelform = cancelform;
						vm.PUTLogiciel = PUTLogiciel;

						vm.logiciel = classified;

						FournisseurFactory.getFournisseurs().then(
								function(data) {
									vm.four = data.data;

								});

						GarentieFactory.getGAR().then(function(data) {
							vm.gar = data.data;

						});

						MArqsFactory.getMArqs().then(function(data) {
							vm.marqs = data.data;

						});
						// vm.logiciel = $state.params.classified;
						// console.log(vm.logiciel);

						// POST Form
						console.log("||||||||||||||||||||:" + vm.logiciel
								+ "--------");

						function PUTLogiciel(logiciel) {
							console.log("the one :" + logiciel);

							if ($scope.myform.$valid) {

								var res = $http.put('/updateECC', logiciel);
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