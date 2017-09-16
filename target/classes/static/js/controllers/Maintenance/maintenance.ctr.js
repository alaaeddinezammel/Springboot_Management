(function() {

  "use strict";

  angular
    .module('ngClassifieds')
    .controller('listManitController', function($scope, $http,$state,$uibModal, $stateParams, MAINTSFactory) {

      var vm = this;
      
   vm.EditLog=EditLog;    
   vm.deleteLog=deleteLog;
   vm.addItem=addItem;
  
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

   
   

   MAINTSFactory.getMAINTS().then(function(data) {
        vm.classifieds = data.data;
        
      });


      
      
     function EditLog(row){
    	  
         vm.classified = row;

   	  $uibModal.open({
		  animation: $scope.animationsEnabled,
		  templateUrl: 'js/controllers/Maintenance/edit_maintenance/maintenance.edit.tpl.html',
          controller: 'editMaintController as vm',
          size:"lg",
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
    		  templateUrl: 'js/controllers/Maintenance/new_maintenance/maintenance.new.tpl.html',
              controller: 'newmaintController as vm',
              size:"lg"
    	  }
    	  );
      }

        
        function deleteLog (classified) {
            vm.num=classified;
        	console.log("--------------:D"+vm.num);
        	var url = '/DeleteMaint?numMaintenance='+vm.num;
        
                      	
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