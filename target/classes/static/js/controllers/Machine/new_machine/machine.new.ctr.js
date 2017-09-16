(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'newMachineController',
			function($scope, $http, $state, $stateParams, $uibModalInstance,
					PerepheriquesFactory, FournisseurFactory, GarentieFactory,
					EmplacementFactory, MachineFactory, DDURFactory,
					MArqsFactory, EcransFactory, cartVFactory, MAINTSFactory) {
				// MyFunctions:bestpractices
				var vm = this;
				vm.postLogiciel = postLogiciel;
				vm.cancelform = cancelform;

				vm.dateV = {
					currentDate : new Date()
				};
				
				
				
				

				EcransFactory.getEC().then(function(data) {
					vm.ecrans = data.data;

				});

				MArqsFactory.getMArqs().then(function(data) {
					vm.marqs = data.data;

				});

				EmplacementFactory.getEmpl().then(function(data) {
					vm.EMLPs = data.data;

				});

				MAINTSFactory.getMAINTS().then(function(data) {
					vm.maints = data.data;

				});

				cartVFactory.getcartV().then(function(data) {
					vm.carteV = data.data;

				});

				DDURFactory.getDD().then(function(data) {
					vm.ddur = data.data;

				});

				

				FournisseurFactory.getFournisseurs().then(function(data) {
					vm.four = data.data;

				});
				// POST Form
				GarentieFactory.getGAR().then(function(data) {
					vm.gar = data.data;

				});

				function postLogiciel(logiciel) {

					if ($scope.myform.$valid) {

						var res = $http.post('/save_machine', logiciel);
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