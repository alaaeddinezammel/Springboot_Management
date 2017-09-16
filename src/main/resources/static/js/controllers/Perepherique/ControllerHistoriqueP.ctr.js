(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'PERHistoriqueController',
			function($scope, $http, $state, $uibModalInstance, $stateParams,
					classified, classifiedsFactory) {

				var vm = this;
				vm.cancel = cancel;

				vm.type = [

				"OS", "LINUX", "Windows" ];

				vm.dateV = {
					currentDate : new Date()
				};

				vm.logiciel = classified;

				console.log(vm.logiciel.machines);

				function cancel() {
					$uibModalInstance.close();
				}
				;

			});

})();