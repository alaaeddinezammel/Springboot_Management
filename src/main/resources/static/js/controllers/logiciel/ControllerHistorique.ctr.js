(function() {

  "use strict";

  angular
    .module('ngClassifieds')
    .controller('HistoriqueController', function($scope, $http,$state,$uibModalInstance, $stateParams,classifiedH, classifiedsFactory) {

      var vm = this;
      vm.cancelform=cancelform;

    

      
      
      vm.type = [

 				"OS", "LINUX", "Windows" ];

 				  vm.dateV = {
 					         currentDate: new Date()
 					       };
 				
 				
 				vm.logiciel = classifiedH;
   
   console.log(vm.logiciel);
   
   

    

  function cancelform(){
	    $uibModalInstance.close();
	  };
        
        
        
        
        
        

    });

})();