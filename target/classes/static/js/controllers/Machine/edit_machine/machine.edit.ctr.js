(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'editMachineController',
			function($scope, $http, $state, $stateParams, $uibModalInstance,
					PerepheriquesFactory, FournisseurFactory, GarentieFactory,
					EmplacementFactory, MachineFactory, DDURFactory,
					MArqsFactory, EcransFactory, cartVFactory, MAINTSFactory,classified) {
				// MyFunctions:bestpractices
				var vm = this;

				vm.cancelform = cancelform;
				vm.PUTLogiciel = PUTLogiciel;

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

				// another one .........

				vm.logiciel = classified;

				//vm.logiciel.dateL = new Date(vm.logiciel.dateL);
				// vm.logiciel = $state.params.classified;
				// console.log(vm.logiciel);

				// POST Form
				vm.logiciel.dateAchat = new Date(vm.logiciel.dateAchat);
				
				vm.logiciel.dateMiseEnService = new Date(vm.logiciel.dateMiseEnService);
				
				vm.logiciel.dateLivraison = new Date(vm.logiciel.dateLivraison);
			
				function PUTLogiciel(logiciel) {
					console.log("the one :" + logiciel);

					if ($scope.myform.$valid) {

						var res = $http.put('/updateMachine', logiciel);
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