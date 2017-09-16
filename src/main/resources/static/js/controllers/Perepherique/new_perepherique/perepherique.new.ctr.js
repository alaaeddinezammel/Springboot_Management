(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'newPerpeheriqueController',
			function($scope, $http, $state, $stateParams, $uibModalInstance,
					PerepheriquesFactory,FournisseurFactory,GarentieFactory) {
				// MyFunctions:bestpractices
				var vm = this;
				vm.postLogiciel = postLogiciel;
				vm.cancelform = cancelform;

				 PerepheriquesFactory.getPerepheriques().then(function(data) {
				        vm.classifieds = data.data;
				        
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

						var res = $http.post('/save_per', logiciel);
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

				};

				// cancel Form
				function cancelform() {
				
					$uibModalInstance.dismiss();
					$state.reload();
				}

			});

})();