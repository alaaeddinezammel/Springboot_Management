(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'detailMachineController',
			function($scope, $http, $state, $stateParams, $uibModalInstance,
					PerepheriquesFactory, FournisseurFactory, GarentieFactory,
					EmplacementFactory, MachineFactory, DDURFactory,
					MArqsFactory, EcransFactory, cartVFactory, MAINTSFactory,classified) {
				// MyFunctions:bestpractices
				var vm = this;
				vm.cancelform=cancelform;
				
				vm.logiciel = classified;

				// cancel Form
				function cancelform() {
					$uibModalInstance.dismiss();
					$state.reload();
				}

			});

})();