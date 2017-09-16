(function() {

  "use strict";

  angular
    .module('ngClassifieds')
    .controller('PerpheriquesController', function($scope, $http,$state,$uibModal, $stateParams, PerepheriquesFactory) {

      var vm = this;
      
   vm.EditLog=EditLog;    
   vm.deleteLog=deleteLog;
   vm.addItem=addItem;
   vm.Historique=Historique;
   
   
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

   
   
   

   PerepheriquesFactory.getPerepheriques().then(function(data) {
        vm.classifieds = data.data;
        
      });

      function Historique(row){
    	  vm.classified = row;
       	  $uibModal.open({
    		  animation: $scope.animationsEnabled,
    		  templateUrl: 'js/controllers/Perepherique/perepherique.historique.tpl.html',
              controller: 'PERHistoriqueController as vm',
              size:"sm",
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
		  templateUrl: 'js/controllers/Perepherique/edit_perepherique/perepherique.edit.tpl.html',
          controller: 'editPerpheriqueController as vm',
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
    		  templateUrl: 'js/controllers/Perepherique/new_perepherique/perepherique.new.tpl.html',
              controller: 'newPerpeheriqueController as vm',
              size:"lg"
    	  }
    	  );
      }

        
        function deleteLog (classified) {
            vm.num=classified;
        	console.log(vm.num);
        	var url = '/DeletePer?numMateriel='+vm.num;
           
                      	
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