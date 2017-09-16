(function() {

	"use strict";

	angular.module('ngClassifieds').controller(
			'machineHistController',
			function($scope, $http, $state, $uibModalInstance, $stateParams,
					classified, classifiedsFactory,$interval) {

				var vm = this;
				vm.cancel = cancel;
				vm.deleteLogH = deleteLogH;
				vm.deleteUitlisateurH = deleteUitlisateurH;
				vm.deletePerepheriqueH = deletePerepheriqueH;

				vm.type = [

				"OS", "LINUX", "Windows" ];

				vm.dateV = {
					currentDate : new Date()
				};

				
						vm.logiciel = classified;
				
						$scope.$watch('logiciel',function(value){
							
							console.log("value="+value);
						});
				
							
				
			
				// ------------------------------

				function deleteLogH(numL) {
					vm.classifie = vm.logiciel;
					console.log(vm.classifie);
					vm.numL = numL;

					
					if(confirm("vous etes sur de cette action ??")){
					
						 var data = $.param({
				                numL: vm.numL,
				                numMachine:vm.classifie.numMachine
				                
				            });

				            $http.delete('/DeleteL?' + data)
				            .success(function (data, status, headers) {
				               console.log("mchat serveur");
				            
				            })
				            .error(function (data, status, header, config) {
				               console.log(data);
				            });
						
				            $state.reload();
					
					}

				}

				function deletePerepheriqueH(numMateriel) {
					vm.classifie = vm.logiciel;
					vm.numMateriel = numMateriel;
					console.log(vm.numMateriel);
					if(confirm("vous etes sur de cette action ??")){
						
						 var data = $.param({
							    numMateriel: vm.numMateriel,
				                numMachine:vm.classifie.numMachine
				                
				            });

				            $http.delete('/DeleteP?' + data)
				            .success(function (data, status, headers) {
				               console.log("mchat serveur");
				            
				            })
				            .error(function (data, status, header, config) {
				               console.log(data);
				            });
						
				            $state.reload();
					
					}

				}


				function deleteUitlisateurH(numU) {
					vm.classifie = vm.logiciel;
					vm.numU = numU;
					console.log(vm.numU);
					if(confirm("vous etes sur de cette action ??")){
						
						 var data = $.param({
				                numU: vm.numU,
				                numMachine:vm.classifie.numMachine
				                
				            });

				            $http.delete('/DeleteU?' + data)
				            .success(function (data, status, headers) {
				               console.log("mchat serveur");
				            
				            })
				            .error(function (data, status, header, config) {
				               console.log(data);
				            });
						
				            $state.reload();
					
					}

				}

				// -----------------

				function cancel() {
					$uibModalInstance.close();
				}
				;

			});

})();