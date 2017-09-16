(function() {

  "use strict";

  angular
    .module('ngClassifieds')
    .controller('machineController', function($scope, $http,$state,$uibModal, $stateParams, MachineFactory) {

      var vm = this;
      
   vm.EditLog=EditLog;    
   vm.deleteLog=deleteLog;
   vm.addItem=addItem;
   vm.Historique=Historique;
   vm.Details=Details;
   
	vm.loggedU=$http.get('/getLogedUser');
	

	$http({
		  method: 'GET',
		  url: '/getLogedUser'
		}).then(function successCallback(data) {
		    // this callback will be called asynchronously
		    // when the response is available
			vm.loggedU=data;
		  }, function errorCallback(data) {
		    console.log("eroooooooor");
		  });

   

   MachineFactory.getMachines().then(function(data) {
        vm.classifieds = data.data;
        console.log(vm.classifieds);
      });
   
   


      function Historique(row){
    	  vm.classified = row;
       	  $uibModal.open({
    		  animation: $scope.animationsEnabled,
    		  templateUrl: 'js/controllers/Machine/machine.historique.tpl.html',
              controller: 'machineHistController as vm',
              size:"lg",
              resolve: {
            	    classified: function() {
            	      
            	    	
            	      return vm.classified;
            	    }
            	  }
              
    	  });
    	  
      }
      
      
     function EditLog(row){
    	  
         vm.classified = row;

   	  $uibModal.open({
		  animation: $scope.animationsEnabled,
		  templateUrl: 'js/controllers/Machine/edit_machine/machine.edit.tpl.html',
          controller: 'editMachineController as vm',
          size:"lg",
          resolve: {
        	    classified: function() {
        	      
        	      return vm.classified;
        	    }
        	  }
          
	  }
	  );
    	 
     }
     
     
     
     function Details(row){
    	 // $state.go('Listlogicieladd');
         vm.classified = row;
    	  $uibModal.open({
    		  animation: $scope.animationsEnabled,
    		  templateUrl: 'js/controllers/Machine/detail_machine/machine.detail.tpl.html',
              controller: 'detailMachineController as vm',
              size:"sm",
              resolve: {
          	    classified: function() {
          	      
          	      return vm.classified;
          	    }
          	  }
    	  }
    	  );
      }
		

      function addItem(){
    	 // $state.go('Listlogicieladd');
    	  $uibModal.open({
    		  animation: $scope.animationsEnabled,
    		  templateUrl: 'js/controllers/Machine/new_machine/machine.new.tpl.html',
              controller: 'newMachineController as vm',
              size:"lg"
    	  }
    	  );
      }

        
        function deleteLog (classified) {
            vm.num=classified;
        	console.log(vm.num+"delete here ");
        	var url = '/DeleteMachine?numMachine='+vm.num;
           
                      	
        	$http.delete(url).then(function (response) {
        	    console.log('all is good', response.data);
				$state.reload();

        	}, function (error) {
        		$state.go("403");
        	    console.log('an error occurred', error.data);
        	});

        }
        
        
        
        
        
        
        
        

    });

})();