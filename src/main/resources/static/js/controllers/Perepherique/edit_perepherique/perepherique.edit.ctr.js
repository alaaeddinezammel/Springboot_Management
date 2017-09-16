(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'editPerpheriqueController',
			function($scope, $http, $state, $stateParams, classified,PerepheriquesFactory,
					$uibModalInstance,FournisseurFactory,GarentieFactory) {
				// MyFunctions:bestpractices
				var vm = this;
				
				vm.cancelform = cancelform;
				vm.PUTLogiciel = PUTLogiciel;

				 PerepheriquesFactory.getPerepheriques().then(function(data) {
				        vm.classifieds = data.data;
				        
				      });
				 FournisseurFactory.getFournisseurs().then(function(data) {
				        vm.four = data.data;
				        
				      });
				
				 GarentieFactory.getGAR().then(function(data) {
				        vm.gar = data.data;
				        
				      });
				 
					// another one .........
				 
				vm.logiciel = classified;

				vm.logiciel.dateL = new Date(vm.logiciel.dateL);
				// vm.logiciel = $state.params.classified;
				// console.log(vm.logiciel);

				// POST Form
				 console.log("||||||||||||||||||||:" + vm.logiciel.numMateriel + "--------");

				
				
				function PUTLogiciel(logiciel) {
					console.log("the one :"+logiciel);

					if ($scope.myform.$valid) {

						var res = $http.put('/updatePer', logiciel);
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