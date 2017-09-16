(function() {

  "use strict";

  angular
    .module('ngClassifieds')
    .controller('HistoriqueUSerController', function($scope, $http,$state,$uibModalInstance, $stateParams,classifiedH, classifiedsFactory) {

      var vm = this;
      vm.cancel=cancel;

    

      
      
      vm.type = [

 				"OS", "LINUX", "Windows" ];

 				  vm.dateV = {
 					         currentDate: new Date()
 					       };
 				
 				
 				vm.logiciel = classifiedH;
   
   console.log(vm.logiciel.machines.numMachine+": why other fuckers ");
   
   

    

  function cancel(){
	    $uibModalInstance.close();
	  };
        
        
        
        
        
        

    });

})();